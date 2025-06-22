public class Main{
    public static void main(String[] args){
        TaskLinkedList task_list = new TaskLinkedList();
        task_list.addTask(new Task(1, "Task Skilling", "Pending"));
        task_list.addTask(new Task(2, "Task Deepskilling", "In Progress"));
        task_list.addTask(new Task(3, "Task assignment", "Completed"));
        System.out.println("All tasks:");
        task_list.displayTasks();
        System.out.println("Searxching for task with ID 1:");
        task_list.searchTask(1);
        
        System.out.println("Removing task with ID 2:");
        task_list.deleteTask(2);
        System.out.println("All tasks after removal:");
        task_list.displayTasks();

    }
}