package com.jmgarzo.newratescar.provider.menuitem;

// @formatter:off
import com.jmgarzo.newratescar.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Menu Item
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class MenuItemBean implements MenuItemModel {
    private long mId;
    private String mMenuItemName;
    private Integer mMenuItemImage;

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
     * Menu Item Name
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getMenuItemName() {
        return mMenuItemName;
    }

    /**
     * Menu Item Name
     * Can be {@code null}.
     */
    public void setMenuItemName(@Nullable String menuItemName) {
        mMenuItemName = menuItemName;
    }

    /**
     * Get the {@code menu_item_image} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMenuItemImage() {
        return mMenuItemImage;
    }

    /**
     * Set the {@code menu_item_image} value.
     * Can be {@code null}.
     */
    public void setMenuItemImage(@Nullable Integer menuItemImage) {
        mMenuItemImage = menuItemImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItemBean bean = (MenuItemBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new MenuItemBean with specified values.
     */
    @NonNull
    public static MenuItemBean newInstance(long id, @Nullable String menuItemName, @Nullable Integer menuItemImage) {
        MenuItemBean res = new MenuItemBean();
        res.mId = id;
        res.mMenuItemName = menuItemName;
        res.mMenuItemImage = menuItemImage;
        return res;
    }

    /**
     * Instantiate a new MenuItemBean with all the values copied from the given model.
     */
    @NonNull
    public static MenuItemBean copy(@NonNull MenuItemModel from) {
        MenuItemBean res = new MenuItemBean();
        res.mId = from.getId();
        res.mMenuItemName = from.getMenuItemName();
        res.mMenuItemImage = from.getMenuItemImage();
        return res;
    }

    public static class Builder {
        private MenuItemBean mRes = new MenuItemBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Menu Item Name
         * Can be {@code null}.
         */
        public Builder menuItemName(@Nullable String menuItemName) {
            mRes.mMenuItemName = menuItemName;
            return this;
        }

        /**
         * Set the {@code menu_item_image} value.
         * Can be {@code null}.
         */
        public Builder menuItemImage(@Nullable Integer menuItemImage) {
            mRes.mMenuItemImage = menuItemImage;
            return this;
        }

        /**
         * Get a new MenuItemBean built with the given values.
         */
        public MenuItemBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
