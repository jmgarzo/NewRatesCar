package com.jmgarzo.newratescar.provider.toll;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.base.AbstractSelection;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.roadworthiness.RoadworthinessColumns;
import com.jmgarzo.newratescar.provider.toll.TollColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * toll
 */
@SuppressWarnings("unused")
public class TollColumns implements BaseColumns {
    public static final String TABLE_NAME = "toll";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String TOLL_DATE = "toll_date";

    public static final String TOLL_PRICE = "toll_price";

    public static final String TOLL_NAME = "toll_name";

    public static final String TOLL_ROAD = "toll_road";

    public static final String TOLL_DIRECTION = "toll_direction";

    public static final String TOLL_LOCATION = "toll_location";

    public static final String TOLL_ADDITIONAL_INFORMATION = "toll_additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            TOLL_DATE,
            TOLL_PRICE,
            TOLL_NAME,
            TOLL_ROAD,
            TOLL_DIRECTION,
            TOLL_LOCATION,
            TOLL_ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(TOLL_DATE) || c.contains("." + TOLL_DATE)) return true;
            if (c.equals(TOLL_PRICE) || c.contains("." + TOLL_PRICE)) return true;
            if (c.equals(TOLL_NAME) || c.contains("." + TOLL_NAME)) return true;
            if (c.equals(TOLL_ROAD) || c.contains("." + TOLL_ROAD)) return true;
            if (c.equals(TOLL_DIRECTION) || c.contains("." + TOLL_DIRECTION)) return true;
            if (c.equals(TOLL_LOCATION) || c.contains("." + TOLL_LOCATION)) return true;
            if (c.equals(TOLL_ADDITIONAL_INFORMATION) || c.contains("." + TOLL_ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
}
