package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;

/**
 * Created by jmgarzo on 31/10/16.
 */

public class VehicleAdapter extends CursorAdapter {

     public static class ViewHolder {
         public TextView textName;

         public ViewHolder(View view) {
            textName = (TextView) view.findViewById(R.id.vehicle_name_list_item);
         }
     }

    public VehicleAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_vehicle,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        int index= cursor.getColumnIndex(VehicleColumns.VEHICLE_NAME);
        viewHolder.textName.setText(cursor.getShort(index));
    }
}
