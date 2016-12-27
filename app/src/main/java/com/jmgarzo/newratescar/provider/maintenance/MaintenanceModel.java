package com.jmgarzo.newratescar.provider.maintenance;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * maintenance
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface MaintenanceModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code vehicle_id} value.
     */
    long getVehicleId();

    /**
     * Get the {@code maintenance_title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMaintenanceTitle();

    /**
     * Get the {@code maintenance_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Date getMaintenanceDate();

    /**
     * Get the {@code maintenance_mileage} value.
     */
    int getMaintenanceMileage();

    /**
     * Get the {@code maintenance_type} value.
     */
    int getMaintenanceType();

    /**
     * Get the {@code maintenance_price} value.
     */
    double getMaintenancePrice();

    /**
     * Get the {@code maintenance_description} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMaintenanceDescription();

    /**
     * Get the {@code is_regular} value.
     */
    boolean getIsRegular();

    /**
     * Get the {@code maintenance_periodicity} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMaintenancePeriodicity();

    /**
     * Get the {@code maintenance_garage} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMaintenanceGarage();

    /**
     * Get the {@code maintenance_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMaintenanceAdditionalInformation();
}
