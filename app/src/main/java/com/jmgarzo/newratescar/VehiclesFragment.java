package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jmgarzo.newratescar.adapter.VehicleAdapter;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class VehiclesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int VEHICLE_LOADER_ID = 0;

    private VehicleAdapter mVehicleAdapter;

    private ListView mListView;


    public VehiclesFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(VEHICLE_LOADER_ID,null,this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mVehicleAdapter = new VehicleAdapter(getActivity(),null,0);

        View rootView =  inflater.inflate(R.layout.fragment_vehicle, container, false);

        mListView = (ListView) rootView.findViewById(R.id.listview_vehicles);
        mListView.setAdapter(mVehicleAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                VehicleColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mVehicleAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mVehicleAdapter.swapCursor(null);
    }
}
