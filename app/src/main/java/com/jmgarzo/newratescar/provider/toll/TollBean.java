package com.jmgarzo.newratescar.provider.toll;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * toll
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class TollBean implements TollModel {
    private long mId;
    private long mVehicleId;
    private Date mTollDate;
    private double mTollPrice;
    private String mTollName;
    private String mTollRoad;
    private String mTollDirection;
    private String mTollLocation;
    private String mTollAdditionalInformation;

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
     * Get the {@code vehicle_id} value.
     */
    @Override
    public long getVehicleId() {
        return mVehicleId;
    }

    /**
     * Set the {@code vehicle_id} value.
     */
    public void setVehicleId(long vehicleId) {
        mVehicleId = vehicleId;
    }

    /**
     * Get the {@code toll_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getTollDate() {
        return mTollDate;
    }

    /**
     * Set the {@code toll_date} value.
     * Must not be {@code null}.
     */
    public void setTollDate(@NonNull Date tollDate) {
        if (tollDate == null) throw new IllegalArgumentException("tollDate must not be null");
        mTollDate = tollDate;
    }

    /**
     * Get the {@code toll_price} value.
     */
    @Override
    public double getTollPrice() {
        return mTollPrice;
    }

    /**
     * Set the {@code toll_price} value.
     */
    public void setTollPrice(double tollPrice) {
        mTollPrice = tollPrice;
    }

    /**
     * Get the {@code toll_name} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTollName() {
        return mTollName;
    }

    /**
     * Set the {@code toll_name} value.
     * Can be {@code null}.
     */
    public void setTollName(@Nullable String tollName) {
        mTollName = tollName;
    }

    /**
     * Get the {@code toll_road} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTollRoad() {
        return mTollRoad;
    }

    /**
     * Set the {@code toll_road} value.
     * Can be {@code null}.
     */
    public void setTollRoad(@Nullable String tollRoad) {
        mTollRoad = tollRoad;
    }

    /**
     * Get the {@code toll_direction} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTollDirection() {
        return mTollDirection;
    }

    /**
     * Set the {@code toll_direction} value.
     * Can be {@code null}.
     */
    public void setTollDirection(@Nullable String tollDirection) {
        mTollDirection = tollDirection;
    }

    /**
     * Get the {@code toll_location} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTollLocation() {
        return mTollLocation;
    }

    /**
     * Set the {@code toll_location} value.
     * Can be {@code null}.
     */
    public void setTollLocation(@Nullable String tollLocation) {
        mTollLocation = tollLocation;
    }

    /**
     * Get the {@code toll_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTollAdditionalInformation() {
        return mTollAdditionalInformation;
    }

    /**
     * Set the {@code toll_additional_information} value.
     * Can be {@code null}.
     */
    public void setTollAdditionalInformation(@Nullable String tollAdditionalInformation) {
        mTollAdditionalInformation = tollAdditionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TollBean bean = (TollBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new TollBean with specified values.
     */
    @NonNull
    public static TollBean newInstance(long id, long vehicleId, @NonNull Date tollDate, double tollPrice, @Nullable String tollName, @Nullable String tollRoad, @Nullable String tollDirection, @Nullable String tollLocation, @Nullable String tollAdditionalInformation) {
        if (tollDate == null) throw new IllegalArgumentException("tollDate must not be null");
        TollBean res = new TollBean();
        res.mId = id;
        res.mVehicleId = vehicleId;
        res.mTollDate = tollDate;
        res.mTollPrice = tollPrice;
        res.mTollName = tollName;
        res.mTollRoad = tollRoad;
        res.mTollDirection = tollDirection;
        res.mTollLocation = tollLocation;
        res.mTollAdditionalInformation = tollAdditionalInformation;
        return res;
    }

    /**
     * Instantiate a new TollBean with all the values copied from the given model.
     */
    @NonNull
    public static TollBean copy(@NonNull TollModel from) {
        TollBean res = new TollBean();
        res.mId = from.getId();
        res.mVehicleId = from.getVehicleId();
        res.mTollDate = from.getTollDate();
        res.mTollPrice = from.getTollPrice();
        res.mTollName = from.getTollName();
        res.mTollRoad = from.getTollRoad();
        res.mTollDirection = from.getTollDirection();
        res.mTollLocation = from.getTollLocation();
        res.mTollAdditionalInformation = from.getTollAdditionalInformation();
        return res;
    }

    public static class Builder {
        private TollBean mRes = new TollBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code vehicle_id} value.
         */
        public Builder vehicleId(long vehicleId) {
            mRes.mVehicleId = vehicleId;
            return this;
        }

        /**
         * Set the {@code toll_date} value.
         * Must not be {@code null}.
         */
        public Builder tollDate(@NonNull Date tollDate) {
            if (tollDate == null) throw new IllegalArgumentException("tollDate must not be null");
            mRes.mTollDate = tollDate;
            return this;
        }

        /**
         * Set the {@code toll_price} value.
         */
        public Builder tollPrice(double tollPrice) {
            mRes.mTollPrice = tollPrice;
            return this;
        }

        /**
         * Set the {@code toll_name} value.
         * Can be {@code null}.
         */
        public Builder tollName(@Nullable String tollName) {
            mRes.mTollName = tollName;
            return this;
        }

        /**
         * Set the {@code toll_road} value.
         * Can be {@code null}.
         */
        public Builder tollRoad(@Nullable String tollRoad) {
            mRes.mTollRoad = tollRoad;
            return this;
        }

        /**
         * Set the {@code toll_direction} value.
         * Can be {@code null}.
         */
        public Builder tollDirection(@Nullable String tollDirection) {
            mRes.mTollDirection = tollDirection;
            return this;
        }

        /**
         * Set the {@code toll_location} value.
         * Can be {@code null}.
         */
        public Builder tollLocation(@Nullable String tollLocation) {
            mRes.mTollLocation = tollLocation;
            return this;
        }

        /**
         * Set the {@code toll_additional_information} value.
         * Can be {@code null}.
         */
        public Builder tollAdditionalInformation(@Nullable String tollAdditionalInformation) {
            mRes.mTollAdditionalInformation = tollAdditionalInformation;
            return this;
        }

        /**
         * Get a new TollBean built with the given values.
         */
        public TollBean build() {
            if (mRes.mTollDate == null) throw new IllegalArgumentException("tollDate must not be null");
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
