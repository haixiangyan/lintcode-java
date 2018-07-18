import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC120 {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<>();
        Set<String > set = new HashSet<>();
        int step = 1;

        queue.offer(start);
        set.add(start);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curStr = queue.poll();

                for (String closeString : getCloseStrings(dict, curStr)) {
                    if (closeString.equals(end)) {
                        return step;
                    }
                    if (!set.contains(closeString)) {
                        queue.offer(closeString);
                        set.add(closeString);
                    }
                }
            }
        }

        return 0;
    }

    private Set<String> getCloseStrings(Set<String> dict, String curStr) {
        Set<String > closeStringSet = new HashSet<>();

        for (char c = 'a'; c < 'z'; c++) {
            // Replace char for each position
            for (int i = 0; i < curStr.length(); i++) {
                if (c == curStr.charAt(i)) {
                    continue;
                }

                String newString = replace(curStr, i, c);
                if (dict.contains(newString)) {
                    closeStringSet.add(newString);
                }
            }
        }

        return closeStringSet;
    }

    private String replace(String curStr, int pos, char newChar) {
        char[] curStrArray = curStr.toCharArray();
        curStrArray[pos] = newChar;
        return new String(curStrArray);
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";

        Set<String > dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        LC120 lc120 = new LC120();
        System.out.println(lc120.ladderLength(start, end, dict));
    }
}
