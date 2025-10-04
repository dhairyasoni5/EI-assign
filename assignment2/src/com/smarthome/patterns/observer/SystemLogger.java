package com.smarthome.patterns.observer;

/**
 * A concrete Observer that logs system events to the console.
 */
public class SystemLogger implements Observer {
    @Override
    public void update(String message) {
        // In a real application, this would write to a file or a logging service.
        System.out.println("[SYSTEM LOG]: " + message);
    }
}
