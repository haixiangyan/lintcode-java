import java.util.*;

public class LC526 {
    private Map<Integer, Integer> idToIndex;
    private List<Integer> ids;
    private Random random;

    public LC526() {
        idToIndex = new HashMap<>();
        ids = new ArrayList<>();
        random = new Random();
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        if (idToIndex.containsKey(server_id)) {
            return ;
        }

        ids.add(server_id);
        idToIndex.put(server_id, ids.size() - 1);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        int lastone = ids.get(ids.size() - 1);
        int curtIndex = idToIndex.get(server_id);

        // Swap the current server id with the last one
        ids.set(curtIndex, lastone);
        idToIndex.put(lastone, curtIndex);

        // Remove last one of array and current server id from hash map
        ids.remove(ids.size() - 1);
        idToIndex.remove(server_id);
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        return ids.get(random.nextInt(ids.size()));
    }
}
