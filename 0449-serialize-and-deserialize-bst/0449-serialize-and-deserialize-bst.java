/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private TreeNode BuildBst(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        if(root.val>val){
            root.left=BuildBst(root.left,val);
        }else{
            root.right=BuildBst(root.right,val);
        }

        return root;
    }
    private void Preorder(TreeNode root,StringBuilder str){
        if(root==null){
            return ;
        }
        str.append(root.val).append(",");
        Preorder(root.left,str);
        Preorder(root.right,str);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str=new StringBuilder();
        Preorder(root,str);

        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] values=data.split(",");
        TreeNode root=null;
        for(int i=0;i<values.length;i++){
            root = BuildBst(root,Integer.parseInt(values[i]));
        }
        

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;