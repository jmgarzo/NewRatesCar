package com.jmgarzo.newratescar.provider.fuelsubtype;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel Subtype
 */
public interface FuelSubtypeModel extends BaseModel {

    /**
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    String getFuelSubtypeName();
}
