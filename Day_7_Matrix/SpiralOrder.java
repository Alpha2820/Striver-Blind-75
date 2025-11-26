package Day_7_Matrix;

import java.util.*;

public class SpiralOrder {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }

    int top = 0;
    int bottom = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
      // Traverse from left to right
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      top++;

      // Traverse from top to bottom
      for (int i = top; i <= bottom; i++) {
        result.add(matrix[i][right]);
      }
      right--;

      if (top <= bottom) {
        // Traverse from right to left
        for (int i = right; i >= left; i--) {
          result.add(matrix[bottom][i]);
        }
        bottom--;
      }

      if (left <= right) {
        // Traverse from bottom to top
        for (int i = bottom; i >= top; i--) {
          result.add(matrix[i][left]);
        }
        left++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    SpiralOrder so = new SpiralOrder();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows:");
    int rows = sc.nextInt();
    System.out.println("Enter number of columns:");
    int cols = sc.nextInt();
    int[][] matrix = new int[rows][cols];
    System.out.println("Enter the elements of the matrix:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    List<Integer> spiralOrder = so.spiralOrder(matrix);
    System.out.println("Spiral Order: " + spiralOrder);
    sc.close();
  }
}
