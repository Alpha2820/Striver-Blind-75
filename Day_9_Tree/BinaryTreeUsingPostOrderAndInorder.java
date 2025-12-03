package Day_9_Tree;

import java.util.*;

public class BinaryTreeUsingPostOrderAndInorder {
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

  public static TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) {
      return null;
    }
    Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderIndexMap);
  }

  private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd,
      int[] postorder, int postStart, int postEnd,
      Map<Integer, Integer> inorderIndexMap) {
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    int rootVal = postorder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    int inorderRootIndex = inorderIndexMap.get(rootVal);
    int leftTreeSize = inorderRootIndex - inStart;

    root.left = buildTreeHelper(inorder, inStart, inorderRootIndex - 1,
        postorder, postStart, postStart + leftTreeSize - 1,
        inorderIndexMap);
    root.right = buildTreeHelper(inorder, inorderRootIndex + 1, inEnd,
        postorder, postStart + leftTreeSize, postEnd - 1,
        inorderIndexMap);
    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes:");
    int n = sc.nextInt();
    System.out.println("Enter inorder traversal:");
    int[] inorder = new int[n];
    for (int i = 0; i < n; i++) {
      inorder[i] = sc.nextInt();
    }
    System.out.println("Enter postorder traversal:");
    int[] postorder = new int[n];
    for (int i = 0; i < n; i++) {
      postorder[i] = sc.nextInt();
    }
    TreeNode root = buildTree(inorder, postorder);
    System.out.println("Binary Tree constructed successfully." +
        " Root node value: " + root.val);
    sc.close();
  }
}
