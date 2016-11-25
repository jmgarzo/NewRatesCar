package com.jmgarzo.newratescar.provider.make;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Make
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class MakeBean implements MakeModel {
    private long mId;
    private String mMakeName;

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Primary key.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMakeName() {
        return mMakeName;
    }

    /**
     * Make
     * Can be {@code null}.
     */
    public void setMakeName(@Nullable String makeName) {
        mMakeName = makeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeBean bean = (MakeBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new MakeBean with specified values.
     */
    @NonNull
    public static MakeBean newInstance(long id, @Nullable String makeName) {
        MakeBean res = new MakeBean();
        res.mId = id;
        res.mMakeName = makeName;
        return res;
    }

    /**
     * Instantiate a new MakeBean with all the values copied from the given model.
     */
    @NonNull
    public static MakeBean copy(@NonNull MakeModel from) {
        MakeBean res = new MakeBean();
        res.mId = from.getId();
        res.mMakeName = from.getMakeName();
        return res;
    }

    public static class Builder {
        private MakeBean mRes = new MakeBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Make
         * Can be {@code null}.
         */
        public Builder makeName(@Nullable String makeName) {
            mRes.mMakeName = makeName;
            return this;
        }

        /**
         * Get a new MakeBean built with the given values.
         */
        public MakeBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
