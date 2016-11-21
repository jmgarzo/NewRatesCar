package com.jmgarzo.newratescar.Utility;

import android.content.Context;

import com.jmgarzo.newratescar.R;


/**
 * Created by jmgarzo on 21/11/16.
 */

public class Utility {
    public static int getImagefromIdClass(Context context, Long idClass) {
        String vehicleClassName = ProviderUtilities.getVehicleClassName(context, idClass);
        if (vehicleClassName.equalsIgnoreCase(context.getString(R.string.car_class_db))) {
            return R.drawable.car01;
        } else  if (vehicleClassName.equalsIgnoreCase(context.getString(R.string.van_class_db))) {
                return R.drawable.van01;
        }else if (vehicleClassName.equalsIgnoreCase(context.getString(R.string.motorcycle_class_db))){
            return  R.drawable.motorbike01;
        }else if (vehicleClassName.equalsIgnoreCase(context.getString(R.string.truck_class_db))){
            return R.drawable.truck01;
        }else if(vehicleClassName.equalsIgnoreCase(context.getString(R.string.tractor_class_db))){
            return R.drawable.tractor01;

        }else if(vehicleClassName.equalsIgnoreCase(context.getString(R.string.quad_class_db))){
            return R.drawable.quad01;
        }else if(vehicleClassName.equalsIgnoreCase(context.getString(R.string.bike_class_db))){
            return R.drawable.bike01;
        }else if(vehicleClassName.equalsIgnoreCase(context.getString(R.string.bus_class_db))){
            return R.drawable.bus01;
        }else{
            return R.drawable.car01;
        }
    }
}
