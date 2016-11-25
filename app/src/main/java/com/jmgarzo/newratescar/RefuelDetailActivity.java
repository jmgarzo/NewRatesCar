package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelContentValues;
import com.jmgarzo.newratescar.provider.refuel.RefuelSelection;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.jmgarzo.newratescar.R.id.action_delete;

public class RefuelDetailActivity extends AppCompatActivity implements RefuelDetailFragment.Callback {

    private Long refuelId=null;
    private boolean isNew;
    private boolean isDataChanged;

    private Toast mToast;


    MaterialBetterSpinner mSpinnerVehicleName;
    EditText mRefuelDate;



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

            refuelId = getIntent().getLongExtra(RefuelColumns._ID, -1);
            arguments.putLong(VehicleColumns._ID, refuelId);

            if (refuelId == -1) {
                isNew = true;
            } else {
                isNew = false;
            }

            //fragment.setArguments(arguments);

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
        mRefuelDate = (EditText) findViewById(R.id.input_refuel_date);


        boolean isCorrect = true;

//        String vehicleName = mInputVehicleName.getText().toString();
//        if (vehicleName.equalsIgnoreCase("")) {
//            mInputLayoutVehicleName.setErrorEnabled(true);
//            mInputLayoutVehicleName.setError(getString(R.string.vehicle_name_error));
//            isCorrect = false;
//        }


        String vehicleName = mSpinnerVehicleName.getText().toString();


        String sfecha = mRefuelDate.getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar cal = new GregorianCalendar();
        try {
            cal.setTime(format.parse(sfecha));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Date refuelDate =cal.getGregorianChange();
        // calendarFecha.getTimeInMillis();


        if (isCorrect) {
            RefuelContentValues values = new RefuelContentValues();
            values.putVehicleId(ProviderUtilities.getVehicleId(this,vehicleName))
                    .putRefuelDate(refuelDate)
                    .putRefuelFuelSubtype(ProviderUtilities.getVehicleFuelSubtypeId(this,"carisimo"))
                    .putRefuelMileage(12)
                    .putRefuelTripOdometer(14)
                    .putRefuelLitres(20f)
                    .putRefuelGasPrice(1f)
                    .putRefuelTotalPrice(26f)
                    .putIsFull(false)
                    .putIsTrailer(false)
                    .putIsRoofRack(false)
                    .putRouteType(50)
                    .putDrivingStyle(50)
                    .putAverageConsumption(5.5f);



            if (isNew) {
                getContentResolver().insert(values.uri(), values.values());
            } else {
                getContentResolver().update(values.uri(),
                        values.values(),
                        RefuelColumns._ID + "= ?",
                        new String[]{refuelId.toString()});
            }

            Intent intent = new Intent(this, RefuelsActivity.class);
            startActivity(intent);
        }else{
//            mInputVehicleName.requestFocus();
        }
        return isCorrect;
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

    void delete(){
        RefuelSelection where = new RefuelSelection();
        where.id(refuelId);
        where.delete(this);
    }


    @Override
    public void onDataChanged() {
        isDataChanged=true;
    }
}
