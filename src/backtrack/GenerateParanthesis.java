package backtrack;

import java.util.*;

public class GenerateParanthesis {

  public static void main(String[] args) {
      GenerateParanthesis obj = new GenerateParanthesis();
      List<String> list = obj.generateParenthesis(3);

    list.forEach(
        str -> {
          System.out.println(str);
        });
  }

    Set<String> permutes = new HashSet<>();
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList();

        if(n <=0)
            return list;

        List<String> paran = Arrays.asList("()","(())","((()))", "(((())))", "((((()))))",
                "(((((())))))", "((((((()))))))", "(((((((())))))))");

        String str = paran.get(n-1);


        permute(str,0, str.length()-1);

        permutes.forEach(val->{
            if(isValid(val))
                list.add(val);
        });

        return list;
    }

    private boolean isValid(String str)
    {
        if(str==null)
            return false;

        Stack<Character> stack = new Stack();
        for(int i=0; i<str.length(); i++)
        {
            char first= str.charAt(i);
            if(first =='(')
                stack.push(first);
            else if(first ==')')
            {
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }

        if(!stack.isEmpty())
            return false;

        return true;

    }


    private void permute(String str, int l, int r)
    {
        if (l == r)
            permutes.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String str, int i, int j)
    {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
