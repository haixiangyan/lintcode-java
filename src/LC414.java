public class LC414 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long newDividend = Math.abs((long) dividend);
        long newDivisor = Math.abs((long) divisor);

        long total = 0;
        int time = 0;

        while (total < newDividend) {
            total = total + newDivisor;
            time ++;
        }

        if (newDividend % newDivisor != 0) {
            time --;
        }

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            return time;
        }
        else {
            return -time;
        }
    }

    public static void main(String[] args) {
        LC414 lc414 = new LC414();

        int dividend = -2147483648;
        int divisor = -1;

        System.out.println(lc414.divide(dividend, divisor));
    }
}
