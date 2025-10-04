package com.smarthome;

import com.smarthome.controller.SmartHomeController;
import com.smarthome.factory.DeviceFactory;
import com.smarthome.model.device.Device;
import com.smarthome.model.device.Thermostat;
import com.smarthome.model.proxy.DeviceProxy;
import com.smarthome.model.trigger.Trigger;
import com.smarthome.patterns.command.LockCommand;
import com.smarthome.patterns.command.TurnOffCommand;
import com.smarthome.patterns.command.TurnOnCommand;
import com.smarthome.patterns.command.UnlockCommand;
import com.smarthome.patterns.observer.SystemLogger;
import com.smarthome.utils.ConsoleReader;

/**
 * [cite_start]Main entry point for the Smart Home System console application. [cite: 21]
 * This class is responsible for the user interface loop and delegating actions
 * to the controller.
 */
public class Main {

    public static void main(String[] args) {
        // Initialize the controller and logger
        SmartHomeController controller = SmartHomeController.getInstance();
        controller.addObserver(new SystemLogger());

        System.out.println("Welcome to the Smart Home Simulation!");

        // --- PRE-POPULATE THE SYSTEM FOR DEMONSTRATION ---
        setupInitialState(controller);

        // --- MAIN APPLICATION LOOP ---
        runMenu(controller);

        System.out.println("Exiting Smart Home Simulation. Goodbye!");
    }

    private static void runMenu(SmartHomeController controller) {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Choose an option: ");
            int choice = ConsoleReader.readInt();

            switch (choice) {
                case 1:
                    controller.displayAllDeviceStatuses();
                    break;
                case 2:
                    turnOnDevice(controller);
                    break;
                case 3:
                    turnOffDevice(controller);
                    break;
                case 4:
                    setThermostat(controller);
                    break;
                case 5:
                    unlockDoor(controller);
                    break;
                case 6:
                    lockDoor(controller);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n========= Smart Home Menu =========");
        System.out.println("1. View all device statuses");
        System.out.println("2. Turn ON a light");
        System.out.println("3. Turn OFF a light");
        System.out.println("4. Set thermostat temperature");
        System.out.println("5. UNLOCK the front door");
        System.out.println("6. LOCK the front door");
        System.out.println("0. Exit");
        System.out.println("===================================");
    }

    private static void turnOnDevice(SmartHomeController controller) {
        System.out.print("Enter ID of the light to turn ON (e.g., 'living_room_light'): ");
        String id = ConsoleReader.readString();
        Device device = controller.getDevice(id);
        if (device != null) {
            controller.executeCommand(new TurnOnCommand(device));
        } else {
            System.out.println("Device with ID '" + id + "' not found.");
        }
    }

    private static void turnOffDevice(SmartHomeController controller) {
        System.out.print("Enter ID of the light to turn OFF (e.g., 'living_room_light'): ");
        String id = ConsoleReader.readString();
        Device device = controller.getDevice(id);
        if (device != null) {
            controller.executeCommand(new TurnOffCommand(device));
        } else {
            System.out.println("Device with ID '" + id + "' not found.");
        }
    }

    private static void setThermostat(SmartHomeController controller) {
        System.out.print("Enter ID of the thermostat (e.g., 'main_thermostat'): ");
        String id = ConsoleReader.readString();
        Device device = controller.getDevice(id);
        if (device instanceof Thermostat) {
            System.out.print("Enter new temperature: ");
            int temp = ConsoleReader.readInt();
            // Directly call the method, then notify and check triggers
            ((Thermostat) device).setTemperature(temp);
            controller.executeCommand(() -> {}); // Empty command to trigger notifications
        } else {
            System.out.println("Device with ID '" + id + "' is not a thermostat or not found.");
        }
    }

    private static void unlockDoor(SmartHomeController controller) {
        System.out.print("Enter ID of the door to UNLOCK (e.g., 'front_door'): ");
        String id = ConsoleReader.readString();
        Device device = controller.getDevice(id);
        if (device instanceof DeviceProxy) {
            controller.executeCommand(new UnlockCommand((DeviceProxy) device));
        } else {
            System.out.println("Device with ID '" + id + "' is not a door or not found.");
        }
    }

    private static void lockDoor(SmartHomeController controller) {
        System.out.print("Enter ID of the door to LOCK (e.g., 'front_door'): ");
        String id = ConsoleReader.readString();
        Device device = controller.getDevice(id);
        if (device instanceof DeviceProxy) {
            controller.executeCommand(new LockCommand((DeviceProxy) device));
        } else {
            System.out.println("Device with ID '" + id + "' is not a door or not found.");
        }
    }

    /**
     * Sets up the initial state of the smart home with some devices and a trigger.
     */
    private static void setupInitialState(SmartHomeController controller) {
        // Create devices using the factory
        Device light = DeviceFactory.createDevice("light", "living_room_light");
        Device thermostat = DeviceFactory.createDevice("thermostat", "main_thermostat");
        Device door = DeviceFactory.createDevice("door", "front_door");

        // IMPORTANT: Wrap the door lock with a security proxy
        DeviceProxy doorProxy = new DeviceProxy(door);

        // Add devices to the controller
        controller.addDevice(light);
        controller.addDevice(thermostat);
        controller.addDevice(doorProxy); // Add the proxy, not the real door!

        // Create a creative automation trigger
        // Condition: The thermostat temperature goes above 75 degrees
        // Action: Turn off the living room light
        Trigger highTempTrigger = new Trigger(
            "If temp > 75°F, turn off living room light",
            () -> ((Thermostat) thermostat).getTemperature() > 75,
            new TurnOffCommand(light)
        );

        controller.addTrigger(highTempTrigger);

        System.out.println("\n--- System Initialized ---");
        controller.displayAllDeviceStatuses();
        System.out.println("Automation Rule Added: " + highTempTrigger.getDescription());
        System.out.println("--------------------------");
    }
}
