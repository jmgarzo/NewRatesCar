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
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jmgarzo.newratescar.Task.SaveToll;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.toll.TollColumns;
import com.jmgarzo.newratescar.provider.toll.TollContentValues;
import com.jmgarzo.newratescar.provider.toll.TollSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.action_delete;

public class TollDetail extends AppCompatActivity implements TollDetailFragment.Callback {

    private final String LOG_TAG = TollDetail.class.getSimpleName();

    private Long mTollId = null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;

    MaterialBetterSpinner mSpinnerVehicleName;
    private TextInputLayout mTollLayoutDate;
    private EditText mTollDate;
    private EditText mTollPrice;
    private EditText mTollName;
    private EditText mTollRoad;
    private EditText mTollDirection;
    private EditText mTollLocation;
    private EditText mTollAdditionalInformation;

    MaterialDialog md;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toll_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        isDataChanged = false;


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            TollDetailFragment fragment = new TollDetailFragment();

            mTollId = getIntent().getLongExtra(TollColumns._ID, -1);
            arguments.putLong(TollColumns._ID, mTollId);

            if (mTollId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.toll_detail_container, fragment)
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
                        TollDetail.super.onBackPressed();
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
        getMenuInflater().inflate(R.menu.menu_toll_detail, menu);
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

        mSpinnerVehicleName = (MaterialBetterSpinner) findViewById(R.id.better_spinner_toll_vehicle_name);
        mTollLayoutDate = (TextInputLayout) findViewById(R.id.input_layout_toll_date);
        mTollDate = (EditText) findViewById(R.id.input_toll_date);
        mTollPrice = (EditText) findViewById(R.id.input_toll_price);
        mTollName = (EditText) findViewById(R.id.input_toll_name);
        mTollRoad = (EditText) findViewById(R.id.input_toll_road);
        mTollDirection = (EditText) findViewById(R.id.input_toll_direction);
        mTollLocation = (EditText) findViewById(R.id.input_toll_location);
        mTollAdditionalInformation = (EditText) findViewById(R.id.input_toll_additional_information);

        boolean isCorrect = true;


        String vehicleName = mSpinnerVehicleName.getText().toString();

        GregorianCalendar cal = new GregorianCalendar();
        String sFecha = mTollDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cal.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }


        if (isValidateEmptyFields()) {
            TollContentValues values = new TollContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this, vehicleName))
                    .putTollDate(cal.getTimeInMillis())
                    .putTollPrice(Utility.getDoubleNoNull(mTollPrice.getText().toString()))
                    .putTollName(mTollName.getText().toString())
                    .putTollRoad(mTollRoad.getText().toString())
                    .putTollDirection(mTollDirection.getText().toString())
                    .putTollLocation(mTollLocation.getText().toString())
                    .putTollAdditionalInformation(mTollAdditionalInformation.getText().toString());



            SaveToll saveToll = new SaveToll(this, mTollId, mSpinnerVehicleName.getText().toString());
            saveToll.execute(values);

            Intent intent = new Intent(this, Tolls.class);
            startActivity(intent);
        } else {
            isCorrect = false;
            mSpinnerVehicleName.requestFocus();
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


    private boolean isValidateEmptyFields() {
        boolean result = true;
        if(Utility.isEmptyOrNull(mSpinnerVehicleName.getText().toString())){
            mSpinnerVehicleName.setError(getString(R.string.refuel_vehicle_name_error));
            result = false;
        }

        if (Utility.isEmptyOrNull(mTollDate.getText().toString())) {
            mTollLayoutDate.setErrorEnabled(true);
            mTollLayoutDate.setError(getString(R.string.refuel_error_date));
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
        TollSelection where = new TollSelection();
        where.id(mTollId);
        where.delete(this);
    }

    @Override
    public void onDataChanged() {
        isDataChanged = true;
    }

}
