package Day_9_Tree;

import java.util.*;

public class checkIfTwoTreesAreIdenticalOrNot {
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

  public static boolean isIdentical(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
    if (root1 == null || root2 == null) {
      return false;
    }
    return (root1.val == root2.val) &&
        isIdentical(root1.left, root2.left) &&
        isIdentical(root1.right, root2.right);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes in the first binary tree:");
    int n1 = sc.nextInt();
    TreeNode[] nodes1 = new TreeNode[n1];
    System.out.println("Enter the values of the nodes for the first tree (-1 for null):");
    for (int i = 0; i < n1; i++) {
      int val = sc.nextInt();
      if (val != -1) {
        nodes1[i] = new TreeNode(val);
      } else {
        nodes1[i] = null;
      }
    }
    for (int i = 0; i < n1; i++) {
      if (nodes1[i] != null) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex < n1) {
          nodes1[i].left = nodes1[leftIndex];
        }
        if (rightIndex < n1) {
          nodes1[i].right = nodes1[rightIndex];
        }
      }
    }
    TreeNode root1 = nodes1[0];

    System.out.println("Enter number of nodes in the second binary tree:");
    int n2 = sc.nextInt();
    TreeNode[] nodes2 = new TreeNode[n2];
    System.out.println("Enter the values of the nodes for the second tree (-1 for null):");
    for (int i = 0; i < n2; i++) {
      int val = sc.nextInt();
      if (val != -1) {
        nodes2[i] = new TreeNode(val);
      } else {
        nodes2[i] = null;
      }
    }
    for (int i = 0; i < n2; i++) {
      if (nodes2[i] != null) {
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        if (leftIndex < n2) {
          nodes2[i].left = nodes2[leftIndex];
        }
        if (rightIndex < n2) {
          nodes2[i].right = nodes2[rightIndex];
        }
      }
    }
    TreeNode root2 = nodes2[0];
    boolean result = isIdentical(root1, root2);
    if (result) {
      System.out.println("The two binary trees are identical.");
    } else {
      System.out.println("The two binary trees are not identical.");
    }
    sc.close();
  }

}
