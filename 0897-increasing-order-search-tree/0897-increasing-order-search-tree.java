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
    private TreeNode skewBST(List<Integer> order){
        TreeNode dummy =new TreeNode(-1);
        TreeNode root=dummy;
        int i=0;
        while(i<order.size()){
            if(order.get(i)>root.val){
                root.right=new TreeNode(order.get(i));
                root=root.right;
            }

            else{
                root.left=new TreeNode(order.get(i));
            }
            i++;
        }

        return dummy.right;

    }
    private void inorder(TreeNode root,List<Integer> order){
        if(root==null){
            return ;
        }
        inorder(root.left,order);
        order.add(root.val);
        inorder(root.right,order);


    }
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> order=new ArrayList<>();
        inorder(root,order);
        
        return skewBST(order);
        
    }
}