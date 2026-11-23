
import java.util.*;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);

        int minDiff = Integer.MAX_VALUE;
        int n = timePoints.size();

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(
                minDiff,
                getMinutes(timePoints.get(i))
                    - getMinutes(timePoints.get(i - 1))
            );
        }

        // Check difference across midnight
        int first = getMinutes(timePoints.get(0));
        int last = getMinutes(timePoints.get(n - 1));

        minDiff = Math.min(minDiff, first + 1440 - last);

        return minDiff;
    }

    private int getMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3, 5));

        return hours * 60 + minutes;
    }
}
