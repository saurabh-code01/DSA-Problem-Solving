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
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    // return array: [isBST, min, max, sum]
    private int[] dfs(TreeNode root) {
        if (root == null) {
            // empty tree is BST, min=+∞, max=-∞, sum=0
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // check BST property
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            int sum = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, sum);
            return new int[]{1, Math.min(root.val, left[1]), Math.max(root.val, right[2]), sum};
        } else {
            // not BST
            return new int[]{0, 0, 0, 0};
        }
    }
}
