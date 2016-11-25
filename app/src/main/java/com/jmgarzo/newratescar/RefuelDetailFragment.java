package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class RefuelDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onDataChanged();
    }

    private static final String LOG_TAG = RefuelDetailFragment.class.getSimpleName();

    private static final int REFUEL_LOADER = 0;

    private Long mRefuelId;
    private MaterialBetterSpinner mVehicleName;

    ArrayList<String> mVehicleNameList;
    ArrayAdapter<String> mVehicleNameAdapter;


    public RefuelDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refuel_detail, container, false);

        mRefuelId = null;
        Bundle argument = getArguments();
        if (argument != null) {
            mRefuelId = argument.getLong(RefuelColumns._ID);
        }

        mVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_vehicle_name);

        initialValuesVehicleName();

        return view;
    }


    void initialValuesVehicleName() {
        VehicleSelection vehicleSelection = new VehicleSelection();
        Cursor c = getActivity().getContentResolver().query(vehicleSelection.uri(), null, null, null, null);
        mVehicleNameList = new ArrayList<>();
        while (c.moveToNext()) {
            int index = c.getColumnIndex(VehicleColumns.VEHICLE_NAME);
            mVehicleNameList.add(c.getString(index));

        }

        mVehicleNameAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mVehicleNameList);
        mVehicleName.setAdapter(mVehicleNameAdapter);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(REFUEL_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case REFUEL_LOADER: {
                if (mRefuelId != null) {
                    return new CursorLoader(
                            getActivity(),
                            RefuelColumns.CONTENT_URI,
                            RefuelColumns.ALL_COLUMNS,
                            RefuelColumns._ID + "= ?",
                            new String[]{mRefuelId.toString()},
                            null
                    );
                }
            }
        }

        return null;
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch (loader.getId()) {
            case REFUEL_LOADER: {
                if (data != null && data.moveToFirst()) {
                    String name = data.getString(ProviderUtilities.COL_REFUEL_VEHICLE_ID);
                    mVehicleName.setText(name);

//                    fillVehicleClass(data);
//
//                    fillVehicleFuelType(data);
//
//                    fillVehicleMake(data);
//
//                    mVehicleModel.setText(data.getString(ProviderUtilities.COL_VEHICLE_MODEL));
//                    mVehicleMileage.setText(data.getString(ProviderUtilities.COL_VEHICLE_MILEAGE));
//                    mVehicleAddInformation.setText(data.getString(ProviderUtilities.COL_VEHICLE_ADDITIONAL_INFORMATION));
//
//                    mVehicleName.addTextChangedListener(textWatcher);
//                    mVehicleClass.addTextChangedListener(textWatcher);
//                    mVehicleFuelType.addTextChangedListener(textWatcher);
//                    mVehicleMake.addTextChangedListener(textWatcher);
//                    mVehicleModel.addTextChangedListener(textWatcher);
//                    mVehicleMileage.addTextChangedListener(textWatcher);
//                    mVehicleAddInformation.addTextChangedListener(textWatcher);
                }

            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
