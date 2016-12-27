package com.jmgarzo.newratescar.provider.maintenance;

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
 * maintenance
 */
@SuppressWarnings("unused")
public class MaintenanceColumns implements BaseColumns {
    public static final String TABLE_NAME = "maintenance";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String MAINTENANCE_TITLE = "maintenance_title";

    public static final String MAINTENANCE_DATE = "maintenance_date";

    public static final String MAINTENANCE_MILEAGE = "maintenance_mileage";

    public static final String MAINTENANCE_TYPE = "maintenance_type";

    public static final String MAINTENANCE_PRICE = "maintenance_price";

    public static final String MAINTENANCE_DESCRIPTION = "maintenance_description";

    public static final String IS_REGULAR = "is_regular";

    public static final String MAINTENANCE_PERIODICITY = "maintenance_periodicity";

    public static final String MAINTENANCE_GARAGE = "maintenance_garage";

    public static final String MAINTENANCE_ADDITIONAL_INFORMATION = "maintenance_additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            MAINTENANCE_TITLE,
            MAINTENANCE_DATE,
            MAINTENANCE_MILEAGE,
            MAINTENANCE_TYPE,
            MAINTENANCE_PRICE,
            MAINTENANCE_DESCRIPTION,
            IS_REGULAR,
            MAINTENANCE_PERIODICITY,
            MAINTENANCE_GARAGE,
            MAINTENANCE_ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(MAINTENANCE_TITLE) || c.contains("." + MAINTENANCE_TITLE)) return true;
            if (c.equals(MAINTENANCE_DATE) || c.contains("." + MAINTENANCE_DATE)) return true;
            if (c.equals(MAINTENANCE_MILEAGE) || c.contains("." + MAINTENANCE_MILEAGE)) return true;
            if (c.equals(MAINTENANCE_TYPE) || c.contains("." + MAINTENANCE_TYPE)) return true;
            if (c.equals(MAINTENANCE_PRICE) || c.contains("." + MAINTENANCE_PRICE)) return true;
            if (c.equals(MAINTENANCE_DESCRIPTION) || c.contains("." + MAINTENANCE_DESCRIPTION)) return true;
            if (c.equals(IS_REGULAR) || c.contains("." + IS_REGULAR)) return true;
            if (c.equals(MAINTENANCE_PERIODICITY) || c.contains("." + MAINTENANCE_PERIODICITY)) return true;
            if (c.equals(MAINTENANCE_GARAGE) || c.contains("." + MAINTENANCE_GARAGE)) return true;
            if (c.equals(MAINTENANCE_ADDITIONAL_INFORMATION) || c.contains("." + MAINTENANCE_ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
}
