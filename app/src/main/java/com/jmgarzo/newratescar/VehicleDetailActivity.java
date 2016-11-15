package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleCursor;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static com.jmgarzo.newratescar.R.id.input_layout_vehicle_name;

public class VehicleDetailActivity extends AppCompatActivity {

    private static final String LOG_TAG = VehicleDetailActivity.class.getSimpleName();

    private Long vehicleId;

    private TextInputLayout mInputLayoutVehicleName;
    EditText mInputVehicleName;
    MaterialBetterSpinner mSpinnerVehicleClass;
    MaterialBetterSpinner mSpinnerFuelType;
    MaterialBetterSpinner mSpinnerMake;
    EditText mInputModel;
    EditText mInputMileage;
    EditText mInputAddInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mInputLayoutVehicleName = (TextInputLayout) findViewById(input_layout_vehicle_name);
                mInputVehicleName = (EditText) findViewById(R.id.input_vehicle_name);
                mSpinnerVehicleClass = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_class);
                mSpinnerFuelType = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_fuel_type);
                mSpinnerMake = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_make);
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
                String vehicleFuelType = mSpinnerFuelType.getText().toString();
                String vehicleMake = mSpinnerMake.getText().toString();
                String vehicleModel = mInputModel.getText().toString();

                int vehicleMileage = 0;
                try {
                    vehicleMileage = Integer.valueOf(mInputMileage.getText().toString());
                } catch (NumberFormatException e) {
                    Log.e(LOG_TAG,"vehicleMileage Integer.valueOf exception");
                    vehicleMileage = 0;
                }

                String addInformation = mInputAddInformation.getText().toString();


                if (isCorrect) {
                    VehicleContentValues values = new VehicleContentValues();
                    values.putVehicleName(vehicleName)
                            .putVehicleClass(ProviderUtilities.getVehicleClassId(view.getContext(), vehicleClass))
                            .putFuelType(ProviderUtilities.getVehicleFuelTypeId(view.getContext(), vehicleFuelType))
                            .putMake(ProviderUtilities.getMakeId(view.getContext(), vehicleMake))
                            .putModel(vehicleModel)
                            .putMileage(vehicleMileage)
                            .putAdditionalInformation(addInformation);

                    getContentResolver().insert(values.uri(), values.values());

                    Intent intent = new Intent(view.getContext(), VehiclesActivity.class);
                    startActivity(intent);
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            VehicleDetailFragment fragment = new VehicleDetailFragment();

            Long idVehicle = getIntent().getLongExtra(VehicleColumns._ID, -1);
            arguments.putLong(VehicleColumns._ID, idVehicle);

            fragment.setArguments(arguments);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.vehicle_detail_container, fragment)
                    .commit();



        }

        //vehicleId = getIntent().getLongExtra(VehicleDetailFragment.VEHICLE_ID,-1);

    }


}