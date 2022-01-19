package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BTSDemoTest {

    BTSDemo<String> btsDemo;

    public BTSDemoTest() {
        this.btsDemo = new BTSDemo<String>() {
            @Override
            int compareTo(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
//        btsDemo.insert("K");
//        btsDemo.insert("A");
//        btsDemo.insert("P");
//        btsDemo.insert("F");
//        btsDemo.insert("Q");
//        btsDemo.insert("Y");
//        btsDemo.insert("D");
    }


    @Test
    void insert() {

    }

    @Test
    void getSize() {
        int expected = 4;
        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        int result = btsDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void clear() {
        int expected = 0;
        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        btsDemo.clear();
        int result = btsDemo.getSize();
        assertEquals(expected, result);
    }

    @Test
    void search() {
        int expected = 4;
        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        //
        int result = btsDemo.search("F");
        assertEquals(expected, result);
    }

    @Test
    void remove() {
        int expected = -1;
        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        //
        btsDemo.remove("F");
        int result = btsDemo.search("F");
        assertEquals(expected, result);
    }

    @Test
    void inOrder1() {
        ArrayList<String> expected = new ArrayList<>();

        expected.add("K");
        expected.add("A");
        expected.add("P");
        expected.add("F");
        expected.sort((o1, o2) -> o1.compareTo(o2));

        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        //
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
        expected.sort((o2, o1) -> o1.compareTo(o2));

        btsDemo.insert("K");
        btsDemo.insert("A");
        btsDemo.insert("P");
        btsDemo.insert("F");
        //
        ArrayList<String> result = btsDemo.inOrder(true);
        assertEquals(expected, result);
    }
}