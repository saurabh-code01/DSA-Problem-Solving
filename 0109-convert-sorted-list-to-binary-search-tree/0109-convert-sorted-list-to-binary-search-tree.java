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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode BST(List<Integer>list,int st,int ei){
        if(st>ei){
            return null;
        }
        int mid=st+(ei-st)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=BST(list,st,mid-1);
        root.right=BST(list,mid+1,ei);

        return root;

    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        return BST(list,0,list.size()-1);
        
    }
}