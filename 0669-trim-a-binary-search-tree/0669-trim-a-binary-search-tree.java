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
 *         this.left = le9ft;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode BuildBst(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        
        if(root.val>val){
            // left
            root.left=BuildBst(root.left,val);
        }else{
            // right
            root.right=BuildBst(root.right,val);
        }

        return root;
    }
    private void Preorder(TreeNode root,List<Integer> order){
        if(root==null){
            return ;
        }
        order.add(root.val);
        Preorder(root.left,order);
        Preorder(root.right,order);

    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        List<Integer> order=new ArrayList<>();
        List<Integer> trim=new ArrayList<>();

        Preorder(root,order);
        for(int i=0;i<order.size();i++){
            if(order.get(i)>=low && order.get(i)<=high){
                trim.add(order.get(i));
            }
        }
        root=null;
        for(int i=0;i<trim.size();i++){
            root=BuildBst(root,trim.get(i));
        }
        

        return root;
        
    }
}