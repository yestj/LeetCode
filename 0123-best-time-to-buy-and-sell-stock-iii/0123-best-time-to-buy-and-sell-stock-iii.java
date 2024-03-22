class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;

        int[] leftMaxProfit = new int[N];
        int[] rightMaxProfit = new int[N];

        int minPrice = prices[0];
        for (int i = 1; i < N; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            leftMaxProfit[i] = Math.max(leftMaxProfit[i - 1], prices[i] - minPrice);
        }

        int maxPrice = prices[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);
            rightMaxProfit[i] = Math.max(rightMaxProfit[i + 1], maxPrice - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < N; i++) {
            profit = Math.max(profit, rightMaxProfit[i] + leftMaxProfit[i]);
        }

        return profit;
    }
}