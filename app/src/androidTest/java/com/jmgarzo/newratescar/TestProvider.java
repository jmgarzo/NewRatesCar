package com.jmgarzo.newratescar;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.jmgarzo.newratescar.provider.AppProvider;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeContentValues;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeCursor;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeSelection;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeContentValues;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

/**
 * Created by jmgarzo on 20/09/16.
 */

public class TestProvider extends AndroidTestCase {

    public static final String LOG_TAG = TestProvider.class.getSimpleName();

    public void deleteAllRecordsFromProvider() {
        mContext.getContentResolver().delete(
                FuelSubtypeColumns.CONTENT_URI,
                null,
                null
        );

        Cursor cursor = mContext.getContentResolver().query(
                FuelSubtypeColumns.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        assertEquals("Error: Records not deleted from Weather table during delete", 0, cursor.getCount());
        cursor.close();


        mContext.getContentResolver().delete(
                FuelTypeColumns.CONTENT_URI,
                null,
                null
        );

        cursor = mContext.getContentResolver().query(
                FuelTypeColumns.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        assertEquals("Error: Records not deleted from Weather table during delete", 0, cursor.getCount());
        cursor.close();

        mContext.getContentResolver().delete(
                MakeColumns.CONTENT_URI,
                null,
                null
        );

        cursor = mContext.getContentResolver().query(
                MakeColumns.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        assertEquals("Error: Records not deleted from Weather table during delete", 0, cursor.getCount());
        cursor.close();

        mContext.getContentResolver().delete(
                VehicleClassColumns.CONTENT_URI,
                null,
                null
        );

        cursor = mContext.getContentResolver().query(
                VehicleClassColumns.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        assertEquals("Error: Records not deleted from Weather table during delete", 0, cursor.getCount());
        cursor.close();

        mContext.getContentResolver().delete(
                VehicleColumns.CONTENT_URI,
                null,
                null
        );

        cursor = mContext.getContentResolver().query(
                VehicleColumns.CONTENT_URI,
                null,
                null,
                null,
                null
        );
        assertEquals("Error: Records not deleted from Weather table during delete", 0, cursor.getCount());
        cursor.close();

    }


    public void deleteAllRecords() {
        //deleteAllRecordsFromProvider();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        deleteAllRecords();
    }

    public void testProviderRegistry() {
        PackageManager pm = mContext.getPackageManager();


        ComponentName componentName = new ComponentName(mContext.getPackageName(),
                FuelTypeColumns.class.getName());
        try {
            // Fetch the provider info using the component name from the PackageManager
            // This throws an exception if the provider isn't registered.
            ProviderInfo providerInfo = pm.getProviderInfo(componentName, 0);

            // Make sure that the registered authority matches the authority from the Contract.
            assertEquals("Error: AppProvider registered with authority: " + providerInfo.authority +
                            " instead of authority: " + AppProvider.AUTHORITY,
                    providerInfo.authority, AppProvider.AUTHORITY);
        } catch (PackageManager.NameNotFoundException e) {
            // I guess the provider isn't registered correctly.
            assertTrue("Error: AppProvider not registered at " + mContext.getPackageName(),
                    false);
        }
    }

//    /*
//        This test doesn't touch the database.  It verifies that the ContentProvider returns
//        the correct type for each type of URI that it can handle.
//
//     */
//    public void testGetType() {
//        // content://com.example.android.sunshine.app/weather/
//        String type = mContext.getContentResolver().getType(FuelSubtypeColumns.CONTENT_URI);
//        // vnd.android.cursor.dir/com.example.android.sunshine.app/weather
//        assertEquals("Error: the FuelSubtypeEntry CONTENT_URI should return FuelSubtypeColumns.CONTENT_TYPE",
//                WeatherEntry.CONTENT_TYPE, type);
//
//        String testLocation = "94074";
//        // content://com.example.android.sunshine.app/weather/94074
//        type = mContext.getContentResolver().getType(
//                WeatherEntry.buildWeatherLocation(testLocation));
//        // vnd.android.cursor.dir/com.example.android.sunshine.app/weather
//        assertEquals("Error: the WeatherEntry CONTENT_URI with location should return WeatherEntry.CONTENT_TYPE",
//                WeatherEntry.CONTENT_TYPE, type);
//
//        long testDate = 1419120000L; // December 21st, 2014
//        // content://com.example.android.sunshine.app/weather/94074/20140612
//        type = mContext.getContentResolver().getType(
//                WeatherEntry.buildWeatherLocationWithDate(testLocation, testDate));
//        // vnd.android.cursor.item/com.example.android.sunshine.app/weather/1419120000
//        assertEquals("Error: the WeatherEntry CONTENT_URI with location and date should return WeatherEntry.CONTENT_ITEM_TYPE",
//                WeatherEntry.CONTENT_ITEM_TYPE, type);
//
//        // content://com.example.android.sunshine.app/location/
//        type = mContext.getContentResolver().getType(LocationEntry.CONTENT_URI);
//        // vnd.android.cursor.dir/com.example.android.sunshine.app/location
//        assertEquals("Error: the LocationEntry CONTENT_URI should return LocationEntry.CONTENT_TYPE",
//                LocationEntry.CONTENT_TYPE, type);
//    }


    /*
    This test uses the database directly to insert and then uses the ContentProvider to
    read out the data.
 */
    public void testBasicWeatherQuery() {
        // insert our test records into the database
//        WeatherDbHelper dbHelper = new WeatherDbHelper(mContext);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//
//        ContentValues testValues = TestUtilities.createNorthPoleLocationValues();
//        long locationRowId = TestUtilities.insertNorthPoleLocationValues(mContext);

        //Insert values for FuelSubtype
        final String FUEL_SUBTYPE_NAME = "normal";
        FuelSubtypeContentValues values = new FuelSubtypeContentValues();
        values.putFuelSubtypeName(FUEL_SUBTYPE_NAME);
        mContext.getContentResolver().insert(FuelSubtypeColumns.CONTENT_URI, values.values());

//        FuelTypeContentValues fuelValues = new FuelTypeContentValues();
//        fuelValues.putFuelTypeName("Diesel");
//        mContext.getContentResolver().insert(FuelTypeColumns.CONTENT_URI,fuelValues.values());


        FuelSubtypeSelection where = new FuelSubtypeSelection();
        where.fuelSubtypeName(FUEL_SUBTYPE_NAME);
        Cursor c = mContext.getContentResolver().query(FuelSubtypeColumns.CONTENT_URI, null,
                where.sel(), where.args(), null);


        FuelSubtypeCursor fuelSubtype = new FuelSubtypeCursor(c);
        String fuelSubtypeName = fuelSubtype.getFuelSubtypeName();



//        ContentValues weatherValues = TestUtilities.createWeatherValues(locationRowId);
//
//        long weatherRowId = db.insert(WeatherEntry.TABLE_NAME, null, weatherValues);
//        assertTrue("Unable to Insert WeatherEntry into the Database", weatherRowId != -1);
//
//        db.close();

//        // Test the basic content provider query
//        Cursor weatherCursor = mContext.getContentResolver().query(
//                WeatherEntry.CONTENT_URI,
//                null,
//                null,
//                null,
//                null
//        );
//
//        // Make sure we get the correct cursor out of the database
//        TestUtilities.validateCursor("testBasicWeatherQuery", weatherCursor, weatherValues);
    }


}
