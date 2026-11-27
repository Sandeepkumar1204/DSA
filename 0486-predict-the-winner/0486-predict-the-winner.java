class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i];
            for (int j = i + 1; j < n; j++) {
                int pickLeft = nums[i] - dp[j];
                int pickRight = nums[j] - dp[j - 1];
                dp[j] = Math.max(pickLeft, pickRight);
            }
        }

        return dp[n - 1] >= 0;
    }
}
