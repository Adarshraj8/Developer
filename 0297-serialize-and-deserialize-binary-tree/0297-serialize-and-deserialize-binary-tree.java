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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
         encodeData(root,sb);
         return sb.toString();
    }
    private void encodeData(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
        return ;
        }
        sb.append(root.val).append(",");
        encodeData(root.left,sb);
        encodeData(root.right,sb);
        }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> token = new LinkedList<>(Arrays.asList(data.split(",")));
        return decodeData(token);
    }

    private TreeNode decodeData(Queue<String> token){
        String val = token.poll();
        if(val.equals("#"))
        return null;

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = decodeData(token);
        root.right = decodeData(token);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));