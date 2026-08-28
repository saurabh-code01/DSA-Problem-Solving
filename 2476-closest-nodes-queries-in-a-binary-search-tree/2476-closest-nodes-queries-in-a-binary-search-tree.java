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
        if(root == null) return;
        Inorder(root.left, order);
        order.add(root.val);
        Inorder(root.right, order);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> order = new ArrayList<>();
        Inorder(root, order);

        List<List<Integer>> result = new ArrayList<>();

        for(int q : queries){
            List<Integer> list = new ArrayList<>();

            // floor (min ≤ q)
            int idx = Collections.binarySearch(order, q);
            if(idx >= 0){
                list.add(order.get(idx)); // exact match
            } else {
                int insertPoint = -(idx+1);
                if(insertPoint > 0) list.add(order.get(insertPoint-1));
                else list.add(-1);
            }

            // ceil (max ≥ q)
            idx = Collections.binarySearch(order, q);
            if(idx >= 0){
                list.add(order.get(idx)); // exact match
            } else {
                int insertPoint = -(idx+1);
                if(insertPoint < order.size()) list.add(order.get(insertPoint));
                else list.add(-1);
            }

            result.add(list);
        }

        return result;
    }
}
