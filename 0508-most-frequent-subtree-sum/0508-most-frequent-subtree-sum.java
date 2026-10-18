
import java.util.*;

class Solution {
    Map<Integer, Integer> freq = new HashMap<>();
    int maxFreq = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        dfs(root);

        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int sum = node.val + left + right;

        int count = freq.getOrDefault(sum, 0) + 1;
        freq.put(sum, count);

        maxFreq = Math.max(maxFreq, count);

        return sum;
    }
}
