/*
 Find the Nth number in Fibonacci sequence.

 A Fibonacci sequence is defined as follow:

 The first two numbers are 0 and 1.
 The i th number is the sum of i-1 th number and i-2 th number.
 The first ten numbers in Fibonacci sequence is:

 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...
 */

public class LC366 {

    public int fibonacci(int n) {
        if (n <= 2) {
            return n - 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        LC366 lc366 = new LC366();

        int n = 10;

        System.out.println(lc366.fibonacci(n));
    }
}
