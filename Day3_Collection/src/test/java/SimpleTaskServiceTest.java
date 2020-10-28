import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class SimpleTaskServiceTest {

    @Test
    public void frequencyTest() {
        Integer[] array = new Integer[]{1, 1, 2, 2, 2, 3, 4};
        Map<Integer, Integer> actual = new SimpleTaskService<Integer>().count(array);
        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();

        expected.put(1, 2);
        expected.put(2, 3);
        expected.put(3, 1);
        expected.put(4, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void frequencyFromFile() throws IOException, URISyntaxException {
        Map<String, Integer> expected = new HashMap<String, Integer>();

        expected.put("привет", 2);
        expected.put("куку", 2);
        expected.put("как", 1);
        expected.put("дела", 1);

        SimpleTaskService<String> service = new SimpleTaskService<>();

        Map<String, Integer> actual = service.countFromFile(new File("/Users/killthis/Documents/Java/war2.txt"));

        Assert.assertEquals(expected, actual);

    }
}
