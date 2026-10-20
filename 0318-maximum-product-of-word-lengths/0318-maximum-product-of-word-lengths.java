
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];

        
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                mask[i] |= 1 << (c - 'a');
            }
        }

        int max = 0;

        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                
                if ((mask[i] & mask[j]) == 0) {
                    int product = words[i].length()
                                * words[j].length();

                    max = Math.max(max, product);
                }
            }
        }

        return max;
    }
}
