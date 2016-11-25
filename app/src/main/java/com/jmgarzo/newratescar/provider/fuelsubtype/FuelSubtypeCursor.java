package com.jmgarzo.newratescar.provider.fuelsubtype;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code fuel_subtype} table.
 */
public class FuelSubtypeCursor extends AbstractCursor implements FuelSubtypeModel {
    public FuelSubtypeCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(FuelSubtypeColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Subtype
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelSubtypeName() {
        String res = getStringOrNull(FuelSubtypeColumns.FUEL_SUBTYPE_NAME);
        return res;
    }
}
