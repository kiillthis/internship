import java.util.*;

public class SimpleTaskService<K> {
    public SimpleTaskService() {
    }

    public Map<K,Integer> count(K[] array) {
        Map<K, Integer> map = new HashMap<K, Integer>();

        int frequency = 0;

        Set<K> uniqueElements = new HashSet<K>(Arrays.asList(array));

        for (int i = 0; i < array.length; i++) {
            Iterator<K> it = uniqueElements.iterator();

            while (it.hasNext()) {
                K toBeAdded = it.next();

                for (int j = 0; j < array.length; j++) {
                    if(array[j].equals(toBeAdded)) {
                        frequency++;
                    }
                }

                map.put(toBeAdded, frequency);
                frequency = 0;
            }
        }

        return map;
    }
}
