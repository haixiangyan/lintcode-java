import java.util.ArrayList;
import java.util.List;

public class LC862 {
    private int closestTime;
    private String closesTimeStr;
    private int givenMinutes;

    public String nextClosestTime(String time) {
        closestTime = Integer.MAX_VALUE;

        int[] timeDigit = init(time);

        dfs(timeDigit, new ArrayList<>());

        return closesTimeStr;
    }

    private void dfs(int[] timeDigit, List<Integer> list) {
        if (list.size() == 4) {
            if (!isValid(list)) {
                return;
            }
            int curMinutes = toMinute(list);
            int diff = Math.abs(givenMinutes - curMinutes);
            if (diff > closestTime) {
                return;
            }

            closestTime = diff;
            closesTimeStr = toStr(list);
            return;
        }

        for (int i = 0; i < 4; i++) {
            list.add(timeDigit[i]);
            dfs(timeDigit, list);
            list.remove(list.size() - 1);
        }
    }

    private int[] init(String time) {
        int[] timeDigits = new int[4];

        timeDigits[0] = time.charAt(0) - '0';
        timeDigits[1] = time.charAt(1) - '0';
        timeDigits[2] = time.charAt(3) - '0';
        timeDigits[3] = time.charAt(4) - '0';

        givenMinutes = 60 * (timeDigits[0] * 10 + timeDigits[1]) + (timeDigits[2] * 10 + timeDigits[3]);

        return timeDigits;
    }

    private boolean isValid(List<Integer> timeDigit) {
        int hours = timeDigit.get(0) * 10 + timeDigit.get(1);
        int minutes = timeDigit.get(2) * 10 + timeDigit.get(3);

        return (0 <= hours && hours < 24) && (0 <= minutes && minutes < 60);
    }

    private int toMinute(List<Integer> timeDigit) {
        int hours = timeDigit.get(0) * 10 + timeDigit.get(1);
        int minutes = timeDigit.get(2) * 10 + timeDigit.get(3);

        int totalMinutes = hours * 60 + minutes;

        if (totalMinutes <= givenMinutes) {
            return totalMinutes + 23 * 60 + 59; // The other day
        }

        return totalMinutes;
    }

    private String toStr(List<Integer> timeDigit) {
        return "" + timeDigit.get(0) + timeDigit.get(1) + ":" + timeDigit.get(2) + timeDigit.get(3);
    }
}
