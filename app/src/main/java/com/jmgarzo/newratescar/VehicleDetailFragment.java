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

import com.jmgarzo.newratescar.adapter.VehicleClassAdapter;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class VehicleDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int VEHICLE_CLASS_LOADER = 0;

    private VehicleClassAdapter mVehicleClassAdapter;

    public VehicleDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);

        //String[] SPINNERLIST = {"Android Material Design", "Material Design Spinner", "Spinner Using Material Library", "Material Spinner Example"};

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, getVehicleClass());

        mVehicleClassAdapter = new VehicleClassAdapter(getActivity(),null,0);

        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                view.findViewById(R.id.better_spinner_vehicle_class);
        materialDesignSpinner.setAdapter(mVehicleClassAdapter);

        return view;


    }

    private ArrayList<String> getVehicleClass() {
        ArrayList<String> classesList = new ArrayList<String>();

        VehicleClassSelection vcs = new VehicleClassSelection();
        VehicleClassCursor vcc = vcs.query(getActivity().getContentResolver());
        while (vcc.moveToNext()) {
            classesList.add(vcc.getVehicleClassName());
        }
        return classesList;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(VEHICLE_CLASS_LOADER,null,this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        switch (id){
            case VEHICLE_CLASS_LOADER:{
                return  new CursorLoader(getActivity(),
                        VehicleClassColumns.CONTENT_URI,
                        null,
                        null,
                        null,
                        null);
            }
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mVehicleClassAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mVehicleClassAdapter.swapCursor(null);

    }
}
