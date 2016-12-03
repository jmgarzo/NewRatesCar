package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.jmgarzo.newratescar.adapter.MenuAdapter;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int MENU_LOADER_ID = 0;

    private MenuAdapter mMenuAdapter;
    private RecyclerView mRecyclerView;
    private int mPosition = mRecyclerView.NO_POSITION;

    RecyclerView.LayoutManager recyclerViewLayoutManager;
    private GridView mGridView;

    public MainActivityFragment() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(MENU_LOADER_ID, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        View emptyView = rootView.findViewById(R.id.recyclerview_menu_empty);

        mMenuAdapter = new MenuAdapter(getActivity(), new MenuAdapter.MenuAdapterOnClickHandler() {
            @Override
            public void onClick(Long idMenu, MenuAdapter.MenuViewHolder vh) {
//                ((Callback) getActivity()).onItemSelected(idMenu);
//                mPosition = vh.getAdapterPosition();
            }
        }, emptyView);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_menu);

        recyclerViewLayoutManager = new GridLayoutManager(getContext(), 2);
        mRecyclerView.setLayoutManager(recyclerViewLayoutManager);
        mRecyclerView.setAdapter(mMenuAdapter);


//        mGridView = (GridView) rootView.findViewById(R.id.gridview);
//        mGridView.setAdapter(mMenuAdapter);
//        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                if(position==0) {
//                    Intent intent = new Intent(getActivity(), VehiclesActivity.class);
//                    startActivity(intent);
//                }if(position==1){
//                    Intent intent = new Intent(getActivity(),RefuelsActivity.class);
//                    startActivity(intent);
//                }
//            }
//        });


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
