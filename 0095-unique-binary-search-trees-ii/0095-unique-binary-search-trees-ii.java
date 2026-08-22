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
 * }.
 */
class Solution {

    private List<TreeNode> uniqueBST(int st,int ei,Map<String , List<TreeNode>>memo){
        String key=st+ "," +ei;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        List<TreeNode> result=new ArrayList<>();
        if(st>ei){
            result.add(null);
            return result;

        }
        for(int i=st;i<=ei;i++){
            
            List<TreeNode> leftTree=uniqueBST(st,i-1,memo);
            List<TreeNode> rightTree=uniqueBST(i+1,ei,memo);

            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    result.add(root);

                }
            }
        }
        memo.put(key, result);
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        
        if(n==0){
            return new ArrayList<>();
        }
        return uniqueBST(1,n, new HashMap<>());
        


        
    }
}