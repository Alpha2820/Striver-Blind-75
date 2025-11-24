package Day_2_Binary;

import java.util.*;

public class NumberOfOneBits {
  public static int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an integer:");
    int n = sc.nextInt();
    int result = hammingWeight(n);
    System.out.println("The number of 1 bits in the binary representation is: " + result);
    sc.close();
  }
}
