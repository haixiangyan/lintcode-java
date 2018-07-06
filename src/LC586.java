public class LC586 {
    public double sqrt(double x) {
        double left = 0;
        double right = Math.max(x, 1.0);
        // The minimum difference\
        double eps = 1e-12;

        while (left + eps < right) {
            double mid = left + (right - left) / 2;
            // Push left to mid
            if (mid * mid < x) {
                left = mid;
            }
            // Push right to mid
            else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LC586 lc586 = new LC586();

        double x = 4;

        System.out.println(lc586.sqrt(x));
    }
}
