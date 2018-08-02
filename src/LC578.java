public class LC578 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class ResultType {
        public boolean aExist, bExist;
        public TreeNode node;

        public ResultType(boolean aExist, boolean bExist, TreeNode node) {
            this.aExist = aExist;
            this.bExist = bExist;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType rt = helper(root, A, B);

        if (rt.aExist && rt.bExist) {
            return rt.node;
        }
        else {
            return null;
        }
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean aExist = left.aExist || right.aExist || root == A;
        boolean bExist = left.bExist || right.bExist || root == B;

        if (root == A || root == B) {
            return new ResultType(aExist, bExist, root);
        }

        if (left.node != null && right.node != null) {
            return new ResultType(aExist, bExist, root);
        }
        if (left.node != null) {
            return new ResultType(aExist, bExist, left.node);
        }
        if (right.node != null) {
            return new ResultType(aExist, bExist, right.node);
        }

        return new ResultType(aExist, bExist, null);
    }
}
