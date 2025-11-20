import java.util.*;

public class FindMediaFromDataStream {
  public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public static void addNum(int num) {
    if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
      maxHeap.add(num);
    } else {
      minHeap.add(num);
    }
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.add(maxHeap.poll());
    } else if (minHeap.size() > maxHeap.size()) {
      maxHeap.add(minHeap.poll());
    }
  }

  public static double findMedian() {
    if (maxHeap.size() > minHeap.size()) {
      return maxHeap.peek();
    } else {
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements to be added:");
    int n = sc.nextInt();
    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      addNum(num);
      System.out.println("Current Median: " + findMedian());
    }
    sc.close();
  }

}
