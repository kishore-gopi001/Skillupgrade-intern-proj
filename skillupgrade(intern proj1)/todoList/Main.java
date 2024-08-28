package todoList;
import java.util.Scanner;

import todoList.Taskset.usertasks;

public class Main {

    public static void main(String[] args) {
        Taskset task = new Taskset();
        int choice = 0;  // Declare select outside the loop

        Scanner scc = new Scanner(System.in);  // Initialize the Scanner once outside the loop
        
        do { 
            System.out.println("KISHORE'S TODO LIST APPLICATION");
            System.out.println("Press 1 for create");
            System.out.println("Press 2 for read");
            System.out.println("Press 3 for update");
            System.out.println("Press 4 for delete");
            System.out.println("Press 5 for exit");
            System.out.print("Enter your choice: ");
            
            if (scc.hasNextInt()) {
                choice = scc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scc.next();  // Clear the invalid input
                continue;  // Skip to the next iteration of the loop
            }
            
            switch (choice) {
                case 1:
                    Create cr = new Create();
                    cr.taskCreate(task);  // Create a new task
                    break;
                case 2:
                    if (usertasks.taskCount > 0) {
                        Read rr = new Read();
                        rr.read(task);  // Read existing tasks
                    } else {
                        System.out.println("Please create some tasks before reading.");
                    }
                    break;
                case 3:
                    if (usertasks.taskCount > 0) {
                        update up = new update();
                        up.taskupdate(task);  // Update an existing task
                    } else {
                        System.out.println("Please create some tasks before updating.");
                    }
                    break;
                case 4:
                    if (usertasks.taskCount > 0) {
                        Delete dl = new Delete();
                        dl.delete(task);  // Delete a task
                    } else {
                        System.out.println("Please create some tasks before deleting.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Please enter a number between 1 and 5.");
                    break;
            }
        } while (choice != 5);

        scc.close();  // Close the scanner after the loop ends
    }
}
