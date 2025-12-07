package Day_8_String;

import java.util.*;

public class MinimumWindowSubstring {
  public static String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) {
      return "";
    }

    Map<Character, Integer> dictT = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      dictT.put(c, dictT.getOrDefault(c, 0) + 1);
    }

    int required = dictT.size();
    int left = 0, right = 0;
    int formed = 0;
    Map<Character, Integer> windowCounts = new HashMap<>();
    int[] ans = { -1, 0, 0 };

    while (right < s.length()) {
      char c = s.charAt(right);
      windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

      if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
        formed++;
      }

      while (left <= right && formed == required) {
        c = s.charAt(left);
        if (ans[0] == -1 || right - left + 1 < ans[0]) {
          ans[0] = right - left + 1;
          ans[1] = left;
          ans[2] = right;
        }

        windowCounts.put(c, windowCounts.get(c) - 1);
        if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
          formed--;
        }
        left++;
      }
      right++;
    }

    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string S:");
    String s = sc.nextLine();
    System.out.println("Enter the string T:");
    String t = sc.nextLine();
    String result = minWindow(s, t);
    System.out.println("Minimum window substring: " + result);
    sc.close();
  }
}
