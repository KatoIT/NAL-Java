package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Objects;

public class ArrayListTest<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENT_DATA = {};
    Object[] elements;

    public ArrayListTest(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        } else {
            for (int i = size; i > index; i--) {
                this.elements[i] = this.elements[i - 1];
            }
            this.elements[index] = element;
        }
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elements;

        @SuppressWarnings("unchecked") E oldValue = (E) es[index];
        fastRemove(es, index);

        return oldValue;
    }

    public int size() {
        return size;
    }

    public void ensureCapacity(int minCapacity) {

    }

    public boolean contains(E o) {
        for (Object e : elements) {
            if (e == o) return true;
        }
        return false;
    }

    public int indexOf(E o) {
        Object[] es = elements;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public ArrayListTest<?> clone() {
        try {
            ArrayListTest<?> v = (ArrayListTest<?>) super.clone();
            v.elements = Arrays.copyOf(elements, size);
//            v.modCount = 0;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elements[index];
    }

    public void clear() {
        elements = EMPTY_ELEMENT_DATA;
        size = 0;
    }
}
