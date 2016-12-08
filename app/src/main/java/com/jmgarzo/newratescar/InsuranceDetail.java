package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.jmgarzo.newratescar.Task.SaveInsurance;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;
import com.jmgarzo.newratescar.provider.insurance.InsuranceContentValues;
import com.jmgarzo.newratescar.provider.insurance.InsuranceSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.action_delete;

public class InsuranceDetail extends AppCompatActivity implements InsuranceDetailFragment.Callback {

    private final String LOG_TAG = InsuranceDetail.class.getSimpleName();

    private Long mInsuranceId = null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;

    private MaterialBetterSpinner mVehicleName;

    private EditText mStartDate;
    private EditText mEndDate;
    private EditText mPrice;
    private TextView mPriceCurrency;
    private EditText mCompany;
    private EditText mPolicy;
    private EditText mAdditionalInf;

    MaterialDialog md;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        isDataChanged = false;


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            InsuranceDetailFragment fragment = new InsuranceDetailFragment();

            mInsuranceId = getIntent().getLongExtra(InsuranceColumns._ID, -1);
            arguments.putLong(InsuranceColumns._ID, mInsuranceId);

            if (mInsuranceId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.insurance_detail_container, fragment)
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
                        InsuranceDetail.super.onBackPressed();
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
        getMenuInflater().inflate(R.menu.menu_insurance_detail, menu);
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

        mVehicleName = (MaterialBetterSpinner) findViewById(R.id.better_spinner_insurance_vehicle_name);
        mStartDate = (EditText) findViewById(R.id.input_insurance_start_date);
        mEndDate = (EditText) findViewById(R.id.input_insurance_end_date);
        mPrice = (EditText) findViewById(R.id.input_insurance_price);
        mCompany = (EditText) findViewById(R.id.input_insurance_company);
        mPolicy = (EditText) findViewById(R.id.input_insurance_policy);
        mAdditionalInf=(EditText) findViewById(R.id.input_insurance_additional_information);

        boolean isCorrect = true;
        String vehicleName = mVehicleName.getText().toString();

        GregorianCalendar cal = new GregorianCalendar();
        String sFecha = mStartDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cal.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }

        GregorianCalendar cal2 = new GregorianCalendar();
        String sFecha2 = mEndDate.getText().toString();
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cal2.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }


        if (isValidateEmptyFields()) {
            InsuranceContentValues values = new InsuranceContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this, vehicleName))
                    .putStartDate(cal.getTimeInMillis())
                    .putEndDate(cal2.getTimeInMillis())
                    .putInsurancePrice(Utility.getDoubleNoNull(mPrice.getText().toString()))
                    .putInsuranceCompany(mCompany.getText().toString())
                    .putPolicyNumber(mPolicy.getText().toString())
                    .putInsuranceAdditionalInformation(mAdditionalInf.getText().toString());



            SaveInsurance saveInsurance = new SaveInsurance(this, mInsuranceId);
            saveInsurance.execute(values);

            Intent intent = new Intent(this, Insurance.class);
            startActivity(intent);
        } else {
            isCorrect = false;
            mVehicleName.requestFocus();
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
        if(Utility.isEmptyOrNull(mVehicleName.getText().toString())){
            mVehicleName.setError(getString(R.string.refuel_vehicle_name_error));
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
        InsuranceSelection where = new InsuranceSelection();
        where.id(mInsuranceId);
        where.delete(this);
    }

    @Override
    public void onDataChanged() {
        isDataChanged = true;
    }




}
