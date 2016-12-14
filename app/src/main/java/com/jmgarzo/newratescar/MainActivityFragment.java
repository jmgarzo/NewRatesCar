package com.jmgarzo.newratescar;

import android.content.Intent;
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
import android.widget.GridView;

import com.jmgarzo.newratescar.adapter.MenuAdapter;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int MENU_LOADER_ID = 0;

    private MenuAdapter mMenuAdapter;

    private GridView mGridView;

    public MainActivityFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(MENU_LOADER_ID,null,this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mMenuAdapter = new MenuAdapter(getActivity(),null,0);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mGridView = (GridView) rootView.findViewById(R.id.gridview);
        mGridView.setAdapter(mMenuAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;

                switch (position){
                    case 0:
                        intent = new Intent(getActivity(), VehiclesActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(),RefuelsActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(),RoadworthinessActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getActivity(),Tolls.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getActivity(),Insurance.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(getActivity(),MaintenanceDetail.class);
                        startActivity(intent);
                        break;
                }
            }
        });


        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(getActivity(),
                MenuItemColumns.CONTENT_URI,
                null,
                null,
                null,
                null);

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mMenuAdapter.swapCursor(data);

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mMenuAdapter.swapCursor(null);

    }
}
