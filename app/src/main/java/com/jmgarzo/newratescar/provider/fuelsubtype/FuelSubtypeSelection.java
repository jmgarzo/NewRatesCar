package com.jmgarzo.newratescar.provider.fuelsubtype;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;

/**
 * Selection for the {@code fuel_subtype} table.
 */
public class FuelSubtypeSelection extends AbstractSelection<FuelSubtypeSelection> {
    @Override
    protected Uri baseUri() {
        return FuelSubtypeColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FuelSubtypeCursor} object, which is positioned before the first entry, or null.
     */
    public FuelSubtypeCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FuelSubtypeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public FuelSubtypeCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code FuelSubtypeCursor} object, which is positioned before the first entry, or null.
     */
    public FuelSubtypeCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new FuelSubtypeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public FuelSubtypeCursor query(Context context) {
        return query(context, null);
    }


    public FuelSubtypeSelection id(long... value) {
        addEquals("fuel_subtype." + FuelSubtypeColumns._ID, toObjectArray(value));
        return this;
    }

    public FuelSubtypeSelection idNot(long... value) {
        addNotEquals("fuel_subtype." + FuelSubtypeColumns._ID, toObjectArray(value));
        return this;
    }

    public FuelSubtypeSelection orderById(boolean desc) {
        orderBy("fuel_subtype." + FuelSubtypeColumns._ID, desc);
        return this;
    }

    public FuelSubtypeSelection orderById() {
        return orderById(false);
    }

    public FuelSubtypeSelection fuelSubtypeName(String... value) {
        addEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection fuelSubtypeNameNot(String... value) {
        addNotEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection fuelSubtypeNameLike(String... value) {
        addLike(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection fuelSubtypeNameContains(String... value) {
        addContains(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection fuelSubtypeNameStartsWith(String... value) {
        addStartsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection fuelSubtypeNameEndsWith(String... value) {
        addEndsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeSelection orderByFuelSubtypeName(boolean desc) {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, desc);
        return this;
    }

    public FuelSubtypeSelection orderByFuelSubtypeName() {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, false);
        return this;
    }
}
