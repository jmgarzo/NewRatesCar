package com.jmgarzo.newratescar.provider.vehicle;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;
import com.jmgarzo.newratescar.provider.vehicleclass.*;
import com.jmgarzo.newratescar.provider.fueltype.*;
import com.jmgarzo.newratescar.provider.fuelsubtype.*;
import com.jmgarzo.newratescar.provider.make.*;

/**
 * Selection for the {@code vehicle} table.
 */
public class VehicleSelection extends AbstractSelection<VehicleSelection> {
    @Override
    protected Uri baseUri() {
        return VehicleColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public VehicleCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code VehicleCursor} object, which is positioned before the first entry, or null.
     */
    public VehicleCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new VehicleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public VehicleCursor query(Context context) {
        return query(context, null);
    }


    public VehicleSelection id(long... value) {
        addEquals("vehicle." + VehicleColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleSelection idNot(long... value) {
        addNotEquals("vehicle." + VehicleColumns._ID, toObjectArray(value));
        return this;
    }

    public VehicleSelection orderById(boolean desc) {
        orderBy("vehicle." + VehicleColumns._ID, desc);
        return this;
    }

    public VehicleSelection orderById() {
        return orderById(false);
    }

    public VehicleSelection vehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection vehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection vehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection vehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection vehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection vehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public VehicleSelection orderByVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public VehicleSelection orderByVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public VehicleSelection vehicleClass(Long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection vehicleClassNot(Long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection vehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection vehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection vehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection vehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public VehicleSelection orderByVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public VehicleSelection orderByVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection vehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public VehicleSelection orderByVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public VehicleSelection orderByVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public VehicleSelection fuelType(Long... value) {
        addEquals(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeNot(Long... value) {
        addNotEquals(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeLt(long value) {
        addLessThan(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.FUEL_TYPE, value);
        return this;
    }

    public VehicleSelection orderByFuelType(boolean desc) {
        orderBy(VehicleColumns.FUEL_TYPE, desc);
        return this;
    }

    public VehicleSelection orderByFuelType() {
        orderBy(VehicleColumns.FUEL_TYPE, false);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtype(Long... value) {
        addEquals(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeNot(Long... value) {
        addNotEquals(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeGt(long value) {
        addGreaterThan(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeGtEq(long value) {
        addGreaterThanOrEquals(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeLt(long value) {
        addLessThan(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeLtEq(long value) {
        addLessThanOrEquals(FuelTypeColumns.FUEL_SUBTYPE, value);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelSubtype(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_SUBTYPE, desc);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelSubtype() {
        orderBy(FuelTypeColumns.FUEL_SUBTYPE, false);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeName(String... value) {
        addEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeNameNot(String... value) {
        addNotEquals(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeNameLike(String... value) {
        addLike(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeNameContains(String... value) {
        addContains(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeNameStartsWith(String... value) {
        addStartsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection fuelTypeFuelSubtypeFuelSubtypeNameEndsWith(String... value) {
        addEndsWith(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, value);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelSubtypeFuelSubtypeName(boolean desc) {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, desc);
        return this;
    }

    public VehicleSelection orderByFuelTypeFuelSubtypeFuelSubtypeName() {
        orderBy(FuelSubtypeColumns.FUEL_SUBTYPE_NAME, false);
        return this;
    }

    public VehicleSelection make(Long... value) {
        addEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection makeNot(Long... value) {
        addNotEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection makeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection makeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection makeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection makeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public VehicleSelection orderByMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public VehicleSelection orderByMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public VehicleSelection makeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection makeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection makeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection makeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection makeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection makeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public VehicleSelection orderByMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public VehicleSelection orderByMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public VehicleSelection model(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection modelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection modelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection modelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection modelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection modelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public VehicleSelection orderByModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public VehicleSelection orderByModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public VehicleSelection mileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection mileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection mileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection mileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection mileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection mileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public VehicleSelection orderByMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public VehicleSelection orderByMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public VehicleSelection additionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection additionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection additionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection additionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection additionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection additionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public VehicleSelection orderByAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public VehicleSelection orderByAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }
}
