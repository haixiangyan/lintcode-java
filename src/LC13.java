public class LC13 {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int sourceLen = source.length();
        int targetLen = target.length();
        int i = 0 ;
        int j = 0 ;

        if (sourceLen < targetLen) {
            return -1;
        }
        else if (sourceLen == targetLen) {
            return source.equals(target) ? 0 : -1;
        }

        // Source string
        for (i = 0 ; i <= sourceLen - targetLen ; i++) {
            // Target string
            for (j = 0 ; j < targetLen ; j++) {
                if (target.charAt(j) != source.charAt(i + j)) {
                    break;
                }
            }

            // Match!
            if (j == targetLen) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String source = "abcde";
        String target = "a";

        LC13 lc13 = new LC13();

        System.out.println(lc13.strStr(source, target));
    }
}
