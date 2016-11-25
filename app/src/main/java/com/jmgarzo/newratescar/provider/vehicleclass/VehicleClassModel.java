package com.jmgarzo.newratescar.provider.vehicleclass;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicle class
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface VehicleClassModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleClassName();
}
