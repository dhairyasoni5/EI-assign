package com.smarthome.model.device;

/**
 * Represents a smart thermostat device.
 */
public class Thermostat implements Device {
    private final String id;
    private int temperature;

    public Thermostat(String id) {
        this.id = id;
        this.temperature = 70; // Default temperature
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + id + " temperature set to " + temperature + "°F.");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDeviceType() {
        return "Thermostat";
    }

    @Override
    public void turnOn() {
        System.out.println("Thermostat " + id + " is active.");
    }

    @Override
    public void turnOff() {
        System.out.println("Thermostat " + id + " is inactive.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + "°F";
    }
}
