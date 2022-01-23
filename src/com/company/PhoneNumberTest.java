package com.company;

public class PhoneNumberTest {
    protected static final String[] validPhoneNumbers = new String[]{"(84)-(0978489648)", "(84)-(0978485678)", "(84)-(0978481234)"};
    protected static final String[] invalidPhoneNumbers = new String[]{"(a4)-(0978489648)", "(84)-(78489648)", "(84)-(0978489a48)"};

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        for (String account : validPhoneNumbers) {
            boolean isValid = phoneNumber.validate(account);
            System.out.println("PhoneNumber is " + account + " is valid: " + isValid);
        }
        for (String account : invalidPhoneNumbers) {
            boolean isValid = phoneNumber.validate(account);
            System.out.println("PhoneNumber is " + account + " is valid: " + isValid);
        }
    }
}
