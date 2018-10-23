import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC624 {
    public int minLength(String s, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.add(s);
        set.add(s);
        int min = s.length();

        while (!queue.isEmpty()) {
            String curString = queue.poll();

            // Find next step to remove some strings
            for (String dictItem : dict) {
                int found = curString.indexOf(dictItem);
                while (found != -1) {
                    String nextString = curString.substring(0, found) + curString.substring(found + dictItem.length());

                    if (!set.contains(nextString)) {
                        if (nextString.length() < min) {
                            min = nextString.length();
                        }
                        queue.add(nextString);
                        set.add(nextString);
                    }

                    // Remove dict item from found to end
                    found = curString.indexOf(dictItem, found + 1);
                }
            }
        }

        return min;
    }
}
