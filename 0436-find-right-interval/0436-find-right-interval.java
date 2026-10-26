
import java.util.Arrays;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals[i][0];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) ->
            Integer.compare(a[0], b[0])
        );

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];

            int left = 0;
            int right = n - 1;
            int index = -1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid][0] >= target) {
                    index = arr[mid][1];
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = index;
        }

        return result;
    }
}
