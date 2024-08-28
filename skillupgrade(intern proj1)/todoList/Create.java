package todoList;

import java.util.Scanner;

public class Create {
    String task;
    int priority;
    String status;
    String deadline;

    public void taskCreate(Taskset mytask) {  // Accept the Taskset object as a parameter
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of your task:");
        task = sc.nextLine();

        System.out.println("How much priority you give to this task (rate between 1 to 10):");
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid integer between 1 and 10.");
            sc.next();  // Clear invalid input
        }
        priority = sc.nextInt();
        sc.nextLine();  // Clear the newline character from the buffer

        System.out.println("Enter the status of your task (complete or incomplete):");
        status = sc.nextLine();

        System.out.println("Give the deadline (enter date (dd/mm/yyyy)):");
        deadline = sc.nextLine();

        // Add the task to the Taskset object
        if (Taskset.usertasks.taskCount < mytask.usertask.length) {
            mytask.usertask[Taskset.usertasks.taskCount] = mytask.new usertasks(task, priority, status, deadline);
            Taskset.usertasks.taskCount++;
            System.out.println("Your task was created successfully.");
        } else {
            System.out.println("Task limit reached!");
        }
    }
    
}
