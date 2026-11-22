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
    public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> list = new ArrayList<>();
          if(root==null)
          return list;
          Queue<TreeNode> q = new LinkedList<>();
          q.add(root);
          while(!q.isEmpty())
          {
            List<Integer> level = new ArrayList<>();
             int size = q.size();
             while(size-->0)
             {
                TreeNode current =  q.poll();
                if(current!=null)
                level.add(current.val);
                if(current.left!=null)
                q.add(current.left);
                if(current.right!=null)
                q.add(current.right);
             }
             list.add(level);
          }
          return list;
    }
}