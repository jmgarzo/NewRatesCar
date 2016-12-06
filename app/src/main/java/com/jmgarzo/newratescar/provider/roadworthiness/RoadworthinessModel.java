package com.jmgarzo.newratescar.provider.roadworthiness;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * roadworthiness
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface RoadworthinessModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code vehicle_id} value.
     */
    long getVehicleId();

    /**
     * Get the {@code roadworthiness_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Date getRoadworthinessDate();

    /**
     * Get the {@code roadworthiness_mileage} value.
     */
    int getRoadworthinessMileage();

    /**
     * Get the {@code roadworthiness_price} value.
     */
    double getRoadworthinessPrice();

    /**
     * Get the {@code roadworthiness_result} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRoadworthinessResult();

    /**
     * Get the {@code roadworthiness_next_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    Date getRoadworthinessNextDate();

    /**
     * Get the {@code roadworthiness_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRoadworthinessAdditionalInformation();
}
