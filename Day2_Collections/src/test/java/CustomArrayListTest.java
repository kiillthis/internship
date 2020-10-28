import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CustomArrayListTest {

    @Test
    void add() {
        CustomArrayList<Integer> s = new CustomArrayList<Integer>();
        s.add(2);

        int expected = 2;
        int actual = s.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void addAll() {
        CustomArrayList<String> s = new CustomArrayList<String>();
        s.add("1");
        s.add("2");
        s.add("3");

        int expected = 3;
        int actual = s.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void clear() {
        CustomArrayList<Integer> s = new CustomArrayList<Integer>();
        s.add(1);

        s.clear();

        Integer expected = null;
        Integer actual = s.get(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void contains() {
        CustomArrayList<Integer> first = new CustomArrayList<Integer>();
        Integer object = 2;

        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);

        boolean actual = first.contains(object);

        Assert.assertTrue(actual);
    }

    @Test
    void isEmpty() {
        CustomArrayList<Integer> s = new CustomArrayList<Integer>();
        boolean condition = s.isEmpty();
        Assert.assertTrue(condition);
    }

    @Test
    void remove() {
        CustomArrayList<Integer> s = new CustomArrayList<Integer>();

        s.add(1);

        Integer expected1 = 1;
        Integer actual1 = s.remove(0);
        int expected2 = 0;
        int actual2 = s.size();

        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    void size() {
        CustomArrayList<Integer> c = new CustomArrayList<Integer>();

        c.add(3);
        c.add(4);

        int expected = 2;
        int actual = c.size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    void retainAll() {
        CustomArrayList<Integer> first = new CustomArrayList<Integer>();
        CustomArrayList<Integer> second = new CustomArrayList<Integer>();

        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);

        second.add(3);
        second.add(4);
        second.add(5);

        boolean actual = first.removeAll(second);

        Integer actual2 = first.get(0);

        Assert.assertTrue(actual);
        Assert.assertNull(actual2);
    }

    @Test
    void removeAll() {
        CustomArrayList<Integer> first = new CustomArrayList<Integer>();
        CustomArrayList<Integer> second = new CustomArrayList<Integer>();

        first.add(1);
        first.add(2);
        first.add(3);
        first.add(4);

        second.add(3);
        second.add(4);
        second.add(5);

        boolean actual = first.removeAll(second);

        Integer actual2 = first.get(0);

        Assert.assertTrue(actual);
        Assert.assertNull(actual2);

    }

    @Test
    void containsAll() {
        CustomArrayList<Integer> c1 = new CustomArrayList<Integer>();
        CustomArrayList<Integer> c2 = new CustomArrayList<Integer>();

        c1.add(1);
        c1.add(2);
        c1.add(3);
        c1.add(4);

        c2.add(3);
        c2.add(4);
        c2.add(5);
        c2.add(6);

        boolean actual = c1.containsAll(c2);

        Assert.assertTrue(actual);
    }
}