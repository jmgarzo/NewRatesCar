package com.jmgarzo.newratescar.provider.vehicleclass;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;

/**
 * Selection for the {@code vehicle_class} table.
 */
public class VehicleClassSelection extends AbstractSelection<VehicleClassSelection> {
    @Override
    protected Uri baseUri() {
        return VehicleClassColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleClassCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleClassCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleClassCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public VehicleClassCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleClassCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleClassCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleClassCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public VehicleClassCursor query(Context context) {
        return query(context, null);
    }


    public VehicleClassSelection id(long... value) {
        addEquals("vehicle_class." + VehicleClassColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleClassSelection idNot(long... value) {
        addNotEquals("vehicle_class." + VehicleClassColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleClassSelection orderById(boolean desc) {
        orderBy("vehicle_class." + VehicleClassColumns._ID, desc);
        return this;
    }

    public VehicleClassSelection orderById() {
        return orderById(false);
    }

    public VehicleClassSelection vehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection vehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection vehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection vehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection vehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection vehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassSelection orderByVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public VehicleClassSelection orderByVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }
}
