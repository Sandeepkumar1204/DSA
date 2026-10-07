import java.util.*;

class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Long, Integer> map = new HashMap<>();

       
        map.put(0L, 1);

        return dfs(root, 0L, targetSum, map);
    }

    private int dfs(TreeNode root, long currentSum,
                    int targetSum,
                    HashMap<Long, Integer> map) {

        if (root == null) {
            return 0;
        }

        
        currentSum += root.val;

        
        long required = currentSum - targetSum;

        int count = map.getOrDefault(required, 0);

        
        map.put(currentSum,
                map.getOrDefault(currentSum, 0) + 1);

        
        count += dfs(root.left, currentSum, targetSum, map);
        count += dfs(root.right, currentSum, targetSum, map);

      
        map.put(currentSum, map.get(currentSum) - 1);

        return count;
    }
}