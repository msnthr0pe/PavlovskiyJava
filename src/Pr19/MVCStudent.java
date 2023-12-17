package Pr19;

public class MVCStudent {
    public static void main(String[] args) {
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);
        view.GUI(controller);
    }
}