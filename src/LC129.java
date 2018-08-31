public class LC129 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private void append(ListNode head, ListNode newNode) {
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable.length <= 0) {
            return hashTable;
        }

        int newSize = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newSize];

        for (ListNode node : hashTable) {
            while (node != null) {
                int newIndex = (node.val <= 0) ? (node.val % newSize + newSize) % newSize : node.val % newSize;

                if (newHashTable[newIndex] != null) {
                    append(newHashTable[newIndex], new ListNode(node.val));
                }
                else {
                    newHashTable[newIndex] = new ListNode(node.val);
                }

                node = node.next;
            }
        }

        return newHashTable;
    }
}
