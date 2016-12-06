package com.jmgarzo.newratescar.provider.refuel;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.base.AbstractSelection;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * refuel
 */
@SuppressWarnings("unused")
public class RefuelColumns implements BaseColumns {
    public static final String TABLE_NAME = "refuel";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String REFUEL_DATE = "refuel_date";

    public static final String REFUEL_FUEL_TYPE = "refuel_fuel_type";

    public static final String REFUEL_FUEL_SUBTYPE = "refuel_fuel_subtype";

    public static final String REFUEL_MILEAGE = "refuel_mileage";

    public static final String REFUEL_TRIP_ODOMETER = "refuel_trip_odometer";

    public static final String REFUEL_LITRES = "refuel_litres";

    public static final String REFUEL_GAS_PRICE = "refuel_gas_price";

    public static final String REFUEL_TOTAL_PRICE = "refuel_total_price";

    public static final String IS_FULL = "is_full";

    public static final String IS_TRAILER = "is_trailer";

    public static final String IS_ROOF_RACK = "is_roof_rack";

    public static final String ROUTE_TYPE = "route_type";

    public static final String DRIVING_STYLE = "driving_style";

    public static final String AVERAGE_SPEED = "average_speed";

    public static final String AVERAGE_CONSUMPTION = "average_consumption";

    public static final String PAYMENT_TYPE = "payment_type";

    public static final String GAS_STATION = "gas_station";

    public static final String REFUEL_ADDITIONAL_INFORMATION = "refuel_additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            REFUEL_DATE,
            REFUEL_FUEL_TYPE,
            REFUEL_FUEL_SUBTYPE,
            REFUEL_MILEAGE,
            REFUEL_TRIP_ODOMETER,
            REFUEL_LITRES,
            REFUEL_GAS_PRICE,
            REFUEL_TOTAL_PRICE,
            IS_FULL,
            IS_TRAILER,
            IS_ROOF_RACK,
            ROUTE_TYPE,
            DRIVING_STYLE,
            AVERAGE_SPEED,
            AVERAGE_CONSUMPTION,
            PAYMENT_TYPE,
            GAS_STATION,
            REFUEL_ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(REFUEL_DATE) || c.contains("." + REFUEL_DATE)) return true;
            if (c.equals(REFUEL_FUEL_TYPE) || c.contains("." + REFUEL_FUEL_TYPE)) return true;
            if (c.equals(REFUEL_FUEL_SUBTYPE) || c.contains("." + REFUEL_FUEL_SUBTYPE)) return true;
            if (c.equals(REFUEL_MILEAGE) || c.contains("." + REFUEL_MILEAGE)) return true;
            if (c.equals(REFUEL_TRIP_ODOMETER) || c.contains("." + REFUEL_TRIP_ODOMETER)) return true;
            if (c.equals(REFUEL_LITRES) || c.contains("." + REFUEL_LITRES)) return true;
            if (c.equals(REFUEL_GAS_PRICE) || c.contains("." + REFUEL_GAS_PRICE)) return true;
            if (c.equals(REFUEL_TOTAL_PRICE) || c.contains("." + REFUEL_TOTAL_PRICE)) return true;
            if (c.equals(IS_FULL) || c.contains("." + IS_FULL)) return true;
            if (c.equals(IS_TRAILER) || c.contains("." + IS_TRAILER)) return true;
            if (c.equals(IS_ROOF_RACK) || c.contains("." + IS_ROOF_RACK)) return true;
            if (c.equals(ROUTE_TYPE) || c.contains("." + ROUTE_TYPE)) return true;
            if (c.equals(DRIVING_STYLE) || c.contains("." + DRIVING_STYLE)) return true;
            if (c.equals(AVERAGE_SPEED) || c.contains("." + AVERAGE_SPEED)) return true;
            if (c.equals(AVERAGE_CONSUMPTION) || c.contains("." + AVERAGE_CONSUMPTION)) return true;
            if (c.equals(PAYMENT_TYPE) || c.contains("." + PAYMENT_TYPE)) return true;
            if (c.equals(GAS_STATION) || c.contains("." + GAS_STATION)) return true;
            if (c.equals(REFUEL_ADDITIONAL_INFORMATION) || c.contains("." + REFUEL_ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
    public static final String PREFIX_FUEL_TYPE = TABLE_NAME + "__" + FuelTypeColumns.TABLE_NAME;
    public static final String PREFIX_FUEL_SUBTYPE = TABLE_NAME + "__" + FuelSubtypeColumns.TABLE_NAME;
}
