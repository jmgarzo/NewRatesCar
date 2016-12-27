package com.jmgarzo.newratescar.provider.maintenance;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code maintenance} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class MaintenanceContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MaintenanceColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MaintenanceSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MaintenanceSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MaintenanceContentValues putVehicleId(long value) {
        mContentValues.put(MaintenanceColumns.VEHICLE_ID, value);
        return this;
    }


    public MaintenanceContentValues putMaintenanceTitle(@Nullable String value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceContentValues putMaintenanceTitleNull() {
        mContentValues.putNull(MaintenanceColumns.MAINTENANCE_TITLE);
        return this;
    }

    public MaintenanceContentValues putMaintenanceDate(@NonNull Date value) {
        if (value == null) throw new IllegalArgumentException("maintenanceDate must not be null");
        mContentValues.put(MaintenanceColumns.MAINTENANCE_DATE, value.getTime());
        return this;
    }


    public MaintenanceContentValues putMaintenanceDate(long value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceContentValues putMaintenanceMileage(int value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_MILEAGE, value);
        return this;
    }


    public MaintenanceContentValues putMaintenanceType(int value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_TYPE, value);
        return this;
    }


    public MaintenanceContentValues putMaintenancePrice(double value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_PRICE, value);
        return this;
    }


    public MaintenanceContentValues putMaintenanceDescription(@Nullable String value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceContentValues putMaintenanceDescriptionNull() {
        mContentValues.putNull(MaintenanceColumns.MAINTENANCE_DESCRIPTION);
        return this;
    }

    public MaintenanceContentValues putIsRegular(boolean value) {
        mContentValues.put(MaintenanceColumns.IS_REGULAR, value);
        return this;
    }


    public MaintenanceContentValues putMaintenancePeriodicity(@Nullable Integer value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceContentValues putMaintenancePeriodicityNull() {
        mContentValues.putNull(MaintenanceColumns.MAINTENANCE_PERIODICITY);
        return this;
    }

    public MaintenanceContentValues putMaintenanceGarage(@Nullable String value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceContentValues putMaintenanceGarageNull() {
        mContentValues.putNull(MaintenanceColumns.MAINTENANCE_GARAGE);
        return this;
    }

    public MaintenanceContentValues putMaintenanceAdditionalInformation(@Nullable String value) {
        mContentValues.put(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceContentValues putMaintenanceAdditionalInformationNull() {
        mContentValues.putNull(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION);
        return this;
    }
}
