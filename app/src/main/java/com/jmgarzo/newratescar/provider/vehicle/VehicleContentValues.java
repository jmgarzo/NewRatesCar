package com.jmgarzo.newratescar.provider.vehicle;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code vehicle} table.
 */
public class VehicleContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return VehicleColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable VehicleSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable VehicleSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Vehicle name
     */
    public VehicleContentValues putVehicleName(@Nullable String value) {
        mContentValues.put(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleContentValues putVehicleNameNull() {
        mContentValues.putNull(VehicleColumns.VEHICLE_NAME);
        return this;
    }

    public VehicleContentValues putVehicleClass(long value) {
        mContentValues.put(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }


    public VehicleContentValues putVehicleFuelType(long value) {
        mContentValues.put(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }


    public VehicleContentValues putMake(long value) {
        mContentValues.put(VehicleColumns.MAKE, value);
        return this;
    }


    public VehicleContentValues putModel(@Nullable String value) {
        mContentValues.put(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleContentValues putModelNull() {
        mContentValues.putNull(VehicleColumns.MODEL);
        return this;
    }

    public VehicleContentValues putMileage(@Nullable Integer value) {
        mContentValues.put(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleContentValues putMileageNull() {
        mContentValues.putNull(VehicleColumns.MILEAGE);
        return this;
    }

    public VehicleContentValues putAdditionalInformation(@Nullable String value) {
        mContentValues.put(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleContentValues putAdditionalInformationNull() {
        mContentValues.putNull(VehicleColumns.ADDITIONAL_INFORMATION);
        return this;
    }
}
