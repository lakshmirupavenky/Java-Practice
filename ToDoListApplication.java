import java.util.ArrayList;
import java.util.Scanner;
public class ToDoListApplication {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            showMenu();
            int choice = getIntInput("Choose an option: ");
            switch (choice) {
                case 1 -> addTask();
                case 2 -> displayTasks();
                case 3 -> removeTask();
                case 4 -> {
                    System.out.println("Exiting application. Goodbye!");
                    run = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void showMenu() {
        System.out.println("\n--- To-Do List Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
    }
    private static void addTask() {
        System.out.print("Enter task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }
    private static void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("\n--- Your Tasks ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    private static void removeTask() {
        displayTasks();
        if (tasks.isEmpty()) return;
        System.out.print("Remove by (1) Index or (2) Name? Enter 1 or 2: ");
        String option = scanner.nextLine();
        switch (option) {
            case "1" -> {
                int index = getIntInput("Enter the task number to remove: ") - 1;
                if (index >= 0 && index < tasks.size()) {
                    System.out.println("Removed: " + tasks.remove(index));
                } else {
                    System.out.println("Invalid index.");
                }
            }
            case "2" -> {
                System.out.print("Enter the task name to remove: ");
                String name = scanner.nextLine();
                if (tasks.remove(name)) {
                    System.out.println("Task removed.");
                } else {
                    System.out.println("Task not found.");
                }
            }
            default -> System.out.println("Invalid option.");
        }
    }
    private static int getIntInput(String message) {
        int input = -1;
        while (true) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return input;
    }
}
