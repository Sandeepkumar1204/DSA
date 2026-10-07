import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            
            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                level.add(current.val);

                
                for (Node child : current.children) {
                    queue.offer(child);
                }
            }

            result.add(level);
        }

        return result;
    }
}