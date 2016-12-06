package com.jmgarzo.newratescar.provider.toll;

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
 * Selection for the {@code toll} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class TollSelection extends AbstractSelection<TollSelection> {
    @Override
    protected Uri baseUri() {
        return TollColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TollCursor} object, which is positioned before the first entry, or null.
     */
    public TollCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TollCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public TollCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code TollCursor} object, which is positioned before the first entry, or null.
     */
    public TollCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new TollCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public TollCursor query(Context context) {
        return query(context, null);
    }


    public TollSelection id(long... value) {
        addEquals("toll." + TollColumns._ID, toObjectArray(value));
        return this;
    }

    public TollSelection idNot(long... value) {
        addNotEquals("toll." + TollColumns._ID, toObjectArray(value));
        return this;
    }

    public TollSelection orderById(boolean desc) {
        orderBy("toll." + TollColumns._ID, desc);
        return this;
    }

    public TollSelection orderById() {
        return orderById(false);
    }

    public TollSelection vehicleId(long... value) {
        addEquals(TollColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleIdNot(long... value) {
        addNotEquals(TollColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleIdGt(long value) {
        addGreaterThan(TollColumns.VEHICLE_ID, value);
        return this;
    }

    public TollSelection vehicleIdGtEq(long value) {
        addGreaterThanOrEquals(TollColumns.VEHICLE_ID, value);
        return this;
    }

    public TollSelection vehicleIdLt(long value) {
        addLessThan(TollColumns.VEHICLE_ID, value);
        return this;
    }

    public TollSelection vehicleIdLtEq(long value) {
        addLessThanOrEquals(TollColumns.VEHICLE_ID, value);
        return this;
    }

    public TollSelection orderByVehicleId(boolean desc) {
        orderBy(TollColumns.VEHICLE_ID, desc);
        return this;
    }

    public TollSelection orderByVehicleId() {
        orderBy(TollColumns.VEHICLE_ID, false);
        return this;
    }

    public TollSelection vehicleVehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public TollSelection orderByVehicleVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public TollSelection orderByVehicleVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public TollSelection vehicleVehicleClass(long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleVehicleClassNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleVehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public TollSelection vehicleVehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public TollSelection vehicleVehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public TollSelection vehicleVehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public TollSelection orderByVehicleVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public TollSelection orderByVehicleVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection vehicleVehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public TollSelection orderByVehicleVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public TollSelection orderByVehicleVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public TollSelection vehicleVehicleFuelType(long... value) {
        addEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleVehicleFuelTypeNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleVehicleFuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public TollSelection vehicleVehicleFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public TollSelection vehicleVehicleFuelTypeLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public TollSelection vehicleVehicleFuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public TollSelection orderByVehicleVehicleFuelType(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, desc);
        return this;
    }

    public TollSelection orderByVehicleVehicleFuelType() {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, false);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection vehicleFuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public TollSelection orderByVehicleFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public TollSelection orderByVehicleFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public TollSelection vehicleMake(long... value) {
        addEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleMakeNot(long... value) {
        addNotEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public TollSelection vehicleMakeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public TollSelection vehicleMakeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public TollSelection vehicleMakeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public TollSelection vehicleMakeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public TollSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public TollSelection orderByVehicleMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public TollSelection vehicleMakeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection vehicleMakeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection vehicleMakeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection vehicleMakeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection vehicleMakeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection vehicleMakeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public TollSelection orderByVehicleMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public TollSelection orderByVehicleMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public TollSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public TollSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public TollSelection orderByVehicleModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public TollSelection vehicleMileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection vehicleMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection vehicleMileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection vehicleMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection vehicleMileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection vehicleMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public TollSelection orderByVehicleMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public TollSelection orderByVehicleMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public TollSelection vehicleAdditionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection vehicleAdditionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection vehicleAdditionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection vehicleAdditionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection vehicleAdditionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection vehicleAdditionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection orderByVehicleAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public TollSelection orderByVehicleAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }

    public TollSelection tollDate(Date... value) {
        addEquals(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection tollDateNot(Date... value) {
        addNotEquals(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection tollDate(long... value) {
        addEquals(TollColumns.TOLL_DATE, toObjectArray(value));
        return this;
    }

    public TollSelection tollDateAfter(Date value) {
        addGreaterThan(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection tollDateAfterEq(Date value) {
        addGreaterThanOrEquals(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection tollDateBefore(Date value) {
        addLessThan(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection tollDateBeforeEq(Date value) {
        addLessThanOrEquals(TollColumns.TOLL_DATE, value);
        return this;
    }

    public TollSelection orderByTollDate(boolean desc) {
        orderBy(TollColumns.TOLL_DATE, desc);
        return this;
    }

    public TollSelection orderByTollDate() {
        orderBy(TollColumns.TOLL_DATE, false);
        return this;
    }

    public TollSelection tollPrice(double... value) {
        addEquals(TollColumns.TOLL_PRICE, toObjectArray(value));
        return this;
    }

    public TollSelection tollPriceNot(double... value) {
        addNotEquals(TollColumns.TOLL_PRICE, toObjectArray(value));
        return this;
    }

    public TollSelection tollPriceGt(double value) {
        addGreaterThan(TollColumns.TOLL_PRICE, value);
        return this;
    }

    public TollSelection tollPriceGtEq(double value) {
        addGreaterThanOrEquals(TollColumns.TOLL_PRICE, value);
        return this;
    }

    public TollSelection tollPriceLt(double value) {
        addLessThan(TollColumns.TOLL_PRICE, value);
        return this;
    }

    public TollSelection tollPriceLtEq(double value) {
        addLessThanOrEquals(TollColumns.TOLL_PRICE, value);
        return this;
    }

    public TollSelection orderByTollPrice(boolean desc) {
        orderBy(TollColumns.TOLL_PRICE, desc);
        return this;
    }

    public TollSelection orderByTollPrice() {
        orderBy(TollColumns.TOLL_PRICE, false);
        return this;
    }

    public TollSelection tollName(String... value) {
        addEquals(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection tollNameNot(String... value) {
        addNotEquals(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection tollNameLike(String... value) {
        addLike(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection tollNameContains(String... value) {
        addContains(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection tollNameStartsWith(String... value) {
        addStartsWith(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection tollNameEndsWith(String... value) {
        addEndsWith(TollColumns.TOLL_NAME, value);
        return this;
    }

    public TollSelection orderByTollName(boolean desc) {
        orderBy(TollColumns.TOLL_NAME, desc);
        return this;
    }

    public TollSelection orderByTollName() {
        orderBy(TollColumns.TOLL_NAME, false);
        return this;
    }

    public TollSelection tollRoad(String... value) {
        addEquals(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection tollRoadNot(String... value) {
        addNotEquals(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection tollRoadLike(String... value) {
        addLike(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection tollRoadContains(String... value) {
        addContains(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection tollRoadStartsWith(String... value) {
        addStartsWith(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection tollRoadEndsWith(String... value) {
        addEndsWith(TollColumns.TOLL_ROAD, value);
        return this;
    }

    public TollSelection orderByTollRoad(boolean desc) {
        orderBy(TollColumns.TOLL_ROAD, desc);
        return this;
    }

    public TollSelection orderByTollRoad() {
        orderBy(TollColumns.TOLL_ROAD, false);
        return this;
    }

    public TollSelection tollDirection(String... value) {
        addEquals(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection tollDirectionNot(String... value) {
        addNotEquals(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection tollDirectionLike(String... value) {
        addLike(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection tollDirectionContains(String... value) {
        addContains(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection tollDirectionStartsWith(String... value) {
        addStartsWith(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection tollDirectionEndsWith(String... value) {
        addEndsWith(TollColumns.TOLL_DIRECTION, value);
        return this;
    }

    public TollSelection orderByTollDirection(boolean desc) {
        orderBy(TollColumns.TOLL_DIRECTION, desc);
        return this;
    }

    public TollSelection orderByTollDirection() {
        orderBy(TollColumns.TOLL_DIRECTION, false);
        return this;
    }

    public TollSelection tollLocation(String... value) {
        addEquals(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection tollLocationNot(String... value) {
        addNotEquals(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection tollLocationLike(String... value) {
        addLike(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection tollLocationContains(String... value) {
        addContains(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection tollLocationStartsWith(String... value) {
        addStartsWith(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection tollLocationEndsWith(String... value) {
        addEndsWith(TollColumns.TOLL_LOCATION, value);
        return this;
    }

    public TollSelection orderByTollLocation(boolean desc) {
        orderBy(TollColumns.TOLL_LOCATION, desc);
        return this;
    }

    public TollSelection orderByTollLocation() {
        orderBy(TollColumns.TOLL_LOCATION, false);
        return this;
    }

    public TollSelection tollAdditionalInformation(String... value) {
        addEquals(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection tollAdditionalInformationNot(String... value) {
        addNotEquals(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection tollAdditionalInformationLike(String... value) {
        addLike(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection tollAdditionalInformationContains(String... value) {
        addContains(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection tollAdditionalInformationStartsWith(String... value) {
        addStartsWith(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection tollAdditionalInformationEndsWith(String... value) {
        addEndsWith(TollColumns.TOLL_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public TollSelection orderByTollAdditionalInformation(boolean desc) {
        orderBy(TollColumns.TOLL_ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public TollSelection orderByTollAdditionalInformation() {
        orderBy(TollColumns.TOLL_ADDITIONAL_INFORMATION, false);
        return this;
    }
}
