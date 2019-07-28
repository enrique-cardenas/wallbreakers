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
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        
        // 0th index element = val
        // 1st index element = level of val
        int[] bottomValue = new int[2];
        bottomValue[0] = root.val;
        bottomValue[1] = 0;
        preOrder(root, 0, bottomValue);
        return bottomValue[0];
    }
    
    public void preOrder(TreeNode root, int level, int[] bottomValue){
        if(root == null) return ;
        if(level > bottomValue[1]){
            bottomValue[1] = level;
            bottomValue[0] = root.val;
        }
        preOrder(root.left, level + 1, bottomValue);
        preOrder(root.right, level + 1, bottomValue);
    }
}