package com.jmgarzo.newratescar.provider.insurance;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * insurance
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface InsuranceModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code vehicle_id} value.
     */
    long getVehicleId();

    /**
     * Get the {@code insurance_company} value.
     * Can be {@code null}.
     */
    @Nullable
    String getInsuranceCompany();

    /**
     * Get the {@code insurance_price} value.
     */
    double getInsurancePrice();

    /**
     * Get the {@code policy_number} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPolicyNumber();

    /**
     * Get the {@code start_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getStartDate();

    /**
     * Get the {@code end_date} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getEndDate();

    /**
     * Get the {@code insurance_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    String getInsuranceAdditionalInformation();
}
