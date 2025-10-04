package com.smarthome.model.trigger;

import com.smarthome.patterns.command.Command;
import java.util.function.Supplier;

/**
 * Represents an automation rule.
 * A trigger links a Condition (a boolean supplier) to an Action (a Command).
 */
public class Trigger {
    private final String description;
    private final Supplier<Boolean> condition;
    private final Command action;

    public Trigger(String description, Supplier<Boolean> condition, Command action) {
        this.description = description;
        this.condition = condition;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Checks if the condition is met and executes the action if it is.
     */
    public void checkAndExecute() {
        if (condition.get()) {
            System.out.println("\n--- TRIGGER ACTIVATED: " + description + " ---");
            action.execute();
            System.out.println("--- TRIGGER ACTION COMPLETE ---");
        }
    }
}
