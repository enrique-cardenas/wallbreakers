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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];
        helper(root, max);
        return max[0];
    }
    
    public int helper(TreeNode root, int[] max){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;
        
        // left and right variables keep track of max length with same val as root
        int left = 0;
        int right = 0;
        if(root.left != null && root.left.val == root.val)
            left = 1 + helper(root.left, max);
        if(root.right != null && root.right.val == root.val)
            right = 1 + helper(root.right, max);
        
        // max[0] keeps track of maximum path so far
        max[0] = Math.max(max[0], left + right);
        
        
        // if left child does not have the same val as root traverse the left subtree for
        // new path
        if(root.left != null && root.left.val != root.val)
            helper(root.left, max);
        
        // if right child does not have the same val as root, traverse the right child for 
        // new path
        if(root.right != null && root.right.val != root.val)
            helper(root.right, max);
        
        // return longest path univalue path from either left subtree or right subtree
        return Math.max(left, right);
    }
}