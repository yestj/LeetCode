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
    static List<TreeNode> nodeList = new ArrayList<>();

    public void flatten(TreeNode root) {
        
        preorder(root);

        TreeNode prev = nodeList.get(0);
        for (int i = 1; i < nodeList.size(); i++) {
            TreeNode curr = nodeList.get(i);
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }

    }

    private void preorder(TreeNode root) {
        if (root == null) return;
        nodeList.add(root);
        preorder(root.left);
        preorder(root.right);
    }
}