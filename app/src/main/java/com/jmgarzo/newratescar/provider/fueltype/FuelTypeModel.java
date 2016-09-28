package com.jmgarzo.newratescar.provider.fueltype;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel subtype
 */
public interface FuelTypeModel extends BaseModel {

    /**
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    String getFuelTypeName();

    /**
     * Get the {@code fuel_subtype} value.
     */
    long getFuelSubtype();
}
