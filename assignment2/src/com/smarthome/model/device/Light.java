package com.smarthome.model.device;

/**
 * Represents a smart light device.
 */
public class Light implements Device {
    private final String id;
    private boolean isOn;

    public Light(String id) {
        this.id = id;
        this.isOn = false; // Default state is off
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDeviceType() {
        return "Light";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Light " + id + " is now ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Light " + id + " is now OFF.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is currently " + (isOn ? "ON" : "OFF");
    }
}
