import java.util.*;

public class LC582 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> results = new ArrayList<>();

        if (s == null) {
            return results;
        }
        if (s.length() == 0) {
            results.add("");
            return results;
        }

        Map<String, ArrayList<String>> memo = new HashMap<>();

        return wordBreakHelper(s, wordDict, memo);
    }

    private ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        ArrayList<String> results = new ArrayList<>();

        if (s.length() == 0) {
            return results;
        }

        // Add the first matched word
        if (dict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); len++) {
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }

            String suffix = s.substring(len);
            ArrayList<String> segs = wordBreakHelper(suffix, dict, memo);

            for (String seg : segs) {
                results.add(word + " " + seg);
            }
        }

        memo.put(s, results);
        return results;
    }
}
