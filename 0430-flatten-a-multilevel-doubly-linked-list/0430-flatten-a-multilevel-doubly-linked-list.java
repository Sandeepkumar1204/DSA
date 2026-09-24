
class Solution {

    public Node flatten(Node head) {

        if (head == null) {
            return head;
        }

        Node current = head;

        while (current != null) {

            
            if (current.child != null) {

                Node child = current.child;
                Node next = current.next;

                
                current.next = child;
                child.prev = current;

               
                Node temp = child;

                while (temp.next != null) {
                    temp = temp.next;
                }

               
                temp.next = next;

                if (next != null) {
                    next.prev = temp;
                }

                
                current.child = null;
            }

            current = current.next;
        }

        return head;
    }
}

