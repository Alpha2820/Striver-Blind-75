package Day_6_LinkedList;

import java.util.*;

public class DetectACycleInLinkedList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of nodes in the linked list:");
    int n = sc.nextInt();
    ListNode head = null;
    ListNode tail = null;
    System.out.println("Enter the elements of the linked list:");
    for (int i = 0; i < n; i++) {
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
    System.out.println("Does the linked list have a cycle? " + hasCycle(head));
    sc.close();
  }

}
