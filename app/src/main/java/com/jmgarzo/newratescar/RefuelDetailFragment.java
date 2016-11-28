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
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeSelection;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


/**
 * A placeholder fragment containing a simple view.
 */
public class RefuelDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onDataChanged();
    }

    private static final String LOG_TAG = RefuelDetailFragment.class.getSimpleName();

    private static final int REFUEL_LOADER = 0;
    private static final int VEHICLE_LOADER = 1;

    private Long mRefuelId;
    private MaterialBetterSpinner mVehicleName;
    private EditText mRefuelDate;
    private SwitchCompat mRefuelFullTank;
    private AutoCompleteTextView mRefuelFuelType;
    private AutoCompleteTextView mRefuelFuelSubtype;
    private EditText mMileage;
    private EditText mMileageUnits;
    private EditText mLitres;
    private EditText mGasPrice;
    private EditText mTotalPrice;
    private SwitchCompat mIsRoofRack;
    private SwitchCompat mIsTrailer;
    private AppCompatSeekBar mSeekBarRouteType;
    private AppCompatSeekBar mSeekBarDrivingStyle;
    private EditText mAverageSpeed;
    private EditText mAverageConsumption;
    private EditText mPaymentType;
    private EditText mGasStation;
    private EditText mAdditionalInf;

    private boolean isNew;


    ArrayList<String> mVehicleNameList;
    ArrayAdapter<String> mVehicleNameAdapter;
    ArrayList<String> mFuelTypeList;
    ArrayAdapter<String> mFuelTypeAdapter;
    ArrayList<String> mFuelSubtypeList;
    ArrayAdapter<String> mFuelSubtypeAdapter;


    public RefuelDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refuel_detail, container, false);

        isNew = true;
        mRefuelId = null;

        Bundle argument = getArguments();
        if (argument != null) {
            mRefuelId = argument.getLong(RefuelColumns._ID);

            if (mRefuelId != -1) {
                isNew = false;
            }
        }

        mVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_vehicle_name);
        mRefuelDate = (EditText) view.findViewById(R.id.input_refuel_date);
        mRefuelDate.setFocusable(false);
        mRefuelDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mRefuelDate);
            }
        });


        Calendar cal = new GregorianCalendar();
        java.util.Date currentDate = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        String formatteDate = df.format(currentDate);
        mRefuelDate.setText(formatteDate);
        mRefuelFullTank = (SwitchCompat) view.findViewById(R.id.switch_is_full);
        mRefuelFuelType = (AutoCompleteTextView) view.findViewById(R.id.autocomplete_refuel_fuel_type);
        mRefuelFuelSubtype = (AutoCompleteTextView) view.findViewById(R.id.autocomplete_refuel_fuel_subtype);
        mMileage = (EditText) view.findViewById(R.id.input_refuel_mileage);
        mMileageUnits = (EditText) view.findViewById(R.id.input_refuel_mileage_unit);
        mLitres = (EditText) view.findViewById(R.id.input_refuel_litres);
        mGasPrice = (EditText) view.findViewById(R.id.input_refuel_gas_price);
        mTotalPrice = (EditText) view.findViewById(R.id.input_refuel_total_price);
        mIsRoofRack = (SwitchCompat) view.findViewById(R.id.switch_is_roof_rack);
        mIsTrailer = (SwitchCompat) view.findViewById(R.id.switch_is_trailer);
        mSeekBarRouteType = (AppCompatSeekBar) view.findViewById(R.id.seekbar_route_type);
        mSeekBarDrivingStyle = (AppCompatSeekBar) view.findViewById(R.id.seekbar_driving_style);
        mAverageSpeed = (EditText) view.findViewById(R.id.input_refuel_average_speed);
        mAverageConsumption = (EditText) view.findViewById(R.id.input_refuel_average_consumption);
        mPaymentType = (EditText) view.findViewById(R.id.input_refuel_payment_type);
        mGasStation = (EditText) view.findViewById(R.id.input_refuel_gas_station);
        mAdditionalInf = (EditText) view.findViewById(R.id.input_refuel_additional_information);

        mMileageUnits.setText(Utility.getPreferredMileageUnit(getContext()));

        initialValuesVehicleName();
        initialValuesFuelType();
        initialValuesFuelSubtype();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(REFUEL_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case REFUEL_LOADER: {
                if (!isNew) {
                    return new CursorLoader(
                            getActivity(),
                            RefuelColumns.CONTENT_URI,
                            RefuelColumns.ALL_COLUMNS,
                            RefuelColumns._ID + "= ?",
                            new String[]{mRefuelId.toString()},
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
            case REFUEL_LOADER: {
                if (!isNew) {
                    if (data != null && data.moveToFirst()) {
                        String name = ProviderUtilities.getVehicleName(getActivity(), data.getLong(ProviderUtilities.COL_REFUEL_VEHICLE_ID));
                        mVehicleName.setText(name);


                        Calendar cal = new GregorianCalendar();
                        java.util.Date refuelDate = new Date(
                                data.getLong(ProviderUtilities.COL_REFUEL_DATE));
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        String formatDate = df.format(refuelDate);
                        mRefuelDate.setText(formatDate);


                        boolean isFull = false;
                        if (data.getInt(ProviderUtilities.COL_REFUEL_IS_FULL) == 1) {
                            isFull = true;
                        }
                        mRefuelFullTank.setChecked(isFull);
                        mRefuelFuelType.setText(ProviderUtilities.getVehicleFuelTypeName(getActivity(), data.getLong(ProviderUtilities.COL_REFUEL_FUEL_TYPE)));
                        mRefuelFuelSubtype.setText(ProviderUtilities.getVehicleFuelSubtypeName(getActivity(), data.getLong(ProviderUtilities.COL_REFUEL_FUEL_SUBTYPE)));
                        mMileage.setText(data.getString(ProviderUtilities.COL_REFUEL_MILEAGE));
                        mLitres.setText(Double.toString(data.getDouble(ProviderUtilities.COL_REFUEL_LITRES)));
                        mGasPrice.setText(Double.toString(data.getDouble(ProviderUtilities.COL_REFUEL_GAS_PRICE)));
                        mTotalPrice.setText(Double.toString(data.getDouble(ProviderUtilities.COL_REFUEL_TOTAL_PRICE)));
                        boolean isRoofRack = false;
                        if (data.getInt(ProviderUtilities.COL_REFUEL_IS_ROOF_RACK) == 1) {
                            isRoofRack = true;
                        }
                        mIsRoofRack.setChecked(isRoofRack);

                        boolean isTrailer = false;
                        if (data.getInt(ProviderUtilities.COL_REFUEL_IS_TRAILER) == 1) {
                            isTrailer = true;
                        }
                        mIsTrailer.setChecked(isRoofRack);

                        mSeekBarRouteType.setProgress(data.getInt(ProviderUtilities.COL_REFUEL_ROUTE_TYPE));
                        mSeekBarDrivingStyle.setProgress(data.getInt(ProviderUtilities.COL_REFUEL_DRIVING_STYLE));
                        mAverageSpeed.setText(Double.toString(data.getDouble(ProviderUtilities.COL_REFUEL_AVERAGE_SPEED)));
                        mAverageConsumption.setText(Double.toString(data.getDouble(ProviderUtilities.COL_REFUEL_AVERAGE_CONSUMPTION)));
                        mPaymentType.setText(data.getString(ProviderUtilities.COL_REFUEL_PAYMENT_TYPE));
                        mGasStation.setText(data.getString(ProviderUtilities.COL_REFUEL_AVERAGE_CONSUMPTION));
                        mAdditionalInf.setText(data.getString(ProviderUtilities.COL_REFUEL_ADDITIONAL_INFORMATION));

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
        DatePickerFragment newFragment = new DatePickerFragment(getActivity(), v);
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



        mVehicleName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(isNew){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


    void initialValuesFuelType() {
        FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
        Cursor cursorFuelType = getActivity().getContentResolver().query(fuelTypeSelection.uri(), null, null, null, null);
        mFuelTypeList = new ArrayList<>();
        while (cursorFuelType.moveToNext()) {
            int index = cursorFuelType.getColumnIndex(FuelTypeColumns.FUEL_TYPE_NAME);
            mFuelTypeList.add(cursorFuelType.getString(index));
        }
        mFuelTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mFuelTypeList);
        mRefuelFuelType.setAdapter(mFuelTypeAdapter);

        if(!isNew){

            if(!Utility.isEmptyOrNull(mVehicleName.getText().toString())){
                String fuelType = ProviderUtilities.getVehicleFuelTypeByVehicleName(getActivity(),mVehicleName.getText().toString());
                mRefuelFuelType.setText(fuelType);            }

        }
    }

    void initialValuesFuelSubtype() {
        FuelSubtypeSelection fuelSubtypeSelection = new FuelSubtypeSelection();
        Cursor cursorFuelSubtype = getActivity().getContentResolver().query(fuelSubtypeSelection.uri(), null, null, null, null);
        mFuelSubtypeList = new ArrayList<>();
        while (cursorFuelSubtype.moveToNext()) {
            int index = cursorFuelSubtype.getColumnIndex(FuelSubtypeColumns.FUEL_SUBTYPE_NAME);
            mFuelSubtypeList.add(cursorFuelSubtype.getString(index));
        }
        mFuelSubtypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mFuelSubtypeList);
        mRefuelFuelSubtype.setAdapter(mFuelSubtypeAdapter);
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
}
