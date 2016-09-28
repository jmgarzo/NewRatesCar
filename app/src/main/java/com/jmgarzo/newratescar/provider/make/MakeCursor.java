package com.jmgarzo.newratescar.provider.make;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code make} table.
 */
public class MakeCursor extends AbstractCursor implements MakeModel {
    public MakeCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MakeColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Make
     * Can be {@code null}.
     */
    @Nullable
    public String getMakeName() {
        String res = getStringOrNull(MakeColumns.MAKE_NAME);
        return res;
    }
}
