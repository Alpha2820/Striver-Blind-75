package Day_1_Array;

import java.util.*;

public class MaximumSubArray {
  public static int maxSubArr(int nums[]) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (sum > max) {
        max = sum;
      } else {
        sum = 0;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    int result = maxSubArr(nums);
    System.out.println(result);
    sc.close();
  }

}
