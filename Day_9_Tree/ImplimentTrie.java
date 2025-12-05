package Day_9_Tree;

import java.util.*;

public class ImplimentTrie {
  static class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
      children = new TrieNode[26];
      isEndOfWord = false;
    }
  }

  static class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void insert(String word) {
      TrieNode node = root;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (node.children[index] == null) {
          node.children[index] = new TrieNode();
        }
        node = node.children[index];
      }
      node.isEndOfWord = true;
    }

    public boolean search(String word) {
      TrieNode node = root;
      for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];
      }
      return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
      TrieNode node = root;
      for (char ch : prefix.toCharArray()) {
        int index = ch - 'a';
        if (node.children[index] == null) {
          return false;
        }
        node = node.children[index];
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number of words to insert:");
    int n = sc.nextInt();
    System.out.println("Enter words to insert:");
    for (int i = 0; i < n; i++) {
      String word = sc.next();
      trie.insert(word);
    }

    System.out.println("Enter number of search queries:");
    int q = sc.nextInt();
    System.out.println("Enter words to search:");
    for (int i = 0; i < q; i++) {
      String word = sc.next();
      System.out.println("Search for \"" + word + "\": " + trie.search(word));
    }

    System.out.println("Enter number of prefix queries:");
    int p = sc.nextInt();
    System.out.println("Enter prefixes to check:");
    for (int i = 0; i < p; i++) {
      String prefix = sc.next();
      System.out.println("Starts with \"" + prefix + "\": " + trie.startsWith(prefix));
    }
    sc.close();
  }
}
