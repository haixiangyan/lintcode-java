public class LC900 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }

        TreeNode lowerNode = lowerBound(root, target);
        TreeNode upperNode = upperBound(root, target);

        if (lowerNode == null) {
            return upperNode.val;
        }
        if (upperNode == null) {
            return lowerNode.val;
        }
        if (target - lowerNode.val > upperNode.val - target) {
            return upperNode.val;
        }
        return lowerNode.val;
    }

    private TreeNode lowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target <= root.val) {
            return lowerBound(root.left, target);
        }

        TreeNode lowerNode = lowerBound(root.right, target);
        if (lowerNode != null) {
            return lowerNode;
        }

        return root;
    }

    private TreeNode upperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (target > root.val) {
            return upperBound(root.right, target);
        }

        TreeNode upperNode = upperBound(root.left, target);
        if (upperNode != null) {
            return upperNode;
        }

        return root;
    }
}
