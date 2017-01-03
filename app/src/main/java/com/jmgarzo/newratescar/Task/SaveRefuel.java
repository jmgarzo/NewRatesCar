package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.Utility.ProviderUtilities;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleContentValues;
import com.jmgarzo.newratescar.provider.vehicle.VehicleCursor;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;

/**
 * Created by jmgarzo on 27/11/16.
 */

public class SaveRefuel extends AsyncTask<RefuelContentValues, Void, Void> {

    private final String LOG_TAG = SaveRefuel.class.getSimpleName();

    private final Context mContext;
    private final Long mRefuelId;
    private final String mVehicleName;
    private Integer mMileage;
    private String mFuelType;



    public SaveRefuel(Context mContext, Long refuelId, String vehicleName, Integer mileage,String fuelType) {
        this.mContext = mContext;
        this.mRefuelId = refuelId;
        this.mVehicleName = vehicleName;
        this.mMileage = mileage;
        this.mFuelType = fuelType;

    }

    @Override
    protected Void doInBackground(RefuelContentValues... params) {
        if (params.length == 0) {
            return null;
        }


        RefuelContentValues values = params[0];

        String newRefuelId;
        if (null == mRefuelId || mRefuelId == -1) {

            Uri insertUri = mContext.getContentResolver().insert(values.uri(), values.values());
            newRefuelId = insertUri.getLastPathSegment();
        } else {
            newRefuelId=mRefuelId.toString();
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    RefuelColumns._ID + "= ?",
                    new String[]{mRefuelId.toString()});
        }


        VehicleSelection vehicleSelection = new VehicleSelection();
        vehicleSelection.vehicleName(mVehicleName);
        VehicleCursor vehicleCursor = vehicleSelection.query(mContext,new String[]{VehicleColumns.MILEAGE,VehicleColumns.VEHICLE_FUEL_TYPE,VehicleColumns._ID});
        Integer mileage=0;
        boolean isFuelTypeEmpty=false;
        if (vehicleCursor.moveToNext()) {
            mileage = vehicleCursor.getMileage();
            String vehicleFuelType = ProviderUtilities.getVehicleFuelTypeName(mContext,vehicleCursor.getVehicleFuelType());
            if(vehicleFuelType != null && vehicleFuelType != ""){
                isFuelTypeEmpty = true;

            }
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

        ProviderUtilities.calculateAverageConsumption(mContext,Long.parseLong(newRefuelId));

        if(isFuelTypeEmpty){
            VehicleContentValues vehicleValues = new VehicleContentValues();
            vehicleValues.putVehicleFuelType(ProviderUtilities.getVehicleFuelTypeId(mContext,mFuelType));

            mContext.getContentResolver().update(vehicleValues.uri(),
                    vehicleValues.values(),
                    VehicleColumns.VEHICLE_NAME.concat("= ?"),
                    new String[]{mVehicleName});
        }


        return null;
    }
}
