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
    int rooti;
    private TreeNode splitTree(int[] postorder,Map<Integer,Integer> inorderMap,int lefti,int righti){


        if(lefti>righti) return null;
        if(rooti<0)return null;
        int rootVal=postorder[rooti--];
        TreeNode root=new TreeNode(rootVal);
        int mid=inorderMap.get(rootVal);

        root.right=splitTree(postorder,inorderMap,mid+1,righti);
        root.left=   splitTree(postorder,inorderMap,lefti,mid-1);
        
       

       return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inorderMap= new HashMap<>();
        rooti=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return splitTree(postorder,inorderMap,0,inorder.length-1);
        
    }
}