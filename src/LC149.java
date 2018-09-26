public class LC149 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (Integer i : prices) {
            min = Math.min(min, i);
            profit = i - min > profit ? i - min : profit;
        }

        return profit;
    }
}
