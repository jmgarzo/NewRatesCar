package com.jmgarzo.newratescar.provider.menuitem;

import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Menu Item
 */
public interface MenuItemModel extends BaseModel {

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
