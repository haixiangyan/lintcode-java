import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC607 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int count = 0;

    public void add(int number) {
        count ++;
        map.put(count, number);
    }

    public boolean find(int value) {
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        int first = 0;
        boolean isCheck = false;

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (map.containsValue(value - entry.getValue())) {
                if (!isCheck) {
                    first = entry.getKey();
                    isCheck = true;
                }
                else {
                    if (first != entry.getKey()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LC607 lc607 = new LC607();

        lc607.add(2);
        lc607.add(3);

        System.out.println(lc607.find(4));
        System.out.println(lc607.find(7));
    }
}
