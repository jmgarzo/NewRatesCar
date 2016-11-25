package com.jmgarzo.newratescar.provider.menuitem;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.jmgarzo.newratescar.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code menu_item} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class MenuItemCursor extends AbstractCursor implements MenuItemModel {
    public MenuItemCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(MenuItemColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Menu Item Name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMenuItemName() {
        String res = getStringOrNull(MenuItemColumns.MENU_ITEM_NAME);
        return res;
    }

    /**
     * Get the {@code menu_item_image} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMenuItemImage() {
        Integer res = getIntegerOrNull(MenuItemColumns.MENU_ITEM_IMAGE);
        return res;
    }
}
