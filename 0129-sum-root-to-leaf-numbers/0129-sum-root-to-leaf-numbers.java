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
    int sum=0;
    private int pathx(TreeNode root,int num){
        if(root==null){
            return 0;
        }
        num=num*10+root.val;
        if(root.left==null && root.right==null){
            sum+=num;
        
        }

        if(root.left!=null){
            pathx(root.left,num);
        }
        if(root.right!=null){
            pathx(root.right,num);

        }

        return sum;

    }
    public int sumNumbers(TreeNode root) {
        
        return pathx(root,0);
        
        
    }
}