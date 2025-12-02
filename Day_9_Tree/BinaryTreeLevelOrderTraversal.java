package Day_9_Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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

  public static List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();
        currentLevel.add(currentNode.val);
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
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
    List<List<Integer>> levels = levelOrder(root);
    System.out.println("Level order traversal of the binary tree:");
    for (List<Integer> level : levels) {
      System.out.println(level);
    }
    sc.close();
  }
}
