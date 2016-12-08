package com.jmgarzo.newratescar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class InsuranceDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    public interface Callback {
        public void onDataChanged();
    }

    private static final String LOG_TAG = InsuranceDetailFragment.class.getSimpleName();
    private static final int INSURANCE_LOADER = 0;

    private Long mInsuranceId;
    private MaterialBetterSpinner mVehicleName;
    private EditText mStartDate;
    private EditText mEndDate;
    private EditText mPrice;
    private TextView mPriceCurrency;
    private EditText mCompany;
    private EditText mPolicy;
    private EditText mAdditionalInf;

    private boolean isNew;

    ArrayList<String> mVehicleNameList;
    ArrayAdapter<String> mVehicleNameAdapter;
    public InsuranceDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insurance_detail, container, false);

        isNew = true;
        mInsuranceId = null;

        Bundle argument = getArguments();
        if (argument != null) {
            mInsuranceId = argument.getLong(InsuranceColumns._ID);

            if (mInsuranceId != -1) {
                isNew = false;
            }
        }

        mVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_insurance_vehicle_name);
        mStartDate = (EditText) view.findViewById(R.id.input_insurance_start_date);
        mStartDate.setFocusable(false);
        mStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mStartDate);
            }
        });
        mEndDate = (EditText) view.findViewById(R.id.input_insurance_end_date);
        mEndDate.setFocusable(false);
        mEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mEndDate);
            }
        });
        mPrice= (EditText) view.findViewById(R.id.input_insurance_price);
        mPriceCurrency= (TextView) view.findViewById(R.id.input_insurance_currency_unit);
        String currency = Utility.getPreferredCurrencyUnit(getContext());
        mPriceCurrency.setText(currency);
        mCompany= (EditText) view.findViewById(R.id.input_insurance_company);
        mPolicy = (EditText) view.findViewById(R.id.input_insurance_policy);
        mAdditionalInf= (EditText) view.findViewById(R.id.input_insurance_additional_information);


        mVehicleName.addTextChangedListener(textWatcher);
        mStartDate.addTextChangedListener(textWatcher);
        mEndDate.addTextChangedListener(textWatcher);
        mPrice.addTextChangedListener(textWatcher);
        mCompany.addTextChangedListener(textWatcher);
        mPolicy.addTextChangedListener(textWatcher);
        mAdditionalInf.addTextChangedListener(textWatcher);

        initialValuesVehicleName();

        return view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case INSURANCE_LOADER: {
                if (!isNew) {
                    return new CursorLoader(
                            getActivity(),
                            InsuranceColumns.CONTENT_URI,
                            InsuranceColumns.ALL_COLUMNS,
                            InsuranceColumns._ID + "= ?",
                            new String[]{mInsuranceId.toString()},
                            null
                    );
                }
            }

        }

        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        switch (loader.getId()) {
            case INSURANCE_LOADER: {
                if (!isNew) {
                    if (data != null && data.moveToFirst()) {
                        String name = ProviderUtilities.getVehicleName(getActivity(), data.getLong(ProviderUtilities.COL_INSURANCE_VEHICLE_ID));
                        mVehicleName.setText(name);

                        mStartDate.setText(Utility.getFormatedDate(data.getLong(ProviderUtilities.COL_INSURANCE_START_DATE)));
                        mEndDate.setText(Utility.getFormatedDate(data.getLong(ProviderUtilities.COL_INSURANCE_END_DATE)));
                        mPrice.setText(data.getString(ProviderUtilities.COL_INSURANCE_PRICE));
                        mCompany.setText(data.getString(ProviderUtilities.COL_INSURANCE_COMPANY));
                        mPolicy.setText(data.getString(ProviderUtilities.COL_INSURANCE_POLICY_NUMBER));
                        mAdditionalInf.setText(data.getString(ProviderUtilities.COL_INSURANCE_ADDITIONAL_INFORMATION));

                    }
                }
                break;
            }

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }


    public void showDatePickerDialog(EditText v) {
        InsuranceDetailFragment.DatePickerFragment newFragment = new InsuranceDetailFragment.DatePickerFragment(getActivity(), v);
        newFragment.show(getActivity().getFragmentManager(), "datePicker");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(INSURANCE_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    void initialValuesVehicleName() {

        VehicleSelection vehicleSelection = new VehicleSelection();
        Cursor c = getActivity().getContentResolver().query(vehicleSelection.uri(), null, null, null, null);
        mVehicleNameList = new ArrayList<>();
        while (c.moveToNext()) {
            int index = c.getColumnIndex(VehicleColumns.VEHICLE_NAME);
            mVehicleNameList.add(c.getString(index));
        }

        mVehicleNameAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mVehicleNameList);
        mVehicleName.setAdapter(mVehicleNameAdapter);


        if(isNew && mVehicleNameList.size()>0){
            String lastCarName = ProviderUtilities.getLastRefuelCarName(getContext());
            if(null!= lastCarName &&!lastCarName.equalsIgnoreCase("")) {
                mVehicleName.setText(lastCarName);
            }


        }


    }


    private TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((InsuranceDetailFragment.Callback) getActivity())
                    .onDataChanged();

        }
    };


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        private Context context;
        private EditText editText;

        public DatePickerFragment() {
            super();
        }

        @SuppressLint("ValidFragment")
        public DatePickerFragment(Context context, EditText editText) {
            super();
            this.context = context;
            this.editText = editText;

        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            if (null != editText && null != Integer.valueOf(year) && null != Integer.valueOf(monthOfYear) && null != Integer.valueOf(dayOfMonth)) {
                editText.setText(Integer.valueOf(dayOfMonth).toString().concat("/").concat(Integer.valueOf(monthOfYear + 1).toString().concat("/").concat(Integer.valueOf(year).toString())));
            }
        }
    }

}
