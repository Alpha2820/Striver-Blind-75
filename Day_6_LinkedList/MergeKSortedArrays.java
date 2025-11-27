package Day_6_LinkedList;

import java.util.*;

public class MergeKSortedArrays {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
    for (ListNode head : lists) {
      if (head != null) {
        minHeap.offer(head);
      }
    }

    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    while (!minHeap.isEmpty()) {
      ListNode minNode = minHeap.poll();
      current.next = minNode;
      current = current.next;
      if (minNode.next != null) {
        minHeap.offer(minNode.next);
      }
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of linked lists:");
    int k = sc.nextInt();
    ListNode[] lists = new ListNode[k];
    for (int i = 0; i < k; i++) {
      System.out.println("Enter number of nodes in linked list " + (i + 1) + ":");
      int n = sc.nextInt();
      ListNode head = null;
      ListNode tail = null;
      System.out.println("Enter the elements of linked list " + (i + 1) + ":");
      for (int j = 0; j < n; j++) {
        int val = sc.nextInt();
        ListNode newNode = new ListNode(val);
        if (head == null) {
          head = newNode;
          tail = newNode;
        } else {
          tail.next = newNode;
          tail = newNode;
        }
      }
      lists[i] = head;
    }
    ListNode mergedHead = mergeKLists(lists);
    System.out.println("Merged linked list:");
    ListNode current = mergedHead;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    sc.close();
  }
}
