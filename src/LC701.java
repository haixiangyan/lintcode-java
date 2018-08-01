public class LC701 {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        if (root == null) {
            return null;
        }

        if (minimum <= root.val && root.val <= maximum) {
            root.right = trimBST(root.right, minimum, maximum);
            root.left = trimBST(root.left, minimum, maximum);
        }
        else if (maximum < root.val) {
            root = trimBST(root.left, minimum, maximum);
        }
        else {
            root = trimBST(root.right, minimum, maximum);
        }

        return root;
    }
}
