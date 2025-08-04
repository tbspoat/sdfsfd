package com.bi.keystrokesmod.modules;

public abstract class Module {

    private final String name;
    private final String description;
    private boolean enabled;

    public Module(String name, String description, boolean enabled) {
        this.name = name;
        this.description = description;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void onEnable() {
        this.enabled = true;
    }

    public void onDisable() {
        this.enabled = false;
    }
}
