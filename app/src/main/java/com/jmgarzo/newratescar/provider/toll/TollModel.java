package com.jmgarzo.newratescar.provider.toll;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * toll
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface TollModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code vehicle_id} value.
     */
    long getVehicleId();

    /**
     * Get the {@code toll_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Date getTollDate();

    /**
     * Get the {@code toll_price} value.
     */
    double getTollPrice();

    /**
     * Get the {@code toll_name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTollName();

    /**
     * Get the {@code toll_road} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTollRoad();

    /**
     * Get the {@code toll_direction} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTollDirection();

    /**
     * Get the {@code toll_location} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTollLocation();

    /**
     * Get the {@code toll_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTollAdditionalInformation();
}
