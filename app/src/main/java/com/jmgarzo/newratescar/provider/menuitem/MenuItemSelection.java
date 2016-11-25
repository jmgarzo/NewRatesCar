package com.jmgarzo.newratescar.provider.menuitem;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.jmgarzo.newratescar.provider.base.AbstractSelection;

/**
 * Selection for the {@code menu_item} table.
 */
public class MenuItemSelection extends AbstractSelection<MenuItemSelection> {
    @Override
    protected Uri baseUri() {
        return MenuItemColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MenuItemCursor} object, which is positioned before the first entry, or null.
     */
    public MenuItemCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MenuItemCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MenuItemCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MenuItemCursor} object, which is positioned before the first entry, or null.
     */
    public MenuItemCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MenuItemCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MenuItemCursor query(Context context) {
        return query(context, null);
    }


    public MenuItemSelection id(long... value) {
        addEquals("menu_item." + MenuItemColumns._ID, toObjectArray(value));
        return this;
    }

    public MenuItemSelection idNot(long... value) {
        addNotEquals("menu_item." + MenuItemColumns._ID, toObjectArray(value));
        return this;
    }

    public MenuItemSelection orderById(boolean desc) {
        orderBy("menu_item." + MenuItemColumns._ID, desc);
        return this;
    }

    public MenuItemSelection orderById() {
        return orderById(false);
    }

    public MenuItemSelection menuItemName(String... value) {
        addEquals(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection menuItemNameNot(String... value) {
        addNotEquals(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection menuItemNameLike(String... value) {
        addLike(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection menuItemNameContains(String... value) {
        addContains(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection menuItemNameStartsWith(String... value) {
        addStartsWith(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection menuItemNameEndsWith(String... value) {
        addEndsWith(MenuItemColumns.MENU_ITEM_NAME, value);
        return this;
    }

    public MenuItemSelection orderByMenuItemName(boolean desc) {
        orderBy(MenuItemColumns.MENU_ITEM_NAME, desc);
        return this;
    }

    public MenuItemSelection orderByMenuItemName() {
        orderBy(MenuItemColumns.MENU_ITEM_NAME, false);
        return this;
    }

    public MenuItemSelection menuItemImage(Integer... value) {
        addEquals(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection menuItemImageNot(Integer... value) {
        addNotEquals(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection menuItemImageGt(int value) {
        addGreaterThan(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection menuItemImageGtEq(int value) {
        addGreaterThanOrEquals(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection menuItemImageLt(int value) {
        addLessThan(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection menuItemImageLtEq(int value) {
        addLessThanOrEquals(MenuItemColumns.MENU_ITEM_IMAGE, value);
        return this;
    }

    public MenuItemSelection orderByMenuItemImage(boolean desc) {
        orderBy(MenuItemColumns.MENU_ITEM_IMAGE, desc);
        return this;
    }

    public MenuItemSelection orderByMenuItemImage() {
        orderBy(MenuItemColumns.MENU_ITEM_IMAGE, false);
        return this;
    }
}
