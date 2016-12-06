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
 * Created by jmgarzo on 04/12/16.
 */

public class RoadworthinessAdapter extends RecyclerView.Adapter<RoadworthinessAdapter.RoadViewHolder> {


    private Cursor mCursor;
    final private Context mContext;
    final private RoadAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;

    public class RoadViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Long roadId;
        public ImageView imageHeader;
        public TextView textVehicleName;
        public TextView textTotalPrice;
        public TextView textDate;
        public TextView textNextDate;
        public TextView textOdometer;
//


        public RoadViewHolder(View view) {
            super(view);
            imageHeader = (ImageView) view.findViewById(R.id.road_image_header_cardview);
            textVehicleName = (TextView) view.findViewById(R.id.road_vehicle_name_cardview);
            textTotalPrice = (TextView) view.findViewById(R.id.road_price_cardview);
            textDate =(TextView) view.findViewById(R.id.road_date_cardview);
            textNextDate = (TextView) view.findViewById(R.id.road_next_date_cardview);
            textOdometer = (TextView) view.findViewById(R.id.road_odometer_cardview);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            mClickHandler.onClick(mCursor.getLong(ProviderUtilities.COL_ROADWORTHINESS_ID), this);

        }
    }

    public  interface RoadAdapterOnClickHandler {
        void onClick(Long idRoad,RoadViewHolder vh);
    }

    public RoadworthinessAdapter(Context context, RoadAdapterOnClickHandler dh, View emptyView) {
        mContext = context;
        mClickHandler = dh;
        mEmptyView = emptyView;
    }

    @Override
    public RoadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_roadworthiness, parent, false);
        view.setFocusable(true);

        return new RoadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoadViewHolder holder, int position) {
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

        Long idClass = ProviderUtilities.getVehicleClassIdFromVehicleId(mContext,mCursor.getLong(ProviderUtilities.COL_ROADWORTHINESS_VEHICLE_ID));
        Glide.with(mContext)
                .load(Utility.getRefuelImagefromVehicleId(mContext,idClass))
                .crossFade()
                .into(holder.imageHeader);

        holder.textVehicleName.setText(ProviderUtilities.getVehicleName(mContext,idVehicle));

        String currency = Utility.getPreferredCurrencyUnit(mContext);
        holder.textTotalPrice.setText(mCursor.getString(ProviderUtilities.COL_ROADWORTHINESS_PRICE).concat(" ").concat(currency));
        holder.textDate.setText(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_ROADWORTHINESS_DATE)));
        holder.textNextDate.setText(mContext.getString(R.string.road_next).concat(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_ROADWORTHINESS_NEXT_DATE))));

        String distanceUnit = Utility.getPreferredMileageUnit(mContext);

        holder.textOdometer.setText(mCursor.getString(ProviderUtilities.COL_ROADWORTHINESS_MILEAGE).concat(" ").concat(distanceUnit));

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
