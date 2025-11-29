package Day_9_Tree;

import java.util.*;

public class HeightOfABinaryTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
      this.left = null;
      this.right = null;
    }
  }

  public static int height(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = height(root.left);
    int right = height(root.right);
    return 1 + Math.max(left, right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes in the binary tree:");
    int n = sc.nextInt();
    if (n == 0) {
      System.out.println("Height of the binary tree is 0");
    }
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
    int treeHeight = height(root);
    System.out.println("Height of the binary tree is: " + treeHeight);
    sc.close();
  }

}
