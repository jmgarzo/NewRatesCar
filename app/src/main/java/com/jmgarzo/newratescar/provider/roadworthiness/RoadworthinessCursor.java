package com.jmgarzo.newratescar.provider.roadworthiness;

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
 * Cursor wrapper for the {@code roadworthiness} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class RoadworthinessCursor extends AbstractCursor implements RoadworthinessModel {
    public RoadworthinessCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(RoadworthinessColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code vehicle_id} value.
     */
    @Override
    public long getVehicleId() {
        Long res = getLongOrNull(RoadworthinessColumns.VEHICLE_ID);
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
     * Get the {@code roadworthiness_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRoadworthinessDate() {
        Date res = getDateOrNull(RoadworthinessColumns.ROADWORTHINESS_DATE);
        if (res == null)
            throw new NullPointerException("The value of 'roadworthiness_date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code roadworthiness_mileage} value.
     */
    @Override
    public int getRoadworthinessMileage() {
        Integer res = getIntegerOrNull(RoadworthinessColumns.ROADWORTHINESS_MILEAGE);
        if (res == null)
            throw new NullPointerException("The value of 'roadworthiness_mileage' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code roadworthiness_price} value.
     */
    @Override
    public double getRoadworthinessPrice() {
        Double res = getDoubleOrNull(RoadworthinessColumns.ROADWORTHINESS_PRICE);
        if (res == null)
            throw new NullPointerException("The value of 'roadworthiness_price' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code roadworthiness_result} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRoadworthinessResult() {
        String res = getStringOrNull(RoadworthinessColumns.ROADWORTHINESS_RESULT);
        return res;
    }

    /**
     * Get the {@code roadworthiness_next_date} value.
     * Cannot be {@code null}.
     */
    @NonNull
    @Override
    public Date getRoadworthinessNextDate() {
        Date res = getDateOrNull(RoadworthinessColumns.ROADWORTHINESS_NEXT_DATE);
        if (res == null)
            throw new NullPointerException("The value of 'roadworthiness_next_date' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code roadworthiness_additional_information} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getRoadworthinessAdditionalInformation() {
        String res = getStringOrNull(RoadworthinessColumns.ROADWORTHINESS_ADDITIONAL_INFORMATION);
        return res;
    }
}
