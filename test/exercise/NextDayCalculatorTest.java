package exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    @DisplayName("Test 1")
    void findDayNextTest1() throws ParseException {
        String curDate = "01/01/2018";
        String expected = "02/01/2018";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 2")
    void findDayNextTest2() throws ParseException {
        String curDate = "31/01/2018";
        String expected = "01/02/2018";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 3")
    void findDayNextTest3() throws ParseException {
        String curDate = "30/04/2018";
        String expected = "01/05/2018";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 4")
    void findDayNextTest4() throws ParseException {
        String curDate = "28/02/2018";
        String expected = "01/03/2018";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 5")
    void findDayNextTest5() throws ParseException {
        String curDate = "29/02/2020";
        String expected = "01/03/2020";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 6")
    void findDayNextTest6() throws ParseException {
        String curDate = "31/12/2018";
        String expected = "01/01/2019";

        String result = NextDayCalculator.findDayNext(curDate);
        assertEquals(expected, result);
    }

}