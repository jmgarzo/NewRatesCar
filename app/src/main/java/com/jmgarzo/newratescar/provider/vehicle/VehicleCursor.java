package com.jmgarzo.newratescar.provider.vehicle;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.*;
import com.jmgarzo.newratescar.provider.fueltype.*;
import com.jmgarzo.newratescar.provider.make.*;

/**
 * Cursor wrapper for the {@code vehicle} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class VehicleCursor extends AbstractCursor implements VehicleModel {
    public VehicleCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(VehicleColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vehicle name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVehicleName() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_NAME);
        return res;
    }

    /**
     * Get the {@code vehicle_class} value.
     */
    @Override
    public long getVehicleClass() {
        Long res = getLongOrNull(VehicleColumns.VEHICLE_CLASS);
        if (res == null)
            throw new NullPointerException("The value of 'vehicle_class' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleClassVehicleClassName() {
        String res = getStringOrNull(VehicleClassColumns.VEHICLE_CLASS_NAME);
        return res;
    }

    /**
     * Get the {@code vehicle_fuel_type} value.
     */
    @Override
    public long getVehicleFuelType() {
        Long res = getLongOrNull(VehicleColumns.VEHICLE_FUEL_TYPE);
        if (res == null)
            throw new NullPointerException("The value of 'vehicle_fuel_type' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Type Name
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelTypeFuelTypeName() {
        String res = getStringOrNull(FuelTypeColumns.FUEL_TYPE_NAME);
        return res;
    }

    /**
     * Get the {@code make} value.
     */
    @Override
    public long getMake() {
        Long res = getLongOrNull(VehicleColumns.MAKE);
        if (res == null)
            throw new NullPointerException("The value of 'make' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    public String getMakeMakeName() {
        String res = getStringOrNull(MakeColumns.MAKE_NAME);
        return res;
    }

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getModel() {
        String res = getStringOrNull(VehicleColumns.MODEL);
        return res;
    }

    /**
     * Get the {@code mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.MILEAGE);
        return res;
    }

    /**
     * Get the {@code additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdditionalInformation() {
        String res = getStringOrNull(VehicleColumns.ADDITIONAL_INFORMATION);
        return res;
    }
}
