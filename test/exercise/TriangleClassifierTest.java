package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @Test
    void triangleClassificationTest1() {
        double side1 = 2.0;
        double side2 = 2.0;
        double side3 = 2.0;
        String expected = "tam giác đều";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
    @Test
    void triangleClassificationTest2() {
        double side1 = 2.0;
        double side2 = 2.0;
        double side3 = 3.0;
        String expected = "tam giác cân";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
    @Test
    void triangleClassificationTest3() {
        double side1 = 3.0;
        double side2 = 4.0;
        double side3 = 5.0;
        String expected = "tam giác thường";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
    @Test
    void triangleClassificationTest4() {
        double side1 = 8.0;
        double side2 = 2.0;
        double side3 = 3.0;
        String expected = "không phải là tam giác";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
    @Test
    void triangleClassificationTest5() {
        double side1 = -1.0;
        double side2 = 2.0;
        double side3 = 1.0;
        String expected = "không phải là tam giác";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
    @Test
    void triangleClassificationTest6() {
        double side1 = 0.0;
        double side2 = 1.0;
        double side3 = 1.0;
        String expected = "không phải là tam giác";

        assertEquals(expected, TriangleClassifier.triangleClassification(side1, side2, side3));
    }
}