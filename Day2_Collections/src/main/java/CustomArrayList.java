import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ListIterator;

public class CustomArrayList<E> implements CustomList<E> {

    private E[] array;

    @SuppressWarnings("unchecked")
    public CustomArrayList(int size) {
        if (size >= 0) {
            E[] a = (E[]) new Object[size];
            this.array = a;
        } else {
            throw new IllegalArgumentException("Negative size");
        }
    }

    @SuppressWarnings("unchecked")
    public CustomArrayList() {
        final E[] a = (E[]) new Object[0];
        this.array = a;
    }

    public CustomArrayList(E[] array) {
        this.array = array;
    }

    @SuppressWarnings("unchecked")
    public boolean add(Object object) {
        E[] newArray = (E[]) new Object[size() + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = (E) object;

        this.array = newArray;

        return newArray[newArray.length - 1].equals(object);
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(CustomCollection c) {
        E[] newArray = (E[]) new Object[size() + c.size()];

        System.arraycopy(array, 0, newArray, array.length - 1, array.length);
        System.arraycopy(c, array.length, newArray, newArray.length, newArray.length);

        this.array = newArray;

        if (array[array.length - 1] == newArray[newArray.length - 1]) {
            return true;
        }

        return false;
    }

    public void clear() {
        Arrays.fill(array, null);
    }

    public boolean contains(Object o) {
        for (E e : array) {
            if (o.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (array.length == 0) {
            return true;
        }
        return false;
    }


    public boolean remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return array.length;
    }

    public void add(int index, E object) {
        E[] newArray = (E[]) new Object[size() + 1];
        System.arraycopy(array, 0, newArray, index - 1, array.length);
        newArray[index] = object;
        System.arraycopy(array, index + 1, newArray, newArray.length - 1, (newArray.length / 2)-1);
    }

    public E get(int index) {
        return array[index];
    }

    public int indexOf(Object object) {
        for (int i = 0; i < array.length; i++) {
            if(object.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        boolean isFound = false;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(object.equals(array[i])) {
                index = i;
                isFound = true;
            }
        }

        if(isFound) {
            return index;
        }
        return -1;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        E[] a = (E[]) new Object[array.length - 1];

        E element = array[index];
        array[index] = null;

        for (int i = 0; i < a.length; i++) {
            if(array[i] != null) {
                a[i] = array[i];
            }
        }
        this.array = a;

        return element;
    }

    public E set(int index, E object) {
        E element = array[index];
        array[index] = object;
        return element;
    }

    public boolean retainAll(Collection<?> c) {
        boolean isDeleted = false;

        for (Object element : c) {
            for (int i = 0; i < array.length; i++) {
                if (!element.equals(array[i])){
                    isDeleted = true;
                    array[i] = null;
                }
            }
        }

        return isDeleted;
    }


    public boolean removeAll(CustomArrayList c) {

        boolean isDeleted = false;

        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < array.length; j++) {
                if(c.get(i).equals(array[j])) {
                    array[i] = null;

                    isDeleted = true;
                }
            }
        }

        if(isDeleted) {
           return true;
        }
        return false;
    }

    public boolean containsAll(CustomArrayList c) {
        for (int i = 0; i < c.size(); i++) {
            if(this.contains(c.get(i))) {
                break;
            }
            if(i == c.size() - 1) {
                return false;
            }
        }
        return true;
    }
}
