package com.company;

import java.util.ArrayList;

public abstract class BinaryTreeDemo<E> {
    private static final int ROOT = 0;
    private int size = 0;
    private final ArrayList<E> elements;

    /*
     * abstract method
     */
    /*
     * o1 < o2 return -1
     * o1 = o2 return 0
     * o1 > o2 return 1
     */
    abstract int compareTo(E o1, E o2);

    // Constructor
    BinaryTreeDemo() {
        elements = new ArrayList<>();
    }

    // Creating root node
    public void root(E value) {
        elements.add(value);
        size = 1;
    }

    // Increase Size
    private void increaseSize(int number) {
        while (elements.size() - 1 < number * 2 + 2) {
            elements.add(null);
        }
    }

    // Insert element
    public void insert(E value) {
        if (size != 0) {
            int index = getIndex(value, ROOT);
            elements.set(index, value);
            size++;
        } else {
            root(value);
        }
    }

    // Remove element
    public boolean remove(E value) {
        if (size != 0) {
            int index = getIndex(value, ROOT);
            move(index);
            size--;
            return true;
        } else {
            return false;
        }
    }

    private void move(int root) {
        increaseSize(root);
        if (elements.get(root * 2 + 1) != null) {
            elements.set(root, elements.get(root * 2 + 1));
            move(root * 2 + 1);
        } else {
            if (elements.get(root * 2 + 2) != null) {
                elements.set(root, elements.get(root * 2 + 2));
                move(root * 2 + 2);
            } else {
                elements.set(root, null);
            }
        }
    }

    private int getIndex(E value, int root) {
        increaseSize(root);
        if (elements.get(root) == null) {
            return root;
        } else {
            if (compareTo(value, elements.get(root)) > 0) {
                return getIndex(value, (root * 2) + 2);
            } else {
                if (compareTo(value, elements.get(root)) < 0) {
                    return getIndex(value, (root * 2) + 1);
                } else {
                    return root;
                }
            }
        }
    }

    // Search
    public int search(E value) {
        int index = getIndex(value, ROOT);
        if (elements.get(index) == null) {
            return -1;
        } else {
            return index;
        }
    }

    // Browsing Tree
    public String browsing(boolean reverse) {
        return browsing(0, reverse);
    }

    private String browsing(int index, boolean reverse) {
        if (elements.get(index) == null) {
            return "";
        } else {
            if (reverse) {
                return browsing(index * 2 + 2, true)
                        + " " + elements.get(index) + " "
                        + browsing(index * 2 + 1, true);
            } else {
                return browsing(index * 2 + 1, false)
                        + " " + elements.get(index) + " "
                        + browsing(index * 2 + 2, false);
            }
        }
    }

    // Print Tree
    public String printTree(int root) {
        increaseSize(root);
        if (elements.get(root) == null) {
            return "";
        } else {
            return printTree(root * 2 + 1)
                    + "" + printTab(log2(root + 1))
                    + elements.get(root)
                    + printTab(log2(root + 1)) + "\n"
                    + printTree(root * 2 + 2);
        }
    }

    // Log 2
    public int log2(int number) {
        return (int) (Math.log(number) / Math.log(2));
    }


    public String printTab(int length) {
        StringBuilder str = new StringBuilder();
        str.append("\t".repeat(Math.max(0, length)));
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (E e : elements) {
            if (e != null) {
                str.append(e).append(" ");
            }
        }
        return str.toString();
    }

    // Clear Tree
    public void clear() {
        elements.clear();
    }
}
