package com.jmgarzo.newratescar.provider.vehicleclass;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code vehicle_class} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class VehicleClassCursor extends AbstractCursor implements VehicleClassModel {
    public VehicleClassCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(VehicleClassColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVehicleClassName() {
        String res = getStringOrNull(VehicleClassColumns.VEHICLE_CLASS_NAME);
        return res;
    }
}
