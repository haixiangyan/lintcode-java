import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC685 {
    public class DataStream {
        public class ListNode {
            public int val;
            public ListNode next;

            public ListNode(int val) {
                this.val = val;
                this.next = next;
            }
        }

        private ListNode head, tail;
        private Map<Integer, ListNode> keyToPrev;
        private Set<Integer> duplicates;

        public DataStream() {
            this.head = new ListNode(0);
            this.tail = head;
            this.keyToPrev = new HashMap<>();
            this.duplicates = new HashSet<>();
        }

        public void remove(int key) {
            ListNode prev = keyToPrev.get(key);

            prev.next = prev.next.next;
            keyToPrev.remove(key);

            if (prev.next != null) {
                keyToPrev.put(prev.next.val, prev);
            }
            else {
                tail = prev;
            }
        }

        public void add(int key) {
            if (duplicates.contains(key)) {
                return;
            }

            if (keyToPrev.containsKey(key)) {
                remove(key);
                duplicates.add(key);
            }
            else {
                ListNode curt = new ListNode(key);
                keyToPrev.put(key, tail);
                tail.next = curt;
                tail = curt;
            }
        }

        public int firstUnique() {
            if (head.next != null) {
                return head.next.val;
            }

            return -1;
        }
    }

    public int firstUniqueNumber(int[] nums, int number) {
        DataStream ds = new DataStream();

        for (int i = 0; i < nums.length; i++) {
            ds.add(nums[i]);
            if (nums[i] == number) {
                return ds.firstUnique();
            }
        }

        return -1;
    }
}
