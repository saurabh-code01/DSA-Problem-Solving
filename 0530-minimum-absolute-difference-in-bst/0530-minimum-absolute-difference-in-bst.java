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
    private void Inorder(TreeNode root,List<Integer> order){
        if(root==null){
            return ;
        }
        Inorder(root.left,order);
        order.add(root.val);
        Inorder(root.right,order);
    }
    public int getMinimumDifference(TreeNode root) {
        List<Integer> order=new ArrayList<>();
        Inorder(root,order);
        
        int min=Integer.MAX_VALUE;
        for(int i=order.size()-1;i>0;i--){
            int diff=order.get(i)-order.get(i-1);
            min=Math.min(min,diff);

        }

        return min;
        
    }
}