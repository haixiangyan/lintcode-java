import java.util.HashMap;
import java.util.Map;

public class LC828 {
    public boolean wordPattern(String pattern, String teststr) {
        Map<Character, String> map = new HashMap<>();

        String[] strs = teststr.split(" ");

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (!map.containsKey(c)) {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
            }
            else {
                if (!strs[i].equals(map.get(c))) {
                    return false;
                }
            }
        }
        return true;
    }
}
