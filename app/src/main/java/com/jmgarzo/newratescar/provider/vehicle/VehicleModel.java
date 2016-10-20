package com.jmgarzo.newratescar.provider.vehicle;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicles
 */
public interface VehicleModel extends BaseModel {

    /**
     * Vehicles name
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleName();

    /**
     * Get the {@code vehicle_class} value.
     */
    long getVehicleClass();

    /**
     * Get the {@code fuel_type} value.
     */
    long getFuelType();

    /**
     * Get the {@code make} value.
     */
    long getMake();

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    String getModel();

    /**
     * Get the {@code mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMileage();

    /**
     * Get the {@code additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAdditionalInformation();
}
