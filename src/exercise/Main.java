package exercise;


public class Main {

    public static void main(String[] args) {
        double percent = 50.0;
        System.out.println("Percent = " + percent + " %");
        // Circle Test
        Circle circle = new Circle();
        System.out.println("Area of the original circle: " + circle.getArea());
        circle.resize(percent);
        System.out.println("Area of circle after resizing: " + circle.getArea());
        System.out.println();

        // Rectangle Test
        Rectangle rectangle = new Rectangle();
        System.out.println("Area of the original rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of the original rectangle: " + rectangle.getPerimeter());
        rectangle.resize(percent);
        System.out.println("Area of rectangle after resizing: " + rectangle.getArea());
        System.out.println("Perimeter of rectangle after resizing: " + rectangle.getPerimeter());
        System.out.println();

        // Square Test
        Square square = new Square();
        System.out.println("Area of the original square: " + square.getArea());
        System.out.println("Perimeter of the original square: " + square.getPerimeter());
        square.resize(percent);
        System.out.println("Area of square after resizing: " + square.getArea());
        System.out.println("Perimeter of square after resizing: " + square.getPerimeter());
        //
        square.howToColor();

    }
}
