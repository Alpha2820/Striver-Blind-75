package Day_9_Tree;

import java.util.*;

public class SerializeAndDeserialize {
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

  public static String serialize(TreeNode root) {
    ArrayList<String> list = new ArrayList<>();
    serializeHelper(root, list);
    return String.join(",", list);
  }

  private static void serializeHelper(TreeNode root, ArrayList<String> list) {
    if (root == null) {
      list.add("N");
      return;
    }
    list.add(String.valueOf(root.val));
    serializeHelper(root.left, list);
    serializeHelper(root.right, list);
  }

  private static TreeNode deserializeHelper(String[] arr, int[] index) {
    if (index[0] >= arr.length || arr[index[0]].equals("N")) {
      index[0]++;
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(arr[index[0]]));
    index[0]++;
    node.left = deserializeHelper(arr, index);
    node.right = deserializeHelper(arr, index);
    return node;
  }

  public static TreeNode deserialize(String data) {
    String arr[] = data.split(",");
    int index[] = new int[1];
    return deserializeHelper(arr, index);
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
    String serializedData = serialize(root);
    System.out.println("Serialized tree: " + serializedData);
    TreeNode deserializedRoot = deserialize(serializedData);
    String reSerializedData = serialize(deserializedRoot);
    System.out.println("Re-Serialized tree after deserialization: " + reSerializedData);
    sc.close();
  }
}
