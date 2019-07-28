/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] answer = new int[1];
        helper(root, answer);
        return answer[0];
    }
    
    public int helper(TreeNode root, int[] answer){
        if(root == null) return 0;
        int leftEdges = 0;
        if(root.left != null){
            leftEdges = 1 + helper(root.left, answer);
        }
        int rightEdges = 0;
        if(root.right != null){
            rightEdges = 1 + helper(root.right, answer);
        }
        answer[0] = Math.max(answer[0], leftEdges + rightEdges);
        return Math.max(leftEdges, rightEdges);
    }
}