package Day_8_String;

import java.util.*;

public class checkAnagram {
  public static boolean areAnagram(String s1, String s2) {
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
    }
    for (int j = 0; j < s2.length(); j++) {
      map2.put(s2.charAt(j), map2.getOrDefault(s2.charAt(j), 0) + 1);
    }
    return map1.equals(map2);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first string:");
    String s1 = sc.nextLine();
    System.out.println("Enter second string:");
    String s2 = sc.nextLine();
    boolean result = areAnagram(s1, s2);
    if (result) {
      System.out.println("The two strings are anagram of each other.");
    } else {
      System.out.println("The two strings are not anagram of each other.");
    }
    sc.close();
  }

}
