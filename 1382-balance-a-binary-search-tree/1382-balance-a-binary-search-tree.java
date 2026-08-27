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
    private TreeNode BuildBst(TreeNode root,List<Integer> order,int st,int ei){
        if(st>ei){
            return null;
        }
        int mid=st+(ei-st)/2;
        root=new TreeNode(order.get(mid));
        root.left=BuildBst(root.left,order,st,mid-1);
        root.right=BuildBst(root.right,order,mid+1,ei);

        return root;
    }
    private void Inorder(TreeNode root, List<Integer> order){
        if(root==null){
            return ;
        }
        Inorder(root.left,order);
        order.add(root.val);
        Inorder(root.right,order);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> order=new ArrayList<>();
        Inorder(root,order);

        return BuildBst(root,order,0,order.size()-1);
        
        
    }
}