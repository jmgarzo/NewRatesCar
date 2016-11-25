package com.jmgarzo.newratescar.provider.vehicleclass;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicle class
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class VehicleClassBean implements VehicleClassModel {
    private long mId;
    private String mVehicleClassName;

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Primary key.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVehicleClassName() {
        return mVehicleClassName;
    }

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    public void setVehicleClassName(@Nullable String vehicleClassName) {
        mVehicleClassName = vehicleClassName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleClassBean bean = (VehicleClassBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new VehicleClassBean with specified values.
     */
    @NonNull
    public static VehicleClassBean newInstance(long id, @Nullable String vehicleClassName) {
        VehicleClassBean res = new VehicleClassBean();
        res.mId = id;
        res.mVehicleClassName = vehicleClassName;
        return res;
    }

    /**
     * Instantiate a new VehicleClassBean with all the values copied from the given model.
     */
    @NonNull
    public static VehicleClassBean copy(@NonNull VehicleClassModel from) {
        VehicleClassBean res = new VehicleClassBean();
        res.mId = from.getId();
        res.mVehicleClassName = from.getVehicleClassName();
        return res;
    }

    public static class Builder {
        private VehicleClassBean mRes = new VehicleClassBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Vehicle class name
         * Can be {@code null}.
         */
        public Builder vehicleClassName(@Nullable String vehicleClassName) {
            mRes.mVehicleClassName = vehicleClassName;
            return this;
        }

        /**
         * Get a new VehicleClassBean built with the given values.
         */
        public VehicleClassBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
