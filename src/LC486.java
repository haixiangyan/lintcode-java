import java.util.Comparator;
import java.util.PriorityQueue;

public class LC486 {
    class ListNode {
        public int i;
        public int j;
        public int val;

        public ListNode(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int[] mergekSortedArrays(int[][] arrays) {
        int size = 0;
        PriorityQueue<ListNode> firstElements = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // Add the first elements of each array to priority queue
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                firstElements.offer(new ListNode(i, 0, arrays[i][0]));
            }
            size += arrays[i].length;
        }

        int[] results = new int[size];
        int counter = 0;

        // Start to merge
        while (!firstElements.isEmpty()) {
            ListNode smallest = firstElements.poll();

            // Add current smallest element to results
            results[counter] = smallest.val;

            if (isValid(arrays, smallest)) {
                firstElements.offer(new ListNode(smallest.i, smallest.j + 1, arrays[smallest.i][smallest.j + 1]));
            }

            counter++;
        }

        return results;
    }

    private boolean isValid(int[][] arrays, ListNode node) {
        return node.j + 1 < arrays[node.i].length;
    }

    public static void main(String[] args) {
        LC486 lc486 = new LC486();

        int[][] test = {{1, 3, 5, 7},{2, 4, 6},{0, 8, 9, 10, 11}};

        lc486.mergekSortedArrays(test);
    }
}
