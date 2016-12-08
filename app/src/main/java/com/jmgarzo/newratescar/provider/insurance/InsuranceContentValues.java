package com.jmgarzo.newratescar.provider.insurance;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code insurance} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class InsuranceContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return InsuranceColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable InsuranceSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable InsuranceSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public InsuranceContentValues putVehicleId(long value) {
        mContentValues.put(InsuranceColumns.VEHICLE_ID, value);
        return this;
    }


    public InsuranceContentValues putInsuranceCompany(@Nullable String value) {
        mContentValues.put(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceContentValues putInsuranceCompanyNull() {
        mContentValues.putNull(InsuranceColumns.INSURANCE_COMPANY);
        return this;
    }

    public InsuranceContentValues putInsurancePrice(double value) {
        mContentValues.put(InsuranceColumns.INSURANCE_PRICE, value);
        return this;
    }


    public InsuranceContentValues putPolicyNumber(@Nullable String value) {
        mContentValues.put(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceContentValues putPolicyNumberNull() {
        mContentValues.putNull(InsuranceColumns.POLICY_NUMBER);
        return this;
    }

    public InsuranceContentValues putStartDate(@Nullable Date value) {
        mContentValues.put(InsuranceColumns.START_DATE, value == null ? null : value.getTime());
        return this;
    }

    public InsuranceContentValues putStartDateNull() {
        mContentValues.putNull(InsuranceColumns.START_DATE);
        return this;
    }

    public InsuranceContentValues putStartDate(@Nullable Long value) {
        mContentValues.put(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceContentValues putEndDate(@Nullable Date value) {
        mContentValues.put(InsuranceColumns.END_DATE, value == null ? null : value.getTime());
        return this;
    }

    public InsuranceContentValues putEndDateNull() {
        mContentValues.putNull(InsuranceColumns.END_DATE);
        return this;
    }

    public InsuranceContentValues putEndDate(@Nullable Long value) {
        mContentValues.put(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceContentValues putInsuranceAdditionalInformation(@Nullable String value) {
        mContentValues.put(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceContentValues putInsuranceAdditionalInformationNull() {
        mContentValues.putNull(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION);
        return this;
    }
}
