package Day_8_String;

import java.util.*;

public class GroupAnagram {
  public static List<List<String>> group(String str[]) {
    HashMap<String, ArrayList<String>> map = new HashMap<>();
    for (String s : str) {
      char ch[] = s.toCharArray();
      Arrays.sort(ch);
      String key = new String(ch);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of strings:");
    int n = sc.nextInt();
    sc.nextLine(); // Consume newline
    String str[] = new String[n];
    System.out.println("Enter the strings:");
    for (int i = 0; i < n; i++) {
      str[i] = sc.nextLine();
    }
    List<List<String>> result = group(str);
    System.out.println("Grouped Anagrams:");
    for (List<String> group : result) {
      System.out.println(group);
    }
    sc.close();
  }
}
