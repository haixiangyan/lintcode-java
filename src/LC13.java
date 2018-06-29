public class LC13 {

    public int BASE = 1000000;

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

    public int strStrRobinKarp(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int sourceLen = source.length();
        int targetLen = target.length();

        if (sourceLen < targetLen) {
            return -1;
        }
        else if (sourceLen == targetLen) {
            return source.equals(target) ? 0 : -1;
        }

        if (targetLen == 0) {
            return 0;
        }

        int power = 1;
        for (int i = 0 ; i < targetLen ; i++) {
            power = (power * 31) % BASE;
        }

        int targetCode = 0;
        for (int i = 0 ; i < targetLen ; i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0 ; i < sourceLen ; i++) {
            // abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;

            if (i < targetLen - 1) {
                continue;
            }

            // abcd - a
            if (i >= targetLen) {
                hashCode = hashCode - (source.charAt(i - targetLen) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }

            // Double check
            if (hashCode == targetCode) {
                if (source.substring(i - targetLen + 1, i + 1).equals(target)) {
                    return i - targetLen + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String source = "a";
        String target = "";

        LC13 lc13 = new LC13();

        System.out.println(lc13.strStrRobinKarp(source, target));
    }
}
