package com.jmgarzo.newratescar.provider.vehicleclass;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicles class
 */
public interface VehicleClassModel extends BaseModel {

    /**
     * Vehicles class name
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleClassName();
}
