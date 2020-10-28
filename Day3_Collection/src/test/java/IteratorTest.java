import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class IteratorTest {

    Integer[] array1D = new Integer[]{1, 2, 3, 4, 5};

    Integer[][] array2D = new Integer[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    @Test
    public void iterator1D() {
        String expected = "12345";

        ArrayIterator<Integer> it = new ArrayIteratorImpl<Integer>(array1D);

        String actual = "";

        while (it.hasNext()) {
            actual = actual + it.next();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void iterator2D() {
        String expected = "123456789";

        ArrayIterator2DimensionImpl<Integer> it = new ArrayIterator2DimensionImpl<Integer>(array2D);

        String actual = "";

        while (it.hasNext()) {
            actual = actual + it.next();
        }

        Assert.assertEquals(expected, actual);

    }

}
