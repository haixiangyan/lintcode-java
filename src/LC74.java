public class LC74 {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int start = 0;
        int end = n;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        return (SVNRepo.isBadVersion(start)) ? start : end;
    }

    private static class SVNRepo {
        public static boolean isBadVersion(int start) {
            return true;
        }
    }
}
