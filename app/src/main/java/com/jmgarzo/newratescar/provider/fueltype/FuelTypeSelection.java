package com.jmgarzo.newratescar.provider.fueltype;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;

/**
 * Selection for the {@code fuel_type} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class FuelTypeSelection extends AbstractSelection<FuelTypeSelection> {
    @Override
    protected Uri baseUri() {
        return FuelTypeColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FuelTypeCursor} object, which is positioned before the first entry, or null.
     */
    public FuelTypeCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FuelTypeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public FuelTypeCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FuelTypeCursor} object, which is positioned before the first entry, or null.
     */
    public FuelTypeCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FuelTypeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public FuelTypeCursor query(Context context) {
        return query(context, null);
    }


    public FuelTypeSelection id(long... value) {
        addEquals("fuel_type." + FuelTypeColumns._ID, toObjectArray(value));
        return this;
    }

    public FuelTypeSelection idNot(long... value) {
        addNotEquals("fuel_type." + FuelTypeColumns._ID, toObjectArray(value));
        return this;
    }

    public FuelTypeSelection orderById(boolean desc) {
        orderBy("fuel_type." + FuelTypeColumns._ID, desc);
        return this;
    }

    public FuelTypeSelection orderById() {
        return orderById(false);
    }

    public FuelTypeSelection fuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection fuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection fuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection fuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection fuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection fuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeSelection orderByFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public FuelTypeSelection orderByFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }
}
