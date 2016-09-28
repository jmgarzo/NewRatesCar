package com.jmgarzo.newratescar.provider.fueltype;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;
import com.jmgarzo.newratescar.provider.fuelsubtype.*;

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
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelTypeName() {
        String res = getStringOrNull(FuelTypeColumns.FUEL_TYPE_NAME);
        return res;
    }

    /**
     * Get the {@code fuel_subtype} value.
     */
    public long getFuelSubtype() {
        Long res = getLongOrNull(FuelTypeColumns.FUEL_SUBTYPE);
        if (res == null)
            throw new NullPointerException("The value of 'fuel_subtype' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Subtype
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelSubtypeFuelSubtypeName() {
        String res = getStringOrNull(FuelSubtypeColumns.FUEL_SUBTYPE_NAME);
        return res;
    }
}
