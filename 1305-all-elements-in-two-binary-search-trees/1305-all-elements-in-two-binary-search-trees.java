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
    private void Inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return ;
        }
        Inorder(root.left,list);
        list.add(root.val);
        Inorder(root.right,list);

    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        Inorder(root1,list1);
        Inorder(root2,list2);

        for(int i=0;i<list1.size();i++){
            ans.add(list1.get(i));
        }
        for(int i=0;i<list2.size();i++){
            ans.add(list2.get(i));
        }

        ans.sort(Comparator.naturalOrder());
        return ans;







        
    }
}