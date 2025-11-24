package Day_2_Binary;

import java.util.*;

public class MissingNumber {
  public static int missing(int arr[]) {
    int missing = arr.length;
    for (int i = 0; i < arr.length; i++) {
      missing = missing ^ (i ^ arr[i]);
    }
    return missing;
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
    int result = missing(arr);
    System.out.println("The missing number is: " + result);
    sc.close();
  }
}
