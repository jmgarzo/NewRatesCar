package com.jmgarzo.newratescar.provider.refuel;

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
import com.jmgarzo.newratescar.provider.fueltype.*;
import com.jmgarzo.newratescar.provider.fuelsubtype.*;

/**
 * Selection for the {@code refuel} table.
 */
public class RefuelSelection extends AbstractSelection<RefuelSelection> {
    @Override
    protected Uri baseUri() {
        return RefuelColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RefuelCursor} object, which is positioned before the first entry, or null.
     */
    public RefuelCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RefuelCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public RefuelCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code RefuelCursor} object, which is positioned before the first entry, or null.
     */
    public RefuelCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new RefuelCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public RefuelCursor query(Context context) {
        return query(context, null);
    }


    public RefuelSelection id(long... value) {
        addEquals("refuel." + RefuelColumns._ID, toObjectArray(value));
        return this;
    }

    public RefuelSelection idNot(long... value) {
        addNotEquals("refuel." + RefuelColumns._ID, toObjectArray(value));
        return this;
    }

    public RefuelSelection orderById(boolean desc) {
        orderBy("refuel." + RefuelColumns._ID, desc);
        return this;
    }

    public RefuelSelection orderById() {
        return orderById(false);
    }

    public RefuelSelection vehicleId(long... value) {
        addEquals(RefuelColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleIdNot(long... value) {
        addNotEquals(RefuelColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleIdGt(long value) {
        addGreaterThan(RefuelColumns.VEHICLE_ID, value);
        return this;
    }

    public RefuelSelection vehicleIdGtEq(long value) {
        addGreaterThanOrEquals(RefuelColumns.VEHICLE_ID, value);
        return this;
    }

    public RefuelSelection vehicleIdLt(long value) {
        addLessThan(RefuelColumns.VEHICLE_ID, value);
        return this;
    }

    public RefuelSelection vehicleIdLtEq(long value) {
        addLessThanOrEquals(RefuelColumns.VEHICLE_ID, value);
        return this;
    }

    public RefuelSelection orderByVehicleId(boolean desc) {
        orderBy(RefuelColumns.VEHICLE_ID, desc);
        return this;
    }

    public RefuelSelection orderByVehicleId() {
        orderBy(RefuelColumns.VEHICLE_ID, false);
        return this;
    }

    public RefuelSelection vehicleVehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public RefuelSelection vehicleVehicleClass(long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleVehicleClassNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleVehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection vehicleVehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public RefuelSelection vehicleVehicleFuelType(long... value) {
        addEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleVehicleFuelTypeNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleVehicleFuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection vehicleVehicleFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection vehicleVehicleFuelTypeLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection vehicleVehicleFuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleFuelType(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, desc);
        return this;
    }

    public RefuelSelection orderByVehicleVehicleFuelType() {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, false);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleFuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection orderByVehicleFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public RefuelSelection orderByVehicleFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public RefuelSelection vehicleMake(long... value) {
        addEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleMakeNot(long... value) {
        addNotEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public RefuelSelection vehicleMakeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public RefuelSelection vehicleMakeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public RefuelSelection vehicleMakeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public RefuelSelection vehicleMakeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public RefuelSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public RefuelSelection orderByVehicleMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public RefuelSelection vehicleMakeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleMakeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleMakeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleMakeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleMakeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection vehicleMakeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public RefuelSelection orderByVehicleMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public RefuelSelection orderByVehicleMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public RefuelSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public RefuelSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public RefuelSelection orderByVehicleModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public RefuelSelection vehicleMileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection vehicleMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection vehicleMileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection vehicleMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection vehicleMileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection vehicleMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public RefuelSelection orderByVehicleMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public RefuelSelection orderByVehicleMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection vehicleAdditionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection orderByVehicleAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public RefuelSelection orderByVehicleAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }

    public RefuelSelection refuelDate(Date... value) {
        addEquals(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection refuelDateNot(Date... value) {
        addNotEquals(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection refuelDate(long... value) {
        addEquals(RefuelColumns.REFUEL_DATE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelDateAfter(Date value) {
        addGreaterThan(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection refuelDateAfterEq(Date value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection refuelDateBefore(Date value) {
        addLessThan(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection refuelDateBeforeEq(Date value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_DATE, value);
        return this;
    }

    public RefuelSelection orderByRefuelDate(boolean desc) {
        orderBy(RefuelColumns.REFUEL_DATE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelDate() {
        orderBy(RefuelColumns.REFUEL_DATE, false);
        return this;
    }

    public RefuelSelection refuelFuelType(long... value) {
        addEquals(RefuelColumns.REFUEL_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelFuelTypeNot(long... value) {
        addNotEquals(RefuelColumns.REFUEL_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelFuelTypeGt(long value) {
        addGreaterThan(RefuelColumns.REFUEL_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelTypeLt(long value) {
        addLessThan(RefuelColumns.REFUEL_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelTypeLtEq(long value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_FUEL_TYPE, value);
        return this;
    }

    public RefuelSelection orderByRefuelFuelType(boolean desc) {
        orderBy(RefuelColumns.REFUEL_FUEL_TYPE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelFuelType() {
        orderBy(RefuelColumns.REFUEL_FUEL_TYPE, false);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public RefuelSelection orderByFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public RefuelSelection orderByFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public RefuelSelection refuelFuelSubtype(Long... value) {
        addEquals(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelSubtypeNot(Long... value) {
        addNotEquals(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelSubtypeGt(long value) {
        addGreaterThan(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelSubtypeGtEq(long value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelSubtypeLt(long value) {
        addLessThan(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection refuelFuelSubtypeLtEq(long value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_FUEL_SUBTYPE, value);
        return this;
    }

    public RefuelSelection orderByRefuelFuelSubtype(boolean desc) {
        orderBy(RefuelColumns.REFUEL_FUEL_SUBTYPE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelFuelSubtype() {
        orderBy(RefuelColumns.REFUEL_FUEL_SUBTYPE, false);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeName(String... value) {
        addEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeNameNot(String... value) {
        addNotEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeNameLike(String... value) {
        addLike(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeNameContains(String... value) {
        addContains(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeNameStartsWith(String... value) {
        addStartsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection fuelSubtypeFuelSubtypeNameEndsWith(String... value) {
        addEndsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public RefuelSelection orderByFuelSubtypeFuelSubtypeName(boolean desc) {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, desc);
        return this;
    }

    public RefuelSelection orderByFuelSubtypeFuelSubtypeName() {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, false);
        return this;
    }

    public RefuelSelection refuelMileage(int... value) {
        addEquals(RefuelColumns.REFUEL_MILEAGE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelMileageNot(int... value) {
        addNotEquals(RefuelColumns.REFUEL_MILEAGE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelMileageGt(int value) {
        addGreaterThan(RefuelColumns.REFUEL_MILEAGE, value);
        return this;
    }

    public RefuelSelection refuelMileageGtEq(int value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_MILEAGE, value);
        return this;
    }

    public RefuelSelection refuelMileageLt(int value) {
        addLessThan(RefuelColumns.REFUEL_MILEAGE, value);
        return this;
    }

    public RefuelSelection refuelMileageLtEq(int value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_MILEAGE, value);
        return this;
    }

    public RefuelSelection orderByRefuelMileage(boolean desc) {
        orderBy(RefuelColumns.REFUEL_MILEAGE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelMileage() {
        orderBy(RefuelColumns.REFUEL_MILEAGE, false);
        return this;
    }

    public RefuelSelection refuelTripOdometer(int... value) {
        addEquals(RefuelColumns.REFUEL_TRIP_ODOMETER, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelTripOdometerNot(int... value) {
        addNotEquals(RefuelColumns.REFUEL_TRIP_ODOMETER, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelTripOdometerGt(int value) {
        addGreaterThan(RefuelColumns.REFUEL_TRIP_ODOMETER, value);
        return this;
    }

    public RefuelSelection refuelTripOdometerGtEq(int value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_TRIP_ODOMETER, value);
        return this;
    }

    public RefuelSelection refuelTripOdometerLt(int value) {
        addLessThan(RefuelColumns.REFUEL_TRIP_ODOMETER, value);
        return this;
    }

    public RefuelSelection refuelTripOdometerLtEq(int value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_TRIP_ODOMETER, value);
        return this;
    }

    public RefuelSelection orderByRefuelTripOdometer(boolean desc) {
        orderBy(RefuelColumns.REFUEL_TRIP_ODOMETER, desc);
        return this;
    }

    public RefuelSelection orderByRefuelTripOdometer() {
        orderBy(RefuelColumns.REFUEL_TRIP_ODOMETER, false);
        return this;
    }

    public RefuelSelection refuelLitres(float... value) {
        addEquals(RefuelColumns.REFUEL_LITRES, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelLitresNot(float... value) {
        addNotEquals(RefuelColumns.REFUEL_LITRES, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelLitresGt(float value) {
        addGreaterThan(RefuelColumns.REFUEL_LITRES, value);
        return this;
    }

    public RefuelSelection refuelLitresGtEq(float value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_LITRES, value);
        return this;
    }

    public RefuelSelection refuelLitresLt(float value) {
        addLessThan(RefuelColumns.REFUEL_LITRES, value);
        return this;
    }

    public RefuelSelection refuelLitresLtEq(float value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_LITRES, value);
        return this;
    }

    public RefuelSelection orderByRefuelLitres(boolean desc) {
        orderBy(RefuelColumns.REFUEL_LITRES, desc);
        return this;
    }

    public RefuelSelection orderByRefuelLitres() {
        orderBy(RefuelColumns.REFUEL_LITRES, false);
        return this;
    }

    public RefuelSelection refuelGasPrice(float... value) {
        addEquals(RefuelColumns.REFUEL_GAS_PRICE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelGasPriceNot(float... value) {
        addNotEquals(RefuelColumns.REFUEL_GAS_PRICE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelGasPriceGt(float value) {
        addGreaterThan(RefuelColumns.REFUEL_GAS_PRICE, value);
        return this;
    }

    public RefuelSelection refuelGasPriceGtEq(float value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_GAS_PRICE, value);
        return this;
    }

    public RefuelSelection refuelGasPriceLt(float value) {
        addLessThan(RefuelColumns.REFUEL_GAS_PRICE, value);
        return this;
    }

    public RefuelSelection refuelGasPriceLtEq(float value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_GAS_PRICE, value);
        return this;
    }

    public RefuelSelection orderByRefuelGasPrice(boolean desc) {
        orderBy(RefuelColumns.REFUEL_GAS_PRICE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelGasPrice() {
        orderBy(RefuelColumns.REFUEL_GAS_PRICE, false);
        return this;
    }

    public RefuelSelection refuelTotalPrice(float... value) {
        addEquals(RefuelColumns.REFUEL_TOTAL_PRICE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelTotalPriceNot(float... value) {
        addNotEquals(RefuelColumns.REFUEL_TOTAL_PRICE, toObjectArray(value));
        return this;
    }

    public RefuelSelection refuelTotalPriceGt(float value) {
        addGreaterThan(RefuelColumns.REFUEL_TOTAL_PRICE, value);
        return this;
    }

    public RefuelSelection refuelTotalPriceGtEq(float value) {
        addGreaterThanOrEquals(RefuelColumns.REFUEL_TOTAL_PRICE, value);
        return this;
    }

    public RefuelSelection refuelTotalPriceLt(float value) {
        addLessThan(RefuelColumns.REFUEL_TOTAL_PRICE, value);
        return this;
    }

    public RefuelSelection refuelTotalPriceLtEq(float value) {
        addLessThanOrEquals(RefuelColumns.REFUEL_TOTAL_PRICE, value);
        return this;
    }

    public RefuelSelection orderByRefuelTotalPrice(boolean desc) {
        orderBy(RefuelColumns.REFUEL_TOTAL_PRICE, desc);
        return this;
    }

    public RefuelSelection orderByRefuelTotalPrice() {
        orderBy(RefuelColumns.REFUEL_TOTAL_PRICE, false);
        return this;
    }

    public RefuelSelection isFull(boolean value) {
        addEquals(RefuelColumns.IS_FULL, toObjectArray(value));
        return this;
    }

    public RefuelSelection orderByIsFull(boolean desc) {
        orderBy(RefuelColumns.IS_FULL, desc);
        return this;
    }

    public RefuelSelection orderByIsFull() {
        orderBy(RefuelColumns.IS_FULL, false);
        return this;
    }

    public RefuelSelection isTrailer(boolean value) {
        addEquals(RefuelColumns.IS_TRAILER, toObjectArray(value));
        return this;
    }

    public RefuelSelection orderByIsTrailer(boolean desc) {
        orderBy(RefuelColumns.IS_TRAILER, desc);
        return this;
    }

    public RefuelSelection orderByIsTrailer() {
        orderBy(RefuelColumns.IS_TRAILER, false);
        return this;
    }

    public RefuelSelection isRoofRack(boolean value) {
        addEquals(RefuelColumns.IS_ROOF_RACK, toObjectArray(value));
        return this;
    }

    public RefuelSelection orderByIsRoofRack(boolean desc) {
        orderBy(RefuelColumns.IS_ROOF_RACK, desc);
        return this;
    }

    public RefuelSelection orderByIsRoofRack() {
        orderBy(RefuelColumns.IS_ROOF_RACK, false);
        return this;
    }

    public RefuelSelection routeType(int... value) {
        addEquals(RefuelColumns.ROUTE_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection routeTypeNot(int... value) {
        addNotEquals(RefuelColumns.ROUTE_TYPE, toObjectArray(value));
        return this;
    }

    public RefuelSelection routeTypeGt(int value) {
        addGreaterThan(RefuelColumns.ROUTE_TYPE, value);
        return this;
    }

    public RefuelSelection routeTypeGtEq(int value) {
        addGreaterThanOrEquals(RefuelColumns.ROUTE_TYPE, value);
        return this;
    }

    public RefuelSelection routeTypeLt(int value) {
        addLessThan(RefuelColumns.ROUTE_TYPE, value);
        return this;
    }

    public RefuelSelection routeTypeLtEq(int value) {
        addLessThanOrEquals(RefuelColumns.ROUTE_TYPE, value);
        return this;
    }

    public RefuelSelection orderByRouteType(boolean desc) {
        orderBy(RefuelColumns.ROUTE_TYPE, desc);
        return this;
    }

    public RefuelSelection orderByRouteType() {
        orderBy(RefuelColumns.ROUTE_TYPE, false);
        return this;
    }

    public RefuelSelection drivingStyle(int... value) {
        addEquals(RefuelColumns.DRIVING_STYLE, toObjectArray(value));
        return this;
    }

    public RefuelSelection drivingStyleNot(int... value) {
        addNotEquals(RefuelColumns.DRIVING_STYLE, toObjectArray(value));
        return this;
    }

    public RefuelSelection drivingStyleGt(int value) {
        addGreaterThan(RefuelColumns.DRIVING_STYLE, value);
        return this;
    }

    public RefuelSelection drivingStyleGtEq(int value) {
        addGreaterThanOrEquals(RefuelColumns.DRIVING_STYLE, value);
        return this;
    }

    public RefuelSelection drivingStyleLt(int value) {
        addLessThan(RefuelColumns.DRIVING_STYLE, value);
        return this;
    }

    public RefuelSelection drivingStyleLtEq(int value) {
        addLessThanOrEquals(RefuelColumns.DRIVING_STYLE, value);
        return this;
    }

    public RefuelSelection orderByDrivingStyle(boolean desc) {
        orderBy(RefuelColumns.DRIVING_STYLE, desc);
        return this;
    }

    public RefuelSelection orderByDrivingStyle() {
        orderBy(RefuelColumns.DRIVING_STYLE, false);
        return this;
    }

    public RefuelSelection averageSpeed(Float... value) {
        addEquals(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection averageSpeedNot(Float... value) {
        addNotEquals(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection averageSpeedGt(float value) {
        addGreaterThan(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection averageSpeedGtEq(float value) {
        addGreaterThanOrEquals(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection averageSpeedLt(float value) {
        addLessThan(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection averageSpeedLtEq(float value) {
        addLessThanOrEquals(RefuelColumns.AVERAGE_SPEED, value);
        return this;
    }

    public RefuelSelection orderByAverageSpeed(boolean desc) {
        orderBy(RefuelColumns.AVERAGE_SPEED, desc);
        return this;
    }

    public RefuelSelection orderByAverageSpeed() {
        orderBy(RefuelColumns.AVERAGE_SPEED, false);
        return this;
    }

    public RefuelSelection averageConsumption(float... value) {
        addEquals(RefuelColumns.AVERAGE_CONSUMPTION, toObjectArray(value));
        return this;
    }

    public RefuelSelection averageConsumptionNot(float... value) {
        addNotEquals(RefuelColumns.AVERAGE_CONSUMPTION, toObjectArray(value));
        return this;
    }

    public RefuelSelection averageConsumptionGt(float value) {
        addGreaterThan(RefuelColumns.AVERAGE_CONSUMPTION, value);
        return this;
    }

    public RefuelSelection averageConsumptionGtEq(float value) {
        addGreaterThanOrEquals(RefuelColumns.AVERAGE_CONSUMPTION, value);
        return this;
    }

    public RefuelSelection averageConsumptionLt(float value) {
        addLessThan(RefuelColumns.AVERAGE_CONSUMPTION, value);
        return this;
    }

    public RefuelSelection averageConsumptionLtEq(float value) {
        addLessThanOrEquals(RefuelColumns.AVERAGE_CONSUMPTION, value);
        return this;
    }

    public RefuelSelection orderByAverageConsumption(boolean desc) {
        orderBy(RefuelColumns.AVERAGE_CONSUMPTION, desc);
        return this;
    }

    public RefuelSelection orderByAverageConsumption() {
        orderBy(RefuelColumns.AVERAGE_CONSUMPTION, false);
        return this;
    }

    public RefuelSelection paymentType(String... value) {
        addEquals(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection paymentTypeNot(String... value) {
        addNotEquals(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection paymentTypeLike(String... value) {
        addLike(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection paymentTypeContains(String... value) {
        addContains(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection paymentTypeStartsWith(String... value) {
        addStartsWith(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection paymentTypeEndsWith(String... value) {
        addEndsWith(RefuelColumns.PAYMENT_TYPE, value);
        return this;
    }

    public RefuelSelection orderByPaymentType(boolean desc) {
        orderBy(RefuelColumns.PAYMENT_TYPE, desc);
        return this;
    }

    public RefuelSelection orderByPaymentType() {
        orderBy(RefuelColumns.PAYMENT_TYPE, false);
        return this;
    }

    public RefuelSelection gasStation(String... value) {
        addEquals(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection gasStationNot(String... value) {
        addNotEquals(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection gasStationLike(String... value) {
        addLike(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection gasStationContains(String... value) {
        addContains(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection gasStationStartsWith(String... value) {
        addStartsWith(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection gasStationEndsWith(String... value) {
        addEndsWith(RefuelColumns.GAS_STATION, value);
        return this;
    }

    public RefuelSelection orderByGasStation(boolean desc) {
        orderBy(RefuelColumns.GAS_STATION, desc);
        return this;
    }

    public RefuelSelection orderByGasStation() {
        orderBy(RefuelColumns.GAS_STATION, false);
        return this;
    }

    public RefuelSelection refuelAdditionalInformation(String... value) {
        addEquals(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection refuelAdditionalInformationNot(String... value) {
        addNotEquals(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection refuelAdditionalInformationLike(String... value) {
        addLike(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection refuelAdditionalInformationContains(String... value) {
        addContains(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection refuelAdditionalInformationStartsWith(String... value) {
        addStartsWith(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection refuelAdditionalInformationEndsWith(String... value) {
        addEndsWith(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public RefuelSelection orderByRefuelAdditionalInformation(boolean desc) {
        orderBy(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public RefuelSelection orderByRefuelAdditionalInformation() {
        orderBy(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION, false);
        return this;
    }
}
