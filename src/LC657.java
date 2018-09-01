import java.util.*;

public class LC657 {
    private Map<Integer, Integer> map = null;
    private List<Integer> list = null;
    private Random rand;

    public LC657() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        // If it's not the last one
        int removeElIndex = map.get(val);
        if (removeElIndex < list.size() - 1) {
            int lastone = list.get(list.size() - 1);
            list.set(removeElIndex, lastone);
            map.put(lastone, removeElIndex);
        }

        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
