package com.jmgarzo.newratescar;

import android.database.Cursor;
import android.test.AndroidTestCase;

import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeContentValues;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeCursor;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeSelection;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeContentValues;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeCursor;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeSelection;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.make.MakeContentValues;
import com.jmgarzo.newratescar.provider.make.MakeCursor;
import com.jmgarzo.newratescar.provider.make.MakeSelection;
import com.jmgarzo.newratescar.provider.vehicle.VehicleColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassContentValues;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;

/**
 * Created by jmgarzo on 20/09/16.
 */

public class TestProvider extends AndroidTestCase {

    public static final String LOG_TAG = TestProvider.class.getSimpleName();

    private static final String TEST_FUEL_SUBTYPE_NAME = "Normal";
    private static final String TEST_FUEL_TYPE_NAME = "Gasolina";
    private static final String TEST_MAKE_NAME = "Renault";
    private static final String TEST_VEHICLE_CLASS_NAME = "Turismo";




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
        deleteAllRecordsFromProvider();
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        deleteAllRecords();
    }



    public void testBasicFuelSubtype() {


        //Insert

        FuelSubtypeContentValues values = new FuelSubtypeContentValues();
        values.putFuelSubtypeName(TEST_FUEL_SUBTYPE_NAME);
        getContext().getContentResolver().insert(FuelSubtypeColumns.CONTENT_URI,values.values());


        FuelSubtypeSelection where = new FuelSubtypeSelection();
        where.fuelSubtypeName(TEST_FUEL_SUBTYPE_NAME);
        FuelSubtypeCursor fuelSubtypeCursor = where.query(getContext().getContentResolver());
        fuelSubtypeCursor.moveToNext();
        String fuelSubtypeName = fuelSubtypeCursor.getFuelSubtypeName();

        assertEquals(TEST_FUEL_SUBTYPE_NAME,fuelSubtypeName);
    }


    public void testBasicFuelType() {

        FuelSubtypeContentValues subtypeValues = new FuelSubtypeContentValues();
        subtypeValues.putFuelSubtypeName(TEST_FUEL_SUBTYPE_NAME);
        getContext().getContentResolver().insert(FuelSubtypeColumns.CONTENT_URI,subtypeValues.values());

        FuelSubtypeSelection whereFuelSubtype = new FuelSubtypeSelection();
        whereFuelSubtype.fuelSubtypeName(TEST_FUEL_SUBTYPE_NAME);
        FuelSubtypeCursor fuelSubtypeCursor = whereFuelSubtype.query(getContext().getContentResolver());
        fuelSubtypeCursor.moveToNext();
        long fuelSubtypeId = fuelSubtypeCursor.getId();

        //Insert

        FuelTypeContentValues values = new FuelTypeContentValues();
        values.putFuelTypeName(TEST_FUEL_TYPE_NAME).putFuelSubtype(fuelSubtypeId);
        getContext().getContentResolver().insert(FuelTypeColumns.CONTENT_URI, values.values());

        FuelTypeSelection whereFuelType = new FuelTypeSelection();
        whereFuelType.fuelTypeName(TEST_FUEL_TYPE_NAME);
        FuelTypeCursor fuelTypeCursor = whereFuelType.query(getContext().getContentResolver());
        fuelTypeCursor.moveToNext();
        String fuelSubtypeName = fuelTypeCursor.getFuelSubtypeFuelSubtypeName();
        String fuelTypeName = fuelTypeCursor.getFuelTypeName();

        assertEquals(TEST_FUEL_SUBTYPE_NAME, fuelSubtypeName);
        assertEquals(TEST_FUEL_TYPE_NAME,fuelTypeName);


    }

    public void testBasicMake(){

        MakeContentValues values = new MakeContentValues();
        values.putMakeName(TEST_MAKE_NAME);
        getContext().getContentResolver().insert(MakeColumns.CONTENT_URI,values.values());

        MakeSelection makeSelection = new MakeSelection();
        makeSelection.makeName(TEST_MAKE_NAME);
        MakeCursor makeCursor = makeSelection.query(getContext().getContentResolver());
        makeCursor.moveToNext();
        String makeName = makeCursor.getMakeName();

        assertEquals(TEST_MAKE_NAME,makeName);

    }

    public void testBasicVehicleClass(){
        VehicleClassContentValues values = new VehicleClassContentValues();
        values.putVehicleClassName(TEST_VEHICLE_CLASS_NAME);
        getContext().getContentResolver().insert(VehicleClassColumns.CONTENT_URI,values.values());

        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        vehicleClassSelection.vehicleClassName(TEST_VEHICLE_CLASS_NAME);
        VehicleClassCursor cursor = vehicleClassSelection.query(getContext().getContentResolver());
        cursor.moveToNext();
        String vehicleClassName = cursor.getVehicleClassName();

        assertEquals(TEST_VEHICLE_CLASS_NAME,vehicleClassName);
    }


}
