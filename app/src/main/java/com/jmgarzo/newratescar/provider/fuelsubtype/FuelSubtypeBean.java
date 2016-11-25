package com.jmgarzo.newratescar.provider.fuelsubtype;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Fuel Subtype
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class FuelSubtypeBean implements FuelSubtypeModel {
    private long mId;
    private String mFuelSubtypeName;

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
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFuelSubtypeName() {
        return mFuelSubtypeName;
    }

    /**
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    public void setFuelSubtypeName(@Nullable String fuelSubtypeName) {
        mFuelSubtypeName = fuelSubtypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelSubtypeBean bean = (FuelSubtypeBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new FuelSubtypeBean with specified values.
     */
    @NonNull
    public static FuelSubtypeBean newInstance(long id, @Nullable String fuelSubtypeName) {
        FuelSubtypeBean res = new FuelSubtypeBean();
        res.mId = id;
        res.mFuelSubtypeName = fuelSubtypeName;
        return res;
    }

    /**
     * Instantiate a new FuelSubtypeBean with all the values copied from the given model.
     */
    @NonNull
    public static FuelSubtypeBean copy(@NonNull FuelSubtypeModel from) {
        FuelSubtypeBean res = new FuelSubtypeBean();
        res.mId = from.getId();
        res.mFuelSubtypeName = from.getFuelSubtypeName();
        return res;
    }

    public static class Builder {
        private FuelSubtypeBean mRes = new FuelSubtypeBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Fuel Subtype Name
         * Can be {@code null}.
         */
        public Builder fuelSubtypeName(@Nullable String fuelSubtypeName) {
            mRes.mFuelSubtypeName = fuelSubtypeName;
            return this;
        }

        /**
         * Get a new FuelSubtypeBean built with the given values.
         */
        public FuelSubtypeBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
