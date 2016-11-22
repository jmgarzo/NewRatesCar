package com.jmgarzo.newratescar;

import android.content.ContentValues;
import android.content.Context;
import android.test.AndroidTestCase;

import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeContentValues;

/**
 * Created by jmgarzo on 17/10/16.
 */

public class TestUtilities extends AndroidTestCase {

    public static final String TEST_FUEL_SUBTYPE_NAME = "normal";


    static ContentValues createFuelSubTypeValues (){

        ContentValues testValues = new ContentValues();
        testValues.put(FuelSubtypeColumns.TABLE_NAME,TEST_FUEL_SUBTYPE_NAME);
        return testValues;
    }

    static void insertFuelSubtype (Context context){


        FuelSubtypeContentValues values = new FuelSubtypeContentValues();
        values.putFuelSubtypeName(TEST_FUEL_SUBTYPE_NAME);
        context.getContentResolver().insert(FuelSubtypeColumns.CONTENT_URI,values.values());
    }


}
