package exercise;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        // Reverse Array Integer
        Integer[] arrInt = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Stack<Integer> stack = new Stack<>();
        for (Integer element : arrInt) {
            stack.push(element);
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        // Reverse String (Word)
        String str = "Nguyen Van An";
        Stack<String> stackStr = new Stack<>();
        for (String element : str.split(" ")) {
            stackStr.push(element);
        }
        while (stackStr.size() > 0) {
            System.out.print(stackStr.pop() + " ");
        }
    }
}
