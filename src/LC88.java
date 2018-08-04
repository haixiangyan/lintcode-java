public class LC88 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        public boolean aExist;
        public boolean bExist;
        public TreeNode node;

        public ResultType(boolean aExist, boolean bExist, TreeNode node) {
            this.aExist = aExist;
            this.bExist = bExist;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        return helper(root, A, B).node;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        ResultType leftRt = helper(root.left, A, B);
        ResultType rightRt = helper(root.right, A, B);

        boolean aExist = leftRt.aExist || rightRt.aExist || root == A;
        boolean bExist = leftRt.bExist || rightRt.bExist || root == B;

        if (root == A || root == B) {
            return new ResultType(aExist, bExist, root);
        }

        if (leftRt.node != null && rightRt.node != null) {
            return new ResultType(aExist, bExist, root);
        }
        if (leftRt.node != null) {
            return new ResultType(aExist, bExist, leftRt.node);
        }
        if (rightRt.node != null) {
            return new ResultType(aExist, bExist, rightRt.node);
        }

        return new ResultType(false, false, null);
    }
}
