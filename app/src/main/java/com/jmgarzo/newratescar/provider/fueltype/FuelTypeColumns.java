package com.jmgarzo.newratescar.provider.fueltype;

import android.net.Uri;
import android.provider.BaseColumns;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * Fuel subtype
 */
public class FuelTypeColumns implements BaseColumns {
    public static final String TABLE_NAME = "fuel_type";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Fuel Subtype Name
     */
    public static final String FUEL_TYPE_NAME = "fuel_type_name";

    public static final String FUEL_SUBTYPE = "fuel_subtype";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            FUEL_TYPE_NAME,
            FUEL_SUBTYPE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(FUEL_TYPE_NAME) || c.contains("." + FUEL_TYPE_NAME)) return true;
            if (c.equals(FUEL_SUBTYPE) || c.contains("." + FUEL_SUBTYPE)) return true;
        }
        return false;
    }

    public static final String PREFIX_FUEL_SUBTYPE = TABLE_NAME + "__" + FuelSubtypeColumns.TABLE_NAME;
}
