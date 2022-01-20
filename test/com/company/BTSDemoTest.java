package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BTSDemoTest {

    BSTDemo<String> bstDemo;

    @BeforeEach
    void createTree() {
        this.bstDemo = new BSTDemo<>();
        bstDemo.insert("K");
        bstDemo.insert("A");
        bstDemo.insert("P");
        bstDemo.insert("F");
        bstDemo.insert("Q");
        bstDemo.insert("Y");
        bstDemo.insert("D");
    }


    @Test
    void insertValueIntoTheEmptyTree() {
        int expected = 0;
        BSTDemo<String> bst = new BSTDemo<>();
        bst.insert("S");
        int result = bst.find("S");
        assertEquals(expected, result);
    }

    @Test
    void insertValueDoesNotExist() {
        int expected = 29;
        bstDemo.insert("S");
        int result = bstDemo.find("S");
        assertEquals(expected, result);
    }

    @Test
    void insertAlreadyExistingValue() {
        boolean expected = false;
        boolean result = bstDemo.insert("A");
        assertEquals(expected, result);
    }

    @Test
    void getSize() {
        int expected = 7;
        int result = bstDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void clear() {
        int expected = 0;
        bstDemo.clear();
        int result = bstDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void findValueDoesNotExist() {
        int expected = -1;
        int result = bstDemo.find("Z");
        assertEquals(expected, result);
    }

    @Test
    void findAlreadyExistingValue() {
        int expected = 4;
        int result = bstDemo.find("F");
        assertEquals(expected, result);
    }

    @Test
    void removeValueDoesNotExist() {
        boolean expected = false;
        boolean result = bstDemo.remove("Z");
        assertEquals(expected, result);
    }

    @Test
    void removeAlreadyExistingValue() {
        boolean expected = true;
        boolean result = bstDemo.remove("F");
        assertEquals(expected, result);
    }

    @Test
    void inAscendingOrder1() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K");
        expected.add("A");
        expected.add("P");
        expected.add("F");
        expected.add("Q");
        expected.add("Y");
        expected.add("D");
        expected.sort((o1, o2) -> o1.compareTo(o2));

        ArrayList<String> result = bstDemo.inOrder(false);
        assertEquals(expected, result);
    }

    @Test
    void inDescendingOrder1() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K");
        expected.add("A");
        expected.add("P");
        expected.add("F");
        expected.add("Q");
        expected.add("Y");
        expected.add("D");
        expected.sort((o2, o1) -> o1.compareTo(o2));

        ArrayList<String> result = bstDemo.inOrder(true);
        assertEquals(expected, result);
    }
}