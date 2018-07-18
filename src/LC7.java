import java.util.*;

public class LC7 {
    class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return new ArrayList<>().toString();
        }
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        result.add(String.valueOf(root.val));
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                // Left
                if (node.left != null) {
                    queue.offer(node.left);
                    result.add(String.valueOf(node.left.val));
                }
                else {
                    queue.offer(null);
                    result.add("#");
                }

                // Right
                if (node.right != null) {
                    queue.offer(node.right);
                    result.add(String.valueOf(node.right.val));
                }
                else {
                    queue.offer(null);
                    result.add("#");
                }
            }
        }

        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(", ");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }

    public static void main(String[] args) {
        LC7 lc7 = new LC7();
        String data = "[1]";
        lc7.deserialize(data);
    }
}
