# Smart Home System

A comprehensive Java application demonstrating multiple design patterns in a smart home automation system.

## 🏗️ Architecture

This project implements several key design patterns:

- **Singleton Pattern**: `SmartHomeController` ensures a single point of control
- **Factory Pattern**: `DeviceFactory` creates device objects without exposing instantiation logic
- **Proxy Pattern**: `DeviceProxy` provides security for sensitive operations like door unlocking
- **Observer Pattern**: `SystemLogger` observes and logs system events
- **Command Pattern**: Commands encapsulate device operations for triggers and user actions

## 📁 Project Structure

```
src/
└── com/
    └── smarthome/
        ├── Main.java                    # Application entry point
        ├── controller/
        │   └── SmartHomeController.java # Central system controller (Singleton)
        ├── factory/
        │   └── DeviceFactory.java       # Device creation factory
        ├── model/
        │   ├── device/
        │   │   ├── Device.java          # Device interface
        │   │   ├── DoorLock.java        # Smart door lock
        │   │   ├── Light.java           # Smart light
        │   │   └── Thermostat.java      # Smart thermostat
        │   ├── proxy/
        │   │   └── DeviceProxy.java     # Security proxy for devices
        │   └── trigger/
        │       └── Trigger.java         # Automation rules
        ├── patterns/
        │   ├── command/
        │   │   ├── Command.java         # Command interface
        │   │   ├── LockCommand.java     # Lock door command
        │   │   ├── TurnOffCommand.java  # Turn off device command
        │   │   ├── TurnOnCommand.java   # Turn on device command
        │   │   └── UnlockCommand.java   # Unlock door command
        │   └── observer/
        │       ├── Observer.java        # Observer interface
        │       └── SystemLogger.java    # System event logger
        └── utils/
            └── ConsoleReader.java       # Console input utility
```

## 🚀 How to Run

1. **Compile the project:**
   ```bash
   javac -d . -cp . src\com\smarthome\Main.java src\com\smarthome\controller\SmartHomeController.java src\com\smarthome\factory\DeviceFactory.java src\com\smarthome\model\device\*.java src\com\smarthome\model\proxy\DeviceProxy.java src\com\smarthome\model\trigger\Trigger.java src\com\smarthome\patterns\command\*.java src\com\smarthome\patterns\observer\*.java src\com\smarthome\utils\ConsoleReader.java
   ```

2. **Run the application:**
   ```bash
   java -cp . com.smarthome.Main
   ```

## 🎮 Features

### Pre-configured Devices
- **Living Room Light** (`living_room_light`)
- **Main Thermostat** (`main_thermostat`) 
- **Front Door** (`front_door`) - Protected by security proxy

### Automation Rules
- **Temperature Trigger**: When thermostat temperature exceeds 75°F, the living room light automatically turns off

### Interactive Menu
1. View all device statuses
2. Turn ON a light
3. Turn OFF a light
4. Set thermostat temperature
5. UNLOCK the front door (requires PIN: 1234)
6. LOCK the front door
0. Exit

## 🔐 Security Features

- **Door Unlocking**: Requires PIN authentication (PIN: 1234)
- **Proxy Pattern**: Sensitive operations are protected through the DeviceProxy
- **System Logging**: All device operations are logged for security monitoring

## 🎯 Design Patterns Demonstrated

1. **Singleton**: Ensures only one SmartHomeController instance exists
2. **Factory**: Creates devices without exposing concrete classes
3. **Proxy**: Adds security layer for sensitive operations
4. **Observer**: Logs system events automatically
5. **Command**: Encapsulates operations for triggers and user actions

## 📝 Example Usage

1. Start the application
2. View device statuses (option 1)
3. Set thermostat to 80°F (option 4, enter "main_thermostat", then "80")
4. Watch the automation trigger activate and turn off the light
5. Try unlocking the door (option 5, enter "front_door", PIN: 1234)

The system demonstrates real-time automation, security controls, and comprehensive logging of all operations.