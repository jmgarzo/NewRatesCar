package com.jmgarzo.newratescar.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.jmgarzo.newratescar.R;

import java.math.BigDecimal;


/**
 * Created by jmgarzo on 21/11/16.
 */

public class Utility {

    private final static BigDecimal KM_PER_MILE = new BigDecimal(1.609344d);
    private final static BigDecimal LITRES_PER_UK_GALLON =  new BigDecimal(4.5460902819948d);
    private final static BigDecimal LITRES_PER_US_GALLON = new BigDecimal(3.785411784d);

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

    public static Double getDoubleNoNull (String sValue){
        if(null == sValue || sValue.equalsIgnoreCase("")){
            sValue = "0";
        }
        return Double.valueOf(sValue);
    }

    public static Integer getIntegerNoNull (String sValue){
        if(null == sValue || sValue.equalsIgnoreCase("")){
            sValue = "0";
        }
        return Integer.parseInt(sValue);
    }

    public static boolean isEmptyOrNull(String value){
        if(null== value || value.isEmpty()){
        return true;
        }
        return false;
    }


    public static String getPreferredMileageUnit(Context context){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String defaultValue = context.getResources().getString(R.string.pref_distance_default_value);
        String selectedKey = sharedPref.getString(context.getString(R.string.pref_distance_key), defaultValue);
        if(selectedKey.equalsIgnoreCase(context.getString(R.string.pref_distance_value_kilometre))){
            return context.getString(R.string.pref_distance_label_kilometre);
        }else if(selectedKey.equalsIgnoreCase(context.getString(R.string.pref_distance_value_mile))){
            return context.getString(R.string.pref_distance_label_mile);
        }
        return defaultValue;

    }

    public static BigDecimal kmToMiles(BigDecimal km) {
        return km.divide(KM_PER_MILE, 15, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal milesToKm(BigDecimal millas) {
        return (millas.multiply(KM_PER_MILE)).setScale(15, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal litresToUSGallons(BigDecimal litres) {
        return litres.divide(LITRES_PER_US_GALLON, 15, BigDecimal.ROUND_HALF_UP).setScale(15, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal USGallonsToLitrs(BigDecimal galonesUS) {
        return (galonesUS.multiply(LITRES_PER_US_GALLON)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal litresToUKGallons(BigDecimal litros) {
        return litros.divide(LITRES_PER_UK_GALLON, 15, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal UKGallonsToLitres(BigDecimal galonesUK) {
        return (galonesUK.multiply(LITRES_PER_UK_GALLON)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal precioPorLitroToPrecioPorGalonUS(BigDecimal precioPorLitro) {
        return (precioPorLitro.multiply(LITRES_PER_US_GALLON)).setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal precioPorGalonUSToPrecioPorLitro(BigDecimal precioPorGalonUS) {
        return (precioPorGalonUS.divide(LITRES_PER_US_GALLON, 15, BigDecimal.ROUND_HALF_UP)).setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal precioPorLitroToPrecioPorGalonUK(BigDecimal precioPorLitro) {
        return (precioPorLitro.multiply(LITRES_PER_UK_GALLON)).setScale(3, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal precioPorGalonUKToPrecioPorLitro(BigDecimal precioPorGalonUK) {
        return (precioPorGalonUK.divide(LITRES_PER_UK_GALLON, 15, BigDecimal.ROUND_HALF_UP).setScale(3, BigDecimal.ROUND_HALF_UP));
    }

    public static BigDecimal litros100ToMpgUS(BigDecimal litrosALos100) {
        BigDecimal resultado = BigDecimal.ZERO;
        if (null != litrosALos100 && (litrosALos100.compareTo(BigDecimal.ZERO) != 0)) {
            resultado = new BigDecimal(235.215).divide(litrosALos100, 15, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return resultado;

    }

    public static BigDecimal mpgUSToLitros100(BigDecimal mpgUS) {
        BigDecimal resultado = BigDecimal.ZERO;
        if (null != mpgUS && (mpgUS.compareTo(BigDecimal.ZERO) != 0)) {
            resultado = new BigDecimal(235.215).divide(mpgUS, 15, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return resultado;
    }

    public static BigDecimal litros100ToMpgImp(BigDecimal litrosALos100) {
        BigDecimal resultado = BigDecimal.ZERO;
        if (null != litrosALos100 && (litrosALos100.compareTo(BigDecimal.ZERO) != 0)) {
            resultado = new BigDecimal(282.481).divide(litrosALos100, 15, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return resultado;
    }

    public static BigDecimal mpgImpToLitros100(BigDecimal mpgImp) {
        BigDecimal resultado = BigDecimal.ZERO;
        if (null != mpgImp && (mpgImp.compareTo(BigDecimal.ZERO) != 0)) {
            resultado = new BigDecimal(282.481).divide(mpgImp, 15, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        return resultado;
    }


    public static BigDecimal RedondearSinDecimales(BigDecimal valor) {
        return valor.setScale(0, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal RedondearDecimales(BigDecimal valor, int decimales) {
        return valor.setScale(decimales, BigDecimal.ROUND_HALF_UP);
    }


}
