package com.jmgarzo.newratescar;

import android.content.Context;

import com.jmgarzo.newratescar.provider.fueltype.FuelTypeCursor;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;

/**
 * Created by jmgarzo on 11/11/16.
 */

public class ProviderUtilities {


    public static final String[] VEHICLE_ALL_COLUMNS = new String[] {
            VehicleColumns._ID,
            VehicleColumns.VEHICLE_NAME,
            VehicleColumns.VEHICLE_CLASS,
            VehicleColumns.FUEL_TYPE,
            VehicleColumns.MAKE,
            VehicleColumns.MODEL,
            VehicleColumns.MILEAGE,
            VehicleColumns.ADDITIONAL_INFORMATION
    };

    public static final int COL_VEHICLE_ID = 0;
    public static final int COL_VEHICLE_NAME = 1;
    public static final int COL_VEHICLE_CLASS = 2;
    public static final int COL_VEHICLE_FUEL_TYPE = 3;
    public static final int COL_VEHICLE_MAKE = 4;
    public static final int COL_VEHICLE_MODEL = 5;
    public static final int COL_VEHICLE_MILEAGE = 6;
    public static final int COL_VEHICLE_ADDITIONAL_INFORMATION = 7;




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

    public static String getVehicleFuelTypeName(Context context, long id) {
        String result = "";
        FuelTypeSelection fuelTypeSelection = new FuelTypeSelection();
        fuelTypeSelection.id(id);
        FuelTypeCursor cursor = fuelTypeSelection.query(context);

        if (cursor.moveToNext()) {
            result = cursor.getFuelTypeName();
        }
        return result;
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
