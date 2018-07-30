import java.util.*;

public class LC794 {
    public int minMoveStep(int[][] init_state, int[][] final_state) {
        String initState = getState(init_state);
        String finalState = getState(final_state);

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int steps = 0;

        queue.offer(initState);

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                String curState = queue.poll();
                for (String nextState : getNext(curState)) {
                    if (nextState.equals(finalState)) {
                        return steps;
                    }

                    if (!set.contains(nextState)) {
                        queue.offer(nextState);
                        set.add(nextState);
                    }
                }
            }
        }

        return -1;
    }

    private List<String> getNext(String curState) {
        List<String> nextStates = new ArrayList<>();
        int[] offsetX = {1, 0, -1, 0};
        int[] offsetY = {0, 1, 0, -1};

        // Find '0' location
        int location = curState.indexOf('0');
        int x = location / 3;
        int y = location % 3;

        for (int i = 0; i < 4; i++) {
            int x_ = x + offsetX[i];
            int y_ = y + offsetY[i];

            if ((x_ >= 0) && (x_ < 3) && (y_ >= 0) && (y_ < 3)) {
                char[] chars = curState.toCharArray();
                chars[x * 3 + y] = chars[x_ * 3 + y_];
                chars[x_ * 3 + y_] = '0';
                nextStates.add(new String(chars));
            }
        }

        return nextStates;
    }

    private String getState(int[][] matrix) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
        }

        return sb.toString();
    }
}
