package com.jmgarzo.newratescar.provider.refuel;

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
import com.jmgarzo.newratescar.provider.fuelsubtype.*;

/**
 * Cursor wrapper for the {@code refuel} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class RefuelCursor extends AbstractCursor implements RefuelModel {
    public RefuelCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(RefuelColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     */
    @Override
    public long getVehicleId() {
        Long res = getLongOrNull(RefuelColumns.VEHICLE_ID);
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
     * Get the {@code refuel_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRefuelDate() {
        Date res = getDateOrNull(RefuelColumns.REFUEL_DATE);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code refuel_fuel_subtype} value.
     */
    @Override
    public long getRefuelFuelSubtype() {
        Long res = getLongOrNull(RefuelColumns.REFUEL_FUEL_SUBTYPE);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_fuel_subtype' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Fuel Subtype Name
     * Can be {@code null}.
     */
    @Nullable
    public String getFuelSubtypeFuelSubtypeName() {
        String res = getStringOrNull(FuelSubtypeColumns.FUEL_SUBTYPE_NAME);
        return res;
    }

    /**
     * Get the {@code refuel_mileage} value.
     */
    @Override
    public int getRefuelMileage() {
        Integer res = getIntegerOrNull(RefuelColumns.REFUEL_MILEAGE);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_mileage' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code refuel_trip_odometer} value.
     */
    @Override
    public int getRefuelTripOdometer() {
        Integer res = getIntegerOrNull(RefuelColumns.REFUEL_TRIP_ODOMETER);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_trip_odometer' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code refuel_litres} value.
     */
    @Override
    public float getRefuelLitres() {
        Float res = getFloatOrNull(RefuelColumns.REFUEL_LITRES);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_litres' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code refuel_gas_price} value.
     */
    @Override
    public float getRefuelGasPrice() {
        Float res = getFloatOrNull(RefuelColumns.REFUEL_GAS_PRICE);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_gas_price' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code refuel_total_price} value.
     */
    @Override
    public float getRefuelTotalPrice() {
        Float res = getFloatOrNull(RefuelColumns.REFUEL_TOTAL_PRICE);
        if (res == null)
            throw new NullPointerException("The value of 'refuel_total_price' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code is_full} value.
     */
    @Override
    public boolean getIsFull() {
        Boolean res = getBooleanOrNull(RefuelColumns.IS_FULL);
        if (res == null)
            throw new NullPointerException("The value of 'is_full' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code is_trailer} value.
     */
    @Override
    public boolean getIsTrailer() {
        Boolean res = getBooleanOrNull(RefuelColumns.IS_TRAILER);
        if (res == null)
            throw new NullPointerException("The value of 'is_trailer' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code is_roof_rack} value.
     */
    @Override
    public boolean getIsRoofRack() {
        Boolean res = getBooleanOrNull(RefuelColumns.IS_ROOF_RACK);
        if (res == null)
            throw new NullPointerException("The value of 'is_roof_rack' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code route_type} value.
     */
    @Override
    public int getRouteType() {
        Integer res = getIntegerOrNull(RefuelColumns.ROUTE_TYPE);
        if (res == null)
            throw new NullPointerException("The value of 'route_type' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code driving_style} value.
     */
    @Override
    public int getDrivingStyle() {
        Integer res = getIntegerOrNull(RefuelColumns.DRIVING_STYLE);
        if (res == null)
            throw new NullPointerException("The value of 'driving_style' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code average_speed} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Float getAverageSpeed() {
        Float res = getFloatOrNull(RefuelColumns.AVERAGE_SPEED);
        return res;
    }

    /**
     * Get the {@code average_consumption} value.
     */
    @Override
    public float getAverageConsumption() {
        Float res = getFloatOrNull(RefuelColumns.AVERAGE_CONSUMPTION);
        if (res == null)
            throw new NullPointerException("The value of 'average_consumption' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code payment_type} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPaymentType() {
        String res = getStringOrNull(RefuelColumns.PAYMENT_TYPE);
        return res;
    }

    /**
     * Get the {@code gas_station} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGasStation() {
        String res = getStringOrNull(RefuelColumns.GAS_STATION);
        return res;
    }

    /**
     * Get the {@code refuel_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRefuelAdditionalInformation() {
        String res = getStringOrNull(RefuelColumns.REFUEL_ADDITIONAL_INFORMATION);
        return res;
    }
}
