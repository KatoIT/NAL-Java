package BaiTap;

public class Circle {
    private final double radius;
    private final String color;

    public Circle() {
        this.radius = 1.0;
        this.color = "Red";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

}
