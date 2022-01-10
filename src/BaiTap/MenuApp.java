package BaiTap;

import java.util.Scanner;

public class MenuApp {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 15; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                }
                case 2 -> {
                    int height = 6;
                    int choice2 = 1;
                    System.out.println("\tRight angle at position: ");
                    System.out.println("\t1. Top-Left");
                    System.out.println("\t2. Top-Right");
                    System.out.println("\t3. Bottom-Left");
                    System.out.println("\t4. Bottom-Right");
                    System.out.println("\tEnter your choice: ");
                    choice2 = input.nextInt();
                    switch (choice2) {
                        case 1 -> {
                            for (int i = 0; i < height; i++) {
                                for (int j = height - i; j > 0; j--) {
                                    System.out.print("*");
                                }
                                System.out.println("");
                            }
                        }
                        case 2 -> {
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < height; j++) {
                                    if (j >= i) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println("");
                            }
                        }
                        case 3 -> {
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j <= i; j++) {
                                    System.out.print("*");
                                }
                                System.out.println("");
                            }
                        }
                        case 4 -> {
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < height; j++) {
                                    if (j >= height - i - 1) {
                                        System.out.print("*");
                                    } else {
                                        System.out.print(" ");
                                    }
                                }
                                System.out.println("");
                            }
                        }
                        default ->  System.out.println("No choice!");
                    }
                }
                case 3 -> {
                    for (int i = 0; i < 6; i++) {
                        for(int j = i; j < 6; j++) {
                            System.out.print(" ");
                        }
                        // in ky tu ngoi sao
                        for(int j = 1; j <= (2*i-1); j++) {
                           System.out.print("*");
                        }
                        System.out.println("");
                    }
                }
                case 4 -> System.exit(0);
                default -> System.out.println("No choice!");
            }
        }
    }
}
