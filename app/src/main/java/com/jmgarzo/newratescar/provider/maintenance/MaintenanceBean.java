package com.jmgarzo.newratescar.provider.maintenance;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * maintenance
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class MaintenanceBean implements MaintenanceModel {
    private long mId;
    private long mVehicleId;
    private String mMaintenanceTitle;
    private Date mMaintenanceDate;
    private int mMaintenanceMileage;
    private int mMaintenanceType;
    private double mMaintenancePrice;
    private String mMaintenanceDescription;
    private boolean mIsRegular;
    private Integer mMaintenancePeriodicity;
    private String mMaintenanceGarage;
    private String mMaintenanceAdditionalInformation;

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
     * Get the {@code maintenance_title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceTitle() {
        return mMaintenanceTitle;
    }

    /**
     * Set the {@code maintenance_title} value.
     * Can be {@code null}.
     */
    public void setMaintenanceTitle(@Nullable String maintenanceTitle) {
        mMaintenanceTitle = maintenanceTitle;
    }

    /**
     * Get the {@code maintenance_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getMaintenanceDate() {
        return mMaintenanceDate;
    }

    /**
     * Set the {@code maintenance_date} value.
     * Must not be {@code null}.
     */
    public void setMaintenanceDate(@NonNull Date maintenanceDate) {
        if (maintenanceDate == null) throw new IllegalArgumentException("maintenanceDate must not be null");
        mMaintenanceDate = maintenanceDate;
    }

    /**
     * Get the {@code maintenance_mileage} value.
     */
    @Override
    public int getMaintenanceMileage() {
        return mMaintenanceMileage;
    }

    /**
     * Set the {@code maintenance_mileage} value.
     */
    public void setMaintenanceMileage(int maintenanceMileage) {
        mMaintenanceMileage = maintenanceMileage;
    }

    /**
     * Get the {@code maintenance_type} value.
     */
    @Override
    public int getMaintenanceType() {
        return mMaintenanceType;
    }

    /**
     * Set the {@code maintenance_type} value.
     */
    public void setMaintenanceType(int maintenanceType) {
        mMaintenanceType = maintenanceType;
    }

    /**
     * Get the {@code maintenance_price} value.
     */
    @Override
    public double getMaintenancePrice() {
        return mMaintenancePrice;
    }

    /**
     * Set the {@code maintenance_price} value.
     */
    public void setMaintenancePrice(double maintenancePrice) {
        mMaintenancePrice = maintenancePrice;
    }

    /**
     * Get the {@code maintenance_description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceDescription() {
        return mMaintenanceDescription;
    }

    /**
     * Set the {@code maintenance_description} value.
     * Can be {@code null}.
     */
    public void setMaintenanceDescription(@Nullable String maintenanceDescription) {
        mMaintenanceDescription = maintenanceDescription;
    }

    /**
     * Get the {@code is_regular} value.
     */
    @Override
    public boolean getIsRegular() {
        return mIsRegular;
    }

    /**
     * Set the {@code is_regular} value.
     */
    public void setIsRegular(boolean isRegular) {
        mIsRegular = isRegular;
    }

    /**
     * Get the {@code maintenance_periodicity} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaintenancePeriodicity() {
        return mMaintenancePeriodicity;
    }

    /**
     * Set the {@code maintenance_periodicity} value.
     * Can be {@code null}.
     */
    public void setMaintenancePeriodicity(@Nullable Integer maintenancePeriodicity) {
        mMaintenancePeriodicity = maintenancePeriodicity;
    }

    /**
     * Get the {@code maintenance_garage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceGarage() {
        return mMaintenanceGarage;
    }

    /**
     * Set the {@code maintenance_garage} value.
     * Can be {@code null}.
     */
    public void setMaintenanceGarage(@Nullable String maintenanceGarage) {
        mMaintenanceGarage = maintenanceGarage;
    }

    /**
     * Get the {@code maintenance_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceAdditionalInformation() {
        return mMaintenanceAdditionalInformation;
    }

    /**
     * Set the {@code maintenance_additional_information} value.
     * Can be {@code null}.
     */
    public void setMaintenanceAdditionalInformation(@Nullable String maintenanceAdditionalInformation) {
        mMaintenanceAdditionalInformation = maintenanceAdditionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceBean bean = (MaintenanceBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new MaintenanceBean with specified values.
     */
    @NonNull
    public static MaintenanceBean newInstance(long id, long vehicleId, @Nullable String maintenanceTitle, @NonNull Date maintenanceDate, int maintenanceMileage, int maintenanceType, double maintenancePrice, @Nullable String maintenanceDescription, boolean isRegular, @Nullable Integer maintenancePeriodicity, @Nullable String maintenanceGarage, @Nullable String maintenanceAdditionalInformation) {
        if (maintenanceDate == null) throw new IllegalArgumentException("maintenanceDate must not be null");
        MaintenanceBean res = new MaintenanceBean();
        res.mId = id;
        res.mVehicleId = vehicleId;
        res.mMaintenanceTitle = maintenanceTitle;
        res.mMaintenanceDate = maintenanceDate;
        res.mMaintenanceMileage = maintenanceMileage;
        res.mMaintenanceType = maintenanceType;
        res.mMaintenancePrice = maintenancePrice;
        res.mMaintenanceDescription = maintenanceDescription;
        res.mIsRegular = isRegular;
        res.mMaintenancePeriodicity = maintenancePeriodicity;
        res.mMaintenanceGarage = maintenanceGarage;
        res.mMaintenanceAdditionalInformation = maintenanceAdditionalInformation;
        return res;
    }

    /**
     * Instantiate a new MaintenanceBean with all the values copied from the given model.
     */
    @NonNull
    public static MaintenanceBean copy(@NonNull MaintenanceModel from) {
        MaintenanceBean res = new MaintenanceBean();
        res.mId = from.getId();
        res.mVehicleId = from.getVehicleId();
        res.mMaintenanceTitle = from.getMaintenanceTitle();
        res.mMaintenanceDate = from.getMaintenanceDate();
        res.mMaintenanceMileage = from.getMaintenanceMileage();
        res.mMaintenanceType = from.getMaintenanceType();
        res.mMaintenancePrice = from.getMaintenancePrice();
        res.mMaintenanceDescription = from.getMaintenanceDescription();
        res.mIsRegular = from.getIsRegular();
        res.mMaintenancePeriodicity = from.getMaintenancePeriodicity();
        res.mMaintenanceGarage = from.getMaintenanceGarage();
        res.mMaintenanceAdditionalInformation = from.getMaintenanceAdditionalInformation();
        return res;
    }

    public static class Builder {
        private MaintenanceBean mRes = new MaintenanceBean();

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
         * Set the {@code maintenance_title} value.
         * Can be {@code null}.
         */
        public Builder maintenanceTitle(@Nullable String maintenanceTitle) {
            mRes.mMaintenanceTitle = maintenanceTitle;
            return this;
        }

        /**
         * Set the {@code maintenance_date} value.
         * Must not be {@code null}.
         */
        public Builder maintenanceDate(@NonNull Date maintenanceDate) {
            if (maintenanceDate == null) throw new IllegalArgumentException("maintenanceDate must not be null");
            mRes.mMaintenanceDate = maintenanceDate;
            return this;
        }

        /**
         * Set the {@code maintenance_mileage} value.
         */
        public Builder maintenanceMileage(int maintenanceMileage) {
            mRes.mMaintenanceMileage = maintenanceMileage;
            return this;
        }

        /**
         * Set the {@code maintenance_type} value.
         */
        public Builder maintenanceType(int maintenanceType) {
            mRes.mMaintenanceType = maintenanceType;
            return this;
        }

        /**
         * Set the {@code maintenance_price} value.
         */
        public Builder maintenancePrice(double maintenancePrice) {
            mRes.mMaintenancePrice = maintenancePrice;
            return this;
        }

        /**
         * Set the {@code maintenance_description} value.
         * Can be {@code null}.
         */
        public Builder maintenanceDescription(@Nullable String maintenanceDescription) {
            mRes.mMaintenanceDescription = maintenanceDescription;
            return this;
        }

        /**
         * Set the {@code is_regular} value.
         */
        public Builder isRegular(boolean isRegular) {
            mRes.mIsRegular = isRegular;
            return this;
        }

        /**
         * Set the {@code maintenance_periodicity} value.
         * Can be {@code null}.
         */
        public Builder maintenancePeriodicity(@Nullable Integer maintenancePeriodicity) {
            mRes.mMaintenancePeriodicity = maintenancePeriodicity;
            return this;
        }

        /**
         * Set the {@code maintenance_garage} value.
         * Can be {@code null}.
         */
        public Builder maintenanceGarage(@Nullable String maintenanceGarage) {
            mRes.mMaintenanceGarage = maintenanceGarage;
            return this;
        }

        /**
         * Set the {@code maintenance_additional_information} value.
         * Can be {@code null}.
         */
        public Builder maintenanceAdditionalInformation(@Nullable String maintenanceAdditionalInformation) {
            mRes.mMaintenanceAdditionalInformation = maintenanceAdditionalInformation;
            return this;
        }

        /**
         * Get a new MaintenanceBean built with the given values.
         */
        public MaintenanceBean build() {
            if (mRes.mMaintenanceDate == null) throw new IllegalArgumentException("maintenanceDate must not be null");
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
