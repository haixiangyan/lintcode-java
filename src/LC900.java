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

        // Find largest number that is smaller than target
        TreeNode lowerbound = findLowerBound(root, target);
        // Find smallest number that is larger than target
        TreeNode upperbound = findUpperBound(root, target);

        if (lowerbound == null) {
            return upperbound.val;
        }
        if (upperbound == null) {
            return lowerbound.val;
        }

        if (target - lowerbound.val > upperbound.val - target) {
            return upperbound.val;
        }

        return lowerbound.val;
    }

    private TreeNode findLowerBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (root.val > target) {
            return findLowerBound(root.left, target);
        }

        // root.val <= target
        TreeNode lowerBound = findLowerBound(root.right, target);
        if (lowerBound != null) {
            return lowerBound;
        }

        return root;
    }

    private TreeNode findUpperBound(TreeNode root, double target) {
        if (root == null) {
            return null;
        }

        if (root.val < target) {
            return findUpperBound(root.right, target);
        }

        // root.val >= target
        TreeNode upperBound = findUpperBound(root.left, target);
        if (upperBound != null) {
            return upperBound;
        }

        return root;
    }
}
