package Pr17.MVCEmployee;

public class EmployeeController {
    public Employee model;
    public EmployeeView view;

    public EmployeeController(Employee model, EmployeeView view) {
        this.model = model;
        this.view = view;
    }

    public void IncreaseSalary(){
        this.model.setSalary(this.model.getSalary()*1.1);
        if (this.model.getSalary() > 50000){
            SetPost("Middle");
        }
        if (this.model.getSalary() > 70000){
            SetPost("Senior");
        }
    }

    public void ReduceSalary(){
        this.model.setSalary(this.model.getSalary()*0.9);
        if (this.model.getSalary() < 70000){
            SetPost("Middle");
        }
        if (this.model.getSalary() < 50000){
            SetPost("Junior");
        }
    }

    public double GetSalary(){
        return this.model.getSalary();
    }

    private void SetPost(String newPost){
        this.model.setPost(newPost);
    }

    public void SetName(String name){
        this.model.setName(name);
    }

    public void SetSalary(double salary){
        this.model.setSalary(salary);
        if (salary<50000){
            SetPost("Junior");
        } else if (salary < 70000) {
            SetPost("Middle");
        } else {
            SetPost("Senior");
        }
    }

    public String GetName(){
        return this.model.getName();
    }

    public String GetPost(){
        return this.model.getPost();
    }

    public void UpdateView(){
        this.view.ViewData(this.model.getName(), this.model.getPost(), this.model.getSalary());
    }
}