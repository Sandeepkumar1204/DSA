
class Solution {
    public String originalDigits(String s) {

        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int[] digit = new int[10];

        digit[0] = count['z' - 'a']; // zero
        digit[2] = count['w' - 'a']; // two
        digit[4] = count['u' - 'a']; // four
        digit[6] = count['x' - 'a']; // six
        digit[8] = count['g' - 'a']; // eight

        
        digit[3] = count['h' - 'a'] - digit[8]; 
        digit[5] = count['f' - 'a'] - digit[4]; 
        digit[7] = count['s' - 'a'] - digit[6]; 

        digit[1] = count['o' - 'a']
                 - digit[0] - digit[2] - digit[4]; 

        digit[9] = count['i' - 'a']
                 - digit[5] - digit[6] - digit[8]; 

        StringBuilder result = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j < digit[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }
}
