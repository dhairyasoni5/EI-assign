package com.smarthome.patterns.observer;

/**
 * [cite_start]The Observer interface for the Observer Pattern. [cite: 164]
 * Any class that wants to be notified of state changes in the Subject
 * (SmartHomeController) must implement this interface.
 */
public interface Observer {
    void update(String message);
}
