package Day_2_Binary;

import java.util.*;

public class SumOfTwoInteger {
  public static int getSum(int a, int b) {
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first integer:");
    int a = sc.nextInt();
    System.out.println("Enter second integer:");
    int b = sc.nextInt();
    int result = getSum(a, b);
    System.out.println("The sum of two integers is: " + result);
    sc.close();
  }

}
