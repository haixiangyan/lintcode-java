public class LC614 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public int maxLength;
        public int maxUp;
        public int maxDown;
        public ResultType(int maxLength, int maxUp, int maxDown) {
            this.maxLength = maxLength;
            this.maxDown = maxDown;
            this.maxUp = maxUp;
        }
    }

    public int longestConsecutive2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return divideConquer(root).maxLength;
    }

    private ResultType divideConquer(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        // Left and right traversal
        ResultType leftRt = divideConquer(root.left);
        ResultType rightRt = divideConquer(root.right);

        // len = up + down + 1
        int up = 0, down = 0;

        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(down, leftRt.maxDown + 1);
        }
        if (root.left != null && root.left.val - 1 == root.val) {
            up = Math.max(up, leftRt.maxUp + 1);
        }

        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(down, rightRt.maxDown + 1);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            up = Math.max(up, rightRt.maxUp + 1);
        }

        int len = up + down + 1;
        len = Math.max(
                len,
                Math.max(leftRt.maxLength, rightRt.maxLength)
        );
        return new ResultType(len, up, down);
    }
}
