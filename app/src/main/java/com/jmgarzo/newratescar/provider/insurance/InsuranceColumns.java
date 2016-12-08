package com.jmgarzo.newratescar.provider.insurance;

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
 * insurance
 */
@SuppressWarnings("unused")
public class InsuranceColumns implements BaseColumns {
    public static final String TABLE_NAME = "insurance";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String VEHICLE_ID = "vehicle_id";

    public static final String INSURANCE_COMPANY = "insurance_company";

    public static final String INSURANCE_PRICE = "insurance_price";

    public static final String POLICY_NUMBER = "policy_number";

    public static final String START_DATE = "start_date";

    public static final String END_DATE = "end_date";

    public static final String INSURANCE_ADDITIONAL_INFORMATION = "insurance_additional_information";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            VEHICLE_ID,
            INSURANCE_COMPANY,
            INSURANCE_PRICE,
            POLICY_NUMBER,
            START_DATE,
            END_DATE,
            INSURANCE_ADDITIONAL_INFORMATION
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(VEHICLE_ID) || c.contains("." + VEHICLE_ID)) return true;
            if (c.equals(INSURANCE_COMPANY) || c.contains("." + INSURANCE_COMPANY)) return true;
            if (c.equals(INSURANCE_PRICE) || c.contains("." + INSURANCE_PRICE)) return true;
            if (c.equals(POLICY_NUMBER) || c.contains("." + POLICY_NUMBER)) return true;
            if (c.equals(START_DATE) || c.contains("." + START_DATE)) return true;
            if (c.equals(END_DATE) || c.contains("." + END_DATE)) return true;
            if (c.equals(INSURANCE_ADDITIONAL_INFORMATION) || c.contains("." + INSURANCE_ADDITIONAL_INFORMATION)) return true;
        }
        return false;
    }

    public static final String PREFIX_VEHICLE = TABLE_NAME + "__" + VehicleColumns.TABLE_NAME;
}
