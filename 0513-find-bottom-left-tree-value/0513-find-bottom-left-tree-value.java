

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int ans = root.val;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            ans = node.val;

            if (node.right != null) {
                q.offer(node.right);
            }

            if (node.left != null) {
                q.offer(node.left);
            }
        }

        return ans;
    }
}
