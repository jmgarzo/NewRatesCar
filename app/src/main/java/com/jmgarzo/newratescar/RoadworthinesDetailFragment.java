package com.jmgarzo.newratescar;

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
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.Utility.Utility;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class RoadworthinesDetailFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {




    public interface Callback {

        public void onDataChanged();
    }

    private static final String LOG_TAG = RoadworthinesDetailFragment.class.getSimpleName();
    private static final int ROAD_LOADER = 0;

    private Long mRoadId;

    private MaterialBetterSpinner mVehicleName;
    private EditText mRoadDate;
    private EditText mMileage;
    private TextView mMileageUnits;
    private EditText mPrice;
    private AutoCompleteTextView mResult;
    private EditText mRoadNextDate;
    private EditText mAdditionalInf;

    private boolean isNew;

    private ArrayList<String> mVehicleNameList;
    private ArrayAdapter<String> mVehicleNameAdapter;


    public RoadworthinesDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_roadworthines_detail, container, false);

        isNew = true;
        mRoadId = null;


        Bundle argument = getArguments();
        if (argument != null) {
            mRoadId = argument.getLong(RefuelColumns._ID);

            if (mRoadId != -1) {
                isNew = false;
            }
        }

        mVehicleName = (MaterialBetterSpinner) view.findViewById(R.id.better_spinner_road_vehicle_name);
        mRoadDate= (EditText) view.findViewById(R.id.input_road_date);
        mRoadDate.setFocusable(false);
        mRoadDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mRoadDate);
            }
        });
        mRoadDate.setText(Utility.getCurrentDate());
        mMileage= (EditText) view.findViewById(R.id.input_road_mileage);
        mMileageUnits= (TextView) view.findViewById(R.id.input_road_mileage_unit);
        mPrice = (EditText) view.findViewById(R.id.input_road_price);
        mResult= (AutoCompleteTextView) view.findViewById(R.id.autocompleteView_road_result);
        mRoadNextDate = (EditText) view.findViewById(R.id.input_road_next_date);
        mRoadNextDate.setFocusable(false);
        mRoadNextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(mRoadNextDate);
            }
        });
        mRoadNextDate.setText(Utility.getCurrentDate());
        mAdditionalInf = (EditText) view.findViewById(R.id.input_road_additional_information);

        mVehicleName.addTextChangedListener(textWatcher);
        mRoadDate.addTextChangedListener(textWatcher);
        mMileage.addTextChangedListener(textWatcher);
        mPrice.addTextChangedListener(textWatcher);
        mResult.addTextChangedListener(textWatcher);
        mRoadNextDate.addTextChangedListener(textWatcher);
        mAdditionalInf.addTextChangedListener(textWatcher);

        initialValuesVehicleName();



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(ROAD_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    void initialValuesVehicleName() {

        mVehicleName.addTextChangedListener(textWatcher);
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

    public void showDatePickerDialog(EditText v) {
        RefuelDetailFragment.DatePickerFragment newFragment = new RefuelDetailFragment.DatePickerFragment(getActivity(), v);
        newFragment.show(getActivity().getFragmentManager(), "datePicker");

    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case ROAD_LOADER: {
                if (mRoadId != null) {
                    return new CursorLoader(
                            getActivity(),
                            RoadworthinessColumns.CONTENT_URI,
                            RoadworthinessColumns.ALL_COLUMNS,
                            RoadworthinessColumns._ID + "= ?",
                            new String[]{mRoadId.toString()},
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
            case ROAD_LOADER: {
                if (data != null && data.moveToFirst()) {
                    String name = ProviderUtilities.getVehicleName(getActivity(),
                            data.getLong(ProviderUtilities.COL_ROADWORTHINESS_VEHICLE_ID));
                    mVehicleName.setText(name);

                    mRoadDate.setText(Utility.getFormatedDate(data.getLong(ProviderUtilities.COL_ROADWORTHINESS_DATE)));
                    mMileage.setText(data.getString(ProviderUtilities.COL_ROADWORTHINESS_MILEAGE));
                    mPrice.setText(Double.toString(data.getDouble(ProviderUtilities.COL_ROADWORTHINESS_PRICE)));
                    mResult.setText(data.getString(ProviderUtilities.COL_ROADWORTHINESS_RESULT));
                    mRoadNextDate.setText(Utility.getFormatedDate(
                            data.getLong(ProviderUtilities.COL_ROADWORTHINESS_NEXT_DATE)));
                    mAdditionalInf.setText(data.getString(ProviderUtilities.COL_ROADWORTHINESS_ADDITIONAL_INFORMATION));

                }
                break;
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }


    private TextWatcher textWatcher = new TextWatcher() {

        public void afterTextChanged(Editable s) {}

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            ((Callback) getActivity())
                    .onDataChanged();

        }
    };
}
