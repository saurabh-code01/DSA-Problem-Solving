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
    private void inorder(List<Integer> order, TreeNode root){
        if(root==null){
            return ;
        }
        inorder(order,root.left);
        order.add(root.val);
        inorder(order,root.right);

        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> order=new ArrayList<>();
        inorder(order,root);

        int n=order.size();
        int i=0;
        if(k<=n){
            i=k-1;
        }

        return order.get(i);
        
    }
}