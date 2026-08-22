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
    private void inorder(List<Integer> order,TreeNode root){
        if(root==null){
            return ;
        }
        inorder(order,root.left);
        order.add(root.val);
        inorder(order,root.right);

        return ;
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> order=new ArrayList<>();
        inorder(order,root);
        int sum=0;
        int n=order.size()-1;
        for(int i=0;i<=n;i++){
            if(order.get(i)>=low && order.get(i)<=high){
                sum+=order.get(i);
            }
            
        }

        return sum;
        
    }
}