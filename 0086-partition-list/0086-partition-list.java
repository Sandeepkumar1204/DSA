class Solution {
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode(0);
        ListNode largeDummy = new ListNode(0);

        ListNode small = smallDummy;
        ListNode large = largeDummy;

        ListNode current = head;

        while (current != null) {

            if (current.val < x) {

                small.next = current;
                small = small.next;

            } else {

                large.next = current;
                large = large.next;
            }

            current = current.next;
        }

        // Important: end large list
        large.next = null;

        // Connect small list with large list
        small.next = largeDummy.next;

        return smallDummy.next;
    }
}