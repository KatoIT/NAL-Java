package com.company;


public class Main {

    public static void main(String[] args) {
        /*
        * String
        * */
        BinaryTreeDemo<String> binaryTree = new BinaryTreeDemo<String>() {
            @Override
            int compareTo(String o1, String o2) {
                 return o1.compareTo(o2);
            }
        };
        binaryTree.insert("E");
        binaryTree.insert("C");
        binaryTree.insert("G");
        binaryTree.insert("B");
        binaryTree.insert("F");
        binaryTree.insert("A");
        binaryTree.insert("D");
        binaryTree.insert("H");
        System.out.println(binaryTree);
        binaryTree.remove("C");
        System.out.println(binaryTree.printTree(0));
        System.out.println(binaryTree.browsing(true));
        String val = "F";
        System.out.println("Index of "+ val + ": " +  binaryTree.search(val));

        /*
        * String
        * */
        BinaryTreeDemo<Integer> BTInt = new BinaryTreeDemo<Integer>() {
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
        System.out.println(BTInt.printTree(0));
        System.out.println(BTInt.browsing(false));
        Integer val2 = 71;
        System.out.println("Index of "+ val + ": " +  BTInt.search(val2));

    }
}
