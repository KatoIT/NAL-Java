package Exercise.Triangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        double side1, side2, side3;
        System.out.print("Enter side1: ");
        side1 = sc.nextDouble();
        System.out.print("Enter side2: ");
        side2 = sc.nextDouble();
        System.out.print("Enter side3: ");
        side3 = sc.nextDouble();
        System.out.print("Enter color: ");
        String color = sc.next();
        Triangle triangle = new Triangle(color, true, side1, side2, side3);
        System.out.println(triangle);
        System.out.println("Perimeter = " + triangle.getPerimeter());
        System.out.println("Area = " + triangle.getArea());
        sc.close();
    }
}
