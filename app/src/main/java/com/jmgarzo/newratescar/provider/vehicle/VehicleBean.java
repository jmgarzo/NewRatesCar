package com.jmgarzo.newratescar.provider.vehicle;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Vehicle
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class VehicleBean implements VehicleModel {
    private long mId;
    private String mVehicleName;
    private long mVehicleClass;
    private long mVehicleFuelType;
    private long mMake;
    private String mModel;
    private Integer mMileage;
    private String mAdditionalInformation;

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
     * Vehicle name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getVehicleName() {
        return mVehicleName;
    }

    /**
     * Vehicle name
     * Can be {@code null}.
     */
    public void setVehicleName(@Nullable String vehicleName) {
        mVehicleName = vehicleName;
    }

    /**
     * Get the {@code vehicle_class} value.
     */
    @Override
    public long getVehicleClass() {
        return mVehicleClass;
    }

    /**
     * Set the {@code vehicle_class} value.
     */
    public void setVehicleClass(long vehicleClass) {
        mVehicleClass = vehicleClass;
    }

    /**
     * Get the {@code vehicle_fuel_type} value.
     */
    @Override
    public long getVehicleFuelType() {
        return mVehicleFuelType;
    }

    /**
     * Set the {@code vehicle_fuel_type} value.
     */
    public void setVehicleFuelType(long vehicleFuelType) {
        mVehicleFuelType = vehicleFuelType;
    }

    /**
     * Get the {@code make} value.
     */
    @Override
    public long getMake() {
        return mMake;
    }

    /**
     * Set the {@code make} value.
     */
    public void setMake(long make) {
        mMake = make;
    }

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getModel() {
        return mModel;
    }

    /**
     * Set the {@code model} value.
     * Can be {@code null}.
     */
    public void setModel(@Nullable String model) {
        mModel = model;
    }

    /**
     * Get the {@code mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMileage() {
        return mMileage;
    }

    /**
     * Set the {@code mileage} value.
     * Can be {@code null}.
     */
    public void setMileage(@Nullable Integer mileage) {
        mMileage = mileage;
    }

    /**
     * Get the {@code additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdditionalInformation() {
        return mAdditionalInformation;
    }

    /**
     * Set the {@code additional_information} value.
     * Can be {@code null}.
     */
    public void setAdditionalInformation(@Nullable String additionalInformation) {
        mAdditionalInformation = additionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleBean bean = (VehicleBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new VehicleBean with specified values.
     */
    @NonNull
    public static VehicleBean newInstance(long id, @Nullable String vehicleName, long vehicleClass, long vehicleFuelType, long make, @Nullable String model, @Nullable Integer mileage, @Nullable String additionalInformation) {
        VehicleBean res = new VehicleBean();
        res.mId = id;
        res.mVehicleName = vehicleName;
        res.mVehicleClass = vehicleClass;
        res.mVehicleFuelType = vehicleFuelType;
        res.mMake = make;
        res.mModel = model;
        res.mMileage = mileage;
        res.mAdditionalInformation = additionalInformation;
        return res;
    }

    /**
     * Instantiate a new VehicleBean with all the values copied from the given model.
     */
    @NonNull
    public static VehicleBean copy(@NonNull VehicleModel from) {
        VehicleBean res = new VehicleBean();
        res.mId = from.getId();
        res.mVehicleName = from.getVehicleName();
        res.mVehicleClass = from.getVehicleClass();
        res.mVehicleFuelType = from.getVehicleFuelType();
        res.mMake = from.getMake();
        res.mModel = from.getModel();
        res.mMileage = from.getMileage();
        res.mAdditionalInformation = from.getAdditionalInformation();
        return res;
    }

    public static class Builder {
        private VehicleBean mRes = new VehicleBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Vehicle name
         * Can be {@code null}.
         */
        public Builder vehicleName(@Nullable String vehicleName) {
            mRes.mVehicleName = vehicleName;
            return this;
        }

        /**
         * Set the {@code vehicle_class} value.
         */
        public Builder vehicleClass(long vehicleClass) {
            mRes.mVehicleClass = vehicleClass;
            return this;
        }

        /**
         * Set the {@code vehicle_fuel_type} value.
         */
        public Builder vehicleFuelType(long vehicleFuelType) {
            mRes.mVehicleFuelType = vehicleFuelType;
            return this;
        }

        /**
         * Set the {@code make} value.
         */
        public Builder make(long make) {
            mRes.mMake = make;
            return this;
        }

        /**
         * Set the {@code model} value.
         * Can be {@code null}.
         */
        public Builder model(@Nullable String model) {
            mRes.mModel = model;
            return this;
        }

        /**
         * Set the {@code mileage} value.
         * Can be {@code null}.
         */
        public Builder mileage(@Nullable Integer mileage) {
            mRes.mMileage = mileage;
            return this;
        }

        /**
         * Set the {@code additional_information} value.
         * Can be {@code null}.
         */
        public Builder additionalInformation(@Nullable String additionalInformation) {
            mRes.mAdditionalInformation = additionalInformation;
            return this;
        }

        /**
         * Get a new VehicleBean built with the given values.
         */
        public VehicleBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
