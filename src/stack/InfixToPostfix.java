package stack;

import java.util.Stack;

/**
 * Created by viagrawal on 3/31/18.
 */
public class InfixToPostfix
{

	public static void main(String[] args)
	{

		String infix ="a+b*(c^d-e)^(f+g*h)-i"; //"1+2*8/4-5+6*3/2"
		InfixToPostfix object = new InfixToPostfix();
		System.out.println(object.infixToPostfix(infix));
	}

	private String infixToPostfix(String str)
	{
		if (str == null || str.isEmpty())
			return str;

		char[] arr = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		Stack<Character> stack = new Stack();

		for (int i = 0; i < arr.length; i++)
		{
			char ch = arr[i];
			if (!isOperator(ch))
			{
				builder.append(ch);
				continue;
			}
			if (ch == '(')
			{
				stack.push(ch);
				continue;
			}
			if (ch == ')')
			{
				while (!stack.isEmpty() && stack.peek() != '(')
				{
					char popped = stack.pop();
					if (stack.peek() == null && popped != '(')
						throw new UnsupportedOperationException("Invalid input");
					if (popped!='(')
						builder.append(popped);
				}
				stack.pop();
			}
			else
			{
				while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
				{
					builder.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while (!stack.isEmpty())
			builder.append(stack.pop());
		return builder.toString();
	}

	private void evaluatePostfix()
	{

	}



	private boolean isOperator(final char c)
	{
		switch (c)
		{
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

	private int precedence(final char opr)
	{
		switch (opr)
		{
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
