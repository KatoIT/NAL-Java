package com.company;

import java.util.ArrayList;

public class BSTDemo<E extends Comparable> {
    private static final int ROOT = 0;
    private int size = 0;
    private final ArrayList<E> elements;


    // Constructor
    BSTDemo() {
        elements = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return printTree(ROOT);
    }

    // Clear Tree
    public void clear() {
        elements.clear();
        size = 0;
    }

    // Insert element
    public boolean insert(E value) {
        if (size != 0) {
            int index = getIndex(value, ROOT);
            if (elements.get(index) == null) {
                elements.set(index, value);
                size++;
                return true;
            }
        } else {
            return root(value);
        }
        return false;
    }

    // Remove element
    public boolean remove(E value) {
        if (size != 0) {
            int index = getIndex(value, ROOT);
            if (elements.get(index) != null) {
                remove(index);
                size--;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    // Search
    public int find(E value) {
        int index = getIndex(value, ROOT);
        if (elements.get(index) == null) {
            return -1;
        } else {
            return index;
        }
    }

    // Browsing Tree
    public ArrayList<E> inOrder(boolean reverse) {
        return inOrder(0, reverse);
    }



    /*
     * Method private
     * */

    // Increase Size
    private void insertNull(int number) {
        while (elements.size() - 1 < right(number)) {
            elements.add(null);
        }
    }

    // Creating root node
    public boolean root(E value) {
        if (elements.add(value)) {
            size = 1;
            return true;
        }
        return false;
    }
    //

    private void remove(int root) {
        int index = left(root);
        if (elements.get(index) != null) {
            elements.set(root, elements.get(index));
            remove(index);
        } else {
            index = right(root);
            if (elements.get(index) != null) {
                elements.set(root, elements.get(index));
                remove(index);
            } else {
                elements.set(root, null);
            }
        }
    }

    //
    private int getIndex(E value, int root) {
        insertNull(root);
        if (elements.get(root) == null) {
            return root;
        } else {
            if (value.compareTo(elements.get(root)) > 0) {
                return getIndex(value, right(root));
            } else if (value.compareTo(elements.get(root)) < 0) {
                return getIndex(value, left(root));
            } else {
                return root;
            }
        }
    }

    //
    private ArrayList<E> inOrder(int root, boolean reverse) {
        ArrayList<E> list = new ArrayList<>();
        if (elements.get(root) == null) {
            return list;
        } else {
            if (reverse) {
                list = inOrder(right(root), true);
                list.add(elements.get(root));
                list.addAll(inOrder(left(root), true));
            } else {
                list = inOrder(left(root), false);
                list.add(elements.get(root));
                list.addAll(inOrder(right(root), false));
            }
            return list;
        }
    }

    // Print Tree
    private String printTree(int root) {
        if (elements.get(root) == null) {
            return "";
        } else {
            return printTree(left(root))
                    + printTab(log2(root + 1))
                    + elements.get(root)
                    + printTab(log2(root + 1)) + "\n"
                    + printTree(right(root));
        }
    }

    // Log 2
    private int log2(int number) {
        return (int) (Math.log(number) / Math.log(2));
    }

    //
    private String printTab(int length) {
        StringBuilder str = new StringBuilder();
        str.append("\t".repeat(Math.max(0, length)));
        return str.toString();
    }

    // get index child note left
    private int left(int root) {
        return root * 2 + 1;
    }

    // get index child note right
    private int right(int root) {
        return root * 2 + 2;
    }

}
