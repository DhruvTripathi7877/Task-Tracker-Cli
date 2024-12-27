package org.yourcompany.yourproject;

import java.io.FileWriter;
import java.io.IOException;

public class TaskTrackerCli {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command provided. Usage: task-cli <command> [arguments]");
            return;
        }

        String command = args[0];

        switch (command.toLowerCase()) {
            case "add":
                if (args.length > 1) {
                    String task = args[1];
                    addTask(task);
                } else {
                    System.out.println("Please provide a task to add. Usage: task-cli add \"<task>\"");
                }
                break;

            default:
                System.out.println("Unknown command: " + command);
                System.out.println("Available commands: add");
        }
    }

    private static void addTask(String task) {
        try (FileWriter writer = new FileWriter("tasks.json", true)) {
            writer.write(task + System.lineSeparator());
            System.out.println("Task added: " + task);
        } catch (IOException e) {
            System.out.println("An error occurred while adding the task.");
            e.printStackTrace();
        }
    }
}
    