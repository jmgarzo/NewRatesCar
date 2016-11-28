package com.jmgarzo.newratescar.provider.refuel;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * refuel
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class RefuelBean implements RefuelModel {
    private long mId;
    private long mVehicleId;
    private Date mRefuelDate;
    private long mRefuelFuelType;
    private long mRefuelFuelSubtype;
    private int mRefuelMileage;
    private int mRefuelTripOdometer;
    private float mRefuelLitres;
    private float mRefuelGasPrice;
    private float mRefuelTotalPrice;
    private boolean mIsFull;
    private boolean mIsTrailer;
    private boolean mIsRoofRack;
    private int mRouteType;
    private int mDrivingStyle;
    private Float mAverageSpeed;
    private float mAverageConsumption;
    private String mPaymentType;
    private String mGasStation;
    private String mRefuelAdditionalInformation;

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
     * Get the {@code refuel_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRefuelDate() {
        return mRefuelDate;
    }

    /**
     * Set the {@code refuel_date} value.
     * Must not be {@code null}.
     */
    public void setRefuelDate(@NonNull Date refuelDate) {
        if (refuelDate == null) throw new IllegalArgumentException("refuelDate must not be null");
        mRefuelDate = refuelDate;
    }

    /**
     * Get the {@code refuel_fuel_type} value.
     */
    @Override
    public long getRefuelFuelType() {
        return mRefuelFuelType;
    }

    /**
     * Set the {@code refuel_fuel_type} value.
     */
    public void setRefuelFuelType(long refuelFuelType) {
        mRefuelFuelType = refuelFuelType;
    }

    /**
     * Get the {@code refuel_fuel_subtype} value.
     */
    @Override
    public long getRefuelFuelSubtype() {
        return mRefuelFuelSubtype;
    }

    /**
     * Set the {@code refuel_fuel_subtype} value.
     */
    public void setRefuelFuelSubtype(long refuelFuelSubtype) {
        mRefuelFuelSubtype = refuelFuelSubtype;
    }

    /**
     * Get the {@code refuel_mileage} value.
     */
    @Override
    public int getRefuelMileage() {
        return mRefuelMileage;
    }

    /**
     * Set the {@code refuel_mileage} value.
     */
    public void setRefuelMileage(int refuelMileage) {
        mRefuelMileage = refuelMileage;
    }

    /**
     * Get the {@code refuel_trip_odometer} value.
     */
    @Override
    public int getRefuelTripOdometer() {
        return mRefuelTripOdometer;
    }

    /**
     * Set the {@code refuel_trip_odometer} value.
     */
    public void setRefuelTripOdometer(int refuelTripOdometer) {
        mRefuelTripOdometer = refuelTripOdometer;
    }

    /**
     * Get the {@code refuel_litres} value.
     */
    @Override
    public float getRefuelLitres() {
        return mRefuelLitres;
    }

    /**
     * Set the {@code refuel_litres} value.
     */
    public void setRefuelLitres(float refuelLitres) {
        mRefuelLitres = refuelLitres;
    }

    /**
     * Get the {@code refuel_gas_price} value.
     */
    @Override
    public float getRefuelGasPrice() {
        return mRefuelGasPrice;
    }

    /**
     * Set the {@code refuel_gas_price} value.
     */
    public void setRefuelGasPrice(float refuelGasPrice) {
        mRefuelGasPrice = refuelGasPrice;
    }

    /**
     * Get the {@code refuel_total_price} value.
     */
    @Override
    public float getRefuelTotalPrice() {
        return mRefuelTotalPrice;
    }

    /**
     * Set the {@code refuel_total_price} value.
     */
    public void setRefuelTotalPrice(float refuelTotalPrice) {
        mRefuelTotalPrice = refuelTotalPrice;
    }

    /**
     * Get the {@code is_full} value.
     */
    @Override
    public boolean getIsFull() {
        return mIsFull;
    }

    /**
     * Set the {@code is_full} value.
     */
    public void setIsFull(boolean isFull) {
        mIsFull = isFull;
    }

    /**
     * Get the {@code is_trailer} value.
     */
    @Override
    public boolean getIsTrailer() {
        return mIsTrailer;
    }

    /**
     * Set the {@code is_trailer} value.
     */
    public void setIsTrailer(boolean isTrailer) {
        mIsTrailer = isTrailer;
    }

    /**
     * Get the {@code is_roof_rack} value.
     */
    @Override
    public boolean getIsRoofRack() {
        return mIsRoofRack;
    }

    /**
     * Set the {@code is_roof_rack} value.
     */
    public void setIsRoofRack(boolean isRoofRack) {
        mIsRoofRack = isRoofRack;
    }

    /**
     * Get the {@code route_type} value.
     */
    @Override
    public int getRouteType() {
        return mRouteType;
    }

    /**
     * Set the {@code route_type} value.
     */
    public void setRouteType(int routeType) {
        mRouteType = routeType;
    }

    /**
     * Get the {@code driving_style} value.
     */
    @Override
    public int getDrivingStyle() {
        return mDrivingStyle;
    }

    /**
     * Set the {@code driving_style} value.
     */
    public void setDrivingStyle(int drivingStyle) {
        mDrivingStyle = drivingStyle;
    }

    /**
     * Get the {@code average_speed} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Float getAverageSpeed() {
        return mAverageSpeed;
    }

    /**
     * Set the {@code average_speed} value.
     * Can be {@code null}.
     */
    public void setAverageSpeed(@Nullable Float averageSpeed) {
        mAverageSpeed = averageSpeed;
    }

    /**
     * Get the {@code average_consumption} value.
     */
    @Override
    public float getAverageConsumption() {
        return mAverageConsumption;
    }

    /**
     * Set the {@code average_consumption} value.
     */
    public void setAverageConsumption(float averageConsumption) {
        mAverageConsumption = averageConsumption;
    }

    /**
     * Get the {@code payment_type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPaymentType() {
        return mPaymentType;
    }

    /**
     * Set the {@code payment_type} value.
     * Can be {@code null}.
     */
    public void setPaymentType(@Nullable String paymentType) {
        mPaymentType = paymentType;
    }

    /**
     * Get the {@code gas_station} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGasStation() {
        return mGasStation;
    }

    /**
     * Set the {@code gas_station} value.
     * Can be {@code null}.
     */
    public void setGasStation(@Nullable String gasStation) {
        mGasStation = gasStation;
    }

    /**
     * Get the {@code refuel_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRefuelAdditionalInformation() {
        return mRefuelAdditionalInformation;
    }

    /**
     * Set the {@code refuel_additional_information} value.
     * Can be {@code null}.
     */
    public void setRefuelAdditionalInformation(@Nullable String refuelAdditionalInformation) {
        mRefuelAdditionalInformation = refuelAdditionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefuelBean bean = (RefuelBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new RefuelBean with specified values.
     */
    @NonNull
    public static RefuelBean newInstance(long id, long vehicleId, @NonNull Date refuelDate, long refuelFuelType, long refuelFuelSubtype, int refuelMileage, int refuelTripOdometer, float refuelLitres, float refuelGasPrice, float refuelTotalPrice, boolean isFull, boolean isTrailer, boolean isRoofRack, int routeType, int drivingStyle, @Nullable Float averageSpeed, float averageConsumption, @Nullable String paymentType, @Nullable String gasStation, @Nullable String refuelAdditionalInformation) {
        if (refuelDate == null) throw new IllegalArgumentException("refuelDate must not be null");
        RefuelBean res = new RefuelBean();
        res.mId = id;
        res.mVehicleId = vehicleId;
        res.mRefuelDate = refuelDate;
        res.mRefuelFuelType = refuelFuelType;
        res.mRefuelFuelSubtype = refuelFuelSubtype;
        res.mRefuelMileage = refuelMileage;
        res.mRefuelTripOdometer = refuelTripOdometer;
        res.mRefuelLitres = refuelLitres;
        res.mRefuelGasPrice = refuelGasPrice;
        res.mRefuelTotalPrice = refuelTotalPrice;
        res.mIsFull = isFull;
        res.mIsTrailer = isTrailer;
        res.mIsRoofRack = isRoofRack;
        res.mRouteType = routeType;
        res.mDrivingStyle = drivingStyle;
        res.mAverageSpeed = averageSpeed;
        res.mAverageConsumption = averageConsumption;
        res.mPaymentType = paymentType;
        res.mGasStation = gasStation;
        res.mRefuelAdditionalInformation = refuelAdditionalInformation;
        return res;
    }

    /**
     * Instantiate a new RefuelBean with all the values copied from the given model.
     */
    @NonNull
    public static RefuelBean copy(@NonNull RefuelModel from) {
        RefuelBean res = new RefuelBean();
        res.mId = from.getId();
        res.mVehicleId = from.getVehicleId();
        res.mRefuelDate = from.getRefuelDate();
        res.mRefuelFuelType = from.getRefuelFuelType();
        res.mRefuelFuelSubtype = from.getRefuelFuelSubtype();
        res.mRefuelMileage = from.getRefuelMileage();
        res.mRefuelTripOdometer = from.getRefuelTripOdometer();
        res.mRefuelLitres = from.getRefuelLitres();
        res.mRefuelGasPrice = from.getRefuelGasPrice();
        res.mRefuelTotalPrice = from.getRefuelTotalPrice();
        res.mIsFull = from.getIsFull();
        res.mIsTrailer = from.getIsTrailer();
        res.mIsRoofRack = from.getIsRoofRack();
        res.mRouteType = from.getRouteType();
        res.mDrivingStyle = from.getDrivingStyle();
        res.mAverageSpeed = from.getAverageSpeed();
        res.mAverageConsumption = from.getAverageConsumption();
        res.mPaymentType = from.getPaymentType();
        res.mGasStation = from.getGasStation();
        res.mRefuelAdditionalInformation = from.getRefuelAdditionalInformation();
        return res;
    }

    public static class Builder {
        private RefuelBean mRes = new RefuelBean();

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
         * Set the {@code refuel_date} value.
         * Must not be {@code null}.
         */
        public Builder refuelDate(@NonNull Date refuelDate) {
            if (refuelDate == null) throw new IllegalArgumentException("refuelDate must not be null");
            mRes.mRefuelDate = refuelDate;
            return this;
        }

        /**
         * Set the {@code refuel_fuel_type} value.
         */
        public Builder refuelFuelType(long refuelFuelType) {
            mRes.mRefuelFuelType = refuelFuelType;
            return this;
        }

        /**
         * Set the {@code refuel_fuel_subtype} value.
         */
        public Builder refuelFuelSubtype(long refuelFuelSubtype) {
            mRes.mRefuelFuelSubtype = refuelFuelSubtype;
            return this;
        }

        /**
         * Set the {@code refuel_mileage} value.
         */
        public Builder refuelMileage(int refuelMileage) {
            mRes.mRefuelMileage = refuelMileage;
            return this;
        }

        /**
         * Set the {@code refuel_trip_odometer} value.
         */
        public Builder refuelTripOdometer(int refuelTripOdometer) {
            mRes.mRefuelTripOdometer = refuelTripOdometer;
            return this;
        }

        /**
         * Set the {@code refuel_litres} value.
         */
        public Builder refuelLitres(float refuelLitres) {
            mRes.mRefuelLitres = refuelLitres;
            return this;
        }

        /**
         * Set the {@code refuel_gas_price} value.
         */
        public Builder refuelGasPrice(float refuelGasPrice) {
            mRes.mRefuelGasPrice = refuelGasPrice;
            return this;
        }

        /**
         * Set the {@code refuel_total_price} value.
         */
        public Builder refuelTotalPrice(float refuelTotalPrice) {
            mRes.mRefuelTotalPrice = refuelTotalPrice;
            return this;
        }

        /**
         * Set the {@code is_full} value.
         */
        public Builder isFull(boolean isFull) {
            mRes.mIsFull = isFull;
            return this;
        }

        /**
         * Set the {@code is_trailer} value.
         */
        public Builder isTrailer(boolean isTrailer) {
            mRes.mIsTrailer = isTrailer;
            return this;
        }

        /**
         * Set the {@code is_roof_rack} value.
         */
        public Builder isRoofRack(boolean isRoofRack) {
            mRes.mIsRoofRack = isRoofRack;
            return this;
        }

        /**
         * Set the {@code route_type} value.
         */
        public Builder routeType(int routeType) {
            mRes.mRouteType = routeType;
            return this;
        }

        /**
         * Set the {@code driving_style} value.
         */
        public Builder drivingStyle(int drivingStyle) {
            mRes.mDrivingStyle = drivingStyle;
            return this;
        }

        /**
         * Set the {@code average_speed} value.
         * Can be {@code null}.
         */
        public Builder averageSpeed(@Nullable Float averageSpeed) {
            mRes.mAverageSpeed = averageSpeed;
            return this;
        }

        /**
         * Set the {@code average_consumption} value.
         */
        public Builder averageConsumption(float averageConsumption) {
            mRes.mAverageConsumption = averageConsumption;
            return this;
        }

        /**
         * Set the {@code payment_type} value.
         * Can be {@code null}.
         */
        public Builder paymentType(@Nullable String paymentType) {
            mRes.mPaymentType = paymentType;
            return this;
        }

        /**
         * Set the {@code gas_station} value.
         * Can be {@code null}.
         */
        public Builder gasStation(@Nullable String gasStation) {
            mRes.mGasStation = gasStation;
            return this;
        }

        /**
         * Set the {@code refuel_additional_information} value.
         * Can be {@code null}.
         */
        public Builder refuelAdditionalInformation(@Nullable String refuelAdditionalInformation) {
            mRes.mRefuelAdditionalInformation = refuelAdditionalInformation;
            return this;
        }

        /**
         * Get a new RefuelBean built with the given values.
         */
        public RefuelBean build() {
            if (mRes.mRefuelDate == null) throw new IllegalArgumentException("refuelDate must not be null");
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
