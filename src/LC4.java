import java.util.ArrayList;
import java.util.List;

public class LC4 {
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 1; i < n; i++) {
            int lastNum = list.get(i - 1);
            while (list.get(p1) * 2 <= lastNum) p1++;
            while (list.get(p2) * 3 <= lastNum) p2++;
            while (list.get(p3) * 5 <= lastNum) p3++;

            list.add(Math.min(
                Math.min(list.get(p1) * 2, list.get(p2) * 3),
                    list.get(p3) * 5
            ));
        }

        return list.get(n - 1);
    }
}
