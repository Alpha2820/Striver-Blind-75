package Day_7_Matrix;

import java.util.*;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    int rows = board.length;
    int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (dfs(board, word, 0, i, j, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if (index == word.length()) {
      return true;
    }
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
        visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }

    visited[row][col] = true;

    boolean found = dfs(board, word, index + 1, row + 1, col, visited) ||
        dfs(board, word, index + 1, row - 1, col, visited) ||
        dfs(board, word, index + 1, row, col + 1, visited) ||
        dfs(board, word, index + 1, row, col - 1, visited);

    visited[row][col] = false;

    return found;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows:");
    int rows = sc.nextInt();
    System.out.println("Enter number of columns:");
    int cols = sc.nextInt();
    char[][] board = new char[rows][cols];
    System.out.println("Enter the elements of the board:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        board[i][j] = sc.next().charAt(0);
      }
    }
    System.out.println("Enter the word to search:");
    String word = sc.next();
    WordSearch ws = new WordSearch();
    boolean result = ws.exist(board, word);
    System.out.println("Word found: " + result);
    sc.close();
  }

}
