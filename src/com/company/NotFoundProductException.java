package com.company;

public class NotFoundProductException extends Exception {//exception class inheriting the Exception class

    NotFoundProductException(String s) {
        super(s);  // Call constructor of parent Exception
    }
}