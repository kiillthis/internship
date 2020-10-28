import java.util.Collection;
import java.util.ListIterator;

public interface CustomList<E> extends CustomCollection<E> {
    void add(int index, E object);
    E get(int index);
    int indexOf(Object object);
    int lastIndexOf(Object object);
    E remove(int index);
    E set(int index, E object);
    boolean retainAll(Collection<?> c);
}
