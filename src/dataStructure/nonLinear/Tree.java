package dataStructure.nonLinear;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tree {
    public TreeNode root;
    public TreeNode node;

    public void makeTree() {
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(0, left, right);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        right.left = new TreeNode(5);
        right.right = new TreeNode(6);

        left.right.right = new TreeNode(7);
        this.node = left.right.right;

        this.root = root;
    }

    public TreeNode makeSumTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) return null;

        TreeNode root = new TreeNode(arr[index]);
        root.left = makeSumTree(arr, 2 * index + 1);
        root.right = makeSumTree(arr, 2 * index + 2);

        return root;
    }

    public TreeNode makeTreeFromArray(Object[] arr, int index) {
        if (index >= arr.length || arr[index] == null) return null;
        TreeNode root = new TreeNode(arr[index]);
        root.left = makeTreeFromArray(arr, 2 * index + 1);
        root.right = makeTreeFromArray(arr, 2 * index + 2);
        this.root = root;
        return root;
    }

    public TreeNode getSpecificNode(TreeNode root, Object value) {
        TreeNode node = null;
        if (root != null) {
            if (root.value == value) return root;
            node = getSpecificNode(root.left, value);
            if (node != null) return node;
            node = getSpecificNode(root.right, value);
        }
        return node;
    }

    public int getTotalNodeCount(TreeNode root, int count){
        if(root!=null){
            count = count+1;
            count = getTotalNodeCount(root.left, count);
            count = getTotalNodeCount(root.right, count);
        }
        return count;
    }
    public void printMe(TreeNode node) {
        if (node != null) System.out.println(node.value);
        else System.out.println("NULL!");
    }

    // Left Root Right
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }

    // Root Left Right
    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // Left Right Root
    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }

    // level based BFS
    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) continue;
            System.out.print(node.value + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    //depth (MAX) or maxHeight
    public int maxDepth(TreeNode root) {
//        if(root==null) return 0;
//         int leftMaxDepth = maxDepth(root.left);
//         int rightMaxDepth = maxDepth(root.right);
//        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //depth
    public int depth(TreeNode root, TreeNode node, int currentDepth) {
        int depth = -1;
        if(root!=null && node!=null) {
            if (root.value == node.value) return currentDepth;
            depth = depth(root.left, node, currentDepth + 1);
            if (depth != -1) return depth;
            depth = depth(root.right, node, currentDepth + 1);
        }
        return depth;
    }

    //level
    public int level(TreeNode root, TreeNode node) {
        return depth(root, node, 0) + 1;
    }

    //height
    public int height(TreeNode root) {
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    //Check if a given Binary Tree is SumTree
    public boolean isSumTree(TreeNode root) {
        int leftSum, rightSum;
        if (root == null || root.left == null || root.right == null) return true;
        leftSum = sum(root.left);
        rightSum = sum(root.right);
        if (((int) root.value == leftSum + rightSum) && isSumTree(root.left) && isSumTree(root.right))
            return true;

        return false;
    }

    int sum(TreeNode node) {
        return node == null ? 0 : (sum(node.left) + (int) node.value + sum(node.right));
    }

    //Check if two nodes are cousins in a Binary Tree
    public void cousinCheck(TreeNode root, TreeNode node1, TreeNode node2) {
        if (depth(root, node1, 0) == depth(root, node2, 0)
                && findParent(root, node1) != findParent(root, node2))
            System.out.println("Cousins!!!");
        else System.out.println("Not cousins!");
    }

    public TreeNode findParent(TreeNode root, TreeNode child) {
        TreeNode node = null;
        if (root != null) {
            if (root.left == child) return root;
            if (root.right == child) return root;
            node = findParent(root.left, child);
            if (node != null) return node;
            node = findParent(root.right, child);
        }
        return node;
    }

    //Check if removing an edge can divide a Binary Tree in two halves
    public void isDivisibleByTwoHalves(TreeNode root){
        int leftSize = getTotalNodeCount(root.left, 0);
        int rightSize = getTotalNodeCount(root.right, 0);
        if(leftSize == rightSize + 1 || rightSize == leftSize + 1) System.out.println("Two equal halves");
        else System.out.println("Sorry can't be divided halves");
    }

    //Check whether a given binary tree is perfect or not
    public void isPerfectBinary(TreeNode root){
        int limit = maxDepth(root), totalNodes=0;
        for(int i=0; i<limit; i++)   totalNodes += Math.pow(2,i);
        if(totalNodes == getTotalNodeCount(root, 0))
            System.out.println("Perfect Binary Tree!!!");
        else System.out.println("Not a perfect binary tree!");
    }

}

class TreeNode {
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