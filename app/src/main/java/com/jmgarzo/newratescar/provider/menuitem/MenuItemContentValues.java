package com.jmgarzo.newratescar.provider.menuitem;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code menu_item} table.
 */
public class MenuItemContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MenuItemColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MenuItemSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MenuItemSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Menu Item Name
     */
    public MenuItemContentValues putMenuItemName(@Nullable String value) {
        mContentValues.put(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemContentValues putMenuItemNameNull() {
        mContentValues.putNull(MenuItemColumns.MENU_ITEM_NAME);
        return this;
    }

    public MenuItemContentValues putMenuItemImage(@Nullable Integer value) {
        mContentValues.put(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemContentValues putMenuItemImageNull() {
        mContentValues.putNull(MenuItemColumns.MENU_ITEM_IMAGE);
        return this;
    }
}
