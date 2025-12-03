package Day_9_Tree;

import java.util.*;

public class SubtreeOfAnotherTree {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

  public static boolean isSameTree(TreeNode root, TreeNode subTree) {
    if (root == null && subTree == null) {
      return true;
    }
    if ((root != null && subTree != null) && (root.val == subTree.val)) {
      return isSameTree(root.left, subTree.left) && (isSameTree(root.right, subTree.right));
    }
    return false;
  }

  public static boolean isSubtree(TreeNode root, TreeNode subTree) {
    if (root == null) {
      return false;
    }
    if (isSameTree(root, subTree)) {
      return true;
    }
    return isSubtree(root.left, subTree) || isSubtree(root.right, subTree);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes in the main tree:");
    int n = sc.nextInt();
    TreeNode[] nodes = new TreeNode[n];
    System.out.println("Enter the values of the nodes (-1 for null):");
    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      if (val != -1) {
        nodes[i] = new TreeNode();
        nodes[i].val = val;
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
    System.out.println("Enter number of nodes in the subtree:");
    int m = sc.nextInt();
    TreeNode[] subNodes = new TreeNode[m];
    System.out.println("Enter the values of the subtree nodes (-1 for null):");
    for (int i = 0; i < m; i++) {
      int val = sc.nextInt();
      if (val != -1) {
        subNodes[i] = new TreeNode();
        subNodes[i].val = val;
      } else {
        subNodes[i] = null;
      }
    }
    for (int i = 0; i < m; i++) {
      if (subNodes[i] != null) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex < m) {
          subNodes[i].left = subNodes[leftIndex];
        }
        if (rightIndex < m) {
          subNodes[i].right = subNodes[rightIndex];
        }
      }
    }
    TreeNode subTree = subNodes[0];
    boolean result = isSubtree(root, subTree);
    System.out.println("Is the subtree present in the main tree? " + result);
    sc.close();
  }
}
