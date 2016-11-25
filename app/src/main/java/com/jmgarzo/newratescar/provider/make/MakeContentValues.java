package com.jmgarzo.newratescar.provider.make;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code make} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class MakeContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MakeColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MakeSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MakeSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Make
     */
    public MakeContentValues putMakeName(@Nullable String value) {
        mContentValues.put(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeContentValues putMakeNameNull() {
        mContentValues.putNull(MakeColumns.MAKE_NAME);
        return this;
    }
}
