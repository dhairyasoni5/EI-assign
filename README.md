# EI Assignments Repository

This repository contains assignments for the Engineering Innovation course.

## Assignments

### [Assignment 1: MindSpark Neo Learning Platform](./assignment1/)
A Java application demonstrating six design patterns (Singleton, Factory, Observer, Command, Decorator, Adapter) through an educational platform simulation.

### [Assignment 2: Smart Home System](./assignment2/)
A comprehensive Java application demonstrating multiple design patterns (Singleton, Factory, Proxy, Observer, Command) in a smart home automation system with security features and automation rules.

## What This Project Does

This is a learning management system that simulates how students interact with questions, how teachers monitor progress, and how the system integrates with external content. It's built to show how different programming patterns work together in a real application.

## Design Patterns Demonstrated

1. **Singleton** - One central repository for all learning content
2. **Factory** - Creates different types of questions automatically  
3. **Observer** - Notifies teachers and parents when students answer questions
4. **Command** - Lets students undo their answers
5. **Decorator** - Adds hints and explanations to questions
6. **Adapter** - Connects to external university video content

## How to Run

### Prerequisites
- Java 8 or higher installed on your computer

### Steps

1. **Compile the code:**
   ```bash
   javac -d bin -cp src (Get-ChildItem -Recurse -Path src -Filter "*.java" | ForEach-Object { $_.FullName })
   ```

2. **Run the application:**
   ```bash
   java -cp bin com.ei.mindsparkneo.MindSparkNeoSim
   ```

### What You'll See

The program will show:
- A student named Arya answering math and geography questions
- Real-time notifications to teachers and parents
- Questions with hints and explanations
- Integration with external video content
- The ability to undo answers

## Project Structure

```
src/com/ei/mindsparkneo/
├── MindSparkNeoSim.java          # Main program
├── model/                        # Core data classes
├── patterns/                     # Design pattern implementations
│   ├── creational/              # Singleton, Factory
│   ├── structural/              # Adapter, Decorator  
│   └── behavioral/              # Observer, Command
├── exception/                    # Custom error handling
└── external/                     # Third-party API simulation
```

## Why These Patterns Matter

- **Singleton**: Prevents duplicate content loading
- **Factory**: Makes adding new question types easy
- **Observer**: Keeps everyone informed of student progress
- **Command**: Provides undo functionality
- **Decorator**: Adds features without changing original code
- **Adapter**: Works with incompatible external systems

This project shows how these patterns solve real problems in software development, not just academic exercises.
