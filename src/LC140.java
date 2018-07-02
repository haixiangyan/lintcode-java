/*
Calculate the a^n % b where a, b and n are all 32bit integers.
 */
public class LC140 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {
            double temp = myPow(x, n / 2);
            return temp * temp;
        }
        else {
            double temp = myPow(x, n / 2);
            return (n > 0) ? temp * temp * x : temp * temp * (1 / x);
        }
    }

    public static void main(String[] args) {
        double a = 3.89707;
        int b = 2;

        LC140 lc140 = new LC140();

        System.out.println(lc140.myPow(a, b));
    }
}
