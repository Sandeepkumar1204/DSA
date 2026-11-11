class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];

        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }

        int length = 0;
        boolean oddFound = false;

        for (int count : freq) {
            length += (count / 2) * 2;

            if (count % 2 == 1) {
                oddFound = true;
            }
        }

        if (oddFound) {
            length++;
        }

        return length;
    }
}