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
 * Created by jmgarzo on 07/12/16.
 */

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.InsuranceViewHolder> {

    private Cursor mCursor;
    final private Context mContext;
    final private InsuranceAdapterOnClickHandler mClickHandler;
    final private View mEmptyView;


    public class InsuranceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageHeader;
        public TextView textVehicleName;
        public TextView textCompany;
        public TextView textPrice;
        public TextView textPolicyNumber;
        public TextView textStartDate;
        public TextView textEndDate;

        public InsuranceViewHolder(View view) {
            super(view);
            imageHeader = (ImageView) view.findViewById(R.id.insurance_image_header_cardview);
            textVehicleName = (TextView) view.findViewById(R.id.insurance_vehicle_name_cardview);
            textCompany =(TextView) view.findViewById(R.id.insurance_company_cardview);
            textPrice = (TextView) view.findViewById(R.id.insurance_price_cardview);
            textPolicyNumber = (TextView) view.findViewById(R.id.insurance_policy_number_cardview);
            textStartDate = (TextView) view.findViewById(R.id.insurance_start_date_cardview);
            textEndDate = (TextView) view.findViewById(R.id.insurance_end_date_cardview);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            mCursor.moveToPosition(adapterPosition);
            mClickHandler.onClick(mCursor.getLong(ProviderUtilities.COL_INSURANCE_ID), this);

        }
    }

    public interface InsuranceAdapterOnClickHandler {
        void onClick(Long idInsurance,InsuranceAdapter.InsuranceViewHolder vh);
    }


    public InsuranceAdapter(Context context, InsuranceAdapterOnClickHandler dh,View emptyView) {
        mContext = context;
        mClickHandler = dh;
        mEmptyView = emptyView;
    }

    @Override
    public InsuranceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_insurance, parent, false);
        view.setFocusable(true);

        return new InsuranceViewHolder(view);
    }


    @Override
    public void onBindViewHolder(InsuranceViewHolder holder, int position) {
        mCursor.moveToPosition(position);

        Long idVehicle = Long.parseLong(mCursor.getString(ProviderUtilities.COL_INSURANCE_VEHICLE_ID));

        Long idClass = ProviderUtilities.getVehicleClassIdFromVehicleId(mContext,mCursor.getLong(ProviderUtilities.COL_INSURANCE_VEHICLE_ID));
        Glide.with(mContext)
                .load(Utility.getRefuelImagefromVehicleId(mContext,idClass))
                .crossFade()
                .into(holder.imageHeader);
        holder.textVehicleName.setText(ProviderUtilities.getVehicleName(mContext,idVehicle));

        holder.textCompany.setText(mCursor.getString(ProviderUtilities.COL_INSURANCE_COMPANY));
        String currency = Utility.getPreferredCurrencyUnit(mContext);
        holder.textPrice.setText(mCursor.getString(ProviderUtilities.COL_INSURANCE_PRICE).concat(" ").concat(currency));

        holder.textPolicyNumber.setText(mCursor.getString(ProviderUtilities.COL_INSURANCE_POLICY_NUMBER));

        holder.textStartDate.setText(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_INSURANCE_START_DATE)));
        holder.textEndDate.setText(Utility.getFormatedDate(mCursor.getLong(ProviderUtilities.COL_INSURANCE_END_DATE)));

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
