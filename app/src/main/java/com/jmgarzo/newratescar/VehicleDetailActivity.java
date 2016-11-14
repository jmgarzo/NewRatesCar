package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static com.jmgarzo.newratescar.R.id.input_layout_vehicle_name;

public class VehicleDetailActivity extends AppCompatActivity {

    private Long vehicleId;

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

                boolean isCorrect = true;
                TextInputLayout inputLayoutVehicleName = (TextInputLayout) findViewById(input_layout_vehicle_name);


                EditText inputVehicleName = (EditText) findViewById(R.id.input_vehicle_name);
                String vehicleName = inputVehicleName.getText().toString();
                if (vehicleName.equalsIgnoreCase("")) {
                    inputLayoutVehicleName.setErrorEnabled(true);
                    inputLayoutVehicleName.setError(getString(R.string.vehicle_name_error));
                    isCorrect = false;
                }

                MaterialBetterSpinner inputVehicleClass = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_class);
                String vehicleClass = inputVehicleClass.getText().toString();

                MaterialBetterSpinner inputVehicleFuelType = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_fuel_type);
                String vehicleFuelType = inputVehicleFuelType.getText().toString();


                if (isCorrect) {
                    VehicleContentValues values = new VehicleContentValues();
                    values.putVehicleName(vehicleName)
                            .putVehicleClass(ProviderUtilities.getVehicleClassId(view.getContext(), vehicleClass))
                            .putFuelType(ProviderUtilities.getVehicleFuelTypeId(view.getContext(), vehicleFuelType));

                    getContentResolver().insert(values.uri(), values.values());

                    Intent intent = new Intent(view.getContext(), VehiclesActivity.class);
                    startActivity(intent);
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if(savedInstanceState == null) {
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
