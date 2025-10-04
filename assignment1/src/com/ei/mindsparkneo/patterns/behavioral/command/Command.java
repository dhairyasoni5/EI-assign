package com.ei.mindsparkneo.patterns.behavioral.command;

public interface Command {
    void execute();
    void unexecute(); // For undo functionality
}


