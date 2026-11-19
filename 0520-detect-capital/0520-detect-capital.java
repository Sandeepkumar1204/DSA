
class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        boolean allUpper = true;
        boolean allLower = true;
        boolean firstUpper = true;

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {
                allUpper = false;
            }

            if (Character.isUpperCase(ch)) {
                allLower = false;
            }

            if (i > 0 && Character.isUpperCase(ch)) {
                firstUpper = false;
            }
        }

        return allUpper || allLower || firstUpper;
    }
}
