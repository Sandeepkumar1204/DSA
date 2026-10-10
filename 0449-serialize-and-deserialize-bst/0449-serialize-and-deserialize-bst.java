import java.util.*;

public class Codec {

   
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        if (sb.length() > 0) {
            sb.append(",");
        }

        sb.append(root.val);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        int[] index = {0};

        return build(values, index, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private TreeNode build(String[] values, int[] index,
                           long min, long max) {

        if (index[0] >= values.length) {
            return null;
        }

        int value = Integer.parseInt(values[index[0]]);

        if (value <= min || value >= max) {
            return null;
        }

        index[0]++;

        TreeNode root = new TreeNode(value);

        root.left = build(values, index, min, value);
        root.right = build(values, index, value, max);

        return root;
    }
}