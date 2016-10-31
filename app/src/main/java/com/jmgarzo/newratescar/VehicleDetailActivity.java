package com.jmgarzo.newratescar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.jmgarzo.newratescar.provider.fueltype.FuelTypeCursor;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class VehicleDetailActivity extends AppCompatActivity {

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

                EditText inputVehicleName = (EditText) findViewById(R.id.input_vehicle_name);
                String vehicleName = inputVehicleName.getText().toString();

                MaterialBetterSpinner inputVehicleClass = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_class);
                String vehicleClass = inputVehicleClass.getText().toString();

                MaterialBetterSpinner inputVehicleFuelType = (MaterialBetterSpinner) findViewById(R.id.better_spinner_vehicle_fuel_type);
                String vehicleFuelType = inputVehicleFuelType.getText().toString();




                VehicleContentValues values = new VehicleContentValues();
                values.putVehicleName(vehicleName)
                        .putVehicleClass(getVehicleClass(vehicleClass));
                getContentResolver().insert(values.uri(), values.values());

                Intent intent = new Intent(view.getContext(), VehiclesActivity.class);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    long getVehicleClass(String vehicleClass) {
        long id = -1;

        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        vehicleClassSelection.vehicleClassName(vehicleClass);
        VehicleClassCursor cursor = vehicleClassSelection.query(this);

        if (cursor.moveToNext()) {
            id = cursor.getId();
        }
        if (id == -1) {
            vehicleClassSelection.vehicleClassName(getString(R.string.car_class));
            VehicleClassCursor cursor2 = vehicleClassSelection.query(this);
            if (cursor.moveToFirst()){
                id = cursor2.getId();
            }
        }
        return id;
    }

    long getVehicleFuelType(String vehicleFuelType) {
        long id = -1;

        FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
        fuelTypeSelection.fuelTypeName(vehicleFuelType);
        FuelTypeCursor cursor = fuelTypeSelection.query(this);

        if (cursor.moveToNext()) {
            id = cursor.getId();
        }
        if (id == -1) {
            fuelTypeSelection.fuelTypeName(getString(R.string.fuel_type_diesel));
            FuelTypeCursor cursor2 = fuelTypeSelection.query(this);
            if (cursor.moveToFirst()){
                id = cursor2.getId();
            }
        }
        return id;
    }


}
