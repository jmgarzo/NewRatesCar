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
 * Created by jmgarzo on 06/12/16.
 */

public class TollAdapter extends RecyclerView.Adapter<TollAdapter.TollViewHolder> {


    private Cursor mCursor;
    final private Context mContext;
    final private TollAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;

    public class TollViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageHeader;
        public TextView textVehicleName;
        public TextView textDate;
        public TextView textPrice;
        public TextView textName;
        public TextView textRoad;
        public TextView textDirection;
        public TextView textLocation;

//


        public TollViewHolder(View view) {
            super(view);
            imageHeader = (ImageView) view.findViewById(R.id.toll_image_header_cardview);
            textVehicleName = (TextView) view.findViewById(R.id.toll_vehicle_name_cardview);
            textDate =(TextView) view.findViewById(R.id.toll_date_cardview);
            textPrice = (TextView) view.findViewById(R.id.toll_price_cardview);
            textName = (TextView) view.findViewById(R.id.toll_name_cardview);
            textRoad = (TextView) view.findViewById(R.id.toll_road_cardview);
            textDirection = (TextView) view.findViewById(R.id.toll_direction_cardview);
            textLocation = (TextView) view.findViewById(R.id.toll_location_cardview);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            mClickHandler.onClick(mCursor.getLong(ProviderUtilities.COL_ROADWORTHINESS_ID), this);

        }
    }

    public interface TollAdapterOnClickHandler {
        void onClick(Long idToll,TollViewHolder vh);
    }

    public TollAdapter(Context context, TollAdapterOnClickHandler dh,View emptyView) {
        mContext = context;
        mClickHandler = dh;
        mEmptyView = emptyView;
    }

    @Override
    public TollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_toll, parent, false);
        view.setFocusable(true);

        return new TollViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TollViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        Long idVehicle = Long.parseLong(mCursor.getString(ProviderUtilities.COL_TOLL_VEHICLE_ID));

        Long idClass = ProviderUtilities.getVehicleClassIdFromVehicleId(mContext,mCursor.getLong(ProviderUtilities.COL_TOLL_VEHICLE_ID));
        Glide.with(mContext)
                .load(Utility.getRefuelImagefromVehicleId(mContext,idClass))
                .crossFade()
                .into(holder.imageHeader);
        holder.textVehicleName.setText(ProviderUtilities.getVehicleName(mContext,idVehicle));
        holder.textDate.setText(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_TOLL_DATE)));
        String currency = Utility.getPreferredCurrencyUnit(mContext);
        holder.textPrice.setText(mCursor.getString(ProviderUtilities.COL_TOLL_PRICE).concat(" ").concat(currency));
        holder.textName.setText(mCursor.getString(ProviderUtilities.COL_TOLL_NAME));
        holder.textRoad.setText(mCursor.getString(ProviderUtilities.COL_TOLL_ROAD));
        holder.textDirection.setText(mCursor.getString(ProviderUtilities.COL_TOLL_DIRECTION));
        holder.textLocation.setText(mCursor.getString(ProviderUtilities.COL_TOLL_LOCATION));


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
