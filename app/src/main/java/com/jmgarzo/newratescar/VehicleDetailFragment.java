package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.SharedElementCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.make.MakeSelection;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

import static com.jmgarzo.newratescar.R.id.input_vehicle_name;

/**
 * A placeholder fragment containing a simple view.
 */
public class VehicleDetailFragment extends Fragment {


    public static final String VEHICLE_ID = "VEHICLE_ID";

    public VehicleDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);

        getArguments().getString(VEHICLE_ID);


        EditText inputVehicleName = (EditText) getActivity().findViewById(input_vehicle_name);




        //Vehicle Class better spinner

        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        Cursor c = getActivity().getContentResolver().query(vehicleClassSelection.uri(), null, null, null, null);
        ArrayList<String> vehicleClassList = new ArrayList<>();
        while (c.moveToNext()) {
            int index = c.getColumnIndex(VehicleClassColumns.VEHICLE_CLASS_NAME);
            vehicleClassList.add(c.getString(index));

        }

        MaterialBetterSpinner vehicleClassSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.better_spinner_vehicle_class);

        ArrayAdapter<String> vehicleClassAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, vehicleClassList);

        vehicleClassSpinner.setAdapter(vehicleClassAdapter);


        //Fuel Type better spinner

        FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
        Cursor cursorFuelType = getActivity().getContentResolver().query(fuelTypeSelection.uri(), null, null, null, null);
        ArrayList<String> fuelTypeList = new ArrayList<>();
        while (cursorFuelType.moveToNext()) {
            int index = cursorFuelType.getColumnIndex(FuelTypeColumns.FUEL_TYPE_NAME);
            fuelTypeList.add(cursorFuelType.getString(index));
        }

        MaterialBetterSpinner vehicleFuelTypeSpinner = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_vehicle_fuel_type);

        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, fuelTypeList);

        vehicleFuelTypeSpinner.setAdapter(fuelTypeAdapter);

        MakeSelection makeSelection = new MakeSelection();
        Cursor cursorMake = getActivity().getContentResolver().query(makeSelection.uri(),null,null,null,null);
        ArrayList<String> makeList = new ArrayList<>();
        while (cursorMake.moveToNext()){
            int index = cursorMake.getColumnIndex(MakeColumns.MAKE_NAME);
            makeList.add(cursorMake.getString(index));

        }

        MaterialBetterSpinner vehicleMake= (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_vehicle_make);

        ArrayAdapter<String> makeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, makeList);

        vehicleMake.setAdapter(makeAdapter);

        return view;


    }

    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }
}
