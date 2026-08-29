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
class BSTIterator {
    private List<Integer> order ;
    private int idx;
    private void Inorder(TreeNode root,List<Integer> order){
        if(root==null){
            return ;
        }
        Inorder(root.left,order);
        order.add(root.val);
        Inorder(root.right,order);
    }

    public BSTIterator(TreeNode root) {
        order=new ArrayList<>();
        Inorder(root,order);
        int n=order.size()-1;
        idx=0;
        
    }
    
    public int next() {
        return order.get(idx++);
    
        
    }
    
    public boolean hasNext() {
        return idx<=order.size()-1?true:false;
            
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */