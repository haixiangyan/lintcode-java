/*
Implement pow(x, n).
 */
public class LC140 {
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }

        long product = fastPower(a, b, n / 2);
        product = product * product % b;

        if (n % 2 == 1) {
            product = (product  * a % b) % b;
        }

        return (int)product;
    }
}
