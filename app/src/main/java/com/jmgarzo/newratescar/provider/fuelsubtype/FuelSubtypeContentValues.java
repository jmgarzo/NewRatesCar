package com.jmgarzo.newratescar.provider.fuelsubtype;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code fuel_subtype} table.
 */
public class FuelSubtypeContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return FuelSubtypeColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable FuelSubtypeSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable FuelSubtypeSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Fuel Subtype
     */
    public FuelSubtypeContentValues putFuelSubtypeName(@Nullable String value) {
        mContentValues.put(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public FuelSubtypeContentValues putFuelSubtypeNameNull() {
        mContentValues.putNull(FuelSubtypeColumns.FUEL_SUBTYPE_NAME);
        return this;
    }
}
