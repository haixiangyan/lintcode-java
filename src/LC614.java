public class LC614 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        public int maxLength, maxDown, maxUp;

        public ResultType(int len, int down, int up) {
            maxLength = len;
            maxDown = down;
            maxUp = up;
        }
    }

    public int longestConsecutive2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return helper(root).maxLength;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int down = 0, up = 0;

        if (root.left != null && root.left.val + 1 == root.val) {
            down = Math.max(down, left.maxDown + 1);
        }
        if (root.left != null && root.val + 1 == root.left.val) {
            up = Math.max(up, left.maxUp + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            up = Math.max(up, right.maxUp + 1);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            down = Math.max(down, right.maxDown + 1);
        }

        int len = down + 1 + up;
        len = Math.max(len, Math.max(left.maxLength, right.maxLength));

        return new ResultType(len, down, up);
    }
}
