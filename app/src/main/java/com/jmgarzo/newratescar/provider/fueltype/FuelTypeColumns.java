package com.jmgarzo.newratescar.provider.fueltype;

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
 * Fuel Type
 */
@SuppressWarnings("unused")
public class FuelTypeColumns implements BaseColumns {
    public static final String TABLE_NAME = "fuel_type";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Fuel Type Name
     */
    public static final String FUEL_TYPE_NAME = "fuel_type__fuel_type_name";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            FUEL_TYPE_NAME
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(FUEL_TYPE_NAME) || c.contains("." + FUEL_TYPE_NAME)) return true;
        }
        return false;
    }

}
