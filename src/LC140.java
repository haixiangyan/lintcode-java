/*
Implement pow(x, n).
 */
public class LC140 {
    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        }

        if (n == 0) {
            return 1 % b;
        }

        if (n % 2 == 0) {
            long temp = fastPower(a, b,n / 2);
            return (int) ((temp * temp) % b);
        }
        else {
            long temp = fastPower(a, b, n / 2);
            return (int) ((temp * temp) % b * a % b);
        }
    }

    public static void main(String[] args) {
        int a = 2147483647, b = 2147483645, n = 214748364;

        LC140 lc140 = new LC140();

        System.out.println(lc140.fastPower(a, b, n));
    }
}
