package com.jmgarzo.newratescar.provider.fueltype;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code fuel_type} table.
 */
public class FuelTypeCursor extends AbstractCursor implements FuelTypeModel {
    public FuelTypeCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(FuelTypeColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Type Name
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelTypeName() {
        String res = getStringOrNull(FuelTypeColumns.FUEL_TYPE_NAME);
        return res;
    }
}
