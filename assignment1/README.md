# Assignment 1: MindSpark Neo Learning Platform

A Java application demonstrating six design patterns through an educational platform simulation.

## Design Patterns Implemented

1. **Singleton Pattern** - ContentRepository ensures single instance of content storage
2. **Factory Pattern** - QuestionFactory creates different types of questions
3. **Observer Pattern** - Real-time notifications to teachers and parents
4. **Command Pattern** - Undoable student actions with command history
5. **Decorator Pattern** - Adding hints and explanations to questions
6. **Adapter Pattern** - Integrating external university video content

## How to Run

### Compile:
```bash
javac -d bin -cp src (Get-ChildItem -Recurse -Path src -Filter "*.java" | ForEach-Object { $_.FullName })
```

### Execute:
```bash
java -cp bin com.ei.mindsparkneo.MindSparkNeoSim
```

## Project Structure
```
assignment1/
├── src/com/ei/mindsparkneo/
│   ├── MindSparkNeoSim.java          # Main application
│   ├── model/                        # Core data classes
│   ├── patterns/                     # Design pattern implementations
│   │   ├── creational/              # Singleton, Factory
│   │   ├── structural/              # Adapter, Decorator
│   │   └── behavioral/              # Observer, Command
│   ├── exception/                    # Custom exceptions
│   └── external/                     # Third-party API simulation
├── bin/                             # Compiled class files
└── _/design-patterns-showcase/      # Project structure requirements
```

## Features Demonstrated
- Student progress tracking with real-time notifications
- Question answering with undo functionality
- Dynamic question enhancement with hints and explanations
- Integration with external educational content
- Comprehensive logging and error handling
