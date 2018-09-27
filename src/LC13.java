public class LC13 {
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int start = 0;
        int curtIndex = 0;

        for (start = 0; start < source.length() - target.length() + 1; start++) {
            for (curtIndex = 0; curtIndex < target.length(); curtIndex++) {
                if (source.charAt(start + curtIndex) != target.charAt(curtIndex)) {
                    break;
                }
            }

            if (curtIndex == target.length()) {
                return start;
            }
        }

        return -1;
    }
}
