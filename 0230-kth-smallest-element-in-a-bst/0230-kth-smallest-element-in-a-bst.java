class Solution {

    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        
        inorder(root.left, k);

    
        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        
        inorder(root.right, k);
    }
}
