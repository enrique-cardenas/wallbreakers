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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1Leaves = new ArrayList<>();
        collectLeaves(root1, tree1Leaves);
        List<Integer> tree2Leaves = new ArrayList<>();
        collectLeaves(root2, tree2Leaves);
        
        return tree1Leaves.equals(tree2Leaves);
    }
    
    public void collectLeaves(TreeNode root, List<Integer> treeLeaves){
        if(root == null) return ;
        if(root.left == null && root.right == null) treeLeaves.add(root.val);
        collectLeaves(root.left, treeLeaves);
        collectLeaves(root.right, treeLeaves);
    }
}