import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC425 {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();

        if (digits.length() == 0) {
            return results;
        }

        Map<Character, char[]> map = new HashMap<>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

        dfs(digits, 0, map, new ArrayList<>(), results);

        return results;
    }

    private void dfs(String digits, int start, Map<Character, char[]> map, List<String> item, List<String> results) {
        if (item.size() == digits.length()) {
            results.add(String.join("", item));
            return;
        }

        char startChar = digits.charAt(start);

        for (char c : map.get(startChar)) {
            item.add("" + c);
            dfs(digits, start + 1, map, item, results);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC425 lc425 = new LC425();

        System.out.println(lc425.letterCombinations("7"));
    }
}
