package com.smarthome.model.device;

/**
 * Represents a smart door lock device.
 * Contains sensitive operations like lock/unlock.
 */
public class DoorLock implements Device {
    private final String id;
    private boolean isLocked;

    public DoorLock(String id) {
        this.id = id;
        this.isLocked = true; // Default state is locked
    }

    public void lock() {
        isLocked = true;
        System.out.println("Door " + id + " has been LOCKED.");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("Door " + id + " has been UNLOCKED.");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDeviceType() {
        return "DoorLock";
    }

    @Override
    public void turnOn() {
        System.out.println("DoorLock " + id + " is now active.");
    }

    @Override
    public void turnOff() {
        System.out.println("DoorLock " + id + " is now inactive.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is currently " + (isLocked ? "LOCKED" : "UNLOCKED");
    }
}
