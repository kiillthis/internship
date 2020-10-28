import java.util.Iterator;

public interface CustomCollection<E>  {
    boolean add(E object);
    boolean addAll(CustomCollection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(CustomArrayList c);
    boolean equals(Object o);
    boolean isEmpty();
    boolean remove(Object o);
    boolean removeAll(CustomArrayList c);
    int size();
}
