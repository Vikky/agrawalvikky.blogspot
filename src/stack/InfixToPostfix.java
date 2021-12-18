package stack;

import java.util.Stack;

/** Created by viagrawal on 3/31/18. */
public class InfixToPostfix {

  public static void main(String[] args) {

    String infix = "a+b*(c^d-e)^(f+g*h)-i"; // "1+2*8/4-5+6*3/2"
    InfixToPostfix object = new InfixToPostfix();
    System.out.println(object.infixToPostfix(infix));

    System.out.println(object.infixToPostfix("-2+3"));
    System.out.println(object.evaluatePostfix(object.infixToPostfix("-2+3")));
  }

  private String infixToPostfix(String str) {
    if (str == null || str.isEmpty()) return str;

    char[] arr = str.toCharArray();
    StringBuilder builder = new StringBuilder();
    Stack<Character> stack = new Stack();

    for (int i = 0; i < arr.length; i++) {
      char ch = arr[i];
      if (!isOperator(ch)) {
        builder.append(ch);
        continue;
      }
      if (ch == '(') {
        stack.push(ch);
        continue;
      }
      if (ch == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          char popped = stack.pop();
          if (stack.peek() == null && popped != '(')
            throw new UnsupportedOperationException("Invalid input");
          if (popped != '(') builder.append(popped);
        }
        stack.pop();
      } else {
        while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
          builder.append(stack.pop());
        }
        stack.push(ch);
      }
    }
    while (!stack.isEmpty()) builder.append(stack.pop());
    return builder.toString();
  }

  private int evaluatePostfix(String postfix) {
    Stack<Integer> stack = new Stack();
    for (int i = 0; i < postfix.length(); i++) {
      // Add cases for unary operator (-) which can be at the start of the expression.

      char ch = postfix.charAt(i);
      if (isOperator(ch)) {
        int first = stack.pop();
        int second = stack.pop();
        int operated = operate(first, second, ch);
        stack.push(operated);
      } else {
        stack.push(Character.getNumericValue(ch));
      }
    }
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) builder.append(stack.pop());
    return Integer.valueOf(builder.toString(),10);
  }

  private int operate(int first, int second, char operator) {
    int result = 0;
    if (operator == '+') result = first + second;
    else if (operator == '-') result = second - first;
    return result;
  }

  private boolean isOperator(final char c) {
    switch (c) {
      case '+':
      case '-':
      case '*':
      case '/':
      case '^':
      case '(':
      case ')':
        return true;
    }
    return false;
  }

  private int precedence(final char opr) {
    switch (opr) {
      case '(':
        return 0;
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      case '^':
        return 3;
    }
    throw new UnsupportedOperationException();
  }
}
