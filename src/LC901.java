import java.util.ArrayList;
import java.util.List;

public class LC901 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();

        // Get all values
        traverse(root, values);

        int i = 0, size = values.size();
        for (; i < size; i++) {
            if (target <= values.get(i)) {
                break;
            }
        }

        if (i >= size) {
            return values.subList(size - k, size);
        }

        int left = i - 1, right = i;
        List<Integer> result = new ArrayList<>();
        for (i = 0; i < k; i++) {
            if (left >= 0 && (right >= size || target - values.get(left) < values.get(right) - target)) {
                result.add(values.get(left));
                left--;
            }
            else {
                result.add(values.get(right));
                right++;
            }
        }

        return result;
    }

    private void traverse(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }

        traverse(root.left, values);
        values.add(root.val);
        traverse(root.right, values);
    }
}
