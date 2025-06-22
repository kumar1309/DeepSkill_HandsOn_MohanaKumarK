public class Employee {
    private int employee_Id;
    private String employee_name;
    private String employee_department;
    private double employee_salary;

    public Employee(int employee_Id, String employee_name, String employee_department, double employee_salary) {
        this.employee_Id = employee_Id;
        this.employee_name = employee_name;
        this.employee_department = employee_department;
        this.employee_salary = employee_salary;
    }
    public int get_EmployeeId() {
        return employee_Id;
    }
    public String get_EmployeeName() {
        return employee_name;
    }
    public String get_EmployeeDepartment() {
        return employee_department;
    }
    public double get_EmployeeSalary() {
        return employee_salary;
    }
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employee_Id);
        System.out.println("Employee Name: " + employee_name);
        System.out.println("Employee Department: " + employee_department);
        System.out.println("Employee Salary: $" + employee_salary);
    }
}