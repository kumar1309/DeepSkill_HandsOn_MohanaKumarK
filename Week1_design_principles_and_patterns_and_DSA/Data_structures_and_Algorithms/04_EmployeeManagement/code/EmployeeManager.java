public class EmployeeManager {
    private Employee[] employees;
    private int employeeCount;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        employeeCount = 0;
    }

    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = employee;
        } else {
            System.out.println("Employee list is full.");
        }
    }
    public void removeEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].get_EmployeeId() == employeeId) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--employeeCount] = null;
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }
    public void searchEmployee(int employeeId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].get_EmployeeId() == employeeId) {
                employees[i].displayEmployeeDetails();
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }

    public void displayAllEmployees() {
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployeeDetails();
            System.out.println("-----------------------");
        }
    }
}