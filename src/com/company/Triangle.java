package com.company;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        // input
        Scanner scanner = new Scanner(System.in);
        double edge1, edge2, edge3;
        System.out.println("Enter edge 1: ");
        edge1 = scanner.nextDouble();
        System.out.println("Enter edge 2: ");
        edge2 = scanner.nextDouble();
        System.out.println("Enter edge 3: ");
        edge3 = scanner.nextDouble();
        //
        try{
            Triangle obj = new Triangle(1,0,3);//object of class Triangle and calls the constructor
        }catch(Exception m){System.out.println("Exception occured: "+m);//if exception is catught then then display the information
        }

    }
    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{//constructor throws IllegalTriangleException
        if(side1+side2<side3) //if sum of 2 side is less than third side then throw exception
            throw new IllegalTriangleException("Triangle violet the rule."); // throw is used to create a new exception and throw it.
        else
            System.out.println("Triangle follows the rule."); //if no exception occur
    }


}
class IllegalTriangleException extends Exception{//exception class inheriting the Exception class
    IllegalTriangleException(String s){
        super(s);  // Call constructor of parent Exception
    }
}