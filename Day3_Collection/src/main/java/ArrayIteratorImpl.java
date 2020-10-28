public class ArrayIteratorImpl<T> implements ArrayIterator<T> {

    @SuppressWarnings("unchecked")
    T[] array;
    private int i = -1;

    public ArrayIteratorImpl(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        if(i != array.length - 1) {
            return true;
        }
        return false;
    }

    public T next() {
        i++;
        return array[i];
    }

}
