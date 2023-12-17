package Pr1;

public class Ball {
    private String color;
    private int radius;

    public Ball(String color, int radius) {
        this.color = color;
        this.radius = radius;
    }

    public Ball (String c){
        color = c;
        radius = 0;
    }
    public Ball (int r){
        color = "Base_color";
        radius = r;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public int getRadius() {
        return radius;
    }
    @Override
    public String toString(){
        return this.color + ", radius " + this.radius;
    }
    public void print(){
        System.out.println(this);
    }

}