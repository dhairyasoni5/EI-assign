package com.ei.mindsparkneo.patterns.behavioral.command;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * The "Invoker" in the Command pattern. It takes command objects and triggers
 * their execution. It also maintains a history for undo functionality.
 */
public class LearningSessionManager {
    private static final Logger LOGGER = Logger.getLogger(LearningSessionManager.class.getName());
    private final Stack<Command> commandHistory = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
        LOGGER.info("Executed and logged command: " + command.getClass().getSimpleName());
    }

    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.unexecute();
            LOGGER.info("Undid last command.");
        } else {
            LOGGER.warning("Command history is empty. Nothing to undo.");
        }
    }
}


