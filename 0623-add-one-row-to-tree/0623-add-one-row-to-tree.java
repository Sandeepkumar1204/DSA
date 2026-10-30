
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        dfs(root, val, depth, 1);
        return root;
    }

    private void dfs(TreeNode node, int val, int depth, int level) {

        if (node == null) {
            return;
        }

        if (level == depth - 1) {
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);

            leftNode.left = node.left;
            rightNode.right = node.right;

            node.left = leftNode;
            node.right = rightNode;

            return;
        }

        dfs(node.left, val, depth, level + 1);
        dfs(node.right, val, depth, level + 1);
    }
}
