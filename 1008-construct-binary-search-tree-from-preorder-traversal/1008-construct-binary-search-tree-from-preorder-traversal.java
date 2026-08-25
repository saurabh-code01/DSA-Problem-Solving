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
    private TreeNode buildBST(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        
        if(root.val>val){
            // left
            root.left=buildBST(root.left,val);
        }

        else{
            // right
            root.right=buildBST(root.right,val);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++){
            root=buildBST(root,preorder[i]);
        }

        return root;
        
        
    }
}