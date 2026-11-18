class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        java.util.List<String> result =
            new java.util.ArrayList<>();

        for (String word : words) {
            String row;

            char first = Character.toLowerCase(word.charAt(0));

            if (row1.indexOf(first) != -1) {
                row = row1;
            } else if (row2.indexOf(first) != -1) {
                row = row2;
            } else {
                row = row3;
            }

            boolean valid = true;

            for (char ch : word.toCharArray()) {
                ch = Character.toLowerCase(ch);

                if (row.indexOf(ch) == -1) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}