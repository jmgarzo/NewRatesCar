package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jmgarzo.newratescar.Task.SaveMaintenance;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceContentValues;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.action_delete;

public class MaintenanceDetail extends AppCompatActivity implements MaintenanceDetailFragment.Callback {

    private final String LOG_TAG = MaintenanceDetail.class.getSimpleName();

    private Long mMaintenanceId = null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;

    MaterialBetterSpinner mSpinnerVehicleName;
    private TextInputLayout mLayoutDate;
    private EditText mDate;
    private TextInputLayout mLayoutTitle;
    private EditText mTitle;
    private EditText mDescription;
    private EditText mMileage;
    private MaterialBetterSpinner mType;
    private EditText mPrice;
    private SwitchCompat mSwitchRegular;
    private EditText mRegularity;
    private EditText mGarage;
    private EditText mAdditionalInformation;

    MaterialDialog md;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        isDataChanged = false;

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            MaintenanceDetailFragment fragment = new MaintenanceDetailFragment();

            mMaintenanceId = getIntent().getLongExtra(MaintenanceColumns._ID, -1);
            arguments.putLong(MaintenanceColumns._ID, mMaintenanceId);

            if (mMaintenanceId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.maintenance_detail_container, fragment)
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
                        MaintenanceDetail.super.onBackPressed();
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
        getMenuInflater().inflate(R.menu.menu_maintenance_detail, menu);
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

        //mInputLayoutVehicleName = (TextInputLayout) findViewById(input_layout_vehicle_name);

        mSpinnerVehicleName = (MaterialBetterSpinner) findViewById(R.id.better_spinner_maintenance_vehicle_name);

        mLayoutDate = (TextInputLayout) findViewById(R.id.input_layout_maintenance_date);
        mDate = (EditText) findViewById(R.id.input_maintenance_date);
        mLayoutTitle = (TextInputLayout) findViewById(R.id.input_layout_maintenance_title);
        mTitle = (EditText) findViewById(R.id.input_maintenance_title);
        mDescription = (EditText) findViewById(R.id.input_maintenance_description);
        mMileage = (EditText) findViewById(R.id.input_maintenance_mileage);
        mType = (MaterialBetterSpinner) findViewById(R.id.better_spinner_maintenance_type);
        mPrice = (EditText) findViewById(R.id.input_maintenance_price);
        mSwitchRegular = (SwitchCompat) findViewById(R.id.switch_is_maintenance_regular);
        mRegularity = (EditText) findViewById(R.id.input_maintenance_regularity);
        mGarage = (EditText) findViewById(R.id.input_maintenance_garage);
        mAdditionalInformation = (EditText) findViewById(R.id.input_maintenance_additional_information);




        boolean isCorrect = true;


        String vehicleName = mSpinnerVehicleName.getText().toString();

        GregorianCalendar cal = new GregorianCalendar();
        String sFecha = mDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cal.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }


        if (isValidateEmptyFields()) {
            MaintenanceContentValues values = new MaintenanceContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this, vehicleName))
                    .putMaintenanceDate(cal.getTimeInMillis())
                    .putMaintenanceTitle(mTitle.getText().toString())
                    .putMaintenanceDescription(mDescription.getText().toString())
                    .putMaintenanceMileage(Utility.getIntegerNoNull(mMileage.getText().toString()))
                    .putMaintenanceType(getType(mType.getText().toString()))
                    .putMaintenancePrice(Utility.getDoubleNoNull(mPrice.getText().toString()))
                    .putIsRegular(mSwitchRegular.isChecked())
                    .putMaintenancePeriodicity(Utility.getIntegerNoNull(mRegularity.getText().toString()))
                    .putMaintenanceGarage(mGarage.getText().toString())
                    .putMaintenanceAdditionalInformation(mAdditionalInformation.getText().toString());



            SaveMaintenance saveMaintenance = new SaveMaintenance(this, mMaintenanceId, mSpinnerVehicleName.getText().toString());
            saveMaintenance.execute(values);

            Intent intent = new Intent(this, Maintenances.class);
            startActivity(intent);
        } else {
            isCorrect = false;
            mSpinnerVehicleName.requestFocus();
        }

        return isCorrect;
    }

    Integer getType(String type ){
        if(type.equalsIgnoreCase(getString(R.string.maintenance_type_breakdown))){
            return 1;
        }
        else{
            return 0;
        }
    }

    @Override
    public void onBackPressed() {
        if(isDataChanged) {
            md.show();
        }else{
            super.onBackPressed();
        }
    }


    private boolean isValidateEmptyFields() {
        boolean result = true;
        if(Utility.isEmptyOrNull(mSpinnerVehicleName.getText().toString())){
            mSpinnerVehicleName.setError(getString(R.string.maintenance_vehicle_name_error));
            result = false;
        }

        if (Utility.isEmptyOrNull(mDate.getText().toString())) {
            mLayoutDate.setErrorEnabled(true);
            mLayoutDate.setError(getString(R.string.maintenance_error_date));
            result = false;
        }

        if (Utility.isEmptyOrNull(mTitle.getText().toString())) {
            mLayoutTitle.setErrorEnabled(true);
            mLayoutTitle.setError(getString(R.string.maintenance_error_title));
            result = false;
        }
        return result;
    }

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

    void delete() {
        MaintenanceSelection where = new MaintenanceSelection();
        where.id(mMaintenanceId);
        where.delete(this);
    }

    @Override
    public void onDataChanged() {
        isDataChanged = true;
    }


}
