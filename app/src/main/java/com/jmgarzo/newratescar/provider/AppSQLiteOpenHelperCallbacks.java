package com.jmgarzo.newratescar.provider;

// @formatter:off

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import com.jmgarzo.newratescar.BuildConfig;
import com.jmgarzo.newratescar.R;
import com.jmgarzo.newratescar.object.MenuItem;
import com.jmgarzo.newratescar.provider.fuelsubtype.FuelSubtypeColumns;
import com.jmgarzo.newratescar.provider.fueltype.FuelTypeColumns;
import com.jmgarzo.newratescar.provider.make.MakeColumns;
import com.jmgarzo.newratescar.provider.menuitem.MenuItemColumns;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassColumns;

import java.util.ArrayList;

/**
 * Implement your custom database creation or upgrade code here.
 *
 * This file will not be overwritten if you re-run the content provider generator.
 */
public class AppSQLiteOpenHelperCallbacks {
    private static final String TAG = AppSQLiteOpenHelperCallbacks.class.getSimpleName();

    public void onOpen(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onOpen");
        // Insert your db open code here.
    }

    public void onPreCreate(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onPreCreate");
        // Insert your db creation code here. This is called before your tables are created.
    }

    public void onPostCreate(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onPostCreate");
        // Insert your db creation code here. This is called after your tables are created.
        addMenuItems(db,context);
        addVehicleClass(db,context);
        addMakes(db,context);
        addFuelType(db,context);
        addFuelSubType(db,context);

    }

    public void onUpgrade(final Context context, final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        if (BuildConfig.DEBUG) Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        // Insert your upgrading code here.
    }

    private void addFuelType(SQLiteDatabase db, Context context){
        ArrayList<String> fuelTypeList = new ArrayList<String>();
        fuelTypeList.add("");
        fuelTypeList.add(context.getString(R.string.fuel_type_petrol));
        fuelTypeList.add(context.getString(R.string.fuel_type_diesel));
        fuelTypeList.add(context.getString(R.string.fuel_type_electric));
        fuelTypeList.add(context.getString(R.string.fuel_type_hybrid));

        for (String fuelType : fuelTypeList){
            ContentValues values = new ContentValues();
            values.put(FuelTypeColumns.FUEL_TYPE_NAME,fuelType);

            db.insert(FuelTypeColumns.TABLE_NAME,null,values);
        }
    }

    private void addFuelSubType(SQLiteDatabase db, Context context){
        ArrayList<String> fuelSubtypeList = new ArrayList<String>();
        fuelSubtypeList.add("");
        fuelSubtypeList.add(context.getString(R.string.subfuel_type_regular));
        fuelSubtypeList.add(context.getString(R.string.subfuel_type_premium));

        for (String fuelSubtype : fuelSubtypeList){
            ContentValues values = new ContentValues();
            values.put(FuelSubtypeColumns.FUEL_SUBTYPE_NAME,fuelSubtype);

            db.insert(FuelSubtypeColumns.TABLE_NAME,null,values);
        }
    }

    private void addMakes(SQLiteDatabase db, Context context){
        ArrayList<String> makeList = new ArrayList<String>();
        makeList.add("");
        makeList.add(context.getString(R.string.make_alfa_romeo));
        makeList.add(context.getString(R.string.make_acura));
        makeList.add(context.getString(R.string.make_aston_martin));
        makeList.add(context.getString(R.string.make_audi));
        makeList.add(context.getString(R.string.make_bentley));
        makeList.add(context.getString(R.string.make_bmw));
        makeList.add(context.getString(R.string.make_bugatti));
        makeList.add(context.getString(R.string.make_buick));
        makeList.add(context.getString(R.string.make_cadillac));
        makeList.add(context.getString(R.string.make_chery));
        makeList.add(context.getString(R.string.make_chevrolet));
        makeList.add(context.getString(R.string.make_chrysler));
        makeList.add(context.getString(R.string.make_citroen));
        makeList.add(context.getString(R.string.make_dacia));
        makeList.add(context.getString(R.string.make_daewoo));
        makeList.add(context.getString(R.string.make_dodge));
        makeList.add(context.getString(R.string.make_ebro_logo));
        makeList.add(context.getString(R.string.make_ferrari));
        makeList.add(context.getString(R.string.make_fiat));
        makeList.add(context.getString(R.string.make_ford));
        makeList.add(context.getString(R.string.make_gaz));
        makeList.add(context.getString(R.string.make_holden));
        makeList.add(context.getString(R.string.make_honda));
        makeList.add(context.getString(R.string.make_hyundai));
        makeList.add(context.getString(R.string.make_infiniti));
        makeList.add(context.getString(R.string.make_jaguar));
        makeList.add(context.getString(R.string.make_jeep));
        makeList.add(context.getString(R.string.make_kia));
        makeList.add(context.getString(R.string.make_lada));
        makeList.add(context.getString(R.string.make_lamborghini));
        makeList.add(context.getString(R.string.make_lancia));
        makeList.add(context.getString(R.string.make_land_rover));
        makeList.add(context.getString(R.string.make_lexus));
        makeList.add(context.getString(R.string.make_lotus));
        makeList.add(context.getString(R.string.make_maserati));
        makeList.add(context.getString(R.string.make_maybach));
        makeList.add(context.getString(R.string.make_mazda));
        makeList.add(context.getString(R.string.make_mercedes));
        makeList.add(context.getString(R.string.make_mercury));
        makeList.add(context.getString(R.string.make_mini));
        makeList.add(context.getString(R.string.make_mitsubishi));
        makeList.add(context.getString(R.string.make_nissan));
        makeList.add(context.getString(R.string.make_opel));
        makeList.add(context.getString(R.string.make_pagani));
        makeList.add(context.getString(R.string.make_peugeot));
        makeList.add(context.getString(R.string.make_piaggio));
        makeList.add(context.getString(R.string.make_pontiac));
        makeList.add(context.getString(R.string.make_porshe));
        makeList.add(context.getString(R.string.make_renault));
        makeList.add(context.getString(R.string.make_rolls_royce));
        makeList.add(context.getString(R.string.make_rover));
        makeList.add(context.getString(R.string.make_saab));
        makeList.add(context.getString(R.string.make_scion));
        makeList.add(context.getString(R.string.make_seat));
        makeList.add(context.getString(R.string.make_skoda));
        makeList.add(context.getString(R.string.make_ssang_yong));
        makeList.add(context.getString(R.string.make_subaru));
        makeList.add(context.getString(R.string.make_suzuki));
        makeList.add(context.getString(R.string.make_toyota));
        makeList.add(context.getString(R.string.make_vauxhall));
        makeList.add(context.getString(R.string.make_volkswagen));
        makeList.add(context.getString(R.string.make_volvo));

        for(String make : makeList){
            ContentValues values = new ContentValues();
            values.put(MakeColumns.MAKE_NAME,make);

            db.insert(MakeColumns.TABLE_NAME,null,values);
        }

    }

    private void addVehicleClass(SQLiteDatabase db,Context context){
        ArrayList<String> vehicleClassList = new ArrayList<String>();
        vehicleClassList.add(context.getString(R.string.empty_class_db));
        vehicleClassList.add(context.getString(R.string.car_class_db));
        vehicleClassList.add(context.getString(R.string.van_class_db));
        vehicleClassList.add(context.getString(R.string.truck_class_db));
        vehicleClassList.add(context.getString(R.string.motorcycle_class_db));
        vehicleClassList.add(context.getString(R.string.quad_class_db));
        vehicleClassList.add(context.getString(R.string.tractor_class_db));
        vehicleClassList.add(context.getString(R.string.bike_class_db));
        vehicleClassList.add(context.getString(R.string.bus_class_db));

        for (String vehicleClass : vehicleClassList){
            ContentValues values = new ContentValues();
            values.put(VehicleClassColumns.VEHICLE_CLASS_NAME,vehicleClass);

            db.insert(VehicleClassColumns.TABLE_NAME,null,values);
        }




    }

    private void addMenuItems(SQLiteDatabase db,Context context){
        ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

        //TODO: Change strings to strings.xml
        menuItemList.add(new MenuItem(context.getString(R.string.vehicle_item_name), R.drawable.car04));
        menuItemList.add(new MenuItem(context.getString(R.string.refuel_item_name),R.drawable.refuel01));
        menuItemList.add(new MenuItem(context.getString(R.string.roadworthiness_item_name),R.drawable.refuel01));
        menuItemList.add(new MenuItem(context.getString(R.string.toll_item_name),R.drawable.refuel01));
        menuItemList.add(new MenuItem(context.getString(R.string.insurance_item_name),R.drawable.refuel01));



        for (MenuItem menu : menuItemList){
            ContentValues values = new ContentValues();
            values.put(MenuItemColumns.MENU_ITEM_NAME,menu.getName());
            values.put(MenuItemColumns.MENU_ITEM_IMAGE,menu.getImage());

            db.insert(MenuItemColumns.TABLE_NAME,null,values);
        }

    }
}
