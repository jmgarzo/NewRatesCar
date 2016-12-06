package com.jmgarzo.newratescar.provider.roadworthiness;

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
 * roadworthiness
 */
@SuppressWarnings("unused")
public class RoadworthinessColumns implements BaseColumns {
    public static final String TABLE_NAME = "roadworthiness";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String ROADWORTHINESS_DATE = "roadworthiness_date";

    public static final String ROADWORTHINESS_MILEAGE = "roadworthiness_mileage";

    public static final String ROADWORTHINESS_PRICE = "roadworthiness_price";

    public static final String ROADWORTHINESS_RESULT = "roadworthiness_result";

    public static final String ROADWORTHINESS_NEXT_DATE = "roadworthiness_next_date";

    public static final String ROADWORTHINESS_ADDITIONAL_INFORMATION = "roadworthiness_additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            ROADWORTHINESS_DATE,
            ROADWORTHINESS_MILEAGE,
            ROADWORTHINESS_PRICE,
            ROADWORTHINESS_RESULT,
            ROADWORTHINESS_NEXT_DATE,
            ROADWORTHINESS_ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(ROADWORTHINESS_DATE) || c.contains("." + ROADWORTHINESS_DATE)) return true;
            if (c.equals(ROADWORTHINESS_MILEAGE) || c.contains("." + ROADWORTHINESS_MILEAGE)) return true;
            if (c.equals(ROADWORTHINESS_PRICE) || c.contains("." + ROADWORTHINESS_PRICE)) return true;
            if (c.equals(ROADWORTHINESS_RESULT) || c.contains("." + ROADWORTHINESS_RESULT)) return true;
            if (c.equals(ROADWORTHINESS_NEXT_DATE) || c.contains("." + ROADWORTHINESS_NEXT_DATE)) return true;
            if (c.equals(ROADWORTHINESS_ADDITIONAL_INFORMATION) || c.contains("." + ROADWORTHINESS_ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
}
