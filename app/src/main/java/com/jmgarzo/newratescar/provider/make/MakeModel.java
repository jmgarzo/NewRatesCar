package com.jmgarzo.newratescar.provider.make;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Make
 */
public interface MakeModel extends BaseModel {

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    String getMakeName();
}
