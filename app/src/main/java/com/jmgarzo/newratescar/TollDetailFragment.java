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
import com.jmgarzo.newratescar.provider.toll.TollColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class TollDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        public void onDataChanged();
    }


    private static final String LOG_TAG = TollDetailFragment.class.getSimpleName();
    private static final int TOLL_LOADER = 0;

    private Long mTollId;
    private MaterialBetterSpinner mVehicleName;
    private EditText mTollDate;
    private EditText mTollPrice;
    private TextView mPricecurrency;
    private EditText mTollName;
    private EditText mTollRoad;
    private EditText mTollDirection;
    private EditText mTollLocation;
    private EditText mTollAditionalInf;

    private boolean isNew;

    ArrayList<String> mVehicleNameList;
    ArrayAdapter<String> mVehicleNameAdapter;


    public TollDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_toll_detail, container, false);
        isNew = true;
        mTollId = null;

        Bundle argument = getArguments();
        if (argument != null) {
            mTollId = argument.getLong(TollColumns._ID);

            if (mTollId != -1) {
                isNew = false;
            }
        }

        mVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_toll_vehicle_name);
        mTollDate = (EditText) view.findViewById(R.id.input_toll_date);
        mTollDate.setFocusable(false);
        mTollDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mTollDate);
            }
        });

        mTollPrice = (EditText) view.findViewById(R.id.input_toll_price);
        mPricecurrency= (TextView) view.findViewById(R.id.input_toll_currency_unit);
        String currency = Utility.getPreferredCurrencyUnit(getContext());
        mPricecurrency.setText(currency);
        mTollName = (EditText) view.findViewById(R.id.input_toll_name);
        mTollRoad = (EditText) view.findViewById(R.id.input_toll_road);
        mTollDirection = (EditText) view.findViewById(R.id.input_toll_direction);
        mTollLocation = (EditText) view.findViewById(R.id.input_toll_location);
        mTollAditionalInf = (EditText) view.findViewById(R.id.input_toll_additional_information);

        mVehicleName.addTextChangedListener(textWatcher);
        mTollDate.addTextChangedListener(textWatcher);
        mTollPrice.addTextChangedListener(textWatcher);
        mTollName.addTextChangedListener(textWatcher);
        mTollRoad.addTextChangedListener(textWatcher);
        mTollDirection.addTextChangedListener(textWatcher);
        mTollLocation.addTextChangedListener(textWatcher);
        mTollAditionalInf.addTextChangedListener(textWatcher);

        initialValuesVehicleName();




        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(TOLL_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }




    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case TOLL_LOADER: {
                if (!isNew) {
                    return new CursorLoader(
                            getActivity(),
                            TollColumns.CONTENT_URI,
                            TollColumns.ALL_COLUMNS,
                            TollColumns._ID + "= ?",
                            new String[]{mTollId.toString()},
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
            case TOLL_LOADER: {
                if (!isNew) {
                    if (data != null && data.moveToFirst()) {
                        String name = ProviderUtilities.getVehicleName(getActivity(), data.getLong(ProviderUtilities.COL_TOLL_VEHICLE_ID));
                        mVehicleName.setText(name);
                        mTollDate.setText(Utility.getFormatedDate(data.getLong(ProviderUtilities.COL_TOLL_DATE)));
                        mTollPrice.setText(Double.toString(data.getDouble(ProviderUtilities.COL_TOLL_PRICE)));
                        mTollName.setText(data.getString(ProviderUtilities.COL_TOLL_NAME));
                        mTollRoad.setText(data.getString(ProviderUtilities.COL_TOLL_ROAD));
                        mTollDirection.setText(data.getString(ProviderUtilities.COL_TOLL_DIRECTION));
                        mTollLocation.setText(data.getString(ProviderUtilities.COL_TOLL_LOCATION));
                        mTollAditionalInf.setText(data.getString(ProviderUtilities.COL_TOLL_ADDITIONAL_INFORMATION));

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
        TollDetailFragment.DatePickerFragment newFragment = new TollDetailFragment.DatePickerFragment(getActivity(), v);
        newFragment.show(getActivity().getFragmentManager(), "datePicker");

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



    private TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {

        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((TollDetailFragment.Callback) getActivity())
                    .onDataChanged();

        }
    };





}
