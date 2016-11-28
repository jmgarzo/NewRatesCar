package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.provider.refuel.RefuelColumns;
import com.jmgarzo.newratescar.provider.refuel.RefuelContentValues;

/**
 * Created by jmgarzo on 27/11/16.
 */

public class SaveRefuel extends AsyncTask<RefuelContentValues,Void,Void> {

    private final String LOG_TAG = SaveRefuel.class.getSimpleName();

    private final Context mContext;
    private final Long refuelId;

    public SaveRefuel(Context mContext,Long refuelId) {
        this.mContext = mContext;
        this.refuelId = refuelId;
    }

    @Override
    protected Void doInBackground(RefuelContentValues... params) {
        if (params.length == 0) {
            return null;
        }

        RefuelContentValues values = params[0];
        if(null == refuelId || refuelId == -1) {
            mContext.getContentResolver().insert(values.uri(), values.values());
        }else{
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    RefuelColumns._ID + "= ?",
                    new String[]{refuelId.toString()});
        }

        return null;
    }
}
