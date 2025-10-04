package com.smarthome.patterns.command;

import com.smarthome.model.device.Device;

public class TurnOffCommand implements Command {
    private final Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}
