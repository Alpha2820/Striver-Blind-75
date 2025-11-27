package Day_6_LinkedList;

import java.util.*;

public class RemoveNthNodeFromBack {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    int N = 0;
    ListNode current = head;
    while (current != null) {
      N++;
      current = current.next;
    }
    int rem = N - n;
    if (rem == 0) {
      return head.next;
    }
    current = head;
    for (int i = 1; i < rem; i++) {
      current = current.next;
    }
    current.next = current.next.next;
    return head;
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
    System.out.println("Enter the value of n (to remove nth node from end):");
    int nToRemove = sc.nextInt();
    head = removeNthFromEnd(head, nToRemove);
    System.out.println("Linked list after removing the nth node from the end:");
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    sc.close();
  }
}
