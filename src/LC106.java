public class LC106 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private ListNode current;

    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = getLength(head);
        current = head;
        return convert(size);
    }

    private TreeNode convert(int size) {
        if (size <= 0) {
            return null;
        }

        TreeNode left = convert(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = convert(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }
}
