public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("3115222", "Mohan", "B");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        controller.setStudentName("Kumar");
        controller.setStudentGrade("A");
        controller.updateView();
    }
}
