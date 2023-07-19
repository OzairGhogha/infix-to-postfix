//

import java.util.Scanner;

public class Converter
{ 
String postfixExpression;

//main method loop
public static void main(String[] args) 
{
	for (;;)
	{
		
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter Infix Expression: ");
    String userExpression = scanner.nextLine();
    if (userExpression.length()<20)
    	{
    	System.out.println("Postfix Expression: " + infixToPostfix(userExpression) +  "\n");
    	}
    else 
    	{
    	System.out.println("Infix expression cannot be greater than 20 characters in length!" + "\n");
    	}
	}
}

static int checkPrecedence(char ch)
{
	//returns a value based on the operator
        switch (ch)
        {
            case '-':
            case '+':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
}

static String infixToPostfix(String expression)
    {
        String outputExpression = "";
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int j = 0; j <expression.length() ; j++)
        {
            char ch = expression.charAt(j);

            //if character is an operator
            if(checkPrecedence(ch)>0)
            {
            	//operators precedence is <= the precedence of the top of the stack
                while(stack.isEmpty()==false && checkPrecedence(stack.peek())>=checkPrecedence(ch)){
                    outputExpression += stack.pop();
                }
                stack.push(ch);
            }
            //character is a ')'
            else if(ch==')')
            {
                char x = stack.pop();
                while(x!='(')
                {
                    outputExpression += x;
                    x = stack.pop();
                }
            }
            //character is a '('
            else if(ch=='(')
            {
                stack.push(ch);
            }
            else if(Character.isLetter(ch))
            {
                //character is neither operator nor '(' 
                outputExpression += ch;
            }
            //character is not part of valid input rules
            else
            {
            	return("Invalid character input or format, Input should only contain 'a-z' or '(' or ')' or '*' or '/' or '+' or '-'. Please remove any whitespace.");
            }
        }
        for (int j = 0; j <=stack.getSize() ; j++) 
        {
            outputExpression += stack.pop();
        }
        return outputExpression;
    }
}