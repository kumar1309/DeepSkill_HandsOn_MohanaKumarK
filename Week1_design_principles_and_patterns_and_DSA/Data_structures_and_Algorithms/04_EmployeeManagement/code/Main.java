public class Main{
    public static void main(String[] args){
        EmployeeManager employeeManager = new EmployeeManager(3);
        Employee employee1 = new Employee(001, "Mohan", "Software developer", 60000.0);
        Employee employee2 = new Employee(002, "Kumar", "Team Lead", 55000.0);
        Employee employee3 = new Employee(003, "Thirisha", "CA", 80000.0);
        employeeManager.addEmployee(employee1);
        employeeManager.addEmployee(employee2);
        employeeManager.addEmployee(employee3);
        System.out.println("Displaying all employees:");
        employeeManager.displayAllEmployees();
        System.out.println("Searching for employee with ID 003:");
        employeeManager.searchEmployee(003);
        System.out.println("Removing employee with ID 002:");
        employeeManager.removeEmployee(002);
        System.out.println("Displaying all employees after removal:");
        employeeManager.displayAllEmployees();
    }
}