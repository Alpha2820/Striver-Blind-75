package Day_2_Binary;

import java.util.*;

public class CountingBits {
  public static int Bits(int n) {
    int count = 0;
    while (n != 0) {
      if ((n & 1) == 1) {
        count++;
      }
      n = n >> 1;
    }
    return count;
  }

  public static int[] countBits(int n) {
    int dp[] = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = Bits(i);
    }
    return dp;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an integer:");
    int n = sc.nextInt();
    int result[] = countBits(n);
    System.out.println("The number of 1 bits in the binary representation from 0 to " + n + " are: ");
    for (int i = 0; i <= n; i++) {
      System.out.print(result[i] + " ");
    }
    sc.close();
  }

}
