package com.company;

public class ClassNameTest {
    protected static final String[] validClassName = new String[]{"C0318G", "A0318H", "P0318I", "C0111K", "C0318L", "C0418M"};
    protected static final String[] invalidClassName = new String[]{"12345", "1234_", "abcde", "M0318G", "P0323A"};

    public static void main(String[] args) {
        ClassName className = new ClassName();
        for (String account : validClassName) {
            boolean isValid = className.validate(account);
            System.out.println("ClassName is " + account + " is valid: " + isValid);
        }
        for (String account : invalidClassName) {
            boolean isValid = className.validate(account);
            System.out.println("ClassName is " + account + " is valid: " + isValid);
        }
    }
}
