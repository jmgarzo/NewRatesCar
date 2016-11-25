package com.jmgarzo.newratescar.provider.vehicleclass;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code vehicle_class} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class VehicleClassContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return VehicleClassColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable VehicleClassSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable VehicleClassSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Vehicle class name
     */
    public VehicleClassContentValues putVehicleClassName(@Nullable String value) {
        mContentValues.put(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleClassContentValues putVehicleClassNameNull() {
        mContentValues.putNull(VehicleClassColumns.VEHICLE_CLASS_NAME);
        return this;
    }
}
