package com.jmgarzo.newratescar;

import android.content.Context;

import com.jmgarzo.newratescar.provider.fueltype.FuelTypeCursor;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;

/**
 * Created by jmgarzo on 11/11/16.
 */

public class ProviderUtilities {

    //Vehicle Class
    public static String getVehicleClassName(Context context, long id) {
        String result = "";
        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        vehicleClassSelection.id(id);
        VehicleClassCursor cursor = vehicleClassSelection.query(context);

        if (cursor.moveToNext()) {
            result = cursor.getVehicleClassName();
        }
        return result;
    }

    public static Long getVehicleClassId(Context context, String vehicleClass) {
        Long id = null;

        if (null != vehicleClass && vehicleClass != "") {


            VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
            vehicleClassSelection.vehicleClassName(vehicleClass);
            VehicleClassCursor cursor = vehicleClassSelection.query(context);

            if (cursor.moveToNext()) {
                id = cursor.getId();
            }

        }
        return id;
    }

    public static Long getVehicleFuelTypeId(Context context, String vehicleFuelType) {
        Long id = null;

        if (vehicleFuelType != null && vehicleFuelType != "") {

            FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
            fuelTypeSelection.fuelTypeName(vehicleFuelType);
            FuelTypeCursor cursor = fuelTypeSelection.query(context);

            if (cursor.moveToNext()) {
                id = cursor.getId();
            }

        }
        return id;
    }
}
