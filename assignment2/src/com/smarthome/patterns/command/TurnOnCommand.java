package com.smarthome.patterns.command;

import com.smarthome.model.device.Device;

public class TurnOnCommand implements Command {
    private final Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
