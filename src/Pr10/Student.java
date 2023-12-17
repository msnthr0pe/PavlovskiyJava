package Pr10;

public class Student {
    private String name;
    private String surname;
    private String speciality;
    private int course;
    private String group;
    private Double GPA;

    public Student(String name, String surname, String speciality, int course, String group, double GPA) {
        this.name = name;
        this.surname = surname;
        this.speciality = speciality;
        this.course = course;
        this.group = group;
        this.GPA = GPA;
    }

    public Student() {
    }

    public Double getGPA() {
        return GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public String getSpeciality() {
        return speciality;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }
}