package exercise;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        while (number >= 1) {
            if (number % 10 == 3) isFizz = true;
            if (number % 10 == 5) isBuzz = true;
            number = (number - (number % 10)) / 10;
        }

        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }
}
