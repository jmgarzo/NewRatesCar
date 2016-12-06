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
import com.jmgarzo.newratescar.Task.SaveRoad;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessContentValues;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.road_action_delete;

public class RoadworthinesDetail extends AppCompatActivity implements RoadworthinesDetailFragment.Callback{

    private final String LOG_TAG = RoadworthinessActivity.class.getSimpleName();

    private Long mRoadId = null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;

    MaterialDialog md;


    private MaterialBetterSpinner mVehicleName;
    private TextInputLayout mRoadLayoutDate;
    private EditText mRoadDate;
    private EditText mMileage;
    private TextInputLayout mRoadLayoutPrice;
    private EditText mPrice;
    private AutoCompleteTextView mResult;
    private EditText mRoadNextDate;
    private EditText mAdditionalInf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadworthines_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isDataChanged=false;


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            RoadworthinesDetailFragment fragment = new RoadworthinesDetailFragment();

            mRoadId = getIntent().getLongExtra(RoadworthinessColumns._ID, -1);
            arguments.putLong(RefuelColumns._ID, mRoadId);

            if (mRoadId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.road_detail_container, fragment)
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
                        RoadworthinesDetail.super.onBackPressed();
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
        getMenuInflater().inflate(R.menu.menu_roadworthines_detail, menu);
        if (isNew) {
            menu.removeItem(road_action_delete);
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
            case R.id.action_done_road:
                if (saveData()) {
                    showToast(R.string.toast_road_saved);
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

    @Override
    public void onDataChanged() {
        isDataChanged=true;
    }


    private boolean saveData() {

        //mInputLayoutVehicleName = (TextInputLayout) findViewById(input_layout_vehicle_name);

        mVehicleName = (MaterialBetterSpinner) findViewById(R.id.better_spinner_road_vehicle_name);
        mRoadLayoutDate = (TextInputLayout) findViewById(R.id.input_layout_road_date);
        mRoadDate = (EditText) findViewById(R.id.input_road_date);
        mMileage = (EditText) findViewById(R.id.input_road_mileage);
        mPrice = (EditText) findViewById(R.id.input_road_price);
        mResult = (AutoCompleteTextView) findViewById(R.id.autocompleteView_road_result);
        mRoadNextDate = (EditText) findViewById(R.id.input_road_next_date);
        mAdditionalInf = (EditText) findViewById(R.id.input_road_additional_information);
        boolean isCorrect = true;


        String vehicleName = mVehicleName.getText().toString();

        GregorianCalendar cal = new GregorianCalendar();
        String sFecha = mRoadDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cal.setTime(format.parse(sFecha));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }



        GregorianCalendar cal2 = new GregorianCalendar();
        String sFecha2 = mRoadNextDate.getText().toString();
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            cal2.setTime(format2.parse(sFecha2));
        } catch (ParseException e) {
            isCorrect = false;
            Log.e(LOG_TAG, e.toString());
        }

        if (isValidateEmptyFields()) {
            RoadworthinessContentValues values = new RoadworthinessContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this, vehicleName))
                    .putRoadworthinessDate(cal.getTimeInMillis())
                    .putRoadworthinessMileage(Utility.getIntegerNoNull(mMileage.getText().toString()))
                    .putRoadworthinessPrice(Utility.getDoubleNoNull(mPrice.getText().toString()))
                    .putRoadworthinessResult(mResult.getText().toString())
                    .putRoadworthinessNextDate(cal2.getTimeInMillis())
                    .putRoadworthinessAdditionalInformation(mAdditionalInf.getText().toString());


            SaveRoad saveRoad = new SaveRoad(this, mRoadId,mVehicleName.getText().toString(), Utility.getIntegerNoNull(mMileage.getText().toString()));
            saveRoad.execute(values);

            Intent intent = new Intent(this, RoadworthinessActivity.class);
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
        ArrayList<String> errors = new ArrayList<>();
        mRoadLayoutDate.setErrorEnabled(false);



        if (Utility.isEmptyOrNull(mVehicleName.getText().toString())) {
            mVehicleName.setError(getString(R.string.road_vehicle_name_error));
            errors.add(getString(R.string.road_vehicle_name_error));
            result = false;
        }
        if (Utility.isEmptyOrNull(mRoadDate.getText().toString())) {
            mRoadLayoutDate.setErrorEnabled(true);
            mRoadLayoutDate.setError(getString(R.string.road_error_date));
            errors.add(getString(R.string.road_error_date));
            result = false;
        }

        return result;
    }

    void delete() {
        RoadworthinessSelection where = new RoadworthinessSelection();
        where.id(mRoadId);
        where.delete(this);
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
}
