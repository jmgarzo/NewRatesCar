package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.make.MakeSelection;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class VehicleDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onDataChanged();
    }

    private static final String LOG_TAG = VehicleDetailFragment.class.getSimpleName();

    private static final int VEHICLE_LOADER = 0;
    private static final int VEHICLE_CLASS_LOADER = 1;

    public static final String VEHICLE_ID = "VEHICLE_ID";
    private Long mVehicleId;
    private EditText mVehicleName;
    private MaterialBetterSpinner mVehicleClass;
    //private MaterialBetterSpinner mVehicleFuelType;
    private AutoCompleteTextView mVehicleFuelType;
    private AutoCompleteTextView mVehicleMake;
    private EditText mVehicleModel;
    private EditText mVehicleMileage;
    private EditText mVehicleAddInformation;

    ArrayList<String> mVehicleClassList;
    ArrayAdapter<String> mVehicleClassAdapter;
    ArrayList<String> mFuelTypeList;
    ArrayAdapter<String> mFuelTypeAdapter;
    ArrayAdapter<String> mMakeAdapter;


    public VehicleDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mVehicleId = null;


        Bundle argument = getArguments();
        if (argument != null) {
            mVehicleId = argument.getLong(VehicleColumns._ID);
        }

        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);

        mVehicleName = (EditText) view.findViewById(R.id.input_vehicle_name);
        mVehicleClass = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_vehicle_class);
        mVehicleFuelType = (AutoCompleteTextView) view.findViewById(R.id.autocompleteView_vehicle_fuel_type);
        mVehicleMake = (AutoCompleteTextView) view.findViewById(R.id.autocompleteView_vehicle_make);
        mVehicleModel = (EditText) view.findViewById(R.id.input_vehicle_model);
        mVehicleMileage = (EditText) view.findViewById(R.id.input_vehicle_mileage);
        mVehicleAddInformation = (EditText) view.findViewById(R.id.input_vehicle_add_information);


        //TODO: Get that values by a Loader
        initialValuesVehicleClass();

        initialValuesFuelType();

        initialValuesMake();

        return view;


    }



    void initialValuesVehicleClass() {
        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        Cursor c = getActivity().getContentResolver().query(vehicleClassSelection.uri(), null, null, null, null);
        mVehicleClassList = new ArrayList<>();
        while (c.moveToNext()) {
            int index = c.getColumnIndex(VehicleClassColumns.VEHICLE_CLASS_NAME);
            mVehicleClassList.add(c.getString(index));

        }

        mVehicleClassAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mVehicleClassList);
        mVehicleClass.setAdapter(mVehicleClassAdapter);


    }

    void initialValuesFuelType() {
        FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
        Cursor cursorFuelType = getActivity().getContentResolver().query(fuelTypeSelection.uri(), null, null, null, null);
        mFuelTypeList = new ArrayList<>();
        while (cursorFuelType.moveToNext()) {
            int index = cursorFuelType.getColumnIndex(FuelTypeColumns.FUEL_TYPE_NAME);
            mFuelTypeList.add(cursorFuelType.getString(index));
        }


        mFuelTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mFuelTypeList);
        mVehicleFuelType.setAdapter(mFuelTypeAdapter);



    }

    void initialValuesMake() {
        MakeSelection makeSelection = new MakeSelection();
        Cursor cursorMake = getActivity().getContentResolver().query(makeSelection.uri(), null, null, null, null);
        ArrayList<String> makeList = new ArrayList<>();
        while (cursorMake.moveToNext()) {
            int index = cursorMake.getColumnIndex(MakeColumns.MAKE_NAME);
            makeList.add(cursorMake.getString(index));

        }


        mMakeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, makeList);

        mVehicleMake.setAdapter(mMakeAdapter);



    }


    @Override
    public void setEnterSharedElementCallback(SharedElementCallback callback) {
        super.setEnterSharedElementCallback(callback);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(VEHICLE_LOADER, null, this);
        //getLoaderManager().initLoader(VEHICLE_CLASS_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case VEHICLE_LOADER: {
                if (mVehicleId != null) {
                    return new CursorLoader(
                            getActivity(),
                            VehicleColumns.CONTENT_URI,
                            VehicleColumns.ALL_COLUMNS,
                            VehicleColumns._ID + "= ?",
                            new String[]{mVehicleId.toString()},
                            null
                    );
                }
            }
            case VEHICLE_CLASS_LOADER: {
//                return new CursorLoader(
//                        getActivity(),
//                        VehicleClassColumns.CONTENT_URI,
//                        VehicleClassColumns.ALL_COLUMNS,
//                        null,
//                        null,
//                        null
//                );
            }


        }
        return null;


        //Vehicle Class better spinner

//            VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
//            Cursor c = getActivity().getContentResolver().query(vehicleClassSelection.uri(), null, null, null, null);
//            ArrayList<String> vehicleClassList = new ArrayList<>();
//            while (c.moveToNext()) {
//                int index = c.getColumnIndex(VehicleClassColumns.VEHICLE_CLASS_NAME);
//                vehicleClassList.add(c.getString(index));
//
//            }

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch (loader.getId()) {
            case VEHICLE_LOADER: {
                if (data != null && data.moveToFirst()) {
                    String name = data.getString(ProviderUtilities.COL_VEHICLE_NAME);
                    mVehicleName.setText(name);

                    fillVehicleClass(data);

                    fillVehicleFuelType(data);

                    fillVehicleMake(data);

                    mVehicleModel.setText(data.getString(ProviderUtilities.COL_VEHICLE_MODEL));
                    mVehicleMileage.setText(data.getString(ProviderUtilities.COL_VEHICLE_MILEAGE));
                    mVehicleAddInformation.setText(data.getString(ProviderUtilities.COL_VEHICLE_ADDITIONAL_INFORMATION));

                    mVehicleName.addTextChangedListener(textWatcher);
                    mVehicleClass.addTextChangedListener(textWatcher);
                    mVehicleFuelType.addTextChangedListener(textWatcher);
                    mVehicleMake.addTextChangedListener(textWatcher);
                    mVehicleModel.addTextChangedListener(textWatcher);
                    mVehicleMileage.addTextChangedListener(textWatcher);
                    mVehicleAddInformation.addTextChangedListener(textWatcher);
                }
            }
            case VEHICLE_CLASS_LOADER: {

//                ArrayList<String> vehicleClassList = new ArrayList<>();
//                ArrayAdapter<String> vehicleClassAdapter = new ArrayAdapter<String>(getActivity(),
//                        android.R.layout.simple_dropdown_item_1line, vehicleClassList);
//
//                vehicleClassAdapter
//                mVehicleClass.setAdapter(vehicleClassAdapter);

            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void fillVehicleClass(Cursor data) {
        String vehicleClass = ProviderUtilities.getVehicleClassName(getActivity(),
                data.getLong(ProviderUtilities.COL_VEHICLE_CLASS));

        Integer position = null;

        if (vehicleClass != null && !vehicleClass.equalsIgnoreCase("")) {
            for (int i = 0; i < mVehicleClassAdapter.getCount(); i++) {
                if (vehicleClass.equalsIgnoreCase(mVehicleClassAdapter.getItem(i))) {
                    position = i;
                    break;
                }
            }

            if (null != position) {
                mVehicleClass.setText(mVehicleClassAdapter.getItem(position));
            }
        }
    }

    private void fillVehicleFuelType(Cursor data) {
        String vehicleFuelType = ProviderUtilities.getVehicleFuelTypeName(getActivity(),
                data.getLong(ProviderUtilities.COL_VEHICLE_FUEL_TYPE));

        Integer position = null;

        if (null != vehicleFuelType && !vehicleFuelType.equalsIgnoreCase("")) {
            for (int i = 0; i < mFuelTypeAdapter.getCount(); i++) {
                if (vehicleFuelType.equalsIgnoreCase(mFuelTypeAdapter.getItem(i))) {
                    position = i;
                    break;
                }
            }
            if (null != position) {
                mVehicleFuelType.setText(mFuelTypeAdapter.getItem(position));
            }
        }
    }

    private void fillVehicleMake(Cursor data) {
        String make = ProviderUtilities.getMakeName(getActivity(),
                data.getLong(ProviderUtilities.COL_VEHICLE_MAKE));

        Integer position = null;

        if (null != make && !make.equalsIgnoreCase("")) {
            for (int i = 0; i < mMakeAdapter.getCount(); i++) {
                if (make.equalsIgnoreCase(mMakeAdapter.getItem(i))) {
                    position = i;
                    break;
                }
            }
            if (null != position) {
                mVehicleMake.setText(mMakeAdapter.getItem(position));
            }
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((Callback) getActivity())
                    .onDataChanged();

        }
    };


}
