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

import com.jmgarzo.newratescar.adapter.InsuranceAdapter;
import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class InsuranceFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int INSURANCE_LOADER_ID = 0;

    private InsuranceAdapter mInsuranceAdapter;

    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;

    public interface Callback {
        public void onItemSelected(Long vehicleId);
    }

    public InsuranceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_insurance, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_insurance_empty);

        mInsuranceAdapter = new InsuranceAdapter(getActivity(),new InsuranceAdapter.InsuranceAdapterOnClickHandler(){
            @Override
            public void onClick(Long idVehicle, InsuranceAdapter.InsuranceViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(idVehicle);
                mPosition = vh.getAdapterPosition();
            }
        },emptyView );

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_insurance);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mInsuranceAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(INSURANCE_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        getLoaderManager().initLoader(INSURANCE_LOADER_ID, null, this);
        super.onResume();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                InsuranceColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mInsuranceAdapter.swapCursor(data);
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
        //Todo: updateEmptyView();

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mInsuranceAdapter.swapCursor(null);
    }
}
