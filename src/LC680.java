import java.util.ArrayList;
import java.util.List;

public class LC680 {
    public List<List<String>> splitString(String s) {
        List<List<String>> results = new ArrayList<>();

        if (s == null) {
            return results;
        }
        if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        stringHelper(s, new ArrayList<>(), 0, results);

        return results;
    }

    private void stringHelper(String s, List<String> subset, int index, List<List<String>> results) {
        if (index == s.length()) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 1; i < 3; i++) {
            if (index + i < s.length()) {
                subset.add(s.substring(index, index + i));
                stringHelper(s, subset, index + i, results);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
