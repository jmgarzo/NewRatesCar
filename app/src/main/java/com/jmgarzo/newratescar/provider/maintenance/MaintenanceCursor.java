package com.jmgarzo.newratescar.provider.maintenance;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;
import com.jmgarzo.newratescar.provider.vehicle.*;
import com.jmgarzo.newratescar.provider.vehicleclass.*;
import com.jmgarzo.newratescar.provider.fueltype.*;
import com.jmgarzo.newratescar.provider.make.*;

/**
 * Cursor wrapper for the {@code maintenance} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class MaintenanceCursor extends AbstractCursor implements MaintenanceModel {
    public MaintenanceCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(MaintenanceColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     */
    @Override
    public long getVehicleId() {
        Long res = getLongOrNull(MaintenanceColumns.VEHICLE_ID);
        if (res == null)
            throw new NullPointerException("The value of 'vehicle_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vehicle name
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleVehicleName() {
        String res = getStringOrNull(VehicleColumns.VEHICLE_NAME);
        return res;
    }

    /**
     * Get the {@code vehicle_class} value.
     */
    public long getVehicleVehicleClass() {
        Long res = getLongOrNull(VehicleColumns.VEHICLE_CLASS);
        if (res == null)
            throw new NullPointerException("The value of 'vehicle_class' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Vehicle class name
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleVehicleClassVehicleClassName() {
        String res = getStringOrNull(VehicleClassColumns.VEHICLE_CLASS_NAME);
        return res;
    }

    /**
     * Get the {@code vehicle_fuel_type} value.
     */
    public long getVehicleVehicleFuelType() {
        Long res = getLongOrNull(VehicleColumns.VEHICLE_FUEL_TYPE);
        if (res == null)
            throw new NullPointerException("The value of 'vehicle_fuel_type' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Type Name
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleFuelTypeFuelTypeName() {
        String res = getStringOrNull(FuelTypeColumns.FUEL_TYPE_NAME);
        return res;
    }

    /**
     * Get the {@code make} value.
     */
    public long getVehicleMake() {
        Long res = getLongOrNull(VehicleColumns.MAKE);
        if (res == null)
            throw new NullPointerException("The value of 'make' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleMakeMakeName() {
        String res = getStringOrNull(MakeColumns.MAKE_NAME);
        return res;
    }

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleModel() {
        String res = getStringOrNull(VehicleColumns.MODEL);
        return res;
    }

    /**
     * Get the {@code mileage} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVehicleMileage() {
        Integer res = getIntegerOrNull(VehicleColumns.MILEAGE);
        return res;
    }

    /**
     * Get the {@code additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getVehicleAdditionalInformation() {
        String res = getStringOrNull(VehicleColumns.ADDITIONAL_INFORMATION);
        return res;
    }

    /**
     * Get the {@code maintenance_title} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceTitle() {
        String res = getStringOrNull(MaintenanceColumns.MAINTENANCE_TITLE);
        return res;
    }

    /**
     * Get the {@code maintenance_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getMaintenanceDate() {
        Date res = getDateOrNull(MaintenanceColumns.MAINTENANCE_DATE);
        if (res == null)
            throw new NullPointerException("The value of 'maintenance_date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code maintenance_mileage} value.
     */
    @Override
    public int getMaintenanceMileage() {
        Integer res = getIntegerOrNull(MaintenanceColumns.MAINTENANCE_MILEAGE);
        if (res == null)
            throw new NullPointerException("The value of 'maintenance_mileage' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code maintenance_type} value.
     */
    @Override
    public int getMaintenanceType() {
        Integer res = getIntegerOrNull(MaintenanceColumns.MAINTENANCE_TYPE);
        if (res == null)
            throw new NullPointerException("The value of 'maintenance_type' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code maintenance_price} value.
     */
    @Override
    public double getMaintenancePrice() {
        Double res = getDoubleOrNull(MaintenanceColumns.MAINTENANCE_PRICE);
        if (res == null)
            throw new NullPointerException("The value of 'maintenance_price' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code maintenance_description} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceDescription() {
        String res = getStringOrNull(MaintenanceColumns.MAINTENANCE_DESCRIPTION);
        return res;
    }

    /**
     * Get the {@code is_regular} value.
     */
    @Override
    public boolean getIsRegular() {
        Boolean res = getBooleanOrNull(MaintenanceColumns.IS_REGULAR);
        if (res == null)
            throw new NullPointerException("The value of 'is_regular' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code maintenance_periodicity} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaintenancePeriodicity() {
        Integer res = getIntegerOrNull(MaintenanceColumns.MAINTENANCE_PERIODICITY);
        return res;
    }

    /**
     * Get the {@code maintenance_garage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceGarage() {
        String res = getStringOrNull(MaintenanceColumns.MAINTENANCE_GARAGE);
        return res;
    }

    /**
     * Get the {@code maintenance_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMaintenanceAdditionalInformation() {
        String res = getStringOrNull(MaintenanceColumns.MAINTENANCE_ADDITIONAL_INFORMATION);
        return res;
    }
}
