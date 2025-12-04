package Day_9_Tree;

import java.util.*;

public class KthSmallestElementInABST {
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

  public static void Helper(TreeNode root, List<Integer> arr) {
    if (root == null) {
      return;
    }
    Helper(root.left, arr);
    arr.add(root.val);
    Helper(root.right, arr);
  }

  public static int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    Helper(root, arr);
    return arr.get(k - 1);
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
    System.out.println("Enter the value of k:");
    int k = sc.nextInt();
    int result = kthSmallest(root, k);
    System.out.println("The " + k + "th smallest element in the BST is: " + result);
    sc.close();

  }

}
