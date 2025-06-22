public class TaskLinkedList {
    private TaskNode head;
    private TaskNode tail;

    public TaskLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.task_id == taskId) {
                current.displayTask();
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }
    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete task.");
            return;
        }
        
        if (head.task.task_id == taskId) {
            head = head.next;
            if (head == null) {
                tail = null; // If the list becomes empty
            }
            System.out.println("Task with ID " + taskId + " deleted.");
            return;
        }

        TaskNode current = head;
        while (current.next != null && current.next.task.task_id != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task with ID " + taskId + " not found.");
        } else {
            current.next = current.next.next;
            if (current.next == null) {
                tail = current; // Update tail if we deleted the last node
            }
            System.out.println("Task with ID " + taskId + " deleted.");
        }
    }
    

    public void displayTasks() {
        TaskNode current = head;
        while (current != null) {
            current.displayTask();
            current = current.next;
        }
    }
}