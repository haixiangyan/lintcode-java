import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC10 {
    public List<String> stringPermutation2(String str) {
        List<String> results = new ArrayList<>();
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        dfs(chars, new boolean[chars.length], new ArrayList<>(), results);

        return results;
    }

    private void dfs(char[] chars, boolean[] visited, List<String> item, List<String> results) {
        if (item.size() == chars.length) {
            results.add(String.join("", item));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                continue;
            }

            item.add("" + chars[i]);
            visited[i] = true;
            dfs(chars, visited, item, results);
            visited[i] = false;
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        LC10 lc10 = new LC10();

        List<String> results = lc10.stringPermutation2("aabb");

        for (String s : results) {
            System.out.println(s);
        }
    }
}
