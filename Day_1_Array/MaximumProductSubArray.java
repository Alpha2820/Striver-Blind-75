package Day_1_Array;

import java.util.*;

public class MaximumProductSubArray {
  public static int maxProduct(int nums[]) {
    int maxProduct = nums[0];
    int minProduct = nums[0];
    int result = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int temp = maxProduct;
        maxProduct = minProduct;
        minProduct = temp;
      }
      maxProduct = Math.max(nums[i], maxProduct * nums[i]);
      minProduct = Math.min(nums[i], minProduct * nums[i]);
      result = Math.max(result, maxProduct);
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    int result = maxProduct(nums);
    System.out.println(result);
    sc.close();
  }

}
