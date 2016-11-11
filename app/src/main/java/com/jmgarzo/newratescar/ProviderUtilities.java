package com.jmgarzo.newratescar;

import android.content.Context;

import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassCursor;
import com.jmgarzo.newratescar.provider.vehicleclass.VehicleClassSelection;

/**
 * Created by jmgarzo on 11/11/16.
 */

public class ProviderUtilities {

    //Vehicle Class
    public static String getVehicleClassName(Context context, long id){
        String result ="";
        VehicleClassSelection vehicleClassSelection = new VehicleClassSelection();
        vehicleClassSelection.id(id);
        VehicleClassCursor cursor = vehicleClassSelection.query(context);

        if (cursor.moveToNext()) {
            result = cursor.getVehicleClassName();
        }
        return result;
    }
}
