import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC104 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.size(), comparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                queue.add(lists.get(i));
            }
        }

        while (!queue.isEmpty()) {
            ListNode head = queue.poll();
            ListNode newNode = new ListNode(head.val);

            tail.next = newNode;
            tail = newNode;

            if (head.next != null) {
                queue.add(head.next);
            }
        }

        return dummy.next;
    }
}
