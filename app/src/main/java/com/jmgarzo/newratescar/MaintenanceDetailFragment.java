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
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * A placeholder fragment containing a simple view.
 */
public class MaintenanceDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public interface Callback {
        public void onDataChanged();
    }

    private static final String LOG_TAG = MaintenanceDetailFragment.class.getSimpleName();
    private static final int MAINTENANCE_LOADER = 0;

    private Long mMaintenanceId;

    private MaterialBetterSpinner mSpinnerVehicleName;
    private EditText mDate;
    private EditText mTitle;
    private EditText mDescription;
    private EditText mMileage;
    private MaterialBetterSpinner mType;
    private EditText mPrice;
    private SwitchCompat mSwitchRegular;
    private EditText mRegularity;
    private EditText mGarage;
    private EditText mAdditionalInformation;

    private boolean isNew;

    ArrayList<String> mVehicleNameList;
    ArrayAdapter<String> mVehicleNameAdapter;

    ArrayList<String> mMaintenanceTypeList;
    ArrayAdapter<String> mMaintenanceTypeAdapter;

    public MaintenanceDetailFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maintenance_detail, container, false);

        isNew = true;
        mMaintenanceId = null;


        Bundle argument = getArguments();
        if (argument != null) {
            mMaintenanceId = argument.getLong(MaintenanceColumns._ID);

            if (mMaintenanceId != -1) {
                isNew = false;
            }
        }

        mSpinnerVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_maintenance_vehicle_name);
        mDate = (EditText) view.findViewById(R.id.input_maintenance_date);
        mDate.setFocusable(false);
        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mDate);
            }
        });
        mTitle = (EditText) view.findViewById(R.id.input_maintenance_title);
        mDescription = (EditText) view.findViewById(R.id.input_maintenance_description);
        mMileage = (EditText) view.findViewById(R.id.input_maintenance_mileage);
        mType = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_maintenance_type);
        mPrice = (EditText) view.findViewById(R.id.input_maintenance_price);
        mSwitchRegular = (SwitchCompat) view.findViewById(R.id.switch_is_maintenance_regular);
        mRegularity = (EditText) view.findViewById(R.id.input_maintenance_regularity);
        mGarage = (EditText) view.findViewById(R.id.input_maintenance_garage);
        mAdditionalInformation = (EditText) view.findViewById(R.id.input_maintenance_additional_information);


        mSpinnerVehicleName.addTextChangedListener(textWatcher);
        mDate.addTextChangedListener(textWatcher);
        mTitle.addTextChangedListener(textWatcher);
        mDescription.addTextChangedListener(textWatcher);
        mMileage.addTextChangedListener(textWatcher);
        mType.addTextChangedListener(textWatcher);
        mPrice.addTextChangedListener(textWatcher);
        mSwitchRegular.addTextChangedListener(textWatcher);
        mRegularity.addTextChangedListener(textWatcher);
        mGarage.addTextChangedListener(textWatcher);
        mAdditionalInformation.addTextChangedListener(textWatcher);


        initialValuesVehicleName();
        initialValuesMaintenanceType();

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(MAINTENANCE_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case MAINTENANCE_LOADER: {
                if (!isNew) {
                    return new CursorLoader(
                            getActivity(),
                            MaintenanceColumns.CONTENT_URI,
                            MaintenanceColumns.ALL_COLUMNS,
                            MaintenanceColumns._ID + "= ?",
                            new String[]{mMaintenanceId.toString()},
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
            case MAINTENANCE_LOADER: {
                if (!isNew) {
                    if (data != null && data.moveToFirst()) {
                        String name = ProviderUtilities.getVehicleName(getActivity(), data.getLong(ProviderUtilities.COL_MAINTENANCE_VEHICLE_ID));
                        mSpinnerVehicleName.setText(name);
                        mDate.setText(Utility.getFormatedDate(data.getLong(ProviderUtilities.COL_MAINTENANCE_DATE)));

                        mTitle.setText(data.getString(ProviderUtilities.COL_MAINTENANCE_TITLE));
                        mDescription.setText(data.getString(ProviderUtilities.COL_MAINTENANCE_DESCRIPTION));
                        mMileage.setText(Integer.toString(data.getInt(ProviderUtilities.COL_MAINTENANCE_MILEAGE)));
                        mType.setText(getType(data.getInt(ProviderUtilities.COL_MAINTENANCE_TYPE)));
                        mPrice.setText(Double.toString(data.getDouble(ProviderUtilities.COL_MAINTENANCE_PRICE)));
                        mSwitchRegular.setChecked((data.getInt(ProviderUtilities.COL_MAINTENANCE_IS_REGULAR) == 1 ? Boolean.TRUE : Boolean.FALSE));
                        mRegularity.setText(Integer.toString(data.getInt(ProviderUtilities.COL_MAINTENANCE_PERIODICITY)));
                        mGarage.setText(data.getString(ProviderUtilities.COL_MAINTENANCE_GARAGE));
                        mAdditionalInformation.setText(data.getString(ProviderUtilities.COL_MAINTENANCE_ADDITIONAL_INFORMATION));
                    }
                }
                break;
            }
        }
    }

    String getType(Integer iType) {
        if (iType == 1) {
            return getContext().getString(R.string.maintenance_type_breakdown);
        } else {
            return getContext().getString(R.string.maintenance_type_maintenance);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public void showDatePickerDialog(EditText v) {
        MaintenanceDetailFragment.DatePickerFragment newFragment = new MaintenanceDetailFragment.DatePickerFragment(getActivity(), v);
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
        mSpinnerVehicleName.setAdapter(mVehicleNameAdapter);


    }

    void initialValuesMaintenanceType() {

        VehicleSelection vehicleSelection = new VehicleSelection();
        Cursor c = getActivity().getContentResolver().query(vehicleSelection.uri(), null, null, null, null);

        mMaintenanceTypeList = new ArrayList<>();
        mMaintenanceTypeList.add(getString(R.string.maintenance_type_maintenance));
        mMaintenanceTypeList.add(getString(R.string.maintenance_type_breakdown));

        mMaintenanceTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, mMaintenanceTypeList);
        mType.setAdapter(mMaintenanceTypeAdapter);


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
            ((MaintenanceDetailFragment.Callback) getActivity())
                    .onDataChanged();

        }
    };
}
