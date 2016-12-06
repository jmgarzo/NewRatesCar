package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.provider.toll.TollColumns;
import com.jmgarzo.newratescar.provider.toll.TollContentValues;

/**
 * Created by jmgarzo on 06/12/16.
 */

public class SaveToll extends AsyncTask<TollContentValues, Void, Void> {

    private final String LOG_TAG = SaveToll.class.getSimpleName();

    private final Context mContext;
    private final Long mTollId;
    private final String mVehicleName;

    public SaveToll(Context mContext, Long tollId, String vehicleName) {
        this.mContext = mContext;
        this.mTollId = tollId;
        this.mVehicleName = vehicleName;
    }


    @Override
    protected Void doInBackground(TollContentValues... params) {
        if (params.length == 0) {
            return null;
        }


        TollContentValues values = params[0];

        if (null == mTollId || mTollId == -1) {
            Uri insertUri = mContext.getContentResolver().insert(values.uri(), values.values());
        } else {
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    TollColumns._ID + "= ?",
                    new String[]{mTollId.toString()});
        }


        return null;
    }

}
