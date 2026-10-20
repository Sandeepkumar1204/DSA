
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] dp = new int[n];
        int[] index = new int[k];

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                long candidate = (long) primes[j] * dp[index[j]];
                min = Math.min(min, candidate);
            }

            dp[i] = (int) min;

            for (int j = 0; j < k; j++) {
                long candidate = (long) primes[j] * dp[index[j]];

                if (candidate == min) {
                    index[j]++;
                }
            }
        }

        return dp[n - 1];
    }
}
