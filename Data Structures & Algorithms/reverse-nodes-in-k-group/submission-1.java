/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
   public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode groupPrev = dummyHead;

        while (true) {
            ListNode groupNext = groupPrev;
            for (int i = 0; i < k; i++) {
                groupNext = groupNext.next;
                if (groupNext == null) {
                    return dummyHead.next;
                }
            }

            ListNode groupStart = groupPrev.next;
            ListNode nextGroupStart = groupNext.next;

            groupPrev.next = reverse(groupStart, nextGroupStart);

            groupStart.next = nextGroupStart;
            groupPrev = groupStart;
        }
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = tail;
        ListNode curr = head;

        while (curr != tail) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }
}
