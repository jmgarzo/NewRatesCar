package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;

import static android.view.View.GONE;

/**
 * Created by jmgarzo on 17/10/16.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private Cursor mCursor;
    final private Context mContext;
    final private MenuAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;

    public static class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView imageView;
        public TextView textView;
        public Button add

        public MenuViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.list_item_image);
            textView = (TextView) view.findViewById(R.id.text_view_title);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public  interface MenuAdapterOnClickHandler {
        void onClick(Long idMenu,MenuViewHolder vh);
    }

    public MenuAdapter(Context mContext, MenuAdapterOnClickHandler mClickHandler, View mEmptyView) {
        this.mContext = mContext;
        this.mClickHandler = mClickHandler;
        this.mEmptyView = mEmptyView;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_menu,parent,false);
        view.setFocusable(true);
        return new MenuViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        mCursor.moveToPosition(position);
        int index = mCursor.getColumnIndex(MenuItemColumns.MENU_ITEM_IMAGE);
        holder.imageView.setImageResource(mCursor.getInt(index));

        index = mCursor.getColumnIndex(MenuItemColumns.MENU_ITEM_NAME);
        holder.textView.setText(mCursor.getString(index));
    }

    @Override
    public int getItemCount() {
        if ( null == mCursor ) return 0;
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
        mEmptyView.setVisibility(getItemCount() == 0 ? View.VISIBLE : GONE);
    }

    public Cursor getCursor() {
        return mCursor;
    }

}
