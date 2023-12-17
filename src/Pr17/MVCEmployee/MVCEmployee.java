package Pr17.MVCEmployee;

public class MVCEmployee {
    public static void main(String[] args) {
        Employee model = new Employee();
        EmployeeView view = new EmployeeView();
        EmployeeController controller = new EmployeeController(model, view);
        controller.SetName("Mikhail");
        controller.SetSalary(77777);
        view.GUI(controller);
    }


}
