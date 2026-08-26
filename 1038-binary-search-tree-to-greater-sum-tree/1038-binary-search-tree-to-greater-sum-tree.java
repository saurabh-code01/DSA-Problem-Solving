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
    private void Swap(TreeNode root,HashMap<Integer , Integer>map){
        if(root==null){
            return ;
        }
        if(map.containsKey(root.val)){
            root.val=map.get(root.val);
        }
        Swap(root.left,map);
        Swap(root.right,map);
    }
    private int Sumcount(List<Integer>order,int idx){
        int sum=0;
        for(int i=idx;i<order.size();i++){
            sum+=order.get(i);
        }
        return sum;
    }
    private void inorder( List<Integer> order,TreeNode root){
        if(root==null){
            return ;
        }
        inorder(order,root.left);
        order.add(root.val);
        inorder(order,root.right);
    }
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> order=new ArrayList<>();
        inorder(order,root);

        HashMap<Integer , Integer>map=new HashMap<>();
        int n=order.size();
        for(int i=0;i<n;i++){
            map.put(order.get(i),Sumcount(order,i));
        }

        Swap(root,map);
        return root;
        
    }
}