package com.jmgarzo.newratescar.provider.roadworthiness;

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
 * Selection for the {@code roadworthiness} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class RoadworthinessSelection extends AbstractSelection<RoadworthinessSelection> {
    @Override
    protected Uri baseUri() {
        return RoadworthinessColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RoadworthinessCursor} object, which is positioned before the first entry, or null.
     */
    public RoadworthinessCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RoadworthinessCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public RoadworthinessCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RoadworthinessCursor} object, which is positioned before the first entry, or null.
     */
    public RoadworthinessCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RoadworthinessCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public RoadworthinessCursor query(Context context) {
        return query(context, null);
    }


    public RoadworthinessSelection id(long... value) {
        addEquals("roadworthiness." + RoadworthinessColumns._ID, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection idNot(long... value) {
        addNotEquals("roadworthiness." + RoadworthinessColumns._ID, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection orderById(boolean desc) {
        orderBy("roadworthiness." + RoadworthinessColumns._ID, desc);
        return this;
    }

    public RoadworthinessSelection orderById() {
        return orderById(false);
    }

    public RoadworthinessSelection vehicleId(long... value) {
        addEquals(RoadworthinessColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleIdNot(long... value) {
        addNotEquals(RoadworthinessColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleIdGt(long value) {
        addGreaterThan(RoadworthinessColumns.VEHICLE_ID, value);
        return this;
    }

    public RoadworthinessSelection vehicleIdGtEq(long value) {
        addGreaterThanOrEquals(RoadworthinessColumns.VEHICLE_ID, value);
        return this;
    }

    public RoadworthinessSelection vehicleIdLt(long value) {
        addLessThan(RoadworthinessColumns.VEHICLE_ID, value);
        return this;
    }

    public RoadworthinessSelection vehicleIdLtEq(long value) {
        addLessThanOrEquals(RoadworthinessColumns.VEHICLE_ID, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleId(boolean desc) {
        orderBy(RoadworthinessColumns.VEHICLE_ID, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleId() {
        orderBy(RoadworthinessColumns.VEHICLE_ID, false);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClass(long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelType(long... value) {
        addEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelTypeNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelTypeLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RoadworthinessSelection vehicleVehicleFuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleFuelType(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleVehicleFuelType() {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, false);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleFuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public RoadworthinessSelection vehicleMake(long... value) {
        addEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleMakeNot(long... value) {
        addNotEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection vehicleMakeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection vehicleMakeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public RoadworthinessSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public RoadworthinessSelection vehicleMileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection vehicleMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection vehicleAdditionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection orderByVehicleAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public RoadworthinessSelection orderByVehicleAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessDate(Date... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessDateNot(Date... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessDate(long... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_DATE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessDateAfter(Date value) {
        addGreaterThan(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessDateAfterEq(Date value) {
        addGreaterThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessDateBefore(Date value) {
        addLessThan(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessDateBeforeEq(Date value) {
        addLessThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_DATE, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessDate(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_DATE, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessDate() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_DATE, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessMileage(int... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessMileageNot(int... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessMileageGt(int value) {
        addGreaterThan(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessMileageGtEq(int value) {
        addGreaterThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessMileageLt(int value) {
        addLessThan(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessMileageLtEq(int value) {
        addLessThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessMileage(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessMileage() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_MILEAGE, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessPrice(double... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_PRICE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessPriceNot(double... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_PRICE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessPriceGt(double value) {
        addGreaterThan(RoadworthinessColumns.ROADWORTHINESS_PRICE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessPriceGtEq(double value) {
        addGreaterThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_PRICE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessPriceLt(double value) {
        addLessThan(RoadworthinessColumns.ROADWORTHINESS_PRICE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessPriceLtEq(double value) {
        addLessThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_PRICE, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessPrice(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_PRICE, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessPrice() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_PRICE, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessResult(String... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessResultNot(String... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessResultLike(String... value) {
        addLike(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessResultContains(String... value) {
        addContains(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessResultStartsWith(String... value) {
        addStartsWith(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessResultEndsWith(String... value) {
        addEndsWith(RoadworthinessColumns.ROADWORTHINESS_RESULT, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessResult(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_RESULT, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessResult() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_RESULT, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDate(Date... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDateNot(Date... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDate(long... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, toObjectArray(value));
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDateAfter(Date value) {
        addGreaterThan(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDateAfterEq(Date value) {
        addGreaterThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDateBefore(Date value) {
        addLessThan(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessNextDateBeforeEq(Date value) {
        addLessThanOrEquals(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessNextDate(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessNextDate() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE, false);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformation(String... value) {
        addEquals(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformationNot(String... value) {
        addNotEquals(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformationLike(String... value) {
        addLike(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformationContains(String... value) {
        addContains(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformationStartsWith(String... value) {
        addStartsWith(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection roadworthinessAdditionalInformationEndsWith(String... value) {
        addEndsWith(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessAdditionalInformation(boolean desc) {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public RoadworthinessSelection orderByRoadworthinessAdditionalInformation() {
        orderBy(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION, false);
        return this;
    }
}
