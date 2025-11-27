package Day_6_LinkedList;

import java.util.*;

public class ReverseLinkedList {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public static ListNode reverseList(ListNode head) {
    ListNode current = head;
    ListNode prev = null;
    while (current != null) {
      ListNode temp = current.next;
      current.next = prev;
      prev = current;
      current = temp;
    }
    return prev;
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
    head = reverseList(head);
    System.out.println("Reversed linked list:");
    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
    sc.close();
  }
}
