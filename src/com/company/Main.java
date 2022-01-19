package com.company;


public class Main {

    public static void main(String[] args) {
        /*
        * String
        * */
        BTSDemo<String> btsDemo = new BTSDemo<>() {
            @Override
            int compareTo(String o1, String o2) {
                 return o1.compareTo(o2);
            }
        };
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
        System.out.println("Index of "+ val + ": " +  btsDemo.search(val));

        /*
        * String
        * */
        BTSDemo<Integer> BTInt = new BTSDemo<>() {
            @Override
            int compareTo(Integer o1, Integer o2) {
                 return o1.compareTo(o2);
            }
        };
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
        System.out.println("Index of "+ val + ": " +  BTInt.search(val2));

        /*
        *
        *
        * */



    }
}
