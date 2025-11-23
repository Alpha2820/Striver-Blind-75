package Day_1_Array;

import java.util.*;

public class SearchInRotatedSortedArray {
  public static int search(int nums[], int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // Left half is sorted
      if (nums[left] <= nums[mid]) {
        if (nums[mid] < target || target < nums[left]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      // right half is sorted
      else {
        if (target < nums[mid] || target > nums[right]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of elements in the array:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Enter the target element to be searched:");
    int target = sc.nextInt();
    int result = search(nums, target);
    System.out.println("The target element is found at index: " + result);
    sc.close();
  }

}
