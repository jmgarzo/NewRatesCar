package com.jmgarzo.newratescar.provider.toll;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code toll} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class TollContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return TollColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable TollSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable TollSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public TollContentValues putVehicleId(long value) {
        mContentValues.put(TollColumns.VEHICLE_ID, value);
        return this;
    }


    public TollContentValues putTollDate(@NonNull Date value) {
        if (value == null) throw new IllegalArgumentException("tollDate must not be null");
        mContentValues.put(TollColumns.TOLL_DATE, value.getTime());
        return this;
    }


    public TollContentValues putTollDate(long value) {
        mContentValues.put(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollContentValues putTollPrice(double value) {
        mContentValues.put(TollColumns.TOLL_PRICE, value);
        return this;
    }


    public TollContentValues putTollName(@Nullable String value) {
        mContentValues.put(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollContentValues putTollNameNull() {
        mContentValues.putNull(TollColumns.TOLL_NAME);
        return this;
    }

    public TollContentValues putTollRoad(@Nullable String value) {
        mContentValues.put(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollContentValues putTollRoadNull() {
        mContentValues.putNull(TollColumns.TOLL_ROAD);
        return this;
    }

    public TollContentValues putTollDirection(@Nullable String value) {
        mContentValues.put(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollContentValues putTollDirectionNull() {
        mContentValues.putNull(TollColumns.TOLL_DIRECTION);
        return this;
    }

    public TollContentValues putTollLocation(@Nullable String value) {
        mContentValues.put(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollContentValues putTollLocationNull() {
        mContentValues.putNull(TollColumns.TOLL_LOCATION);
        return this;
    }

    public TollContentValues putTollAdditionalInformation(@Nullable String value) {
        mContentValues.put(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollContentValues putTollAdditionalInformationNull() {
        mContentValues.putNull(TollColumns.TOLL_ADDITIONAL_INFORMATION);
        return this;
    }
}
