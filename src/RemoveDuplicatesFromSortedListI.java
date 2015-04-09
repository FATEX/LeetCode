
public class RemoveDuplicatesFromSortedListI {
	
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode l = head.next;
        ListNode pNode = head;
        int prev = head.val;
        while (l != null) {
            if (l.val == prev) {
                pNode.next = l.next;
            } else {
                prev = l.val;
                pNode = l;
            }
            l = l.next;
        }
        return head;
    }
	
	public static void main(String[] args) {
	}

}
