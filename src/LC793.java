import java.util.HashMap;
import java.util.Map;

public class LC793 {
    public int intersectionOfArrays(int[][] arrs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                map.put(arrs[i][j], map.containsKey(arrs[i][j]) ? map.get(arrs[i][j]) + 1 : 1);
            }
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == arrs.length) {
                ans++;
            }
        }
        return ans;
    }
}
