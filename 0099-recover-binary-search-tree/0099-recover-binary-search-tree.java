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
    private void swap(TreeNode a,TreeNode b){
        int temp=b.val;
        b.val=a.val;
        a.val=temp;

        return ;

    }
    private TreeNode min(TreeNode root,TreeNode min){
        if(root==null){
            return min;
        }
        if(root.val< min.val){
            min=root;
        }
        min=min(root.left,min);
        min=min(root.right,min);

        return min;
    }
    private TreeNode max(TreeNode root,TreeNode max){
        if(root==null){
            return max;
        }
        if(root.val> max.val){
            max=root;
        }
        max=max(root.left,max);
        max=max(root.right,max);

        return max;
    }
    public void recoverTree(TreeNode root) {
        if(root==null){
            return ;
        }
        TreeNode min=min(root.right,root.right);
        TreeNode max=max(root.left,root.left);


        if(min!=null && max!=null ){
            if(max.val > root.val && root.val >min.val){
                swap(min,max);
            }
        }

        if(max!=null && root.val<max.val){
            swap(root,max);
        }

        if(min!=null && root.val>min.val){
            swap(root,min);
        }
        recoverTree(root.left);
        recoverTree(root.right);

        

        
        
    }
}