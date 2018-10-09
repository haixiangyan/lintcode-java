import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC607 {
    private Map<Integer, Integer> map = new HashMap<>();
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int diff = value - key;
            if (map.containsKey(diff)) {
                if (diff != key || map.get(key) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
