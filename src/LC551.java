import java.util.List;

public class LC551 {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> list, int depth) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        int sum = 0;

        for (NestedInteger nestedInteger : list) {
            if (nestedInteger.isInteger()) {
                sum += nestedInteger.getInteger() * depth;
            }
            else {
                sum += helper(nestedInteger.getList(), depth + 1);
            }
        }

        return sum;
    }
}
