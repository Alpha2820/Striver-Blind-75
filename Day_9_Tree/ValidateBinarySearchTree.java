package Day_9_Tree;

import java.util.*;

public class ValidateBinarySearchTree {
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

  public static boolean chequeValidBST(TreeNode root, long left, long right) {
    if (root == null) {
      return false;
    }
    if (!(left < root.val && root.val < right)) {
      return false;
    }
    return chequeValidBST(root.left, left, root.val) && chequeValidBST(root.right, root.val, right);
  }

  public static boolean isValidBST(TreeNode root) {
    return chequeValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public static TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    if (val < root.val) {
      root.left = insertIntoBST(root.left, val);
    } else {
      root.right = insertIntoBST(root.right, val);
    }
    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes in BST:");
    int n = sc.nextInt();
    System.out.println("Enter node values:");
    TreeNode root = null;
    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      root = insertIntoBST(root, val);
    }
    if (isValidBST(root)) {
      System.out.println("The tree is a valid Binary Search Tree.");
    } else {
      System.out.println("The tree is not a valid Binary Search Tree.");
    }
    sc.close();
  }

}
