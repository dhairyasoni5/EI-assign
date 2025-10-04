package com.smarthome.controller;

import com.smarthome.model.device.Device;
import com.smarthome.model.trigger.Trigger;
import com.smarthome.patterns.command.Command;
import com.smarthome.patterns.observer.Observer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The central "Conductor" of the smart home system.
 * Implemented as a Singleton to ensure a single point of control.
 */
public class SmartHomeController {
    private static SmartHomeController instance;
    private final Map<String, Device> devices = new LinkedHashMap<>();
    private final List<Trigger> triggers = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    // Private constructor to prevent instantiation
    private SmartHomeController() {}

    /**
     * Provides the global point of access to the Singleton instance.
     */
    public static synchronized SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public void addDevice(Device device) {
        devices.put(device.getId(), device);
        notifyObservers("New device added: " + device.getDeviceType() + " with ID '" + device.getId() + "'");
    }

    public Device getDevice(String id) {
        return devices.get(id);
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
        notifyObservers("New trigger added: " + trigger.getDescription());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void executeCommand(Command command) {
        command.execute();
        // After any state change, notify observers and check all triggers
        notifyObservers("A command was executed.");
        checkAllTriggers();
    }

    private void checkAllTriggers() {
        for (Trigger trigger : triggers) {
            trigger.checkAndExecute();
        }
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void displayAllDeviceStatuses() {
        System.out.println("\n--- CURRENT DEVICE STATUSES ---");
        if (devices.isEmpty()) {
            System.out.println("No devices in the system.");
        } else {
            devices.values().forEach(device -> System.out.println("- " + device.getStatus()));
        }
        System.out.println("-----------------------------");
    }
}
