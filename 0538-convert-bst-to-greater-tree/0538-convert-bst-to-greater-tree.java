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
    private void Swap(HashMap<Integer,Integer> map,TreeNode root){
        if(root==null){
            return ;
        }
        
        root.val=map.get(root.val);
        Swap(map,root.left);
        Swap(map,root.right);

        return;

    }
    private int Sumtotal(List<Integer>order,int idx){
        int sum=0;
        for(int i=idx;i<order.size();i++){
            sum+=order.get(i);
        }

        return sum;
    }
    private void Inorder(List<Integer> order,TreeNode root){
        if(root==null){
            return ;
        }
        Inorder(order,root.left);
        order.add(root.val);
        Inorder(order,root.right);
    }
    public TreeNode convertBST(TreeNode root) {
        List<Integer> order=new ArrayList<>();
        Inorder(order,root);

        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<order.size();i++){
            map.put(order.get(i),Sumtotal(order,i));
        }

        Swap(map,root);
        return root;
        
    }
}