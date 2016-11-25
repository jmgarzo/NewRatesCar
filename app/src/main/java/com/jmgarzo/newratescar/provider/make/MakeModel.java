package com.jmgarzo.newratescar.provider.make;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Make
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface MakeModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    String getMakeName();
}
