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

import com.jmgarzo.newratescar.adapter.MaintenanceAdapter;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaintenancesFragment extends Fragment  implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int MAINTENANCE_LOADER_ID = 0;

    private MaintenanceAdapter mMaintenanceAdapter;

    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;

    public interface Callback {
        public void onItemSelected(Long vehicleId);
    }

    public MaintenancesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maintenances, container, false);

        View emptyView = rootView.findViewById(R.id.recyclerview_maintenance_empty);


        mMaintenanceAdapter = new MaintenanceAdapter(getActivity(),new MaintenanceAdapter.MaintenanceAdapterOnClickHandler(){
            @Override
            public void onClick(Long idVehicle, MaintenanceAdapter.MaintenanceViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(idVehicle);
                mPosition = vh.getAdapterPosition();
            }
        },emptyView );

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_maintenance);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mMaintenanceAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(MAINTENANCE_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        getLoaderManager().initLoader(MAINTENANCE_LOADER_ID, null, this);
        super.onResume();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                MaintenanceColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mMaintenanceAdapter.swapCursor(data);
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
        //Todo: updateEmptyView();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mMaintenanceAdapter.swapCursor(null);
    }
}
