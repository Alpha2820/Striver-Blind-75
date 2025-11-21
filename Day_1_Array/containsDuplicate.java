package Day_1_Array;

import java.util.*;

public class containsDuplicate {
  public static boolean Duplicate(int nums[]) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
    }
    return false;
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
    boolean result = Duplicate(nums);
    if (result) {
      System.out.println("The array contains duplicates.");
    } else {
      System.out.println("The array does not contain duplicates.");
    }
    sc.close();
  }
}
