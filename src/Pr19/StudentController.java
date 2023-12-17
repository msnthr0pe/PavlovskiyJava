package Pr19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class StudentController implements Comparator<Student> {
    public ArrayList<Student> models = new ArrayList<>();
    public StudentView view;

    public StudentController(StudentView view) {
        this.view = view;
        setArray();
    }

    public void setArray(){
        Random rand = new Random();
        for(int i = 0; i < Math.abs(rand.nextInt()%10 + 20); i++){
            double r = Math.abs(rand.nextInt()%30)+20;
            Student model = new Student();
            model.setName("Name " + i);
            model.setSurname("Surname " + i);
            model.setGPA(r/10);
            models.add(model);
        }
    }

    public void UpdateView(){
        for (int i = 0; i < models.size(); i++){
            view.ShowData(models.get(i).getName(), models.get(i).getSurname(), models.get(i).getGPA());
        }
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGPA().compareTo(o2.getGPA());
    }

    public  void quickSort(int low, int high) {
        if (this.models.isEmpty())
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        Student opora = this.models.get(middle);

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (compare(opora, this.models.get(i)) < 0) {
                i++;
            }

            while (compare(this.models.get(j), opora) < 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                Student temp = this.models.get(i);
                this.models.set(i, this.models.get(j));
                this.models.set(j, temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

    public Student FindStudent(String name, String surname) throws EmptyStringException{
        if (name.equals("") || surname.equals("")){
            throw new EmptyStringException("Не все поля заполнены");
        }
        for (int i = 0; i < models.size(); i++){
            if (models.get(i).getName().equals(name) && models.get(i).getSurname().equals(surname)){
                return models.get(i);
            }
        }
        return null;
    }
}