import java.util.List;

public class LC619 {
    public class MultiTreeNode {
        int val;
        List<MultiTreeNode> children;

        MultiTreeNode(int x) {
            val = x;
        }
    }

    class ResultType {
        public int maxLength, maxUp, maxDown;
        public ResultType(int maxLength, int maxUp, int maxDown) {
            this.maxLength = maxLength;
            this.maxUp = maxUp;
            this.maxDown = maxDown;
        }
    }

    public int longestConsecutive3(MultiTreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root).maxLength;
    }

    private ResultType divideConquer(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        int down = 0, up = 0, childMaxLength = 0;

        for (MultiTreeNode child : root.children) {
            // Find this child's result type
            ResultType childRt = divideConquer(child);

            // Update down and up
            if (child.val + 1 == root.val) {
                down = Math.max(down, childRt.maxDown + 1);
            }
            if (child.val - 1 == root.val) {
                up = Math.max(up, childRt.maxUp + 1);
            }
            childMaxLength = Math.max(childMaxLength, childRt.maxLength);
        }

        int maxLength = Math.max(up + 1 + down, childMaxLength);
        return new ResultType(maxLength, up, down);
    }
}
