import java.util.ArrayList;
import java.util.List;

public class LC426 {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();

        if (s.length() < 4 || s.length() > 12) {
            return results;
        }

        dfs(0, s, new ArrayList<>(), results);

        return results;
    }

    private void dfs(int start, String s, List<String> ip, List<String> results) {
        if (start == s.length() && ip.size() == 4) {
            results.add(String.join(".", new ArrayList<>(ip)));
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String temp = s.substring(start, start + i);

            if (isValid(temp)) {
                ip.add(temp);
                dfs(start + i, s, ip, results);
                ip.remove(ip.size() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
