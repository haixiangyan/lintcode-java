import java.util.ArrayList;
import java.util.List;

public class LC136 {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();

        if (s == null) {
            return results;
        }
        if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        helper(s, 0, new ArrayList<>(), results);

        return results;
    }

    private void helper(String s, int index, List<String> subset, List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<>(subset));
        }

        for (int i = 1; i + index <= s.length(); i++) {
            String temp = s.substring(index, index + i);
            if (isPalindrome(temp)) {
                subset.add(s.substring(index, index + i));
                helper(s, index + i, subset, results);
                subset.remove(subset.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
        }

        return true;
    }
}
