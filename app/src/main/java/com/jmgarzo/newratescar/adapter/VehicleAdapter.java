package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jmgarzo.newratescar.ProviderUtilities;
import com.jmgarzo.newratescar.R;

/**
 * Created by jmgarzo on 31/10/16.
 */

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private Cursor mCursor;
    final private Context mContext;
    final private VehicleAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;

    public class VehicleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Long vehicleId;
//        public ImageView icon;
        public TextView textName;
        public TextView textMake;
        public TextView textModel;

        public VehicleViewHolder(View view) {
            super(view);
            //icon = (ImageView) view.findViewById(R.id.vehicle_icon);
            textName = (TextView) view.findViewById(R.id.vehicle_name_list_item);
            textMake = (TextView) view.findViewById(R.id.vehicle_make_list_item);
            textModel = (TextView) view.findViewById(R.id.vehicle_model_list_item);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            mClickHandler.onClick(mCursor.getLong(ProviderUtilities.COL_VEHICLE_ID), this);

        }
    }

    public static interface VehicleAdapterOnClickHandler {
        void onClick(Long idVehicle,VehicleViewHolder vh);
    }

    public VehicleAdapter(Context context, VehicleAdapterOnClickHandler dh,View emptyView) {
        mContext = context;
        mClickHandler = dh;
        mEmptyView = emptyView;
    }



    @Override
    public VehicleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_vehicle, parent, false);
        view.setFocusable(true);

        return new VehicleViewHolder(view);
    }

//    @Override
//    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//
//        View view = LayoutInflater.from(context).inflate(R.layout.list_item_vehicle, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        view.setTag(viewHolder);
//        return view;
//    }

    @Override
    public void onBindViewHolder(VehicleViewHolder holder, int position) {
        mCursor.moveToPosition(position);

                Integer iconResource = ProviderUtilities.getIconClass(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS));
//        if (null != iconResource) {
//            holder.icon.setImageResource(iconResource);
//
//        }

        holder.textName.setText(mCursor.getString(ProviderUtilities.COL_VEHICLE_NAME));

        holder.textMake.setText(ProviderUtilities.getMakeName(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_MAKE)));

        String model = mCursor.getString(ProviderUtilities.COL_VEHICLE_MODEL);
        if (!holder.textMake.getText().toString().equalsIgnoreCase("") && !model.equalsIgnoreCase("")) {
            model = " - " + model;
        }
        holder.textModel.setText(model);

        holder.vehicleId = mCursor.getLong(ProviderUtilities.COL_VEHICLE_ID);

    }

    @Override
    public int getItemCount() {
        if ( null == mCursor ) return 0;
        return mCursor.getCount();
    }


    public void swapCursor(Cursor newCursor) {
        mCursor = newCursor;
        notifyDataSetChanged();
        mEmptyView.setVisibility(getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    public Cursor getCursor() {
        return mCursor;
    }


//    @Override
//    public void bindView(View view, Context context, Cursor cursor) {
//        ViewHolder viewHolder = (ViewHolder) view.getTag();
//        Integer iconResource = ProviderUtilities.getIconClass(context, cursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS));
//        if (null != iconResource) {
//            viewHolder.icon.setImageResource(iconResource);
//
//        }
//
//        viewHolder.textName.setText(cursor.getString(ProviderUtilities.COL_VEHICLE_NAME));
//
//        viewHolder.textMake.setText(ProviderUtilities.getMakeName(context, cursor.getLong(ProviderUtilities.COL_VEHICLE_MAKE)));
//
//        String model = cursor.getString(ProviderUtilities.COL_VEHICLE_MODEL);
//        if (!viewHolder.textMake.getText().toString().equalsIgnoreCase("") && !model.equalsIgnoreCase("")) {
//            model = " - " + model;
//        }
//        viewHolder.textModel.setText(model);
//
//        viewHolder.vehicleId = cursor.getLong(ProviderUtilities.COL_VEHICLE_ID);
//    }

}
