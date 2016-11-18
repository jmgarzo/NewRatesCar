package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmgarzo.newratescar.ProviderUtilities;
import com.jmgarzo.newratescar.R;

/**
 * Created by jmgarzo on 31/10/16.
 */

public class VehicleAdapter extends CursorAdapter {

    public static class ViewHolder {
        public Long vehicleId;
        public ImageView icon;
        public TextView textName;
        public TextView textMake;
        public TextView textModel;

        public ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.vehicle_icon);
            textName = (TextView) view.findViewById(R.id.vehicle_name_list_item);
            textMake = (TextView) view.findViewById(R.id.vehicle_make_list_item);
            textModel = (TextView) view.findViewById(R.id.vehicle_model_list_item);
        }
    }

    public VehicleAdapter(Context context, Cursor cursor, int flags) {
        super(context, cursor, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item_vehicle, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        Integer iconResource = ProviderUtilities.getIconClass(context, cursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS));
        if (null != iconResource) {
            viewHolder.icon.setImageResource(iconResource);

        }

        viewHolder.textName.setText(cursor.getString(ProviderUtilities.COL_VEHICLE_NAME));

        viewHolder.textMake.setText(ProviderUtilities.getMakeName(context, cursor.getLong(ProviderUtilities.COL_VEHICLE_MAKE)));

        String model = cursor.getString(ProviderUtilities.COL_VEHICLE_MODEL);
        if (!viewHolder.textMake.getText().toString().equalsIgnoreCase("") && !model.equalsIgnoreCase("")) {
            model = " - " + model;
        }
        viewHolder.textModel.setText(model);

        viewHolder.vehicleId = cursor.getLong(ProviderUtilities.COL_VEHICLE_ID);
    }

}
