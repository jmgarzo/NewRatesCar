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

import static android.view.View.GONE;

/**
 * Created by jmgarzo on 31/10/16.
 */

public class RefuelAdapter extends RecyclerView.Adapter<RefuelAdapter.RefuelViewHolder> {

    private Cursor mCursor;
    final private Context mContext;
    final private RefuelAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;

    public class RefuelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Long refuelId;
        public ImageView imageHeader;
        public TextView textVehicleName;
        public TextView textTotalPrice;
        public TextView textDate;
        public TextView textTripOdometer;
        public TextView textAverageConsumption;
//


        public RefuelViewHolder(View view) {
            super(view);
            imageHeader = (ImageView) view.findViewById(R.id.image_header_cardview);
            textVehicleName = (TextView) view.findViewById(R.id.refuel_vehicle_name_cardview);
            textTotalPrice = (TextView) view.findViewById(R.id.refuel_total_price_cardview);
            textDate =(TextView) view.findViewById(R.id.refuel_date_cardview);
            textTripOdometer = (TextView) view.findViewById(R.id.refuel_trip_odometer_cardview);
            textAverageConsumption = (TextView) view.findViewById(R.id.refuel_trip_average_consumption_cardview);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            mClickHandler.onClick(mCursor.getLong(ProviderUtilities.COL_REFUEL_ID), this);

        }
    }

    public  interface RefuelAdapterOnClickHandler {
        void onClick(Long idRefuel,RefuelViewHolder vh);
    }

    public RefuelAdapter(Context context, RefuelAdapterOnClickHandler dh,View emptyView) {
        mContext = context;
        mClickHandler = dh;
        mEmptyView = emptyView;
    }



    @Override
    public RefuelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_refuel, parent, false);
        view.setFocusable(true);

        return new RefuelViewHolder(view);
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
    public void onBindViewHolder(RefuelViewHolder holder, int position) {
        mCursor.moveToPosition(position);

//                Integer iconResource = ProviderUtilities.getIconClass(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS));
//        if (null != iconResource) {
//            holder.icon.setImageResource(iconResource);
//
//        }

//        Glide.with(mContext)
//                .load(Utility.getImagefromIdClass(mContext,mCursor.getLong(ProviderUtilities.COL_VEHICLE_CLASS)))
//                .crossFade()
//                .into(holder.imageHeader);
        Long idVehicle = Long.parseLong(mCursor.getString(ProviderUtilities.COL_VEHICLE_ID));

        Long idClass = ProviderUtilities.getVehicleClassIdFromVehicleId(mContext,mCursor.getLong(ProviderUtilities.COL_REFUEL_VEHICLE_ID));
        Glide.with(mContext)
                .load(Utility.getRefuelImagefromVehicleId(mContext,idClass))
                .crossFade()
                .into(holder.imageHeader);
        holder.textVehicleName.setText(ProviderUtilities.getVehicleName(mContext,idVehicle));
        String currency = Utility.getPreferredCurrencyUnit(mContext);
        holder.textTotalPrice.setText(mCursor.getString(ProviderUtilities.COL_REFUEL_TOTAL_PRICE).concat(" ").concat(currency));
        holder.textDate.setText(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_REFUEL_DATE)));
        String distanceUnit = Utility.getPreferredMileageUnit(mContext);

        if(mCursor.getString(ProviderUtilities.COL_REFUEL_TRIP_ODOMETER).equalsIgnoreCase("0")){
            holder.textTripOdometer.setText(R.string.refuel_partial_fill_ups);
        }else{
            holder.textTripOdometer.setText(mCursor.getString(ProviderUtilities.COL_REFUEL_TRIP_ODOMETER).concat(" ").concat(distanceUnit));
        }
        String quantityUnit = Utility.getPreferredQuantityUnit(mContext);
        if(mCursor.getString(ProviderUtilities.COL_REFUEL_AVERAGE_CONSUMPTION).equalsIgnoreCase("0")){
            holder.textAverageConsumption.setVisibility(GONE);
        }else {

            holder.textAverageConsumption.setText(mCursor.getString(ProviderUtilities.COL_REFUEL_AVERAGE_CONSUMPTION).concat(" ").concat(quantityUnit)
            .concat("/").concat(distanceUnit));
        }

//        holder.textDate.setText(ProviderUtilities.getMakeName(mContext, mCursor.getLong(ProviderUtilities.COL_VEHICLE_MAKE)));


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
