package Day_8_String;

import java.util.*;

public class CheckBalancedParanthesis {
  public static boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();
    for (char ch : expression.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')' || ch == '}' || ch == ']') {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if (!isMatchingPair(top, ch)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  private static boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
        (open == '{' && close == '}') ||
        (open == '[' && close == ']');
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the expression:");
    String expression = sc.nextLine();
    if (isBalanced(expression)) {
      System.out.println("The parentheses are balanced.");
    } else {
      System.out.println("The parentheses are not balanced.");
    }
    sc.close();
  }

}
