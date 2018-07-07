public class LC437 {
    public int copyBooks(int[] pages, int k) {
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (check(pages, mid, k)) {
                // Too less workers
                right = mid;
            }
            else {
                // Too much workers
                left = mid;
            }
        }

        if (check(pages, left, k)) {
            return left;
        }
        return right;
    }

    private boolean check(int[] pages, int limit, int k) {
        int totalPages = 0;
        int workers = 0;

        for (int page : pages) {
            // Too less pages to copy, too much workers
            // Which means need to minimize the mid by making => mid = right
            if (page > limit) {
                return false;
            }
            if (page > totalPages) {
                // If page > totalPages which means we need one more worker
                workers++;
                totalPages = limit;
            }

            // If page < totalPages which means current worker can handle those pages
            totalPages = totalPages - page;
        }

        return workers <= k;
    }

    public static void main(String[] args) {
        int[] pages = {3, 2, 4};
        int k = 2;

        LC437 lc437 = new LC437();

        System.out.println(lc437.copyBooks(pages, k));
    }
}
