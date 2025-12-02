package Day_9_Tree;

import java.util.*;

public class FlipBinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }

    public static TreeNode flipTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode node = new TreeNode(root.val);
      node.left = flipTree(root.right);
      node.right = flipTree(root.left);
      return root;
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter number of nodes in the binary tree:");
      int n = sc.nextInt();
      TreeNode[] nodes = new TreeNode[n];
      System.out.println("Enter the values of the nodes (-1 for null):");
      for (int i = 0; i < n; i++) {
        int val = sc.nextInt();
        if (val != -1) {
          nodes[i] = new TreeNode(val);
        } else {
          nodes[i] = null;
        }
      }
      for (int i = 0; i < n; i++) {
        if (nodes[i] != null) {
          int leftIndex = 2 * i + 1;
          int rightIndex = 2 * i + 2;
          if (leftIndex < n) {
            nodes[i].left = nodes[leftIndex];
          }
          if (rightIndex < n) {
            nodes[i].right = nodes[rightIndex];
          }
        }
      }
      TreeNode root = nodes[0];
      TreeNode flippedRoot = flipTree(root);
      System.out.println("Flipped binary tree root value: " + (flippedRoot != null ? flippedRoot.val : "null"));
      sc.close();
    }
  }
}
