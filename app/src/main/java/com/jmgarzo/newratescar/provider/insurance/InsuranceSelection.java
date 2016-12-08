package com.jmgarzo.newratescar.provider.insurance;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;
import com.jmgarzo.newratescar.provider.vehicle.*;
import com.jmgarzo.newratescar.provider.vehicleclass.*;
import com.jmgarzo.newratescar.provider.fueltype.*;
import com.jmgarzo.newratescar.provider.make.*;

/**
 * Selection for the {@code insurance} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class InsuranceSelection extends AbstractSelection<InsuranceSelection> {
    @Override
    protected Uri baseUri() {
        return InsuranceColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InsuranceCursor} object, which is positioned before the first entry, or null.
     */
    public InsuranceCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InsuranceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public InsuranceCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InsuranceCursor} object, which is positioned before the first entry, or null.
     */
    public InsuranceCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InsuranceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public InsuranceCursor query(Context context) {
        return query(context, null);
    }


    public InsuranceSelection id(long... value) {
        addEquals("insurance." + InsuranceColumns._ID, toObjectArray(value));
        return this;
    }

    public InsuranceSelection idNot(long... value) {
        addNotEquals("insurance." + InsuranceColumns._ID, toObjectArray(value));
        return this;
    }

    public InsuranceSelection orderById(boolean desc) {
        orderBy("insurance." + InsuranceColumns._ID, desc);
        return this;
    }

    public InsuranceSelection orderById() {
        return orderById(false);
    }

    public InsuranceSelection vehicleId(long... value) {
        addEquals(InsuranceColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleIdNot(long... value) {
        addNotEquals(InsuranceColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleIdGt(long value) {
        addGreaterThan(InsuranceColumns.VEHICLE_ID, value);
        return this;
    }

    public InsuranceSelection vehicleIdGtEq(long value) {
        addGreaterThanOrEquals(InsuranceColumns.VEHICLE_ID, value);
        return this;
    }

    public InsuranceSelection vehicleIdLt(long value) {
        addLessThan(InsuranceColumns.VEHICLE_ID, value);
        return this;
    }

    public InsuranceSelection vehicleIdLtEq(long value) {
        addLessThanOrEquals(InsuranceColumns.VEHICLE_ID, value);
        return this;
    }

    public InsuranceSelection orderByVehicleId(boolean desc) {
        orderBy(InsuranceColumns.VEHICLE_ID, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleId() {
        orderBy(InsuranceColumns.VEHICLE_ID, false);
        return this;
    }

    public InsuranceSelection vehicleVehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public InsuranceSelection vehicleVehicleClass(long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleVehicleClassNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleVehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelType(long... value) {
        addEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelTypeNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelTypeLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public InsuranceSelection vehicleVehicleFuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleFuelType(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleVehicleFuelType() {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, false);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleFuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public InsuranceSelection orderByVehicleFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public InsuranceSelection vehicleMake(long... value) {
        addEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleMakeNot(long... value) {
        addNotEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection vehicleMakeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public InsuranceSelection vehicleMakeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public InsuranceSelection vehicleMakeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public InsuranceSelection vehicleMakeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public InsuranceSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection vehicleMakeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public InsuranceSelection orderByVehicleMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public InsuranceSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public InsuranceSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public InsuranceSelection vehicleMileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection vehicleMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection vehicleMileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection vehicleMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection vehicleMileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection vehicleMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public InsuranceSelection orderByVehicleMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection vehicleAdditionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection orderByVehicleAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public InsuranceSelection orderByVehicleAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }

    public InsuranceSelection insuranceCompany(String... value) {
        addEquals(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection insuranceCompanyNot(String... value) {
        addNotEquals(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection insuranceCompanyLike(String... value) {
        addLike(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection insuranceCompanyContains(String... value) {
        addContains(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection insuranceCompanyStartsWith(String... value) {
        addStartsWith(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection insuranceCompanyEndsWith(String... value) {
        addEndsWith(InsuranceColumns.INSURANCE_COMPANY, value);
        return this;
    }

    public InsuranceSelection orderByInsuranceCompany(boolean desc) {
        orderBy(InsuranceColumns.INSURANCE_COMPANY, desc);
        return this;
    }

    public InsuranceSelection orderByInsuranceCompany() {
        orderBy(InsuranceColumns.INSURANCE_COMPANY, false);
        return this;
    }

    public InsuranceSelection insurancePrice(double... value) {
        addEquals(InsuranceColumns.INSURANCE_PRICE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection insurancePriceNot(double... value) {
        addNotEquals(InsuranceColumns.INSURANCE_PRICE, toObjectArray(value));
        return this;
    }

    public InsuranceSelection insurancePriceGt(double value) {
        addGreaterThan(InsuranceColumns.INSURANCE_PRICE, value);
        return this;
    }

    public InsuranceSelection insurancePriceGtEq(double value) {
        addGreaterThanOrEquals(InsuranceColumns.INSURANCE_PRICE, value);
        return this;
    }

    public InsuranceSelection insurancePriceLt(double value) {
        addLessThan(InsuranceColumns.INSURANCE_PRICE, value);
        return this;
    }

    public InsuranceSelection insurancePriceLtEq(double value) {
        addLessThanOrEquals(InsuranceColumns.INSURANCE_PRICE, value);
        return this;
    }

    public InsuranceSelection orderByInsurancePrice(boolean desc) {
        orderBy(InsuranceColumns.INSURANCE_PRICE, desc);
        return this;
    }

    public InsuranceSelection orderByInsurancePrice() {
        orderBy(InsuranceColumns.INSURANCE_PRICE, false);
        return this;
    }

    public InsuranceSelection policyNumber(String... value) {
        addEquals(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection policyNumberNot(String... value) {
        addNotEquals(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection policyNumberLike(String... value) {
        addLike(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection policyNumberContains(String... value) {
        addContains(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection policyNumberStartsWith(String... value) {
        addStartsWith(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection policyNumberEndsWith(String... value) {
        addEndsWith(InsuranceColumns.POLICY_NUMBER, value);
        return this;
    }

    public InsuranceSelection orderByPolicyNumber(boolean desc) {
        orderBy(InsuranceColumns.POLICY_NUMBER, desc);
        return this;
    }

    public InsuranceSelection orderByPolicyNumber() {
        orderBy(InsuranceColumns.POLICY_NUMBER, false);
        return this;
    }

    public InsuranceSelection startDate(Date... value) {
        addEquals(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDateNot(Date... value) {
        addNotEquals(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDate(Long... value) {
        addEquals(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDateAfter(Date value) {
        addGreaterThan(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDateAfterEq(Date value) {
        addGreaterThanOrEquals(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDateBefore(Date value) {
        addLessThan(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection startDateBeforeEq(Date value) {
        addLessThanOrEquals(InsuranceColumns.START_DATE, value);
        return this;
    }

    public InsuranceSelection orderByStartDate(boolean desc) {
        orderBy(InsuranceColumns.START_DATE, desc);
        return this;
    }

    public InsuranceSelection orderByStartDate() {
        orderBy(InsuranceColumns.START_DATE, false);
        return this;
    }

    public InsuranceSelection endDate(Date... value) {
        addEquals(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDateNot(Date... value) {
        addNotEquals(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDate(Long... value) {
        addEquals(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDateAfter(Date value) {
        addGreaterThan(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDateAfterEq(Date value) {
        addGreaterThanOrEquals(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDateBefore(Date value) {
        addLessThan(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection endDateBeforeEq(Date value) {
        addLessThanOrEquals(InsuranceColumns.END_DATE, value);
        return this;
    }

    public InsuranceSelection orderByEndDate(boolean desc) {
        orderBy(InsuranceColumns.END_DATE, desc);
        return this;
    }

    public InsuranceSelection orderByEndDate() {
        orderBy(InsuranceColumns.END_DATE, false);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformation(String... value) {
        addEquals(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformationNot(String... value) {
        addNotEquals(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformationLike(String... value) {
        addLike(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformationContains(String... value) {
        addContains(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformationStartsWith(String... value) {
        addStartsWith(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection insuranceAdditionalInformationEndsWith(String... value) {
        addEndsWith(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public InsuranceSelection orderByInsuranceAdditionalInformation(boolean desc) {
        orderBy(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public InsuranceSelection orderByInsuranceAdditionalInformation() {
        orderBy(InsuranceColumns.INSURANCE_ADDITIONAL_INFORMATION, false);
        return this;
    }
}
