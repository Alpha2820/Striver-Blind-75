package Day_7_Matrix;

import java.util.*;

public class RotateImage {
  public static void rotate(int matrix[][]) {
    int length = matrix.length;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][length - j - 1];
        matrix[i][length - j - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the square matrix:");
    int n = sc.nextInt();
    int matrix[][] = new int[n][n];
    System.out.println("Enter the elements of the matrix:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = sc.nextInt();
      }
    }
    rotate(matrix);
    System.out.println("The rotated matrix is:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
