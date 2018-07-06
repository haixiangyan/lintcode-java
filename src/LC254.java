public class LC254 {
    public int dropEggs(int n) {
        // x + (x - 1) + (x - 2) + ... + 3 + 2 + 1 >= n
        long ans = 0;

        for (int i = 0; ; i++) {
            ans = ans + (long) i;

            if (ans >= n) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        int n = 100;

        LC254 lc254 = new LC254();

        System.out.println(lc254.dropEggs(n));
    }
}
