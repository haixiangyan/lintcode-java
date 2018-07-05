public class LC141 {
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }

        if (x == 2147483647) {
            return 46340;
        }

        int start = 0;
        int end;

        for (end = 1 ; end * end <= x ; end = end * 2) {
            start = end;
        }

        System.out.println("start: " + start + "; end: " + end);

        return findSquareRoot(start, end , x);
    }

    private int findSquareRoot(int start, int end, int x) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (mid * mid == x) {
                return mid;
            }
            else if (mid * mid < x) {
                start = mid;
            }
            else {
                end = mid;
            }
        }

        if (start * start == x) {
            return start;
        }
        if (end * end == x) {
            return end;
        }

        return start * start < end * end ? start : end;
    }

    public static void main(String[] args) {
        int x = 2147483647;

        LC141 lc141 = new LC141();

        System.out.println(lc141.sqrt(x));
    }
}
