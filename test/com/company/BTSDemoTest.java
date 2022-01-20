package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BTSDemoTest {

    BTSDemo<String> btsDemo;


    @BeforeEach
    void create() {
        this.btsDemo = new BTSDemo<>() {
            @Override
            int compareTo(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        btsDemo.insert("Q");
        btsDemo.insert("Y");
        btsDemo.insert("D");
    }


    @Test
    void insertS() {
        boolean expected = true;
        boolean result = btsDemo.insert("S");
        assertEquals(expected, result);
    }

    @Test
    void insertA() {
        boolean expected = false;
        boolean result = btsDemo.insert("A");
        assertEquals(expected, result);
    }

    @Test
    void getSize() {
        int expected = 7;
        int result = btsDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void clear() {
        int expected = 0;
        btsDemo.clear();
        int result = btsDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void find() {
        int expected = 4;
        int result = btsDemo.find("F");
        assertEquals(expected, result);
    }

    @Test
    void removeF() {
        boolean expected = true;
        boolean result = btsDemo.remove("F");
        assertEquals(expected, result);
    }

    @Test
    void removeZ() {
        boolean expected = false;
        boolean result = btsDemo.remove("Z");
        assertEquals(expected, result);
    }

    @Test
    void inOrder1() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K");
        expected.add("A");
        expected.add("P");
        expected.add("F");
        expected.add("Q");
        expected.add("Y");
        expected.add("D");
        expected.sort((o1, o2) -> o1.compareTo(o2));

        ArrayList<String> result = btsDemo.inOrder(false);
        assertEquals(expected, result);
    }

    @Test
    void inOrder2() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("K");
        expected.add("A");
        expected.add("P");
        expected.add("F");
        expected.add("Q");
        expected.add("Y");
        expected.add("D");
        expected.sort((o2, o1) -> o1.compareTo(o2));

        ArrayList<String> result = btsDemo.inOrder(true);
        assertEquals(expected, result);
    }
}