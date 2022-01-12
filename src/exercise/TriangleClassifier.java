package exercise;

public class TriangleClassifier {
    public static String triangleClassification(double side1, double side2, double side3) {
        if (side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side2 + side1) {
            return "không phải là tam giác";
        }
        if (side1 == side2 && side2 == side3) {
            return "tam giác đều";
        } else {
            if (side1 == side2 || side2 == side3 || side1 == side3) {
                return "tam giác cân";
            } else {
                return "tam giác thường";
            }
        }
    }
}
