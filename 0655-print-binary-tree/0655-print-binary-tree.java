
import java.util.*;

class Solution {

    public List<List<String>> printTree(TreeNode root) {

        int height = getHeight(root);
        int rows = height + 1;
        int cols = (1 << rows) - 1;

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();

            for (int j = 0; j < cols; j++) {
                row.add("");
            }

            result.add(row);
        }

        fill(root, result, 0, 0, cols - 1);

        return result;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(
            getHeight(root.left),
            getHeight(root.right)
        );
    }

    private void fill(TreeNode root,
                      List<List<String>> result,
                      int row, int left, int right) {

        if (root == null) {
            return;
        }

        int mid = left + (right - left) / 2;

        result.get(row).set(mid, String.valueOf(root.val));

        fill(root.left, result, row + 1, left, mid - 1);
        fill(root.right, result, row + 1, mid + 1, right);
    }
}
