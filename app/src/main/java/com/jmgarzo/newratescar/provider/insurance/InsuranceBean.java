package com.jmgarzo.newratescar.provider.insurance;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * insurance
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class InsuranceBean implements InsuranceModel {
    private long mId;
    private long mVehicleId;
    private String mInsuranceCompany;
    private double mInsurancePrice;
    private String mPolicyNumber;
    private Date mStartDate;
    private Date mEndDate;
    private String mInsuranceAdditionalInformation;

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
     * Get the {@code insurance_company} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInsuranceCompany() {
        return mInsuranceCompany;
    }

    /**
     * Set the {@code insurance_company} value.
     * Can be {@code null}.
     */
    public void setInsuranceCompany(@Nullable String insuranceCompany) {
        mInsuranceCompany = insuranceCompany;
    }

    /**
     * Get the {@code insurance_price} value.
     */
    @Override
    public double getInsurancePrice() {
        return mInsurancePrice;
    }

    /**
     * Set the {@code insurance_price} value.
     */
    public void setInsurancePrice(double insurancePrice) {
        mInsurancePrice = insurancePrice;
    }

    /**
     * Get the {@code policy_number} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPolicyNumber() {
        return mPolicyNumber;
    }

    /**
     * Set the {@code policy_number} value.
     * Can be {@code null}.
     */
    public void setPolicyNumber(@Nullable String policyNumber) {
        mPolicyNumber = policyNumber;
    }

    /**
     * Get the {@code start_date} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Set the {@code start_date} value.
     * Can be {@code null}.
     */
    public void setStartDate(@Nullable Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Get the {@code end_date} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Set the {@code end_date} value.
     * Can be {@code null}.
     */
    public void setEndDate(@Nullable Date endDate) {
        mEndDate = endDate;
    }

    /**
     * Get the {@code insurance_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInsuranceAdditionalInformation() {
        return mInsuranceAdditionalInformation;
    }

    /**
     * Set the {@code insurance_additional_information} value.
     * Can be {@code null}.
     */
    public void setInsuranceAdditionalInformation(@Nullable String insuranceAdditionalInformation) {
        mInsuranceAdditionalInformation = insuranceAdditionalInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceBean bean = (InsuranceBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new InsuranceBean with specified values.
     */
    @NonNull
    public static InsuranceBean newInstance(long id, long vehicleId, @Nullable String insuranceCompany, double insurancePrice, @Nullable String policyNumber, @Nullable Date startDate, @Nullable Date endDate, @Nullable String insuranceAdditionalInformation) {
        InsuranceBean res = new InsuranceBean();
        res.mId = id;
        res.mVehicleId = vehicleId;
        res.mInsuranceCompany = insuranceCompany;
        res.mInsurancePrice = insurancePrice;
        res.mPolicyNumber = policyNumber;
        res.mStartDate = startDate;
        res.mEndDate = endDate;
        res.mInsuranceAdditionalInformation = insuranceAdditionalInformation;
        return res;
    }

    /**
     * Instantiate a new InsuranceBean with all the values copied from the given model.
     */
    @NonNull
    public static InsuranceBean copy(@NonNull InsuranceModel from) {
        InsuranceBean res = new InsuranceBean();
        res.mId = from.getId();
        res.mVehicleId = from.getVehicleId();
        res.mInsuranceCompany = from.getInsuranceCompany();
        res.mInsurancePrice = from.getInsurancePrice();
        res.mPolicyNumber = from.getPolicyNumber();
        res.mStartDate = from.getStartDate();
        res.mEndDate = from.getEndDate();
        res.mInsuranceAdditionalInformation = from.getInsuranceAdditionalInformation();
        return res;
    }

    public static class Builder {
        private InsuranceBean mRes = new InsuranceBean();

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
         * Set the {@code insurance_company} value.
         * Can be {@code null}.
         */
        public Builder insuranceCompany(@Nullable String insuranceCompany) {
            mRes.mInsuranceCompany = insuranceCompany;
            return this;
        }

        /**
         * Set the {@code insurance_price} value.
         */
        public Builder insurancePrice(double insurancePrice) {
            mRes.mInsurancePrice = insurancePrice;
            return this;
        }

        /**
         * Set the {@code policy_number} value.
         * Can be {@code null}.
         */
        public Builder policyNumber(@Nullable String policyNumber) {
            mRes.mPolicyNumber = policyNumber;
            return this;
        }

        /**
         * Set the {@code start_date} value.
         * Can be {@code null}.
         */
        public Builder startDate(@Nullable Date startDate) {
            mRes.mStartDate = startDate;
            return this;
        }

        /**
         * Set the {@code end_date} value.
         * Can be {@code null}.
         */
        public Builder endDate(@Nullable Date endDate) {
            mRes.mEndDate = endDate;
            return this;
        }

        /**
         * Set the {@code insurance_additional_information} value.
         * Can be {@code null}.
         */
        public Builder insuranceAdditionalInformation(@Nullable String insuranceAdditionalInformation) {
            mRes.mInsuranceAdditionalInformation = insuranceAdditionalInformation;
            return this;
        }

        /**
         * Get a new InsuranceBean built with the given values.
         */
        public InsuranceBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
