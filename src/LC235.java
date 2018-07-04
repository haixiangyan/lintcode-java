import java.util.ArrayList;
import java.util.List;

public class LC235 {
    public List<Integer> primeFactorization(int num) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2 ; i * i <= num ; i++) {
            while (num % i == 0) {
                num = num / i;
                factors.add(i);
            }
        }

        if (num != 1) {
            factors.add(num);
        }

        return factors;
    }

    public static void main(String[] args) {
        LC235 lc235 = new LC235();

        int num = 8;

        for (Integer i : lc235.primeFactorization(4)) {
            System.out.println(i);
        }
    }
}
