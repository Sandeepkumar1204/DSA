import java.util.*;

class Solution {
    List<Integer> result = new ArrayList<>();

    int currentValue;
    int count = 0;
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (count == 0 || root.val != currentValue) {
            currentValue = root.val;
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(currentValue);
        } else if (count == maxCount) {
            result.add(currentValue);
        }

        inorder(root.right);
    }
}