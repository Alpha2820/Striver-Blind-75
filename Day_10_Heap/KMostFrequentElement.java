import java.util.*;

public class KMostFrequentElement {
  public static int[] topKFrequent(int nums[], int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    for (int key : map.keySet()) {
      pq.add(key);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    int arr[] = new int[k];
    for (int j = 0; j < k; j++) {
      arr[j] = pq.poll();
    }
    return arr;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the elements of the array:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Enter the value of k:");
    int k = sc.nextInt();
    int result[] = topKFrequent(nums, k);
    System.out.println("The top " + k + " frequent elements are:");
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    sc.close();
  }
}