package com.jmgarzo.newratescar.provider.vehicle;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicle
 */
public interface VehicleModel extends BaseModel {

    /**
     * Vehicle name
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleName();

    /**
     * Get the {@code vehicle_class} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getVehicleClass();

    /**
     * Get the {@code fuel_type} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getFuelType();

    /**
     * Get the {@code make} value.
     * Can be {@code null}.
     */
    @Nullable
    Long getMake();

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
