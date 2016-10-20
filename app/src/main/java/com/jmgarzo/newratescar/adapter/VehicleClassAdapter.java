package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * Created by jmgarzo on 19/10/16.
 */

public class VehicleClassAdapter extends CursorAdapter{





    public VehicleClassAdapter(Context context,Cursor c, int flags){
        super(context,c,flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_dropdown_item_1line,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView spinnerTest = (TextView) view.findViewById(android.R.id.text1);
        int index = cursor.getColumnIndex(VehicleClassColumns.VEHICLE_CLASS_NAME);
        spinnerTest.setText(cursor.getString(index));


    }
}
