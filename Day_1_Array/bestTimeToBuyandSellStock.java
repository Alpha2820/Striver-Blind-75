package Day_1_Array;

import java.util.*;

public class bestTimeToBuyandSellStock {
  public static int maxProfit(int arr[]) {
    int max = 0;
    int left = 0;
    int right = 1;
    while (right < arr.length) {
      if (arr[left] < arr[right]) {
        int profit = arr[right] - arr[left];
        max = Math.max(max, profit);
      } else {
        left = right;
      }
      right++;
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int arr[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int result = maxProfit(arr);
    System.out.println("The maximum profit is: " + result);
    sc.close();
  }

}
