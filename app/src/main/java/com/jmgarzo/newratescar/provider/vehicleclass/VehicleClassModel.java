package com.jmgarzo.newratescar.provider.vehicleclass;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicle class
 */
public interface VehicleClassModel extends BaseModel {

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    String getVehicleClassName();
}
