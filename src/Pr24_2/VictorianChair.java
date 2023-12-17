package Pr24_2;

class VictorianChair implements Chair {
    private int age;

    public VictorianChair(int age) {
        this.age = age;
        System.out.println("Victorian chair's age is " + age);
    }

    public int getAge() {
        return age;
    }
}