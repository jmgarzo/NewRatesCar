package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmgarzo.newratescar.adapter.VehicleAdapter;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class VehiclesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int VEHICLE_LOADER_ID = 0;

    private VehicleAdapter mVehicleAdapter;

    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;


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



        View rootView =  inflater.inflate(R.layout.fragment_vehicle, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_vehicles_empty);


        mVehicleAdapter = new VehicleAdapter(getActivity(),new VehicleAdapter.VehicleAdapterOnClickHandler(){
            @Override
            public void onClick(Long idVehicle, VehicleAdapter.VehicleViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(idVehicle);
                mPosition = vh.getAdapterPosition();
                }
        },emptyView );

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_vehicles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mVehicleAdapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
//                if (cursor != null) {
//                    ((Callback) getActivity())
//                            .onItemSelected(cursor.getLong(ProviderUtilities.COL_VEHICLE_ID)
//                            );
//                }
//                mPosition = position;
//
//            }
//        });

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
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
        //Todo: updateEmptyView(); 6.16

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mVehicleAdapter.swapCursor(null);
    }
}
