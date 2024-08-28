package todoList;

public class Read {
    public void read(Taskset mytask) {  // Accept the Taskset object as a parameter
        if (Taskset.usertasks.taskCount == 0) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("TASK_NAME | PRIORITY | STATUS | DEADLINE");
        System.out.println("----------------------------------------");

        for (int i = 0; i < Taskset.usertasks.taskCount; i++) {
            if (mytask.usertask[i] != null) {
                System.out.println(
                    mytask.usertask[i].task + " | " +
                    mytask.usertask[i].priority + " | " +
                    mytask.usertask[i].status + " | " +
                    mytask.usertask[i].deadline
                );
            }
        }

        System.out.println("--------------------------------END--------------------------------");
    }
}
