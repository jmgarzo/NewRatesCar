package com.jmgarzo.newratescar.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;

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
        public ImageView imageHeader;
        public TextView textName;
        public TextView textMake;
        public TextView textModel;
        public TextView textFuelType;
        public TextView textMileage;
        public TextView textAddInformation;


        public VehicleViewHolder(View view) {
            super(view);
            imageHeader = (ImageView) view.findViewById(R.id.image_header_cardview);
            textName = (TextView) view.findViewById(R.id.vehicle_name_cardview);
            textMake = (TextView) view.findViewById(R.id.vehicle_make_cardview);
            textModel = (TextView) view.findViewById(R.id.vehicle_model_cardview);
            textFuelType = (TextView) view.findViewById(R.id.vehicle_fuel_type_cardview);
            textMileage = (TextView) view.findViewById(R.id.vehicle_mileage_cardview);
            textAddInformation = (TextView) view.findViewById(R.id.vehicle_additional_information_carview);
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

//                Integer iconResource = ProviderUtilities.getIconClass(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS));
//        if (null != iconResource) {
//            holder.icon.setImageResource(iconResource);
//
//        }

        Glide.with(mContext)
                .load(Utility.getVehicleImagefromIdClass(mContext,mCursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS)))
                .crossFade()
                .into(holder.imageHeader);

        holder.textName.setText(mCursor.getString(ProviderUtilities.COL_VEHICLE_NAME));

        holder.textMake.setText(ProviderUtilities.getMakeName(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_MAKE)));

        String model = mCursor.getString(ProviderUtilities.COL_VEHICLE_MODEL);
        if (!holder.textMake.getText().toString().equalsIgnoreCase("") && !model.equalsIgnoreCase("")) {
            model = " - " + model;
        }
        holder.textModel.setText(model);

        holder.vehicleId = mCursor.getLong(ProviderUtilities.COL_VEHICLE_ID);


        String fuelType = ProviderUtilities.getVehicleFuelTypeName(mContext,mCursor.getLong(ProviderUtilities.COL_VEHICLE_FUEL_TYPE));
        if(null!=fuelType && !fuelType.equalsIgnoreCase("")){

            holder.textFuelType.setText("· ".concat(fuelType));
        }else{
            holder.textFuelType.setVisibility(View.GONE);
        }


        Integer mileage = mCursor.getInt(ProviderUtilities.COL_VEHICLE_MILEAGE);
        if(mileage!=0){
            holder.textMileage.setText("· ".concat(mileage.toString()));

        }else{
            holder.textMileage.setVisibility(View.GONE);
        }

        String addInformation = mCursor.getString(ProviderUtilities.COL_VEHICLE_ADDITIONAL_INFORMATION);
        if(null!=addInformation && !addInformation.equalsIgnoreCase("")){
            holder.textAddInformation.setText(addInformation);
        }else{
            holder.textAddInformation.setVisibility(View.GONE);
        }
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
