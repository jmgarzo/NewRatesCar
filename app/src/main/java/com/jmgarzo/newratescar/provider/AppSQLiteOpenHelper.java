package com.jmgarzo.newratescar.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.jmgarzo.newratescar.BuildConfig;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

public class AppSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = AppSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "newratescar.db";
    private static final int DATABASE_VERSION = 1;
    private static AppSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final AppSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_FUEL_SUBTYPE = "CREATE TABLE IF NOT EXISTS "
            + FuelSubtypeColumns.TABLE_NAME + " ( "
            + FuelSubtypeColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FuelSubtypeColumns.FUEL_SUBTYPE_NAME + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (fuel_subtype_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_FUEL_TYPE = "CREATE TABLE IF NOT EXISTS "
            + FuelTypeColumns.TABLE_NAME + " ( "
            + FuelTypeColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FuelTypeColumns.FUEL_TYPE_NAME + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (fuel_type_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_MAKE = "CREATE TABLE IF NOT EXISTS "
            + MakeColumns.TABLE_NAME + " ( "
            + MakeColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MakeColumns.MAKE_NAME + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (make_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_MENU_ITEM = "CREATE TABLE IF NOT EXISTS "
            + MenuItemColumns.TABLE_NAME + " ( "
            + MenuItemColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MenuItemColumns.MENU_ITEM_NAME + " TEXT, "
            + MenuItemColumns.MENU_ITEM_IMAGE + " INTEGER "
            + ", CONSTRAINT unique_name UNIQUE (menu_item_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_VEHICLE = "CREATE TABLE IF NOT EXISTS "
            + VehicleColumns.TABLE_NAME + " ( "
            + VehicleColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VehicleColumns.VEHICLE_NAME + " TEXT, "
            + VehicleColumns.VEHICLE_CLASS + " INTEGER, "
            + VehicleColumns.FUEL_TYPE + " INTEGER, "
            + VehicleColumns.MAKE + " INTEGER, "
            + VehicleColumns.MODEL + " TEXT, "
            + VehicleColumns.MILEAGE + " INTEGER, "
            + VehicleColumns.ADDITIONAL_INFORMATION + " TEXT "
            + ", CONSTRAINT fk_vehicle_class FOREIGN KEY (" + VehicleColumns.VEHICLE_CLASS + ") REFERENCES vehicle_class (_id) ON DELETE CASCADE"
            + ", CONSTRAINT fk_fuel_type FOREIGN KEY (" + VehicleColumns.FUEL_TYPE + ") REFERENCES fuel_type (_id) ON DELETE CASCADE"
            + ", CONSTRAINT fk_make FOREIGN KEY (" + VehicleColumns.MAKE + ") REFERENCES make (_id) ON DELETE CASCADE"
            + ", CONSTRAINT unique_name UNIQUE (vehicle_name) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_VEHICLE_CLASS = "CREATE TABLE IF NOT EXISTS "
            + VehicleClassColumns.TABLE_NAME + " ( "
            + VehicleClassColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VehicleClassColumns.VEHICLE_CLASS_NAME + " TEXT "
            + ", CONSTRAINT unique_name UNIQUE (vehicle_class_name) ON CONFLICT REPLACE"
            + " );";

    // @formatter:on

    public static AppSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static AppSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static AppSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new AppSQLiteOpenHelper(context);
    }

    private AppSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new AppSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static AppSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new AppSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private AppSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new AppSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_FUEL_SUBTYPE);
        db.execSQL(SQL_CREATE_TABLE_FUEL_TYPE);
        db.execSQL(SQL_CREATE_TABLE_MAKE);
        db.execSQL(SQL_CREATE_TABLE_MENU_ITEM);
        db.execSQL(SQL_CREATE_TABLE_VEHICLE);
        db.execSQL(SQL_CREATE_TABLE_VEHICLE_CLASS);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
