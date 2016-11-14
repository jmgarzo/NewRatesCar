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
    private int mPosition = ListView.INVALID_POSITION;


    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Long vehicleId);
    }


    public VehiclesFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(VEHICLE_LOADER_ID,null,this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mVehicleAdapter = new VehicleAdapter(getActivity(),null,0);

        View rootView =  inflater.inflate(R.layout.fragment_vehicle, container, false);

        mListView = (ListView) rootView.findViewById(R.id.listview_vehicles);
        mListView.setAdapter(mVehicleAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
                if (cursor != null) {
                    ((Callback) getActivity())
                            .onItemSelected(cursor.getLong(ProviderUtilities.COL_VEHICLE_ID)
                            );
                }
                mPosition = position;

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
