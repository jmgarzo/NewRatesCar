package com.jmgarzo.newratescar.Task;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.jmgarzo.newratescar.provider.insurance.InsuranceColumns;
import com.jmgarzo.newratescar.provider.insurance.InsuranceContentValues;

/**
 * Created by jmgarzo on 07/12/16.
 */

public class SaveInsurance extends AsyncTask<InsuranceContentValues, Void, Void>

{

    private final String LOG_TAG = SaveInsurance.class.getSimpleName();

    private final Context mContext;
    private final Long mInsuranceId;

    public SaveInsurance(Context context, Long insuranceId) {
        this.mContext = context;
        this.mInsuranceId = insuranceId;
    }


    @Override
    protected Void doInBackground(InsuranceContentValues... params) {
        if (params.length == 0) {
            return null;
        }


        InsuranceContentValues values = params[0];

        if (null == mInsuranceId || mInsuranceId == -1) {
            Uri insertUri = mContext.getContentResolver().insert(values.uri(), values.values());
        } else {
            mContext.getContentResolver().update(values.uri(),
                    values.values(),
                    InsuranceColumns._ID + "= ?",
                    new String[]{mInsuranceId.toString()});
        }


        return null;
    }

}
