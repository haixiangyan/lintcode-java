public class LC597 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        public TreeNode node;
        public int sum;
        public int num;

        public ResultType(int sum, int num) {
            this.sum = sum;
            this.num = num;
        }
    }

    private ResultType subResult;
    private TreeNode subtree;

    public TreeNode findSubtree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root);
        return subtree;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType leftRt = helper(root.left);
        ResultType rightRt = helper(root.right);
        ResultType result = new ResultType(leftRt.sum + rightRt.sum + root.val, leftRt.num + rightRt.num + 1);

        if (subtree == null || subResult.sum * result.num < subResult.num * result.sum) {
            subtree = root;
            subResult = result;
        }
        return result;
    }
}
