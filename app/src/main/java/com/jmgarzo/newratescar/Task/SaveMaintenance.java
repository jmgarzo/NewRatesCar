package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.provider.maintenance.MaintenanceColumns;
import com.jmgarzo.newratescar.provider.maintenance.MaintenanceContentValues;

/**
 * Created by jmgarzo on 27/12/16.
 */

public class SaveMaintenance extends AsyncTask<MaintenanceContentValues, Void, Void> {

    private final String LOG_TAG = SaveMaintenance.class.getSimpleName();

    private final Context mContext;
    private final Long mMaintenanceId;
    private final String mVehicleName;

    public SaveMaintenance(Context mContext, Long maintenanceId, String vehicleName) {
        this.mContext = mContext;
        this.mMaintenanceId = maintenanceId;
        this.mVehicleName = vehicleName;
    }

    @Override
    protected Void doInBackground(MaintenanceContentValues... params) {
        if (params.length == 0) {
            return null;
        }


        MaintenanceContentValues values = params[0];

        if (null == mMaintenanceId || mMaintenanceId == -1) {
            Uri insertUri = mContext.getContentResolver().insert(values.uri(), values.values());
        } else {
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    MaintenanceColumns._ID + "= ?",
                    new String[]{mMaintenanceId.toString()});
        }


        return null;
    }
}

