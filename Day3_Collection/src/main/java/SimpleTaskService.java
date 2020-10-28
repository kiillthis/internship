import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SimpleTaskService<K> {
    public SimpleTaskService() {
    }

    public Map<K, Integer> count(K[] array) {
        Map<K, Integer> map = new HashMap<>();

        int frequency = 0;

        Set<K> uniqueElements = new HashSet<K>(Arrays.asList(array));

        for (int i = 0; i < array.length; i++) {

            for (K toBeAdded : uniqueElements) {
                for (K k : array) {
                    if (k.equals(toBeAdded)) {
                        frequency++;
                    }
                }

                map.put(toBeAdded, frequency);
                frequency = 0;
            }
        }
        return map;
    }

    @SuppressWarnings("unchecked")
    public Map<String, Integer> countFromFile(File file) {
        String data = null;
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("An error occurred.");
        }
        if(data != null) {
            data = data.replace(",", "");
            data = data.replace(".", "");
            data = data.replace("-", "");
            data = data.toLowerCase();

            String[] strings = data.split(" ");

            return (Map<String, Integer>) count((K[]) strings);
        }
        return null;
    }
}
