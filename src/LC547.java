import java.util.HashSet;
import java.util.Set;

public class LC547 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Set<Integer> hashset = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashset.add(nums1[i]);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hashset.contains(nums2[i]) && !resultSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] results = new int[resultSet.size()];
        int index = 0;
        for (Integer i : resultSet) {
            results[index++] = i;
        }

        return results;
    }
}
