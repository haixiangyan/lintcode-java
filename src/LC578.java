public class LC578 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    class ResultType {
        public boolean aExist, bExist;
        public TreeNode localLCA;

        public ResultType(boolean aExist, boolean bExist, TreeNode localLCA) {
            this.aExist = aExist;
            this.bExist = bExist;
            this.localLCA = localLCA;
        }
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = divideConquer(root, A, B);
        if (result.aExist && result.bExist) {
            return result.localLCA;
        } else {
            return null;
        }
    }

    private ResultType divideConquer(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }

        ResultType left = divideConquer(root.left, A, B);
        ResultType right = divideConquer(root.right, A, B);

        boolean aExist = left.aExist || right.aExist || root == A;
        boolean bExist = left.bExist || right.bExist || root == B;

        if (root == A || root == B) {
            // Find the source of A and B, LCA would be A or B
            return new ResultType(aExist, bExist, root);
        }

        if (left.localLCA != null && right.localLCA != null) {
            return new ResultType(aExist, bExist, root);
        }
        if (left.localLCA != null) {
            return new ResultType(aExist, bExist, left.localLCA);
        }
        if (right.localLCA != null) {
            return new ResultType(aExist, bExist, right.localLCA);
        }

        return new ResultType(aExist, bExist, null);
    }
}
