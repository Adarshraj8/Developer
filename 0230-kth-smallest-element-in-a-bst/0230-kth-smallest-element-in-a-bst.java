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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // left mein jitna ja sakte ho jao, stack mein push karte jao
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // ab stack se pop karo (ye current smallest hai jo abhi tak nahi dekha)
            curr = stack.pop();
            k--;
            
            if (k == 0) {
                return curr.val;   // yahi kth smallest hai
            }
            
            // ab right subtree explore karo
            curr = curr.right;
        }
        
        return -1; // yahan kabhi nahi aayega agar k valid hai
    }
}