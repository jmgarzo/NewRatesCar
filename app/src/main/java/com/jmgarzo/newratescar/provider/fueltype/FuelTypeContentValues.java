package com.jmgarzo.newratescar.provider.fueltype;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code fuel_type} table.
 */
public class FuelTypeContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return FuelTypeColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable FuelTypeSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable FuelTypeSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Fuel Type Name
     */
    public FuelTypeContentValues putFuelTypeName(@Nullable String value) {
        mContentValues.put(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public FuelTypeContentValues putFuelTypeNameNull() {
        mContentValues.putNull(FuelTypeColumns.FUEL_TYPE_NAME);
        return this;
    }
}
