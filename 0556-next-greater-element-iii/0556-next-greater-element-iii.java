
class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        // Step 1: Find the first decreasing digit from right
        int i = len - 2;

        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        // Step 2: Find the smallest digit greater than digits[i]
        int j = len - 1;

        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the two digits
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;

        // Step 4: Reverse the suffix
        int left = i + 1;
        int right = len - 1;

        while (left < right) {
            temp = digits[left];
            digits[left] = digits[right];
            digits[right] = temp;

            left++;
            right--;
        }

        // Step 5: Check integer overflow
        long result = Long.parseLong(new String(digits));

        if (result > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) result;
    }
}
