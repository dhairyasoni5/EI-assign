package com.smarthome.patterns.command;

import com.smarthome.model.proxy.DeviceProxy;

public class UnlockCommand implements Command {
    private final DeviceProxy proxy;

    public UnlockCommand(DeviceProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute() {
        proxy.unlock();
    }
}
