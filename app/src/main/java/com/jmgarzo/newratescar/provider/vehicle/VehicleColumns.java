package com.jmgarzo.newratescar.provider.vehicle;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.base.AbstractSelection;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.toll.TollColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * Vehicle
 */
@SuppressWarnings("unused")
public class VehicleColumns implements BaseColumns {
    public static final String TABLE_NAME = "vehicle";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Vehicle name
     */
    public static final String VEHICLE_NAME = "vehicle_name";

    public static final String VEHICLE_CLASS = "vehicle_class";

    public static final String VEHICLE_FUEL_TYPE = "vehicle_fuel_type";

    public static final String MAKE = "make";

    public static final String MODEL = "model";

    public static final String MILEAGE = "mileage";

    public static final String ADDITIONAL_INFORMATION = "additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_NAME,
            VEHICLE_CLASS,
            VEHICLE_FUEL_TYPE,
            MAKE,
            MODEL,
            MILEAGE,
            ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_NAME) || c.contains("." + VEHICLE_NAME)) return true;
            if (c.equals(VEHICLE_CLASS) || c.contains("." + VEHICLE_CLASS)) return true;
            if (c.equals(VEHICLE_FUEL_TYPE) || c.contains("." + VEHICLE_FUEL_TYPE)) return true;
            if (c.equals(MAKE) || c.contains("." + MAKE)) return true;
            if (c.equals(MODEL) || c.contains("." + MODEL)) return true;
            if (c.equals(MILEAGE) || c.contains("." + MILEAGE)) return true;
            if (c.equals(ADDITIONAL_INFORMATION) || c.contains("." + ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE_CLASS = TABLE_NAME + "__" + VehicleClassColumns.TABLE_NAME;
    public static final String PREFIX_FUEL_TYPE = TABLE_NAME + "__" + FuelTypeColumns.TABLE_NAME;
    public static final String PREFIX_MAKE = TABLE_NAME + "__" + MakeColumns.TABLE_NAME;
}
