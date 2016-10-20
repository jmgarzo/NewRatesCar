package com.jmgarzo.newratescar.provider.menuitem;

import android.net.Uri;
import android.provider.BaseColumns;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * Menu Item
 */
public class MenuItemColumns implements BaseColumns {
    public static final String TABLE_NAME = "menu_item";
    public static final Uri CONTENT_URI = Uri.parse(AppProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    /**
     * Menu Item Name
     */
    public static final String MENU_ITEM_NAME = "menu_item_name";

    public static final String MENU_ITEM_IMAGE = "menu_item_image";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            MENU_ITEM_NAME,
            MENU_ITEM_IMAGE
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(MENU_ITEM_NAME) || c.contains("." + MENU_ITEM_NAME)) return true;
            if (c.equals(MENU_ITEM_IMAGE) || c.contains("." + MENU_ITEM_IMAGE)) return true;
        }
        return false;
    }

}
