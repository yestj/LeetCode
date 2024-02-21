class Solution {
    public int trap(int[] height) {
        int currHeight = height[0];
        int[][] dp = new int[2][height.length];
        dp[0][0] = 0;
        dp[1][height.length - 1] = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] >= currHeight) {
                dp[0][i] = 0;
                currHeight = height[i];
            } else {
                dp[0][i] = currHeight - height[i];
            }
        }

        currHeight = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] >= currHeight) {
                dp[1][i] = 0;
                currHeight =height[i];
            } else {
                dp[1][i] = currHeight - height[i];
            }
        }

        int result = 0;

        for (int i = 0; i < height.length; i++) {
            result += Math.min(dp[0][i], dp[1][i]);
        }

        return result;
    }

}