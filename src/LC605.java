import java.util.*;

public class LC605 {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        // Initialize graph
        for (int i = 0; i < org.length; i++) {
            map.put(org[i], new HashSet<>());
            indegree.put(org[i], 0);
        }

        // Construct graph
        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count = count + seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n)) {
                return false;
            }
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n) {
                    return false;
                }
                if (map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }

        if (count < n) {
            return false;
        }

        // Topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.add(key);
            }
        }

        int cnt = 0;
        while (queue.size() == 1) {
            int ele = queue.poll();
            for (int next : map.get(ele)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) {
                    queue.add(next);
                }
            }
            if (ele != org[cnt]) {
                return false;
            }
            cnt++;
        }
        return cnt == org.length;
    }

    public static void main(String[] args) {
        int[] org = {1, 2, 3};
        int[][] seqs = {
                {1, 2}, {1, 3}, {2, 3}
        };

        LC605 lc605 = new LC605();
        System.out.println(lc605.sequenceReconstruction(org, seqs));
    }
}
