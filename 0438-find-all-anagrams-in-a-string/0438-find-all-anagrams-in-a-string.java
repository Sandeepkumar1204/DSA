import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;

            // Keep window size equal to p.length()
            if (i >= k) {
                windowFreq[s.charAt(i - k) - 'a']--;
            }

            // Check frequency of current window
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}