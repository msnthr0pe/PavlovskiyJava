package Pr9;

import java.util.Random;

public class Student implements Comparable<Student> {
    public Double IDNumber;
    private String name;


    public Student(double IDNumber, String name) {
        this.IDNumber = IDNumber;
        this.name = name;

    }

    public static Student[] generate(){
        Student[] arr = new Student[10];
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            double r = Math.abs(rand.nextInt()%30)+20;
            arr[i] = new Student(r/10, "Student id " + new String().valueOf(i));
        }
        return arr;
    }
    public static void printer(Student[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i].IDNumber + " " + arr[i].name);
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.IDNumber.compareTo(o.IDNumber);
    }
    public static void main(String[] args) {
        Student.printer(Student.generate());
    }
}