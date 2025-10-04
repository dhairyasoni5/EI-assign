package com.smarthome.model.proxy;

import com.smarthome.model.device.Device;
import com.smarthome.model.device.DoorLock;
import com.smarthome.utils.ConsoleReader;

/**
 * [cite_start]A Proxy to control access to sensitive device operations. [cite: 166]
 * It implements the Device interface so it can stand in for a real device.
 */
public class DeviceProxy implements Device {
    private final Device realDevice;
    private static final String DOOR_PIN = "1234"; // Hardcoded for simplicity

    public DeviceProxy(Device realDevice) {
        this.realDevice = realDevice;
    }

    private boolean authenticate() {
        System.out.print("This is a secure action. Please enter PIN: ");
        String enteredPin = ConsoleReader.readString();
        return DOOR_PIN.equals(enteredPin);
    }

    // --- Delegated Methods ---

    @Override
    public String getId() {
        return realDevice.getId();
    }

    @Override
    public String getDeviceType() {
        return realDevice.getDeviceType();
    }

    @Override
    public String getStatus() {
        return realDevice.getStatus();
    }

    @Override
    public void turnOn() {
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        realDevice.turnOff();
    }

    // --- Proxied Logic for DoorLock ---

    /**
     * A custom method for the proxy to handle locking, which is not a secure action.
     */
    public void lock() {
        if (realDevice instanceof DoorLock) {
            ((DoorLock) realDevice).lock();
        } else {
            System.out.println("This device cannot be locked.");
        }
    }

    /**
     * A custom method to handle unlocking, a secure action.
     * The proxy intercepts this call to perform authentication.
     */
    public void unlock() {
        if (realDevice instanceof DoorLock) {
            if (authenticate()) {
                ((DoorLock) realDevice).unlock();
            } else {
                System.out.println("Authentication failed. Access denied.");
            }
        } else {
            System.out.println("This device cannot be unlocked.");
        }
    }
}
