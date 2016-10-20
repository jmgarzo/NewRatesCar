package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;

/**
 * Created by jmgarzo on 17/10/16.
 */

public class MenuAdapter extends CursorAdapter {

    public static class ViewHolder{
        public ImageView imageView;
        public TextView textView;

        public ViewHolder(View view){
            imageView = (ImageView) view.findViewById(R.id.list_item_image);
            textView = (TextView) view.findViewById(R.id.text_view_title);
        }
    }

    public MenuAdapter(Context context,Cursor cursor,int flags){
        super(context,cursor,flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_menu,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        int index = cursor.getColumnIndex(MenuItemColumns.MENU_ITEM_IMAGE);
        viewHolder.imageView.setImageResource(cursor.getInt(index));

        index = cursor.getColumnIndex(MenuItemColumns.MENU_ITEM_NAME);
        viewHolder.textView.setText(cursor.getString(index));

    }
}
