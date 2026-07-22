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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        //step 1 find length and tail of ll
        int length=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            length++;
        }

        //step 2 make circular ll
        tail.next=head;

        //step 3 find the position of newtail and newhead
        k=k%length;
        int stepstonewtail=length-k;
        ListNode newtail=tail;
        while(stepstonewtail > 0){
            newtail=newtail.next;
            stepstonewtail--;
        }

        //step 4 break the cycle
        ListNode newhead=newtail.next;
        newtail.next=null;
        return newhead;

    }
}