package Day_8_String;

import java.util.*;

public class checkPalindrom {
  public static boolean isPalindrom(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left <= right) {
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String str = sc.nextLine();
    if (isPalindrom(str)) {
      System.out.println("The string is Palindrom");
    } else {
      System.out.println("The string is not Palindrom");
    }
    sc.close();
  }
}
