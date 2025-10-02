# Design Patterns - Exercise1

**Demonstrate understanding of behavioral, creational, and structural design patterns by coding six different use cases in Java.**

## 🔑 Implemented Patterns

### Behavioral Patterns
- **Observer Pattern** → Stock / News Publisher (stock market price updates / news updates)
- **Strategy Pattern** → Payment Gateway System (Credit Card, PayPal, UPI)

### Creational Patterns
- **Singleton Pattern** → Logger Utility (single shared logger)
- **Factory Pattern** → Vehicle / Shape Creator (factory returns Car, Bike, Truck — or shapes)

### Structural Patterns
- **Adapter Pattern** → Media Player (MP3 + MP4 support via adapter)
- **Decorator Pattern** → Coffee Shop (add milk, sugar, chocolate as decorators)

---
# Design Patterns - Exercise2 - Problem1

Each pattern is implemented in its own self-contained package/folder. Each `Test_Case_X` contains separate `.java` files (one class/interface per file) and a `Main.java` to run that example.

Astronaut Daily Schedule Organizer

This is a console-based application that helps astronauts organize their daily schedules. The project was built as part of the HC 2025-26 Coding Exercises.

🚀 Features

- Add a new task with description, start time, end time, and priority level.

- Remove an existing task.

- View all tasks sorted by start time.

- Validate that tasks do not overlap with existing ones.

- Edit an existing task (update description, times, or priority).

- Mark tasks as completed.

- View tasks filtered by priority.

- Error handling with meaningful messages.

- Logging mechanism for application usage and errors.

🛠️ Design Patterns Used

- Singleton Pattern – Ensures only one instance of the ScheduleManager exists.

- Factory Pattern – Used in TaskFactory to create validated Task objects.

- Observer Pattern – ConflictNotifier alerts when a new task conflicts with existing ones.

📂 Project Structure

- model/Task.java → Task entity

- factory/TaskFactory.java → Task creation with validation

- manager/ScheduleManager.java → Singleton managing tasks

- observer/Observer.java, ConflictNotifier.java → Observer for conflicts

- util/Logger.java → Logging utility

- MainApp.java → Console-based user interface
