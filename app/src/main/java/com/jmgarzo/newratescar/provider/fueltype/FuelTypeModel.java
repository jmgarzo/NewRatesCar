package com.jmgarzo.newratescar.provider.fueltype;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel Type
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface FuelTypeModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Fuel Type Name
     * Can be {@code null}.
     */
    @Nullable
    String getFuelTypeName();
}
