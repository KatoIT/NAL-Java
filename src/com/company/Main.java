package com.company;


public class Main {

    public static void main(String[] args) {
        /*
        * String
        * */
        BSTDemo<String> btsDemo = new BSTDemo<>();
        btsDemo.insert("E");
        btsDemo.insert("C");
        btsDemo.insert("G");
        btsDemo.insert("B");
        btsDemo.insert("F");
        btsDemo.insert("A");
        btsDemo.insert("D");
        btsDemo.insert("H");
        System.out.println(btsDemo);
        btsDemo.remove("C");
        System.out.println(btsDemo.inOrder(true));
        String val = "F";
        System.out.println("Index of "+ val + ": " +  btsDemo.find(val));

        /*
        * String
        * */
        BSTDemo<Integer> BTInt = new BSTDemo<>() ;
        BTInt.insert(15);
        BTInt.insert(1);
        BTInt.insert(71);
        BTInt.insert(9);
        BTInt.insert(0);
        BTInt.insert(33);
        BTInt.insert(14);
        BTInt.insert(23);
        System.out.println(BTInt);
        if (BTInt.remove(5)){
            System.out.println("Delete success!");
        }else {
            System.out.println("Delete fail!");
        }
        System.out.println(BTInt.inOrder(false));
        Integer val2 = 71;
        System.out.println("Index of "+ val + ": " +  BTInt.find(val2));

        /*
        *
        *
        * */



    }
}
