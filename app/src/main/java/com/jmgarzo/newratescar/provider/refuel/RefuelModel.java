package com.jmgarzo.newratescar.provider.refuel;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * refuel
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface RefuelModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code vehicle_id} value.
     */
    long getVehicleId();

    /**
     * Get the {@code refuel_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Date getRefuelDate();

    /**
     * Get the {@code refuel_fuel_type} value.
     */
    long getRefuelFuelType();

    /**
     * Get the {@code refuel_fuel_subtype} value.
     */
    long getRefuelFuelSubtype();

    /**
     * Get the {@code refuel_mileage} value.
     */
    int getRefuelMileage();

    /**
     * Get the {@code refuel_trip_odometer} value.
     */
    int getRefuelTripOdometer();

    /**
     * Get the {@code refuel_litres} value.
     */
    float getRefuelLitres();

    /**
     * Get the {@code refuel_gas_price} value.
     */
    float getRefuelGasPrice();

    /**
     * Get the {@code refuel_total_price} value.
     */
    float getRefuelTotalPrice();

    /**
     * Get the {@code is_full} value.
     */
    boolean getIsFull();

    /**
     * Get the {@code is_trailer} value.
     */
    boolean getIsTrailer();

    /**
     * Get the {@code is_roof_rack} value.
     */
    boolean getIsRoofRack();

    /**
     * Get the {@code route_type} value.
     */
    int getRouteType();

    /**
     * Get the {@code driving_style} value.
     */
    int getDrivingStyle();

    /**
     * Get the {@code average_speed} value.
     * Can be {@code null}.
     */
    @Nullable
    Float getAverageSpeed();

    /**
     * Get the {@code average_consumption} value.
     */
    float getAverageConsumption();

    /**
     * Get the {@code payment_type} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPaymentType();

    /**
     * Get the {@code gas_station} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGasStation();

    /**
     * Get the {@code refuel_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRefuelAdditionalInformation();
}
