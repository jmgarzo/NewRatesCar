package com.jmgarzo.newratescar.provider.fuelsubtype;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel Subtype
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface FuelSubtypeModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    String getFuelSubtypeName();
}
