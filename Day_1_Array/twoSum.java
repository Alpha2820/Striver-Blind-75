package Day_1_Array;

import java.util.*;

public class twoSum {
  public static int[] TwoSum(int nums[], int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int value = target - nums[i];
      if (map.containsKey(value)) {
        return new int[] { map.get(value), i };
      }
      map.put(nums[i], i);
    }
    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the array:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    System.out.println("Enter the target sum:");
    int target = sc.nextInt();
    int result[] = TwoSum(nums, target);
    if (result[0] != -1) {
      System.out
          .println("Indices of the two numbers that add up to the target are: " + result[0] + " and " + result[1]);
    } else {
      System.out.println("No two numbers add up to the target.");
    }
    sc.close();
  }
}
