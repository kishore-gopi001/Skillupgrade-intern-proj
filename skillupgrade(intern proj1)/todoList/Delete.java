package todoList;

import java.util.Scanner;

import todoList.Taskset.usertasks;

public class Delete {
    String taskName;

    public void delete(Taskset task) {
        System.out.println("GIVE THE NAME OF THE TASK YOU WANT TO DELETE:");
        System.out.println("MAKE SURE YOUR TASK NAME IS SAME AS YOUR PREVIOUS REGISTER");
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in) ;
            this.taskName = sc.nextLine();
            boolean found = false;

            for (int i = 0; i < usertasks.taskCount; i++) {
                if (this.taskName.equals(task.usertask[i].task)) {
                    found = true;
                    // Shift remaining tasks left by one position
                    for (int j = i; j < usertasks.taskCount - 1; j++) {
                        task.usertask[j] = task.usertask[j + 1];
                    }
                    // Set the last element to null since it's now a duplicate
                    task.usertask[usertasks.taskCount - 1] = null;
                    usertasks.taskCount--; // Decrease the task count
                    System.out.println("YOUR TASK WAS DELETED SUCCESSFULLY");
                    break;
                }
            }

            if (!found) {
                System.out.println("TASK NOT FOUND");
            }
        }
    }

