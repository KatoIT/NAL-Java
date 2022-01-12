package Exercise.Shape;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Cylinder cylinder = new Cylinder(2, "blue", true, 5);
        System.out.println("Cylinder volume = " + cylinder.getVolume());
        System.out.println(cylinder);
    }
}
