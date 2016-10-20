package com.jmgarzo.newratescar.object;

/**
 * Created by jmgarzo on 18/10/16.
 */

public class MenuItem {
    private String name;
    private int image;

    public MenuItem(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
