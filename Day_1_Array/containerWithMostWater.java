package Day_1_Array;

import java.util.*;

public class containerWithMostWater {
  public static int maxWater(int nums[]) {
    int left = 0;
    int right = nums.length - 1;
    int maxArea = 0;
    while (left <= right) {
      int max = (right - left) * Math.min(nums[left], nums[right]);
      maxArea = Math.max(maxArea, max);
      if (nums[left] < nums[right]) {
        left++;
      } else if (nums[left] > nums[right]) {
        right--;
      } else {
        left++;
      }
    }
    return maxArea;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the elements of the array:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    int result = maxWater(nums);
    System.out.println("The maximum water that can be contained is: " + result);
    sc.close();
  }
}
