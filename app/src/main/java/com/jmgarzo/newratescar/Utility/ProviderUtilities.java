package com.jmgarzo.newratescar.Utility;

import android.content.Context;
import android.net.Uri;

import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeContentValues;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeCursor;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.make.MakeContentValues;
import com.jmgarzo.newratescar.provider.make.MakeCursor;
import com.jmgarzo.newratescar.provider.make.MakeSelection;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleCursor;
import com.jmgarzo.newratescar.provider.vehicle.VehicleSelection;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jmgarzo on 11/11/16.
 */

public class ProviderUtilities {


    public static final String[] VEHICLE_ALL_COLUMNS = VehicleColumns.ALL_COLUMNS;
    public static final int COL_VEHICLE_ID = 0;
    public static final int COL_VEHICLE_NAME = 1;
    public static final int COL_VEHICLE_CLASS = 2;
    public static final int COL_VEHICLE_FUEL_TYPE = 3;
    public static final int COL_VEHICLE_MAKE = 4;
    public static final int COL_VEHICLE_MODEL = 5;
    public static final int COL_VEHICLE_MILEAGE = 6;
    public static final int COL_VEHICLE_ADDITIONAL_INFORMATION = 7;


    public static final String[] REFUEL_ALL_COLUMNS = RefuelColumns.ALL_COLUMNS;
    public static final int COL_REFUEL_ID = 0;
    public static final int COL_REFUEL_VEHICLE_ID = 1;
    public static final int COL_DATE = 2;
    public static final int COL_REFUEL_FUEL_TYPE = 3;
    public static final int COL_REFUEL_FUEL_SUBTYPE = 4;
    public static final int COL_REFUEL_MILEAGE = 5;
    public static final int COL_REFUEL_TRIP_ODOMETER = 6;
    public static final int COL_REFUEL_LITRES = 7;
    public static final int COL_REFUEL_GAS_PRICE = 8;
    public static final int COL_REFUEL_TOTAL_PRICE = 9;
    public static final int COL_REFUEL_IS_FULL = 10;
    public static final int COL_REFUEL_IS_TRAILER = 11;
    public static final int COL_REFUEL_IS_ROOF_RACK = 12;
    public static final int COL_REFUEL_ROUTE_TYPE = 13;
    public static final int COL_REFUEL_DRIVING_STYLE = 14;
    public static final int COL_REFUEL_AVERAGE_SPEED = 15;
    public static final int COL_REFUEL_AVERAGE_CONSUMPTION = 16;
    public static final int COL_REFUEL_PAYMENT_TYPE = 17;
    public static final int COL_REFUEL_GAS_STATION = 18;
    public static final int COL_REFUEL_ADDITIONAL_INFORMATION = 19;


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
        if (null != vehicleClass && !vehicleClass.equalsIgnoreCase("")) {
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
            } else {
                id = addNewFuelType(context, vehicleFuelType);
            }
        }
        return id;
    }

    public static Long addNewFuelType(Context context, String fuelType) {
        FuelTypeContentValues contentValues = new FuelTypeContentValues();
        contentValues.putFuelTypeName(fuelType);
        Uri uri = context.getContentResolver().insert(contentValues.uri(), contentValues.values());

        return Long.parseLong(uri.getLastPathSegment());

    }

    public static String getMakeName(Context context, long id) {
        String result = "";
        MakeSelection makeSelection = new MakeSelection();
        makeSelection.id(id);
        MakeCursor cursor = makeSelection.query(context);
        if (cursor.moveToNext()) {
            result = cursor.getMakeName();
        }
        return result;
    }

    public static Long getMakeId(Context context, String make) {
        Long id = null;
        if (make != null && make != "") {
            MakeSelection makeSelection = new MakeSelection();
            makeSelection.makeName(make);
            MakeCursor cursor = makeSelection.query(context);
            if (cursor.moveToNext()) {
                id = cursor.getId();
            } else {
                id = addNewMake(context, make);
            }
        }
        return id;
    }

    public static Long addNewMake(Context context, String make) {
        MakeContentValues contentValues = new MakeContentValues();
        contentValues.putMakeName(make);
        Uri uri = context.getContentResolver().insert(contentValues.uri(), contentValues.values());

        return Long.parseLong(uri.getLastPathSegment());

    }

    public static Integer getIconClass(Context context, Long idClass) {

        if (idClass != null) {
            String className = getVehicleClassName(context, idClass);
            if (null == className || className.equalsIgnoreCase("")) {
                return R.drawable.ic_directions_car_black_48dp;
            } else {
                Map<String, Integer> vehicleClassMap = new HashMap<String, Integer>();
                vehicleClassMap.put(context.getString(R.string.car_class), R.drawable.ic_directions_car_black_48dp);
                vehicleClassMap.put(context.getString(R.string.bike_class), R.drawable.ic_directions_bike_black_48dp);
                vehicleClassMap.put(context.getString(R.string.bus_class), R.drawable.ic_directions_bus_black_48dp);
                vehicleClassMap.put(context.getString(R.string.quad_class), R.drawable.ic_quad_100);
                vehicleClassMap.put(context.getString(R.string.motorcycle_class), R.drawable.ic_motorcycle_black_48dp);
                vehicleClassMap.put(context.getString(R.string.tractor_class), R.drawable.ic_tractor_104);
                vehicleClassMap.put(context.getString(R.string.truck_class), R.drawable.ic_truck_100);
                vehicleClassMap.put(context.getString(R.string.van_class), R.drawable.ic_local_shipping_black_48dp);

                return vehicleClassMap.get(className);
            }
        } else {
            return R.drawable.ic_directions_car_black_48dp;
        }

    }


    public static String getVehicleName(Context context, long id) {
        String result = "";
        VehicleSelection vehicleSelection = new VehicleSelection();
        vehicleSelection.id(id);
        VehicleCursor cursor = vehicleSelection.query(context);
        if (cursor.moveToNext()) {
            result = cursor.getVehicleName();
        }
        return result;
    }

    public static Long getVehicleId(Context context, String name) {
        Long id = null;
        if (name != null && name != "") {
            VehicleSelection vehicleSelection = new VehicleSelection();
            vehicleSelection.vehicleName(name);
            VehicleCursor cursor = vehicleSelection.query(context);
            if (cursor.moveToNext()) {
                id = cursor.getId();
            } else {
                id = null;
            }
        }
        return id;
    }


}