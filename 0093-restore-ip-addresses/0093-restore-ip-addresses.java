import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index,
                            List<String> parts,
                            List<String> result) {

        
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

       
        for (int end = index; end < s.length() && end < index + 3; end++) {

            
            if (s.charAt(index) == '0' && end > index) {
                break;
            }

            String part = s.substring(index, end + 1);

            int value = Integer.parseInt(part);

           
            if (value > 255) {
                break;
            }

            parts.add(part);

            backtrack(s, end + 1, parts, result);

            parts.remove(parts.size() - 1);
        }
    }
}