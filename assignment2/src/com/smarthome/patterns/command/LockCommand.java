package com.smarthome.patterns.command;

import com.smarthome.model.proxy.DeviceProxy;

public class LockCommand implements Command {
    private final DeviceProxy proxy;

    public LockCommand(DeviceProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public void execute() {
        proxy.lock();
    }
}
