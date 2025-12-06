package Day_8_String;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
  public static int charReplace(String s, int k) {
    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set.add(s.charAt(i));
    }
    int maxLength = 0;
    for (char ch : set) {
      int left = 0;
      int count = 0;
      for (int right = 0; right < s.length(); right++) {
        if (s.charAt(right) != ch) {
          count++;
        }
        while (count > k) {
          if (s.charAt(left) != ch) {
            count--;
          }
          left++;
        }
        maxLength = Math.max(maxLength, right - left + 1);
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String s = sc.nextLine();
    System.out.println("Enter the value of k:");
    int k = sc.nextInt();
    int len = charReplace(s, k);
    System.out.println("Length of longest substring after replacement: " + len);
    sc.close();
  }
}
