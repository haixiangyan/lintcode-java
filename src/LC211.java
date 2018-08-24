import java.util.Arrays;

public class LC211 {
    public boolean Permutation(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        Arrays.sort(charsA);
        Arrays.sort(charsB);

        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                return false;
            }
        }

        return true;
    }
}
