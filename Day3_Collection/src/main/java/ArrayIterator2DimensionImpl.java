public class ArrayIterator2DimensionImpl<T> extends ArrayIteratorImpl<T> {

    @SuppressWarnings("unchecked")
    T[][] array;
    private int i = 0;
    private int j = -1;
    private boolean lastRow = false;

    public ArrayIterator2DimensionImpl(T[][] array) {
        super(array[0]);
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if(i < array.length) {
            if(j != array[i].length - 1) {
                return true;
            } else {
                i++;
                j = -1;
                if(i == array.length){
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        j++;
        return array[i][j];
    }
}
