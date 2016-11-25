package com.jmgarzo.newratescar.provider.make;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;

/**
 * Selection for the {@code make} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class MakeSelection extends AbstractSelection<MakeSelection> {
    @Override
    protected Uri baseUri() {
        return MakeColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MakeCursor} object, which is positioned before the first entry, or null.
     */
    public MakeCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MakeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MakeCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MakeCursor} object, which is positioned before the first entry, or null.
     */
    public MakeCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MakeCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MakeCursor query(Context context) {
        return query(context, null);
    }


    public MakeSelection id(long... value) {
        addEquals("make." + MakeColumns._ID, toObjectArray(value));
        return this;
    }

    public MakeSelection idNot(long... value) {
        addNotEquals("make." + MakeColumns._ID, toObjectArray(value));
        return this;
    }

    public MakeSelection orderById(boolean desc) {
        orderBy("make." + MakeColumns._ID, desc);
        return this;
    }

    public MakeSelection orderById() {
        return orderById(false);
    }

    public MakeSelection makeName(String... value) {
        addEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection makeNameNot(String... value) {
        addNotEquals(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection makeNameLike(String... value) {
        addLike(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection makeNameContains(String... value) {
        addContains(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection makeNameStartsWith(String... value) {
        addStartsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection makeNameEndsWith(String... value) {
        addEndsWith(MakeColumns.MAKE_NAME, value);
        return this;
    }

    public MakeSelection orderByMakeName(boolean desc) {
        orderBy(MakeColumns.MAKE_NAME, desc);
        return this;
    }

    public MakeSelection orderByMakeName() {
        orderBy(MakeColumns.MAKE_NAME, false);
        return this;
    }
}
