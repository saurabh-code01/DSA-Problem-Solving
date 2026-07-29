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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        // step 1 find mid point
        ListNode p1=head;
        ListNode slow=head; 
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //step 2 reverse the 2nd half
        ListNode curr=slow.next;
        ListNode prev=null;
        slow.next=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode p2=prev;
        
        //step 3 join again
        
        while(p2!=null){
            ListNode temp1=p1.next;
            ListNode temp2=p2.next;

            p1.next=p2;
            p2.next=temp1;

            p1=temp1;  //+1
            p2=temp2;  //+1
            

        }

        

        
    }
}