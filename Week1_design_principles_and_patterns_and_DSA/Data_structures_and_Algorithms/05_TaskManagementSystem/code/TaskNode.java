public class TaskNode{
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }

    public void displayTask() {
        task.Display_task();
    }
}