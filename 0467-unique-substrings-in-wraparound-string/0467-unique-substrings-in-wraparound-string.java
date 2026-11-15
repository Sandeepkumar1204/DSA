class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] maxLen = new int[26];

        int currentLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                char prev = s.charAt(i - 1);
                char curr = s.charAt(i);

                if ((curr - prev + 26) % 26 == 1) {
                    currentLen++;
                } else {
                    currentLen = 1;
                }
            } else {
                currentLen = 1;
            }

            int index = s.charAt(i) - 'a';

            maxLen[index] = Math.max(maxLen[index], currentLen);
        }

        int answer = 0;

        for (int len : maxLen) {
            answer += len;
        }

        return answer;
    }
}