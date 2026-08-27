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
    private void Inorder(TreeNode root, List<Integer> order){
        if(root==null){
            return ;
        }
        Inorder(root.left,order);
        order.add(root.val);
        Inorder(root.right,order);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> order=new ArrayList<>();
        Inorder(root,order);

        int left=0,right=order.size()-1;
        while(left<right){
            int sum=order.get(left) + order.get(right);
            if(sum==k){
                return true;
            }
            if(sum>k){
                right--;
            }
            if(sum<k){
                left++;
            }

        }

        return false;
    }
}