package com.smarthome.model.device;

/**
 * The core interface for all smart devices.
 * This defines the common contract that all devices must adhere to,
 * enabling polymorphic behavior in the controller.
 */
public interface Device {
    String getId();
    String getDeviceType();
    void turnOn();
    void turnOff();
    String getStatus();
}
