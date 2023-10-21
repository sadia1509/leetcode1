package dataStructure.nonLinear;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tree {
    public TreeNode node ;
    public TreeNode makeTree(){
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(0, left, right);
        left.left= new TreeNode(3);
        left.right= new TreeNode(4);
        right.left= new TreeNode(5);
        right.right= new TreeNode(6);

        left.right.right= new TreeNode(7);
//        this.node = left;
        this.node = left.right.right;

        return root;
    }

    // Left Root Right
    public void inOrderTraversal(TreeNode root){
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    // Root Left Right
    public void preOrderTraversal(TreeNode root){
        if(root!=null){
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Left Right Root
    public void postOrderTraversal(TreeNode root){
        if(root!=null){
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    // level based BFS
    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if (node==null) continue;
            System.out.print(node.value+ " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    //depth (MAX) or maxHeight
    public int maxDepth(TreeNode root){
//        if(root==null) return 0;
//         int leftMaxDepth = maxDepth(root.left);
//         int rightMaxDepth = maxDepth(root.right);
//        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return root==null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    
    //depth
    public int depth(TreeNode root, TreeNode node, int currentDepth){
        if (root == null)  return -1;
        if (root.value == node.value)   return currentDepth;
        int leftDepth = depth(root.left, node, currentDepth + 1);
        if (leftDepth != -1)  return leftDepth;
        int rightDepth = depth(root.right, node, currentDepth + 1);
        return rightDepth;
    }

    //level
    public int level(TreeNode root, TreeNode node){
        return  depth(root, node, 0) + 1;
    }

    //height
    public int height(TreeNode root, TreeNode node){
        if (root == null)   return -1;
        if (root.value == node.value)   return height(root);
        int leftHeight = height(root.left, node);
        if (leftHeight != -1)   return leftHeight;
        int rightHeight = height(root.right, node);
        return rightHeight;
    }
    int height(TreeNode root) {
        return root==null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }


}

class TreeNode{
    Object value;
    TreeNode left;
    TreeNode right;

    public TreeNode(Object value) {
        this.value = value;
    }
    public TreeNode(Object value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}