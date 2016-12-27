package com.jmgarzo.newratescar.provider.maintenance;

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
 * Selection for the {@code maintenance} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class MaintenanceSelection extends AbstractSelection<MaintenanceSelection> {
    @Override
    protected Uri baseUri() {
        return MaintenanceColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MaintenanceCursor} object, which is positioned before the first entry, or null.
     */
    public MaintenanceCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MaintenanceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MaintenanceCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MaintenanceCursor} object, which is positioned before the first entry, or null.
     */
    public MaintenanceCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MaintenanceCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MaintenanceCursor query(Context context) {
        return query(context, null);
    }


    public MaintenanceSelection id(long... value) {
        addEquals("maintenance." + MaintenanceColumns._ID, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection idNot(long... value) {
        addNotEquals("maintenance." + MaintenanceColumns._ID, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection orderById(boolean desc) {
        orderBy("maintenance." + MaintenanceColumns._ID, desc);
        return this;
    }

    public MaintenanceSelection orderById() {
        return orderById(false);
    }

    public MaintenanceSelection vehicleId(long... value) {
        addEquals(MaintenanceColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleIdNot(long... value) {
        addNotEquals(MaintenanceColumns.VEHICLE_ID, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleIdGt(long value) {
        addGreaterThan(MaintenanceColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceSelection vehicleIdGtEq(long value) {
        addGreaterThanOrEquals(MaintenanceColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceSelection vehicleIdLt(long value) {
        addLessThan(MaintenanceColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceSelection vehicleIdLtEq(long value) {
        addLessThanOrEquals(MaintenanceColumns.VEHICLE_ID, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleId(boolean desc) {
        orderBy(MaintenanceColumns.VEHICLE_ID, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleId() {
        orderBy(MaintenanceColumns.VEHICLE_ID, false);
        return this;
    }

    public MaintenanceSelection vehicleVehicleName(String... value) {
        addEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleNameNot(String... value) {
        addNotEquals(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleNameLike(String... value) {
        addLike(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleNameContains(String... value) {
        addContains(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleNameStartsWith(String... value) {
        addStartsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleNameEndsWith(String... value) {
        addEndsWith(VehicleColumns.VEHICLE_NAME, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleName(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_NAME, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleName() {
        orderBy(VehicleColumns.VEHICLE_NAME, false);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClass(long... value) {
        addEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_CLASS, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_CLASS, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleClass(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_CLASS, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleClass() {
        orderBy(VehicleColumns.VEHICLE_CLASS, false);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassName(String... value) {
        addEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassNameNot(String... value) {
        addNotEquals(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassNameLike(String... value) {
        addLike(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassNameContains(String... value) {
        addContains(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassNameStartsWith(String... value) {
        addStartsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleClassVehicleClassNameEndsWith(String... value) {
        addEndsWith(VehicleClassColumns.VEHICLE_CLASS_NAME, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleClassVehicleClassName(boolean desc) {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleClassVehicleClassName() {
        orderBy(VehicleClassColumns.VEHICLE_CLASS_NAME, false);
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelType(long... value) {
        addEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelTypeNot(long... value) {
        addNotEquals(VehicleColumns.VEHICLE_FUEL_TYPE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelTypeGt(long value) {
        addGreaterThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelTypeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelTypeLt(long value) {
        addLessThan(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public MaintenanceSelection vehicleVehicleFuelTypeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.VEHICLE_FUEL_TYPE, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleFuelType(boolean desc) {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleVehicleFuelType() {
        orderBy(VehicleColumns.VEHICLE_FUEL_TYPE, false);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeName(String... value) {
        addEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeNameNot(String... value) {
        addNotEquals(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeNameLike(String... value) {
        addLike(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeNameContains(String... value) {
        addContains(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeNameStartsWith(String... value) {
        addStartsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleFuelTypeFuelTypeNameEndsWith(String... value) {
        addEndsWith(FuelTypeColumns.FUEL_TYPE_NAME, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleFuelTypeFuelTypeName(boolean desc) {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleFuelTypeFuelTypeName() {
        orderBy(FuelTypeColumns.FUEL_TYPE_NAME, false);
        return this;
    }

    public MaintenanceSelection vehicleMake(long... value) {
        addEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleMakeNot(long... value) {
        addNotEquals(VehicleColumns.MAKE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection vehicleMakeGt(long value) {
        addGreaterThan(VehicleColumns.MAKE, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeGtEq(long value) {
        addGreaterThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeLt(long value) {
        addLessThan(VehicleColumns.MAKE, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeLtEq(long value) {
        addLessThanOrEquals(VehicleColumns.MAKE, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleMake(boolean desc) {
        orderBy(VehicleColumns.MAKE, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleMake() {
        orderBy(VehicleColumns.MAKE, false);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection vehicleMakeMakeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleMakeMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleMakeMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }

    public MaintenanceSelection vehicleModel(String... value) {
        addEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection vehicleModelNot(String... value) {
        addNotEquals(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection vehicleModelLike(String... value) {
        addLike(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection vehicleModelContains(String... value) {
        addContains(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection vehicleModelStartsWith(String... value) {
        addStartsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection vehicleModelEndsWith(String... value) {
        addEndsWith(VehicleColumns.MODEL, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleModel(boolean desc) {
        orderBy(VehicleColumns.MODEL, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleModel() {
        orderBy(VehicleColumns.MODEL, false);
        return this;
    }

    public MaintenanceSelection vehicleMileage(Integer... value) {
        addEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection vehicleMileageNot(Integer... value) {
        addNotEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection vehicleMileageGt(int value) {
        addGreaterThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection vehicleMileageGtEq(int value) {
        addGreaterThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection vehicleMileageLt(int value) {
        addLessThan(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection vehicleMileageLtEq(int value) {
        addLessThanOrEquals(VehicleColumns.MILEAGE, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleMileage(boolean desc) {
        orderBy(VehicleColumns.MILEAGE, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleMileage() {
        orderBy(VehicleColumns.MILEAGE, false);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformation(String... value) {
        addEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformationNot(String... value) {
        addNotEquals(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformationLike(String... value) {
        addLike(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformationContains(String... value) {
        addContains(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformationStartsWith(String... value) {
        addStartsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection vehicleAdditionalInformationEndsWith(String... value) {
        addEndsWith(VehicleColumns.ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection orderByVehicleAdditionalInformation(boolean desc) {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public MaintenanceSelection orderByVehicleAdditionalInformation() {
        orderBy(VehicleColumns.ADDITIONAL_INFORMATION, false);
        return this;
    }

    public MaintenanceSelection maintenanceTitle(String... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTitleNot(String... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTitleLike(String... value) {
        addLike(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTitleContains(String... value) {
        addContains(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTitleStartsWith(String... value) {
        addStartsWith(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTitleEndsWith(String... value) {
        addEndsWith(MaintenanceColumns.MAINTENANCE_TITLE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceTitle(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_TITLE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceTitle() {
        orderBy(MaintenanceColumns.MAINTENANCE_TITLE, false);
        return this;
    }

    public MaintenanceSelection maintenanceDate(Date... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection maintenanceDateNot(Date... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection maintenanceDate(long... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_DATE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenanceDateAfter(Date value) {
        addGreaterThan(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection maintenanceDateAfterEq(Date value) {
        addGreaterThanOrEquals(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection maintenanceDateBefore(Date value) {
        addLessThan(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection maintenanceDateBeforeEq(Date value) {
        addLessThanOrEquals(MaintenanceColumns.MAINTENANCE_DATE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceDate(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_DATE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceDate() {
        orderBy(MaintenanceColumns.MAINTENANCE_DATE, false);
        return this;
    }

    public MaintenanceSelection maintenanceMileage(int... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_MILEAGE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenanceMileageNot(int... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_MILEAGE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenanceMileageGt(int value) {
        addGreaterThan(MaintenanceColumns.MAINTENANCE_MILEAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceMileageGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceColumns.MAINTENANCE_MILEAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceMileageLt(int value) {
        addLessThan(MaintenanceColumns.MAINTENANCE_MILEAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceMileageLtEq(int value) {
        addLessThanOrEquals(MaintenanceColumns.MAINTENANCE_MILEAGE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceMileage(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_MILEAGE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceMileage() {
        orderBy(MaintenanceColumns.MAINTENANCE_MILEAGE, false);
        return this;
    }

    public MaintenanceSelection maintenanceType(int... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_TYPE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenanceTypeNot(int... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_TYPE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenanceTypeGt(int value) {
        addGreaterThan(MaintenanceColumns.MAINTENANCE_TYPE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTypeGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceColumns.MAINTENANCE_TYPE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTypeLt(int value) {
        addLessThan(MaintenanceColumns.MAINTENANCE_TYPE, value);
        return this;
    }

    public MaintenanceSelection maintenanceTypeLtEq(int value) {
        addLessThanOrEquals(MaintenanceColumns.MAINTENANCE_TYPE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceType(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_TYPE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceType() {
        orderBy(MaintenanceColumns.MAINTENANCE_TYPE, false);
        return this;
    }

    public MaintenanceSelection maintenancePrice(double... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_PRICE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenancePriceNot(double... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_PRICE, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection maintenancePriceGt(double value) {
        addGreaterThan(MaintenanceColumns.MAINTENANCE_PRICE, value);
        return this;
    }

    public MaintenanceSelection maintenancePriceGtEq(double value) {
        addGreaterThanOrEquals(MaintenanceColumns.MAINTENANCE_PRICE, value);
        return this;
    }

    public MaintenanceSelection maintenancePriceLt(double value) {
        addLessThan(MaintenanceColumns.MAINTENANCE_PRICE, value);
        return this;
    }

    public MaintenanceSelection maintenancePriceLtEq(double value) {
        addLessThanOrEquals(MaintenanceColumns.MAINTENANCE_PRICE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenancePrice(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_PRICE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenancePrice() {
        orderBy(MaintenanceColumns.MAINTENANCE_PRICE, false);
        return this;
    }

    public MaintenanceSelection maintenanceDescription(String... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection maintenanceDescriptionNot(String... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection maintenanceDescriptionLike(String... value) {
        addLike(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection maintenanceDescriptionContains(String... value) {
        addContains(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection maintenanceDescriptionStartsWith(String... value) {
        addStartsWith(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection maintenanceDescriptionEndsWith(String... value) {
        addEndsWith(MaintenanceColumns.MAINTENANCE_DESCRIPTION, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceDescription(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_DESCRIPTION, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceDescription() {
        orderBy(MaintenanceColumns.MAINTENANCE_DESCRIPTION, false);
        return this;
    }

    public MaintenanceSelection isRegular(boolean value) {
        addEquals(MaintenanceColumns.IS_REGULAR, toObjectArray(value));
        return this;
    }

    public MaintenanceSelection orderByIsRegular(boolean desc) {
        orderBy(MaintenanceColumns.IS_REGULAR, desc);
        return this;
    }

    public MaintenanceSelection orderByIsRegular() {
        orderBy(MaintenanceColumns.IS_REGULAR, false);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicity(Integer... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicityNot(Integer... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicityGt(int value) {
        addGreaterThan(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicityGtEq(int value) {
        addGreaterThanOrEquals(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicityLt(int value) {
        addLessThan(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection maintenancePeriodicityLtEq(int value) {
        addLessThanOrEquals(MaintenanceColumns.MAINTENANCE_PERIODICITY, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenancePeriodicity(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_PERIODICITY, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenancePeriodicity() {
        orderBy(MaintenanceColumns.MAINTENANCE_PERIODICITY, false);
        return this;
    }

    public MaintenanceSelection maintenanceGarage(String... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceGarageNot(String... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceGarageLike(String... value) {
        addLike(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceGarageContains(String... value) {
        addContains(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceGarageStartsWith(String... value) {
        addStartsWith(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection maintenanceGarageEndsWith(String... value) {
        addEndsWith(MaintenanceColumns.MAINTENANCE_GARAGE, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceGarage(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_GARAGE, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceGarage() {
        orderBy(MaintenanceColumns.MAINTENANCE_GARAGE, false);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformation(String... value) {
        addEquals(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformationNot(String... value) {
        addNotEquals(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformationLike(String... value) {
        addLike(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformationContains(String... value) {
        addContains(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformationStartsWith(String... value) {
        addStartsWith(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection maintenanceAdditionalInformationEndsWith(String... value) {
        addEndsWith(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, value);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceAdditionalInformation(boolean desc) {
        orderBy(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, desc);
        return this;
    }

    public MaintenanceSelection orderByMaintenanceAdditionalInformation() {
        orderBy(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION, false);
        return this;
    }
}
