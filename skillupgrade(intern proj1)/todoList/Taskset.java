package todoList;

public class Taskset {
    usertasks[] usertask = new usertasks[100];

    public Taskset(){
        
    }

    public class usertasks {
        String task;
        int priority;
        String status;
        String deadline;
        static int taskCount = 0;  // Initialize taskCount once

        public usertasks(String task, int priority, String status, String deadline) {
            this.task = task;
            this.priority = priority;
            this.status = status;
            this.deadline = deadline;
            // Do not reset taskCount here; it should be incremented in the Create class
        }
    }
}
