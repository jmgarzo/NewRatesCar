package com.jmgarzo.newratescar.objects;

/**
 * Created by jmgarzo on 13/12/16.
 */

public class Operation {
    private String name;
    private String description;


    public Operation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
