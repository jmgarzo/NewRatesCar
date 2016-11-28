package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.jmgarzo.newratescar.Task.SaveRefuel;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelContentValues;
import com.jmgarzo.newratescar.provider.refuel.RefuelSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.action_delete;

public class RefuelDetailActivity extends AppCompatActivity implements RefuelDetailFragment.Callback {

    private final String LOG_TAG = RefuelDetailActivity.class.getSimpleName();


    private Long mRefuelId = null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;


    MaterialBetterSpinner mSpinnerVehicleName;
    private TextInputLayout mRefuelLayoutDate;
    private EditText mRefuelDate;
    private SwitchCompat mRefuelFullTank;
    private TextInputLayout mRefuelLayoutFuelType;
    private AutoCompleteTextView mRefuelFuelType;
    private TextInputLayout mRefuelLayoutFuelSubtype;
    private AutoCompleteTextView mRefuelFuelSubtype;
    private TextInputLayout mLayoutMileage;
    private EditText mMileage;
    private TextInputLayout mLayoutLitres;
    private EditText mLitres;
    private TextInputLayout mLayoutGasPrice;
    private EditText mGasPrice;
    private TextInputLayout mLayoutTotalPrice;
    private EditText mTotalPrice;
    private SwitchCompat mIsRoofRack;
    private SwitchCompat mIsTrailer;
    private AppCompatSeekBar mSeekBarRouteType;
    private AppCompatSeekBar mSeekBarDrivingStyle;
    private EditText mAverageSpeed;
    private EditText mAverageConsumption;
    private EditText mPaymentType;
    private EditText mGasStation;
    private EditText mAdditionalInf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuel_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        isDataChanged = false;


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            RefuelDetailFragment fragment = new RefuelDetailFragment();

            mRefuelId = getIntent().getLongExtra(RefuelColumns._ID, -1);
            arguments.putLong(RefuelColumns._ID, mRefuelId);

            if (mRefuelId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.refuel_detail_container, fragment)
                    .commit();


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_refuel_detail, menu);
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

        mSpinnerVehicleName = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_name);
        mRefuelLayoutDate = (TextInputLayout) findViewById(R.id.input_layout_refuel_date);
        mRefuelDate = (EditText) findViewById(R.id.input_refuel_date);
        mRefuelFullTank = (SwitchCompat) findViewById(R.id.switch_is_full);
        mRefuelLayoutFuelType = (TextInputLayout) findViewById(R.id.input_layout_refuel_fuel_type);
        mRefuelFuelType = (AutoCompleteTextView) findViewById(R.id.autocomplete_refuel_fuel_type);
        mRefuelLayoutFuelSubtype = (TextInputLayout) findViewById(R.id.input_layout_refuel_fuel_subtype);
        mRefuelFuelSubtype = (AutoCompleteTextView) findViewById(R.id.autocomplete_refuel_fuel_subtype);
        mLayoutMileage = (TextInputLayout) findViewById(R.id.input_layout_refuel_mileage);
        mMileage = (EditText) findViewById(R.id.input_refuel_mileage);
        mLayoutLitres = (TextInputLayout) findViewById(R.id.input_layout_refuel_litres);
        mLitres = (EditText) findViewById(R.id.input_refuel_litres);
        mLayoutGasPrice = (TextInputLayout) findViewById(R.id.input_layout_refuel_gas_price);
        mGasPrice = (EditText) findViewById(R.id.input_refuel_gas_price);
        mLayoutTotalPrice = (TextInputLayout) findViewById(R.id.input_layout_refuel_total_price);
        mTotalPrice = (EditText) findViewById(R.id.input_refuel_total_price);
        mIsRoofRack = (SwitchCompat) findViewById(R.id.switch_is_roof_rack);
        mIsTrailer = (SwitchCompat) findViewById(R.id.switch_is_trailer);
        mSeekBarRouteType = (AppCompatSeekBar) findViewById(R.id.seekbar_route_type);
        mSeekBarDrivingStyle = (AppCompatSeekBar) findViewById(R.id.seekbar_driving_style);
        mAverageSpeed = (EditText) findViewById(R.id.input_refuel_average_speed);
        mAverageConsumption = (EditText) findViewById(R.id.input_refuel_average_consumption);
        mPaymentType = (EditText) findViewById(R.id.input_refuel_payment_type);
        mGasStation = (EditText) findViewById(R.id.input_refuel_gas_station);
        mAdditionalInf = (EditText) findViewById(R.id.input_refuel_additional_information);
        boolean isCorrect = true;


        String vehicleName = mSpinnerVehicleName.getText().toString();

        GregorianCalendar cal = new GregorianCalendar();
        String sFecha = mRefuelDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cal.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }


        if (isValidateEmptyFields()) {
            RefuelContentValues values = new RefuelContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this, vehicleName))
                    .putRefuelDate(cal.getTimeInMillis())
                    .putRefuelFuelType(ProviderUtilities.getVehicleFuelTypeId(this, mRefuelFuelType.getText().toString()))
                    .putRefuelFuelSubtype(ProviderUtilities.getVehicleFuelSubtypeId(this, mRefuelFuelSubtype.getText().toString()))
                    .putRefuelMileage(Utility.getIntegerNoNull(mMileage.getText().toString()))
                    //Todo: Calculate trip odometer
                    .putRefuelTripOdometer(0)
                    .putRefuelLitres(Utility.getDoubleNoNull(mLitres.getText().toString()))
                    .putRefuelGasPrice(Utility.getDoubleNoNull(mGasPrice.getText().toString()))
                    .putRefuelTotalPrice(Utility.getDoubleNoNull(mTotalPrice.getText().toString()))
                    .putIsFull(mRefuelFullTank.isChecked())
                    .putIsTrailer(mIsTrailer.isChecked())
                    .putIsRoofRack(mIsRoofRack.isChecked())
                    .putRouteType(mSeekBarRouteType.getProgress())
                    .putDrivingStyle(mSeekBarDrivingStyle.getProgress())
                    //Todo: Calculate averageConsumption
                    .putAverageConsumption(0);


            SaveRefuel saveRefuel = new SaveRefuel(this, mRefuelId,mSpinnerVehicleName.getText().toString(), Integer.parseInt(mMileage.getText().toString()));
            saveRefuel.execute(values);

            Intent intent = new Intent(this, RefuelsActivity.class);
            startActivity(intent);
        } else {
            isCorrect = false;
            mSpinnerVehicleName.requestFocus();
        }

        return isCorrect;
    }

    private boolean isValidateEmptyFields() {
        boolean result = true;
        ArrayList<String> errors = new ArrayList<>();
        mRefuelLayoutFuelType.setErrorEnabled(false);
        mLayoutMileage.setErrorEnabled(false);
        mLayoutLitres.setErrorEnabled(false);
        mLayoutGasPrice.setErrorEnabled(false);
        mLayoutTotalPrice.setErrorEnabled(false);


        if (Utility.isEmptyOrNull(mSpinnerVehicleName.getText().toString())) {
            mSpinnerVehicleName.setError(getString(R.string.refuel_vehicle_name_error));
            errors.add(getString(R.string.refuel_vehicle_name_error));
            result = false;
        }
        if (Utility.isEmptyOrNull(mRefuelDate.getText().toString())) {
            mRefuelLayoutDate.setErrorEnabled(true);
            mRefuelLayoutDate.setError(getString(R.string.refuel_error_date));
            errors.add(getString(R.string.refuel_error_date));
            result = false;
        }
        if (Utility.isEmptyOrNull(mRefuelFuelType.getText().toString())) {
            mRefuelLayoutFuelType.setErrorEnabled(true);
            mRefuelLayoutFuelType.setError(getString(R.string.refuel_error_fuel_type));
            errors.add((getString(R.string.refuel_error_fuel_type)));
            result = false;
        }
        if (Utility.isEmptyOrNull(mMileage.getText().toString())) {
            mLayoutMileage.setErrorEnabled(true);
            mLayoutMileage.setError(getString(R.string.refuel_error_mileage));
            errors.add((getString(R.string.refuel_error_mileage)));
            result = false;
        }
        if (Utility.isEmptyOrNull(mLitres.getText().toString())) {
            mLayoutLitres.setErrorEnabled(true);
            mLayoutLitres.setError(getString(R.string.refuel_error_litres));
            errors.add(getString(R.string.refuel_error_litres));
            result = false;
        }
        if (Utility.isEmptyOrNull(mLitres.getText().toString())) {
            mLayoutLitres.setErrorEnabled(true);
            mLayoutLitres.setError(getString(R.string.refuel_error_litres));
            errors.add(getString(R.string.refuel_error_litres));
            result = false;
        }
        if (Utility.isEmptyOrNull(mGasPrice.getText().toString())) {
            mLayoutGasPrice.setErrorEnabled(true);
            mLayoutGasPrice.setError(getString(R.string.refuel_error_gas_price));
            errors.add(getString(R.string.refuel_error_gas_price));
            result = false;
        }
        if (Utility.isEmptyOrNull(mTotalPrice.getText().toString())) {
            mLayoutTotalPrice.setErrorEnabled(true);
            mLayoutTotalPrice.setError(getString(R.string.refuel_error_total_price));
            errors.add(getString(R.string.refuel_error_total_price));
            result = false;
        }

//        for(String error:errors){
//            showToast(error);
//
//        }
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
        RefuelSelection where = new RefuelSelection();
        where.id(mRefuelId);
        where.delete(this);
    }


    @Override
    public void onDataChanged() {
        isDataChanged = true;
    }
}
