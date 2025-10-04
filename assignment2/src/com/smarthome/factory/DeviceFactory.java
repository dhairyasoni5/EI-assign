package com.smarthome.factory;

import com.smarthome.model.device.Device;
import com.smarthome.model.device.DoorLock;
import com.smarthome.model.device.Light;
import com.smarthome.model.device.Thermostat;

/**
 * [cite_start]Factory for creating device objects. [cite: 165]
 * This class encapsulates the logic for object instantiation,
 * decoupling the client code from concrete device classes.
 */
public class DeviceFactory {
    public static Device createDevice(String deviceType, String id) {
        if (deviceType == null || deviceType.isEmpty()) {
            return null;
        }
        switch (deviceType.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id);
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Unknown device type: " + deviceType);
        }
    }
}
