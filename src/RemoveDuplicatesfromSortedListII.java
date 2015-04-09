
public class RemoveDuplicatesfromSortedListII {

	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        int prev = -10000;
        while (p2 != null) {
            if (prev != -10000 && p2.val == prev) {
                p2 = p2.next;
                p1.next = p2;
            } else {
                p1.next = p2;
                prev = p2.val;
                if (p2.next != null && p2.next.val != p2.val) p1 = p2;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
