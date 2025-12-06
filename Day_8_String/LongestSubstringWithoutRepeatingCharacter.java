package Day_8_String;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
  public static int length(String s) {
    HashSet<Character> result = new HashSet<>();
    int left = 0;
    int length = 0;
    for (int right = 0; right < s.length(); right++) {
      while (result.contains(s.charAt(right))) {
        result.remove(s.charAt(right));
        left++;
      }
      result.add(s.charAt(right));
      length = Math.max(length, right - left + 1);
    }
    return length;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string:");
    String s = sc.nextLine();
    int len = length(s);
    System.out.println("Length of longest substring without repeating characters: " + len);
    sc.close();

  }

}
