package com.kenzie.app;

import java.util.Objects;

public class EntryPass {
    //Class properties
    private String name;
    private String id;
    private String accessLevel;

    //Class constructors
    public EntryPass (String name, String id) {
        this.name = name;
        this.id = id;
        this.accessLevel = "general";
    }

    public EntryPass(String name, String id, String accessLevel) {
        this.name = name;
        this.id = id;
        this.accessLevel = accessLevel;
    }

    //Class methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    //Override equals
    @Override
    public boolean equals(Object entryPass) {
        if (this == entryPass)
            return true;
        if (entryPass == null || getClass() != entryPass.getClass())
            return false;
        EntryPass newEntryPass = (EntryPass) entryPass;
        return Objects.equals(this.id, newEntryPass.id) && Objects.equals(accessLevel, newEntryPass.accessLevel);
    }
}