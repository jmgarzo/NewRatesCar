package com.jmgarzo.newratescar.provider.refuel;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code refuel} table.
 */
public class RefuelContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return RefuelColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable RefuelSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable RefuelSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public RefuelContentValues putVehicleId(long value) {
        mContentValues.put(RefuelColumns.VEHICLE_ID, value);
        return this;
    }


    public RefuelContentValues putRefuelDate(@NonNull Date value) {
        if (value == null) throw new IllegalArgumentException("refuelDate must not be null");
        mContentValues.put(RefuelColumns.REFUEL_DATE, value.getTime());
        return this;
    }


    public RefuelContentValues putRefuelDate(long value) {
        mContentValues.put(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelContentValues putRefuelFuelType(long value) {
        mContentValues.put(RefuelColumns.REFUEL_FUEL_TYPE, value);
        return this;
    }


    public RefuelContentValues putRefuelFuelSubtype(@Nullable Long value) {
        mContentValues.put(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelContentValues putRefuelFuelSubtypeNull() {
        mContentValues.putNull(RefuelColumns.REFUEL_FUEL_SUBTYPE);
        return this;
    }

    public RefuelContentValues putRefuelMileage(int value) {
        mContentValues.put(RefuelColumns.REFUEL_MILEAGE, value);
        return this;
    }


    public RefuelContentValues putRefuelTripOdometer(int value) {
        mContentValues.put(RefuelColumns.REFUEL_TRIP_ODOMETER, value);
        return this;
    }


    public RefuelContentValues putRefuelLitres(float value) {
        mContentValues.put(RefuelColumns.REFUEL_LITRES, value);
        return this;
    }


    public RefuelContentValues putRefuelGasPrice(float value) {
        mContentValues.put(RefuelColumns.REFUEL_GAS_PRICE, value);
        return this;
    }


    public RefuelContentValues putRefuelTotalPrice(float value) {
        mContentValues.put(RefuelColumns.REFUEL_TOTAL_PRICE, value);
        return this;
    }


    public RefuelContentValues putIsFull(boolean value) {
        mContentValues.put(RefuelColumns.IS_FULL, value);
        return this;
    }


    public RefuelContentValues putIsTrailer(boolean value) {
        mContentValues.put(RefuelColumns.IS_TRAILER, value);
        return this;
    }


    public RefuelContentValues putIsRoofRack(boolean value) {
        mContentValues.put(RefuelColumns.IS_ROOF_RACK, value);
        return this;
    }


    public RefuelContentValues putRouteType(int value) {
        mContentValues.put(RefuelColumns.ROUTE_TYPE, value);
        return this;
    }


    public RefuelContentValues putDrivingStyle(int value) {
        mContentValues.put(RefuelColumns.DRIVING_STYLE, value);
        return this;
    }


    public RefuelContentValues putAverageSpeed(@Nullable Float value) {
        mContentValues.put(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelContentValues putAverageSpeedNull() {
        mContentValues.putNull(RefuelColumns.AVERAGE_SPEED);
        return this;
    }

    public RefuelContentValues putAverageConsumption(float value) {
        mContentValues.put(RefuelColumns.AVERAGE_CONSUMPTION, value);
        return this;
    }


    public RefuelContentValues putPaymentType(@Nullable String value) {
        mContentValues.put(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelContentValues putPaymentTypeNull() {
        mContentValues.putNull(RefuelColumns.PAYMENT_TYPE);
        return this;
    }

    public RefuelContentValues putGasStation(@Nullable String value) {
        mContentValues.put(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelContentValues putGasStationNull() {
        mContentValues.putNull(RefuelColumns.GAS_STATION);
        return this;
    }

    public RefuelContentValues putRefuelAdditionalInformation(@Nullable String value) {
        mContentValues.put(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelContentValues putRefuelAdditionalInformationNull() {
        mContentValues.putNull(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION);
        return this;
    }
}
