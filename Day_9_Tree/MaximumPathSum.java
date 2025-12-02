package Day_9_Tree;

import java.util.*;

public class MaximumPathSum {
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

  private static int maxPathSumUtil(TreeNode root, int[] maxSum) {
    if (root == null) {
      return 0;
    }
    int left = Math.max(0, maxPathSumUtil(root.left, maxSum));
    int right = Math.max(0, maxPathSumUtil(root.right, maxSum));
    maxSum[0] = Math.max(maxSum[0], left + right + root.val);
    return Math.max(left, right) + root.val;
  }

  public static int maxPathSum(TreeNode root) {
    int[] maxSum = new int[] { Integer.MIN_VALUE };
    maxPathSumUtil(root, maxSum);
    return maxSum[0];
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
    int result = maxPathSum(root);
    System.out.println("Maximum Path Sum: " + result);
    sc.close();
  }
}
