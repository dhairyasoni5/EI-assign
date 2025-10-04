package com.smarthome.patterns.command;

/**
 * The Command interface for the Command Pattern.
 * This decouples the object that invokes an operation from the one that knows
 * how to perform it. Used here for our Trigger actions.
 */
@FunctionalInterface // Good practice for single-method interfaces
public interface Command {
    void execute();
}
