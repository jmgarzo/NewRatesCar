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

import com.jmgarzo.newratescar.adapter.TollAdapter;
import com.jmgarzo.newratescar.provider.toll.TollColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class TollsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int TOLL_LOADER_ID = 0;

    private TollAdapter mTollAdapter;

    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;

    public interface Callback {

        public void onItemSelected(Long vehicleId);
    }

    public TollsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_tolls, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_tolls_empty);


        mTollAdapter = new TollAdapter(getActivity(),new TollAdapter.TollAdapterOnClickHandler(){
            @Override
            public void onClick(Long idVehicle, TollAdapter.TollViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(idVehicle);
                mPosition = vh.getAdapterPosition();
            }
        },emptyView );

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_tolls);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mTollAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(TOLL_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        getLoaderManager().initLoader(TOLL_LOADER_ID, null, this);

        super.onResume();

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                TollColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }


    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mTollAdapter.swapCursor(data);
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
        //Todo: updateEmptyView();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mTollAdapter.swapCursor(null);
    }

}
