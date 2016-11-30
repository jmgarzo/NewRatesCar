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

import com.jmgarzo.newratescar.adapter.RefuelAdapter;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class RefuelsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int REFUEL_LOADER_ID = 0;

    private RefuelAdapter mRefuelAdapter;

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


    public RefuelsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_refuels, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_refuel_empty);


        mRefuelAdapter = new RefuelAdapter(getActivity(),new RefuelAdapter.RefuelAdapterOnClickHandler(){
            @Override
            public void onClick(Long idVehicle, RefuelAdapter.RefuelViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(idVehicle);
                mPosition = vh.getAdapterPosition();
            }
        },emptyView );

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_refuels);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mRefuelAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(REFUEL_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        getLoaderManager().initLoader(REFUEL_LOADER_ID, null, this);

        super.onResume();

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                RefuelColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mRefuelAdapter.swapCursor(data);
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
        //Todo: updateEmptyView();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mRefuelAdapter.swapCursor(null);
    }
}
