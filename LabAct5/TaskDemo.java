package campus.tasks;

public class TaskDemo {

    public static void main(String[] args) {

        TaskBox<String> task = new TaskBox<>("Submit Module 5 Lab");
        TaskBox<Integer> time = new TaskBox<>(45);

        Priority priority = Priority.HIGH;

        String action = switch (priority) {
            case HIGH -> "DO FIRST";
            case MEDIUM -> "SCHEDULE";
            case LOW -> "OPTIONAL";
        };

        System.out.println("=== Type-Safe Task Card ===");
        System.out.println("Task: " + task.getItem());
        System.out.println("Estimated Minutes: " + time.getItem());
        System.out.println("Priority: " + priority);
        System.out.println("Action: " + action);
    }
}
