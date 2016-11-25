package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static com.jmgarzo.newratescar.R.id.action_delete;
import static com.jmgarzo.newratescar.R.id.input_layout_vehicle_name;

public class VehicleDetailActivity extends AppCompatActivity implements VehicleDetailFragment.Callback {

    private static final String LOG_TAG = VehicleDetailActivity.class.getSimpleName();

    private Long idVehicle = null;
    private boolean isNew;
    private boolean isDataChanged;

    private TextInputLayout mInputLayoutVehicleName;
    EditText mInputVehicleName;
    MaterialBetterSpinner mSpinnerVehicleClass;
    AutoCompleteTextView mFuelType;
    AutoCompleteTextView mMake;
    EditText mInputModel;
    EditText mInputMileage;
    EditText mInputAddInformation;

    MaterialDialog md;

    private Toast mToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isDataChanged=false;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            VehicleDetailFragment fragment = new VehicleDetailFragment();

            idVehicle = getIntent().getLongExtra(VehicleColumns._ID, -1);
            arguments.putLong(VehicleColumns._ID, idVehicle);

            if (idVehicle == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.vehicle_detail_container, fragment)
                    .commit();


        }

        md = new MaterialDialog.Builder(this)
                .content(R.string.dialog_discard_changes)
                .positiveText(R.string.dialog_agree)
                .negativeText(R.string.dialog_disagree).build();
        md.getBuilder()
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        showToast("Discarded changes");
                        VehicleDetailActivity.super.onBackPressed();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.closeOptionsMenu();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vehicle_detail, menu);
        if (isNew) {
            menu.removeItem(action_delete);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_done_vehicle:
                if (saveData()) {
                    showToast(R.string.toast_vehicle_saved);
                }
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_delete: {
                if (!isNew) {
                    delete();
                    onBackPressed();
                }
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean saveData() {

        mInputLayoutVehicleName = (TextInputLayout) findViewById(input_layout_vehicle_name);

        mInputVehicleName = (EditText) findViewById(R.id.input_vehicle_name);
        mSpinnerVehicleClass = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_class);
        mFuelType = (AutoCompleteTextView) findViewById(R.id.autocompleteView_vehicle_fuel_type);
        mMake = (AutoCompleteTextView) findViewById(R.id.autocompleteView_vehicle_make);
        mInputModel = (EditText) findViewById(R.id.input_vehicle_model);
        mInputMileage = (EditText) findViewById(R.id.input_vehicle_mileage);
        mInputAddInformation = (EditText) findViewById(R.id.input_vehicle_add_information);


        boolean isCorrect = true;

        String vehicleName = mInputVehicleName.getText().toString();
        if (vehicleName.equalsIgnoreCase("")) {
            mInputLayoutVehicleName.setErrorEnabled(true);
            mInputLayoutVehicleName.setError(getString(R.string.vehicle_name_error));
            isCorrect = false;
        }


        String vehicleClass = mSpinnerVehicleClass.getText().toString();
        String vehicleFuelType = mFuelType.getText().toString();
        String vehicleMake = mMake.getText().toString();
        String vehicleModel = mInputModel.getText().toString();

        int vehicleMileage = 0;
        try {
            vehicleMileage = Integer.valueOf(mInputMileage.getText().toString());
        } catch (NumberFormatException e) {
            Log.e(LOG_TAG, "vehicleMileage Integer.valueOf exception");
            vehicleMileage = 0;
        }

        String addInformation = mInputAddInformation.getText().toString();


        if (isCorrect) {
            VehicleContentValues values = new VehicleContentValues();
            values.putVehicleName(vehicleName)
                    .putVehicleClass(ProviderUtilities.getVehicleClassId(this, vehicleClass))
                    .putVehicleFuelType(ProviderUtilities.getVehicleFuelTypeId(this, vehicleFuelType))
                    .putMake(ProviderUtilities.getMakeId(this, vehicleMake))
                    .putModel(vehicleModel)
                    .putMileage(vehicleMileage)
                    .putAdditionalInformation(addInformation);

            if (isNew) {
                getContentResolver().insert(values.uri(), values.values());
            } else {
                getContentResolver().update(values.uri(),
                        values.values(),
                        VehicleColumns._ID + "= ?",
                        new String[]{idVehicle.toString()});
            }

            Intent intent = new Intent(this, VehiclesActivity.class);
            startActivity(intent);
        }else{
            mInputVehicleName.requestFocus();
        }
        return isCorrect;
    }


    @Override
    public void onBackPressed() {

        if(isDataChanged) {
            md.show();
        }else{
            super.onBackPressed();
        }


    }

//    boolean isValuesChanged(){
//        if(isNew){
//            if(mInputVehicleName.getText().toString().equalsIgnoreCase("")
//                    && mSpinnerVehicleClass.getText().toString().equalsIgnoreCase("")
//                    && mSpinnerFuelType.getText().toString().equalsIgnoreCase("")
//                    && mSpinnerMake.getText().toString().equalsIgnoreCase("")
//                    && mInputModel.getText().toString().equalsIgnoreCase("")
//                    && mInputMileage.getText().toString().equalsIgnoreCase("")
//                    && mInputAddInformation.getText().toString().equalsIgnoreCase("")){
//                return false;
//
//            }
//
//        }else{
//            return true;
//        }
//    return true;
//    }

    private void showToast(int resId) {
        showToast(getString(resId));
    }

    private void showToast(String message) {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }


    void delete(){
        VehicleSelection where = new VehicleSelection();
        where.id(idVehicle);
        where.delete(this);
    }




    @Override
    public void onDataChanged() {
        isDataChanged=true;
    }
}