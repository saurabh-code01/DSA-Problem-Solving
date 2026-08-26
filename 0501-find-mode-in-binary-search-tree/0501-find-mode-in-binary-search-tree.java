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
    private void Inorder(TreeNode root,Map<Integer,Integer> freq){
        if(root==null){
            return ;
        }
        Inorder(root.left,freq);
        
        freq.put(root.val,freq.getOrDefault(root.val,0)+1);
        Inorder(root.right,freq);
    }
    public int[] findMode(TreeNode root) {
        
        Map<Integer,Integer> freq =new HashMap<>();
        Inorder(root,freq);

        int maxFreq=0;
        for(int val :freq.values()){
            maxFreq =Math.max(maxFreq,val);
        }

        List<Integer> mode=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:freq.entrySet()){
            if(entry.getValue()==maxFreq){
                mode.add(entry.getKey());
            }
        }

        int[] arr=new int [mode.size()];
        for(int i=0;i<mode.size();i++){
            arr[i]=mode.get(i);
        }
        
        return arr;
        
    }
}