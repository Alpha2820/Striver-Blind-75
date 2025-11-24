package Day_2_Binary;

import java.util.*;

public class ReverseBits {
  public static int reverseBits(int n) {
    int reverse = 0;
    for (int i = 0; i < 32; i++) {
      int lastBit = (n >> i) & 1;
      reverse = reverse | (lastBit << (31 - i));
    }
    return reverse;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter an integer:");
    int n = sc.nextInt();
    int result = reverseBits(n);
    System.out.println("The reversed bits integer is: " + result);
    sc.close();
  }

}
