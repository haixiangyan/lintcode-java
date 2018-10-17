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
            return "{}";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer sb = new StringBuffer();

        queue.add(root);
        sb.append("{");

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode == null) {
                sb.append("#");
            }
            else {
                sb.append(curNode.val);
                queue.add(curNode.left);
                queue.add(curNode.right);
            }

            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("}");

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("{}")) {
            return null;
        }

        String[] val = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeftChild = true;

        for (int i = 1; i < val.length; i++) {
            if (!val[i].equals("#")) {
                TreeNode curNode = queue.peek();
                TreeNode nextNode = new TreeNode(Integer.parseInt(val[i]));
                if (isLeftChild) {
                    curNode.left = nextNode;
                }
                else {
                    curNode.right = nextNode;
                }

                queue.add(nextNode);
            }
            if (!isLeftChild) {
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }

        return root;
    }
}
