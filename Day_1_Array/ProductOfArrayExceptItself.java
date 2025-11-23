package Day_1_Array;

import java.util.*;

public class ProductOfArrayExceptItself {
  public static int[] productOfArray(int nums[]) {
    int n = nums.length;
    int result[] = new int[n];
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix;
      prefix = prefix * nums[i];
    }
    int postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
      result[i] = result[i] * postfix;
      postfix = postfix * nums[i];
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array:");
    int n = sc.nextInt();
    int nums[] = new int[n];
    System.out.println("Enter the elements of the array:");
    for (int i = 0; i < n; i++) {
      nums[i] = sc.nextInt();
    }
    int result[] = productOfArray(nums);
    System.out.println("The product array is:" + Arrays.toString(result));
    sc.close();
  }
}
