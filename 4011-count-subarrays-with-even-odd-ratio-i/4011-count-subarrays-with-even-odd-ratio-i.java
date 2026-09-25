class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {

        int n = nums.length;
        int answer = 0;

        for (int i = 0; i < n; i++) {

            int odd = 0;

            for (int j = i; j < n; j++) {

                // Count odd numbers
                if (nums[j] % 2 != 0) {
                    odd++;
                }

                // Total elements
                int length = j - i + 1;

                // Even numbers
                int even = length - odd;

                // even / odd <= a / b
                if (odd > 0 &&
                    (long) even * b <= (long) odd * a) {

                    answer++;
                }
            }
        }

        return answer;
    }
}