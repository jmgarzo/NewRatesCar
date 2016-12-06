package com.jmgarzo.newratescar.provider.roadworthiness;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * roadworthiness
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class RoadworthinessBean implements RoadworthinessModel {
    private long mId;
    private long mVehicleId;
    private Date mRoadworthinessDate;
    private int mRoadworthinessMileage;
    private double mRoadworthinessPrice;
    private String mRoadworthinessResult;
    private Date mRoadworthinessNextDate;
    private String mRoadworthinessAdditionalInformation;

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
     * Get the {@code roadworthiness_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRoadworthinessDate() {
        return mRoadworthinessDate;
    }

    /**
     * Set the {@code roadworthiness_date} value.
     * Must not be {@code null}.
     */
    public void setRoadworthinessDate(@NonNull Date roadworthinessDate) {
        if (roadworthinessDate == null) throw new IllegalArgumentException("roadworthinessDate must not be null");
        mRoadworthinessDate = roadworthinessDate;
    }

    /**
     * Get the {@code roadworthiness_mileage} value.
     */
    @Override
    public int getRoadworthinessMileage() {
        return mRoadworthinessMileage;
    }

    /**
     * Set the {@code roadworthiness_mileage} value.
     */
    public void setRoadworthinessMileage(int roadworthinessMileage) {
        mRoadworthinessMileage = roadworthinessMileage;
    }

    /**
     * Get the {@code roadworthiness_price} value.
     */
    @Override
    public double getRoadworthinessPrice() {
        return mRoadworthinessPrice;
    }

    /**
     * Set the {@code roadworthiness_price} value.
     */
    public void setRoadworthinessPrice(double roadworthinessPrice) {
        mRoadworthinessPrice = roadworthinessPrice;
    }

    /**
     * Get the {@code roadworthiness_result} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRoadworthinessResult() {
        return mRoadworthinessResult;
    }

    /**
     * Set the {@code roadworthiness_result} value.
     * Can be {@code null}.
     */
    public void setRoadworthinessResult(@Nullable String roadworthinessResult) {
        mRoadworthinessResult = roadworthinessResult;
    }

    /**
     * Get the {@code roadworthiness_next_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRoadworthinessNextDate() {
        return mRoadworthinessNextDate;
    }

    /**
     * Set the {@code roadworthiness_next_date} value.
     * Must not be {@code null}.
     */
    public void setRoadworthinessNextDate(@NonNull Date roadworthinessNextDate) {
        if (roadworthinessNextDate == null) throw new IllegalArgumentException("roadworthinessNextDate must not be null");
        mRoadworthinessNextDate = roadworthinessNextDate;
    }

    /**
     * Get the {@code roadworthiness_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRoadworthinessAdditionalInformation() {
        return mRoadworthinessAdditionalInformation;
    }

    /**
     * Set the {@code roadworthiness_additional_information} value.
     * Can be {@code null}.
     */
    public void setRoadworthinessAdditionalInformation(@Nullable String roadworthinessAdditionalInformation) {
        mRoadworthinessAdditionalInformation = roadworthinessAdditionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadworthinessBean bean = (RoadworthinessBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new RoadworthinessBean with specified values.
     */
    @NonNull
    public static RoadworthinessBean newInstance(long id, long vehicleId, @NonNull Date roadworthinessDate, int roadworthinessMileage, double roadworthinessPrice, @Nullable String roadworthinessResult, @NonNull Date roadworthinessNextDate, @Nullable String roadworthinessAdditionalInformation) {
        if (roadworthinessDate == null) throw new IllegalArgumentException("roadworthinessDate must not be null");
        if (roadworthinessNextDate == null) throw new IllegalArgumentException("roadworthinessNextDate must not be null");
        RoadworthinessBean res = new RoadworthinessBean();
        res.mId = id;
        res.mVehicleId = vehicleId;
        res.mRoadworthinessDate = roadworthinessDate;
        res.mRoadworthinessMileage = roadworthinessMileage;
        res.mRoadworthinessPrice = roadworthinessPrice;
        res.mRoadworthinessResult = roadworthinessResult;
        res.mRoadworthinessNextDate = roadworthinessNextDate;
        res.mRoadworthinessAdditionalInformation = roadworthinessAdditionalInformation;
        return res;
    }

    /**
     * Instantiate a new RoadworthinessBean with all the values copied from the given model.
     */
    @NonNull
    public static RoadworthinessBean copy(@NonNull RoadworthinessModel from) {
        RoadworthinessBean res = new RoadworthinessBean();
        res.mId = from.getId();
        res.mVehicleId = from.getVehicleId();
        res.mRoadworthinessDate = from.getRoadworthinessDate();
        res.mRoadworthinessMileage = from.getRoadworthinessMileage();
        res.mRoadworthinessPrice = from.getRoadworthinessPrice();
        res.mRoadworthinessResult = from.getRoadworthinessResult();
        res.mRoadworthinessNextDate = from.getRoadworthinessNextDate();
        res.mRoadworthinessAdditionalInformation = from.getRoadworthinessAdditionalInformation();
        return res;
    }

    public static class Builder {
        private RoadworthinessBean mRes = new RoadworthinessBean();

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
         * Set the {@code roadworthiness_date} value.
         * Must not be {@code null}.
         */
        public Builder roadworthinessDate(@NonNull Date roadworthinessDate) {
            if (roadworthinessDate == null) throw new IllegalArgumentException("roadworthinessDate must not be null");
            mRes.mRoadworthinessDate = roadworthinessDate;
            return this;
        }

        /**
         * Set the {@code roadworthiness_mileage} value.
         */
        public Builder roadworthinessMileage(int roadworthinessMileage) {
            mRes.mRoadworthinessMileage = roadworthinessMileage;
            return this;
        }

        /**
         * Set the {@code roadworthiness_price} value.
         */
        public Builder roadworthinessPrice(double roadworthinessPrice) {
            mRes.mRoadworthinessPrice = roadworthinessPrice;
            return this;
        }

        /**
         * Set the {@code roadworthiness_result} value.
         * Can be {@code null}.
         */
        public Builder roadworthinessResult(@Nullable String roadworthinessResult) {
            mRes.mRoadworthinessResult = roadworthinessResult;
            return this;
        }

        /**
         * Set the {@code roadworthiness_next_date} value.
         * Must not be {@code null}.
         */
        public Builder roadworthinessNextDate(@NonNull Date roadworthinessNextDate) {
            if (roadworthinessNextDate == null) throw new IllegalArgumentException("roadworthinessNextDate must not be null");
            mRes.mRoadworthinessNextDate = roadworthinessNextDate;
            return this;
        }

        /**
         * Set the {@code roadworthiness_additional_information} value.
         * Can be {@code null}.
         */
        public Builder roadworthinessAdditionalInformation(@Nullable String roadworthinessAdditionalInformation) {
            mRes.mRoadworthinessAdditionalInformation = roadworthinessAdditionalInformation;
            return this;
        }

        /**
         * Get a new RoadworthinessBean built with the given values.
         */
        public RoadworthinessBean build() {
            if (mRes.mRoadworthinessDate == null) throw new IllegalArgumentException("roadworthinessDate must not be null");
            if (mRes.mRoadworthinessNextDate == null) throw new IllegalArgumentException("roadworthinessNextDate must not be null");
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
