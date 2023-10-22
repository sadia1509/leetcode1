package dataStructure.linear;

import java.util.List;
import java.util.Stack;

public class StackClass {
    //Infix to Postfix Conversion using Stack
    public void infixToPostfix(String expression) {
        System.out.println(expression);
        Stack<Character> stack = new Stack<>();
        char current, peek = ' ';
        List<Character> temp;
        for (int i = 0; i < expression.length(); i++) {
            current = expression.charAt(i);
            if (!stack.isEmpty()) peek = stack.peek();
            switch (current) {
                case '+', '-':
                    temp = List.of('/', '*', '-', '+', '^');
                    if (temp.contains(peek)) resolveStack(stack, current, temp);
                    stack.add(current);
                    break;
                case '*', '/':
                    temp = List.of('/', '*', '^');
                    if (temp.contains(peek)) resolveStack(stack, current, temp);
                    stack.add(current);
                    break;
                case '(', '{', '[', '^':
                    stack.add(current);
                    break;
                case ')':
                    resolveStackForParenthesis(stack, '(');
                    break;
                case '}':
                    resolveStackForParenthesis(stack, '{');
                    break;
                case ']':
                    resolveStackForParenthesis(stack, '[');
                    break;
                default:
                    System.out.print(current);
                    break;
            }
        }
        while (!stack.isEmpty()) System.out.print(stack.pop());
    }

    void resolveStack(Stack<Character> stack, char current, List<Character> lists) {
        while (!stack.isEmpty() && lists.contains(current))
            System.out.print(stack.pop());
    }

    void resolveStackForParenthesis(Stack<Character> stack, char expected) {
        char actual;
        while (!stack.isEmpty()) {
            actual = stack.pop();
            if (actual == expected) break;
            System.out.print(actual);
        }
    }


    //Infix to Prefix Conversion using Stack
    public void infixToPrefix(String expression) {
        System.out.println(expression);
        Stack<Character> stack = new Stack<>(), reverseStack = new Stack<>();
        char current, peek = ' ';
        List<Character> temp;
        for (int i = expression.length() - 1; i >= 0; i--) {
            current = expression.charAt(i);
            if (!stack.isEmpty()) peek = stack.peek();
            switch (current) {
                case '+', '-':
                    temp = List.of('/', '*', '^');
                    if (temp.contains(peek)) resolveStackPre(stack, peek, temp, reverseStack);
                    stack.add(current);
                    break;
                case '/', '*':
                    temp = List.of('^');
                    if (temp.contains(peek)) resolveStackPre(stack, peek, temp, reverseStack);
                    stack.add(current);
                    break;
                case ')', '}', ']', '^':
                    stack.add(current);
                    break;
                case '(':
                    resolveStackForParenthesis(stack, ')', reverseStack);
                    break;
                case '{':
                    resolveStackForParenthesis(stack, '}', reverseStack);
                    break;
                case '[':
                    resolveStackForParenthesis(stack, ']', reverseStack);
                    break;
                default:
                    reverseStack.add(current);
                    break;
            }
        }
        while (!stack.isEmpty()) reverseStack.add(stack.pop());
        while (!reverseStack.isEmpty()) System.out.print(reverseStack.pop());

    }

    void resolveStackPre(Stack<Character> stack, char peek, List<Character> lists, Stack<Character> reverseStack) {
        while (!stack.isEmpty() && lists.contains(peek)) {
            if (!lists.contains(stack.peek())) break;
            peek = stack.pop();
            reverseStack.add(peek);
        }
    }

    void resolveStackForParenthesis(Stack<Character> stack, char expected, Stack<Character> reverseStack) {
        char actual;
        while (!stack.isEmpty()) {
            actual = stack.pop();
            if (actual == expected) break;
            reverseStack.add(actual);
        }
    }

    //Postfix to Infix Conversion using Stack
    public void PostfixToInfix(String expression) {
        System.out.println(expression);
        Stack<Object> stack = new Stack<>();
        List<Character> operators = List.of('+', '-', '/', '*', '^');
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (operators.contains(current)) {
                Object a = stack.pop();
                Object b = stack.pop();
                stack.add("(" + b + current + a + ")");
            } else stack.add(current);
        }
        System.out.println(stack.peek());
    }


    //Postfix to Infix Conversion using Stack
    public void PrefixToInfix(String expression) {
        System.out.println(expression);
        Stack<Object> stack = new Stack<>();
        List<Character> operators = List.of('+', '-', '/', '*', '^');
        for (int i = expression.length() - 1; i >= 0; i--) {
            char current = expression.charAt(i);
            if (operators.contains(current)) {
                Object a = stack.pop();
                Object b = stack.pop();
                stack.add("(" + a + current + b + ")");
            } else stack.add(current);
        }
        System.out.println(stack.peek());
    }
}
