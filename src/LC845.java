public class LC845 {
    public int gcd(int a, int b) {
        if (b != 0) {
            return gcd(b, a % b);
        }
        else {
            return a;
        }
    }

    public static void main(String[] args) {
        int a = 15;
        int b = 10;

        LC845 lc845 = new LC845();

        System.out.println(lc845.gcd(a, b));
    }
}
