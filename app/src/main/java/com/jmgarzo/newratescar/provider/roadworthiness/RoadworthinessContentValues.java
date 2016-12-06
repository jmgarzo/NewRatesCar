package com.jmgarzo.newratescar.provider.roadworthiness;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code roadworthiness} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class RoadworthinessContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return RoadworthinessColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable RoadworthinessSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable RoadworthinessSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public RoadworthinessContentValues putVehicleId(long value) {
        mContentValues.put(RoadworthinessColumns.VEHICLE_ID, value);
        return this;
    }


    public RoadworthinessContentValues putRoadworthinessDate(@NonNull Date value) {
        if (value == null) throw new IllegalArgumentException("roadworthinessDate must not be null");
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_DATE, value.getTime());
        return this;
    }


    public RoadworthinessContentValues putRoadworthinessDate(long value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessContentValues putRoadworthinessMileage(int value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, value);
        return this;
    }


    public RoadworthinessContentValues putRoadworthinessPrice(double value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_PRICE, value);
        return this;
    }


    public RoadworthinessContentValues putRoadworthinessResult(@Nullable String value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessContentValues putRoadworthinessResultNull() {
        mContentValues.putNull(RoadworthinessColumns.ROADWORTHINESS_RESULT);
        return this;
    }

    public RoadworthinessContentValues putRoadworthinessNextDate(@NonNull Date value) {
        if (value == null) throw new IllegalArgumentException("roadworthinessNextDate must not be null");
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value.getTime());
        return this;
    }


    public RoadworthinessContentValues putRoadworthinessNextDate(long value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessContentValues putRoadworthinessAdditionalInformation(@Nullable String value) {
        mContentValues.put(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessContentValues putRoadworthinessAdditionalInformationNull() {
        mContentValues.putNull(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION);
        return this;
    }
}
