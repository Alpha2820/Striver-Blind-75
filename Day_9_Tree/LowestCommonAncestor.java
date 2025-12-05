package Day_9_Tree;

import java.util.*;

public class LowestCommonAncestor {
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

  public static TreeNode LowestCommon(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    int max = Math.max(p.val, q.val);
    int min = Math.min(p.val, q.val);
    if (max < root.val) {
      return LowestCommon(root.left, p, q);
    } else if (min > root.val) {
      return LowestCommon(root.right, p, q);
    } else {
      return root;
    }

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
    System.out.println("Enter values of p and q:");
    int pVal = sc.nextInt();
    int qVal = sc.nextInt();
    TreeNode p = new TreeNode(pVal);
    TreeNode q = new TreeNode(qVal);
    TreeNode lca = LowestCommon(root, p, q);
    System.out.println("The Lowest Common Ancestor of " + pVal + " and " + qVal + " is: " + lca.val);
    sc.close();
  }
}
