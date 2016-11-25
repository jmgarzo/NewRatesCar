package com.jmgarzo.newratescar.provider;

// @formatter:off
import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jmgarzo.newratescar.BuildConfig;
import com.jmgarzo.newratescar.provider.base.BaseContentProvider;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

public class AppProvider extends BaseContentProvider {
    private static final String TAG = AppProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.DEBUG;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "com.jmgarzo.newratescar.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_FUEL_SUBTYPE = 0;
    private static final int URI_TYPE_FUEL_SUBTYPE_ID = 1;

    private static final int URI_TYPE_FUEL_TYPE = 2;
    private static final int URI_TYPE_FUEL_TYPE_ID = 3;

    private static final int URI_TYPE_MAKE = 4;
    private static final int URI_TYPE_MAKE_ID = 5;

    private static final int URI_TYPE_MENU_ITEM = 6;
    private static final int URI_TYPE_MENU_ITEM_ID = 7;

    private static final int URI_TYPE_REFUEL = 8;
    private static final int URI_TYPE_REFUEL_ID = 9;

    private static final int URI_TYPE_VEHICLE = 10;
    private static final int URI_TYPE_VEHICLE_ID = 11;

    private static final int URI_TYPE_VEHICLE_CLASS = 12;
    private static final int URI_TYPE_VEHICLE_CLASS_ID = 13;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, FuelSubtypeColumns.TABLE_NAME, URI_TYPE_FUEL_SUBTYPE);
        URI_MATCHER.addURI(AUTHORITY, FuelSubtypeColumns.TABLE_NAME + "/#", URI_TYPE_FUEL_SUBTYPE_ID);
        URI_MATCHER.addURI(AUTHORITY, FuelTypeColumns.TABLE_NAME, URI_TYPE_FUEL_TYPE);
        URI_MATCHER.addURI(AUTHORITY, FuelTypeColumns.TABLE_NAME + "/#", URI_TYPE_FUEL_TYPE_ID);
        URI_MATCHER.addURI(AUTHORITY, MakeColumns.TABLE_NAME, URI_TYPE_MAKE);
        URI_MATCHER.addURI(AUTHORITY, MakeColumns.TABLE_NAME + "/#", URI_TYPE_MAKE_ID);
        URI_MATCHER.addURI(AUTHORITY, MenuItemColumns.TABLE_NAME, URI_TYPE_MENU_ITEM);
        URI_MATCHER.addURI(AUTHORITY, MenuItemColumns.TABLE_NAME + "/#", URI_TYPE_MENU_ITEM_ID);
        URI_MATCHER.addURI(AUTHORITY, RefuelColumns.TABLE_NAME, URI_TYPE_REFUEL);
        URI_MATCHER.addURI(AUTHORITY, RefuelColumns.TABLE_NAME + "/#", URI_TYPE_REFUEL_ID);
        URI_MATCHER.addURI(AUTHORITY, VehicleColumns.TABLE_NAME, URI_TYPE_VEHICLE);
        URI_MATCHER.addURI(AUTHORITY, VehicleColumns.TABLE_NAME + "/#", URI_TYPE_VEHICLE_ID);
        URI_MATCHER.addURI(AUTHORITY, VehicleClassColumns.TABLE_NAME, URI_TYPE_VEHICLE_CLASS);
        URI_MATCHER.addURI(AUTHORITY, VehicleClassColumns.TABLE_NAME + "/#", URI_TYPE_VEHICLE_CLASS_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return AppSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_FUEL_SUBTYPE:
                return TYPE_CURSOR_DIR + FuelSubtypeColumns.TABLE_NAME;
            case URI_TYPE_FUEL_SUBTYPE_ID:
                return TYPE_CURSOR_ITEM + FuelSubtypeColumns.TABLE_NAME;

            case URI_TYPE_FUEL_TYPE:
                return TYPE_CURSOR_DIR + FuelTypeColumns.TABLE_NAME;
            case URI_TYPE_FUEL_TYPE_ID:
                return TYPE_CURSOR_ITEM + FuelTypeColumns.TABLE_NAME;

            case URI_TYPE_MAKE:
                return TYPE_CURSOR_DIR + MakeColumns.TABLE_NAME;
            case URI_TYPE_MAKE_ID:
                return TYPE_CURSOR_ITEM + MakeColumns.TABLE_NAME;

            case URI_TYPE_MENU_ITEM:
                return TYPE_CURSOR_DIR + MenuItemColumns.TABLE_NAME;
            case URI_TYPE_MENU_ITEM_ID:
                return TYPE_CURSOR_ITEM + MenuItemColumns.TABLE_NAME;

            case URI_TYPE_REFUEL:
                return TYPE_CURSOR_DIR + RefuelColumns.TABLE_NAME;
            case URI_TYPE_REFUEL_ID:
                return TYPE_CURSOR_ITEM + RefuelColumns.TABLE_NAME;

            case URI_TYPE_VEHICLE:
                return TYPE_CURSOR_DIR + VehicleColumns.TABLE_NAME;
            case URI_TYPE_VEHICLE_ID:
                return TYPE_CURSOR_ITEM + VehicleColumns.TABLE_NAME;

            case URI_TYPE_VEHICLE_CLASS:
                return TYPE_CURSOR_DIR + VehicleClassColumns.TABLE_NAME;
            case URI_TYPE_VEHICLE_CLASS_ID:
                return TYPE_CURSOR_ITEM + VehicleClassColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_FUEL_SUBTYPE:
            case URI_TYPE_FUEL_SUBTYPE_ID:
                res.table = FuelSubtypeColumns.TABLE_NAME;
                res.idColumn = FuelSubtypeColumns._ID;
                res.tablesWithJoins = FuelSubtypeColumns.TABLE_NAME;
                res.orderBy = FuelSubtypeColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_FUEL_TYPE:
            case URI_TYPE_FUEL_TYPE_ID:
                res.table = FuelTypeColumns.TABLE_NAME;
                res.idColumn = FuelTypeColumns._ID;
                res.tablesWithJoins = FuelTypeColumns.TABLE_NAME;
                res.orderBy = FuelTypeColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_MAKE:
            case URI_TYPE_MAKE_ID:
                res.table = MakeColumns.TABLE_NAME;
                res.idColumn = MakeColumns._ID;
                res.tablesWithJoins = MakeColumns.TABLE_NAME;
                res.orderBy = MakeColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_MENU_ITEM:
            case URI_TYPE_MENU_ITEM_ID:
                res.table = MenuItemColumns.TABLE_NAME;
                res.idColumn = MenuItemColumns._ID;
                res.tablesWithJoins = MenuItemColumns.TABLE_NAME;
                res.orderBy = MenuItemColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_REFUEL:
            case URI_TYPE_REFUEL_ID:
                res.table = RefuelColumns.TABLE_NAME;
                res.idColumn = RefuelColumns._ID;
                res.tablesWithJoins = RefuelColumns.TABLE_NAME;
                if (VehicleColumns.hasColumns(projection) || VehicleClassColumns.hasColumns(projection) || FuelTypeColumns.hasColumns(projection) || MakeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + VehicleColumns.TABLE_NAME + " AS " + RefuelColumns.PREFIX_VEHICLE + " ON " + RefuelColumns.TABLE_NAME + "." + RefuelColumns.VEHICLE_ID + "=" + RefuelColumns.PREFIX_VEHICLE + "." + VehicleColumns._ID;
                }
                if (VehicleClassColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + VehicleClassColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_VEHICLE_CLASS + " ON " + RefuelColumns.PREFIX_VEHICLE + "." + VehicleColumns.VEHICLE_CLASS + "=" + VehicleColumns.PREFIX_VEHICLE_CLASS + "." + VehicleClassColumns._ID;
                }
                if (FuelTypeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + FuelTypeColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_FUEL_TYPE + " ON " + RefuelColumns.PREFIX_VEHICLE + "." + VehicleColumns.VEHICLE_FUEL_TYPE + "=" + VehicleColumns.PREFIX_FUEL_TYPE + "." + FuelTypeColumns._ID;
                }
                if (MakeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + MakeColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_MAKE + " ON " + RefuelColumns.PREFIX_VEHICLE + "." + VehicleColumns.MAKE + "=" + VehicleColumns.PREFIX_MAKE + "." + MakeColumns._ID;
                }
                if (FuelSubtypeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + FuelSubtypeColumns.TABLE_NAME + " AS " + RefuelColumns.PREFIX_FUEL_SUBTYPE + " ON " + RefuelColumns.TABLE_NAME + "." + RefuelColumns.REFUEL_FUEL_SUBTYPE + "=" + RefuelColumns.PREFIX_FUEL_SUBTYPE + "." + FuelSubtypeColumns._ID;
                }
                res.orderBy = RefuelColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_VEHICLE:
            case URI_TYPE_VEHICLE_ID:
                res.table = VehicleColumns.TABLE_NAME;
                res.idColumn = VehicleColumns._ID;
                res.tablesWithJoins = VehicleColumns.TABLE_NAME;
                if (VehicleClassColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + VehicleClassColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_VEHICLE_CLASS + " ON " + VehicleColumns.TABLE_NAME + "." + VehicleColumns.VEHICLE_CLASS + "=" + VehicleColumns.PREFIX_VEHICLE_CLASS + "." + VehicleClassColumns._ID;
                }
                if (FuelTypeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + FuelTypeColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_FUEL_TYPE + " ON " + VehicleColumns.TABLE_NAME + "." + VehicleColumns.VEHICLE_FUEL_TYPE + "=" + VehicleColumns.PREFIX_FUEL_TYPE + "." + FuelTypeColumns._ID;
                }
                if (MakeColumns.hasColumns(projection)) {
                    res.tablesWithJoins += " LEFT OUTER JOIN " + MakeColumns.TABLE_NAME + " AS " + VehicleColumns.PREFIX_MAKE + " ON " + VehicleColumns.TABLE_NAME + "." + VehicleColumns.MAKE + "=" + VehicleColumns.PREFIX_MAKE + "." + MakeColumns._ID;
                }
                res.orderBy = VehicleColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_VEHICLE_CLASS:
            case URI_TYPE_VEHICLE_CLASS_ID:
                res.table = VehicleClassColumns.TABLE_NAME;
                res.idColumn = VehicleClassColumns._ID;
                res.tablesWithJoins = VehicleClassColumns.TABLE_NAME;
                res.orderBy = VehicleClassColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_FUEL_SUBTYPE_ID:
            case URI_TYPE_FUEL_TYPE_ID:
            case URI_TYPE_MAKE_ID:
            case URI_TYPE_MENU_ITEM_ID:
            case URI_TYPE_REFUEL_ID:
            case URI_TYPE_VEHICLE_ID:
            case URI_TYPE_VEHICLE_CLASS_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
