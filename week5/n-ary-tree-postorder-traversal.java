/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    
    public void postorder(Node root, List<Integer> result){
        if(root == null) return ;
        for(Node child: root.children){
            postorder(child, result);
        }
        result.add(root.val);
    }
}