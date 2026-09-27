import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        // Step 1: Create copy of every node
        Node current = head;

        while (current != null) {

            map.put(current, new Node(current.val));

            current = current.next;
        }

        // Step 2: Connect next and random pointers
        current = head;

        while (current != null) {

            Node copy = map.get(current);

            copy.next = map.get(current.next);

            copy.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}