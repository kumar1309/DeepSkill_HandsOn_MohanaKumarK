public class Task{
    int task_id;
    String task_name;
    String task_status;
    public Task(int task_id, String task_name, String task_status){
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_status = task_status;
    } 
    public void Display_task(){
        System.out.println("Task ID: " + task_id);
        System.out.println("Task Name: " + task_name);
        System.out.println("Task Status: " + task_status);
    }
}