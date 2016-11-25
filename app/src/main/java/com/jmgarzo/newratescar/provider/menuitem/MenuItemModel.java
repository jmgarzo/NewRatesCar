package com.jmgarzo.newratescar.provider.menuitem;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Menu Item
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface MenuItemModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Menu Item Name
     * Can be {@code null}.
     */
    @Nullable
    String getMenuItemName();

    /**
     * Get the {@code menu_item_image} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMenuItemImage();
}
