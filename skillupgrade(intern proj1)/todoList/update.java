package todoList;

import java.util.Scanner;

public class update {
    String taskName;
    int select;
    String newtask;
    int newpriority;
    String newstatus;
    String newdeadline;

    public void taskupdate(Taskset mytask) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.println("GIVE THE NAME OF THE TASK YOU WANT TO UPDATE:");
        System.out.println("MAKE SURE YOUR TASK NAME IS THE SAME AS YOUR PREVIOUSLY REGISTERED TASK");
        this.taskName = sc.nextLine();

        System.out.println("Press 1 to update your task name.");
        System.out.println("Press 2 to update your priority.");
        System.out.println("Press 3 to update your status.");
        System.out.println("Press 4 to update your deadline.");
        this.select = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        boolean taskFound = false;

        switch (select) {
            case 1:
                for (int i = 0; i < Taskset.usertasks.taskCount; i++) {
                    if (this.taskName.equals(mytask.usertask[i].task)) {
                        System.out.println("Enter the new task name:");
                        this.newtask = sc.nextLine();
                        mytask.usertask[i].task = this.newtask;
                        System.out.println("YOUR TASK NAME WAS SUCCESSFULLY UPDATED");
                        taskFound = true;
                        break;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < Taskset.usertasks.taskCount; i++) {
                    if (this.taskName.equals(mytask.usertask[i].task)) {
                        System.out.println("Enter your new priority:");
                        this.newpriority = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        mytask.usertask[i].priority = this.newpriority;
                        System.out.println("YOUR PRIORITY WAS SUCCESSFULLY UPDATED");
                        taskFound = true;
                        break;
                    }
                }
                break;

            case 3:
                for (int i = 0; i < Taskset.usertasks.taskCount; i++) {
                    if (this.taskName.equals(mytask.usertask[i].task)) {
                        System.out.println("Enter your new status:");
                        this.newstatus = sc.nextLine();
                        mytask.usertask[i].status = this.newstatus;
                        System.out.println("YOUR STATUS WAS SUCCESSFULLY UPDATED");
                        taskFound = true;
                        break;
                    }
                }
                break;

            case 4:
                for (int i = 0; i < Taskset.usertasks.taskCount; i++) {
                    if (this.taskName.equals(mytask.usertask[i].task)) {
                        System.out.println("Enter your new deadline:");
                        this.newdeadline = sc.nextLine();
                        mytask.usertask[i].deadline = this.newdeadline;
                        System.out.println("YOUR DEADLINE WAS SUCCESSFULLY UPDATED");
                        taskFound = true;
                        break;
                    }
                }
                break;

            default:
                System.out.println("Please select a number between 1 and 4.");
                break;
        }

        if (!taskFound) {
            System.out.println("Your task name was incorrect or not available in the list.");
        }
    }
}
