package BaiTap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Circle circle = new Circle();
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());

        Student student = new Student();
        System.out.println(student);
        student.setName("An");
        student.setClasses("CNTT1");
        System.out.println(student);

    }
}
