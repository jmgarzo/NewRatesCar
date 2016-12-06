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

import com.jmgarzo.newratescar.adapter.RoadworthinessAdapter;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class RoadworthinessFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private static final int ROAD_LOADER_ID = 0;

    private RoadworthinessAdapter mRoadAdapter;
    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;



    public interface Callback{
        public void onItemSelected(Long roadId );
    }

    public RoadworthinessFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_roadworthiness, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_road_empty);


        mRoadAdapter = new RoadworthinessAdapter(getActivity(),new RoadworthinessAdapter.RoadAdapterOnClickHandler(){
            @Override
            public void onClick(Long roadId, RoadworthinessAdapter.RoadViewHolder vh) {
                ((Callback) getActivity()).onItemSelected(roadId);
                mPosition = vh.getAdapterPosition();
            }

        },emptyView );


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_road);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mRoadAdapter);

        return rootView;
    }


    @Override
    public void onResume() {
        getLoaderManager().initLoader(ROAD_LOADER_ID, null, this);

        super.onResume();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(ROAD_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                RoadworthinessColumns.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mRoadAdapter.swapCursor(data);
        if (mPosition != RecyclerView.NO_POSITION) {
            mRecyclerView.smoothScrollToPosition(mPosition);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mRoadAdapter.swapCursor(null);
    }


}
