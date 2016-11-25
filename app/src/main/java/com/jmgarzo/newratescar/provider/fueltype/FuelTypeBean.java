package com.jmgarzo.newratescar.provider.fueltype;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel Type
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class FuelTypeBean implements FuelTypeModel {
    private long mId;
    private String mFuelTypeName;

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
     * Fuel Type Name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuelTypeName() {
        return mFuelTypeName;
    }

    /**
     * Fuel Type Name
     * Can be {@code null}.
     */
    public void setFuelTypeName(@Nullable String fuelTypeName) {
        mFuelTypeName = fuelTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTypeBean bean = (FuelTypeBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new FuelTypeBean with specified values.
     */
    @NonNull
    public static FuelTypeBean newInstance(long id, @Nullable String fuelTypeName) {
        FuelTypeBean res = new FuelTypeBean();
        res.mId = id;
        res.mFuelTypeName = fuelTypeName;
        return res;
    }

    /**
     * Instantiate a new FuelTypeBean with all the values copied from the given model.
     */
    @NonNull
    public static FuelTypeBean copy(@NonNull FuelTypeModel from) {
        FuelTypeBean res = new FuelTypeBean();
        res.mId = from.getId();
        res.mFuelTypeName = from.getFuelTypeName();
        return res;
    }

    public static class Builder {
        private FuelTypeBean mRes = new FuelTypeBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Fuel Type Name
         * Can be {@code null}.
         */
        public Builder fuelTypeName(@Nullable String fuelTypeName) {
            mRes.mFuelTypeName = fuelTypeName;
            return this;
        }

        /**
         * Get a new FuelTypeBean built with the given values.
         */
        public FuelTypeBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
