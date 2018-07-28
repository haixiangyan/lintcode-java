import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC624 {
    public int minLength(String s, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();

        queue.offer(s);
        set.add(s);
        int min = s.length();

        while (!queue.isEmpty()) {
            s = queue.poll();

            for (String sub : dict) {
                int found = s.indexOf(sub);

                while (found != -1) {
                    String new_s = s.substring(0, found) + s.substring(found + sub.length(), s.length());
                    if (!set.contains(new_s)) {
                        if (new_s.length() < min) {
                            min = new_s.length();
                        }
                        queue.offer(new_s);
                        set.add(new_s);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }

        return min;
    }
}
