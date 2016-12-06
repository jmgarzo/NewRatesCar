package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleCursor;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;

/**
 * Created by jmgarzo on 27/11/16.
 */

public class SaveRoad extends AsyncTask<RoadworthinessContentValues, Void, Void> {

    private final String LOG_TAG = SaveRoad.class.getSimpleName();

    private final Context mContext;
    private final Long mRoadId;
    private final String mVehicleName;
    private Integer mMileage;

    public SaveRoad(Context mContext, Long roadId, String vehicleName, Integer mileage) {
        this.mContext = mContext;
        this.mRoadId = roadId;
        this.mVehicleName = vehicleName;
        this.mMileage = mileage;
    }

    @Override
    protected Void doInBackground(RoadworthinessContentValues... params) {
        if (params.length == 0) {
            return null;
        }


        RoadworthinessContentValues values = params[0];

        String newRoadId;
        if (null == mRoadId || mRoadId == -1) {
            Uri insertUri = mContext.getContentResolver().insert(values.uri(), values.values());
            newRoadId = insertUri.getLastPathSegment();
        } else {
            newRoadId=mRoadId.toString();
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    RoadworthinessColumns._ID + "= ?",
                    new String[]{mRoadId.toString()});
        }


        VehicleSelection vehicleSelection = new VehicleSelection();
        vehicleSelection.vehicleName(mVehicleName);
        VehicleCursor vehicleCursor = vehicleSelection.query(mContext,new String[]{VehicleColumns.MILEAGE,VehicleColumns._ID});
        Integer mileage=0;
        if (vehicleCursor.moveToNext()) {
            mileage = vehicleCursor.getMileage();
        }
        vehicleCursor.close();

        if (mMileage > mileage) {
            VehicleContentValues vehicleValues = new VehicleContentValues();
            vehicleValues.putMileage(mMileage);
            mContext.getContentResolver().update(vehicleValues.uri(),
                    vehicleValues.values(),
                    VehicleColumns.VEHICLE_NAME.concat("= ?"),
                    new String[]{mVehicleName});
        }



        return null;
    }
}
