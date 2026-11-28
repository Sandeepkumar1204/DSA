
import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                int start = parts[i].indexOf('(');
                int end = parts[i].indexOf(')');

                String fileName = parts[i].substring(0, start);
                String content = parts[i].substring(start + 1, end);

                String fullPath = directory + "/" + fileName;

                map.computeIfAbsent(content, k -> new ArrayList<>())
                   .add(fullPath);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> files : map.values()) {
            if (files.size() > 1) {
                result.add(files);
            }
        }

        return result;
    }
}
