package dataStructure.linear;

import java.util.List;
import java.util.Queue;
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


    //Prefix to Infix Conversion using Stack
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

    //Postfix to Prefix Conversion using Stack
    public void PostfixToPrefix(String expression) {
        System.out.println(expression);
        Stack<Object> stack = new Stack<>();
        List<Character> operators = List.of('+', '-', '/', '*', '^');
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (operators.contains(current)) {
                Object a = stack.pop();
                Object b = stack.pop();
                stack.add("" + current + b + a);
            } else stack.add(current);
        }
        System.out.println(stack.peek());
    }

    //Prefix to Postfix Conversion using Stack
    public void PrefixToPostfix(String expression) {
        System.out.println(expression);
        Stack<Object> stack = new Stack<>();
        List<Character> operators = List.of('+', '-', '/', '*', '^');
        for (int i = expression.length() - 1; i >= 0; i--) {
            char current = expression.charAt(i);
            if (operators.contains(current)) {
                Object a = stack.pop();
                Object b = stack.pop();
                stack.add("" + a + b + current);
            } else stack.add(current);
        }
        System.out.println(stack.peek());
    }

    //Check for balanced parentheses in an expression
    public boolean checkParenthesis(String expression) {
        System.out.print(expression + " ");
        Stack<Character> stack = new Stack<>();
        String parenthesis = "({[]})";
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (!parenthesis.contains(current + "")) continue;
            if (parenthesis.substring(0, 3).contains(current + ""))
                stack.add(current);
            else {
                if(stack.isEmpty()) return false;
                switch (current) {
                    case ')':
                        if (stack.pop() != '(') return false;
                        break;
                    case '}':
                        if (stack.pop() != '{') return false;
                        break;
                    case ']':
                        if (stack.pop() != '[') return false;
                        break;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        else return true;
    }

    //Reverse a stack using recursion
    public void reverseStack(Stack<Object> stack){
        if (!stack.isEmpty()) {
            Object temp = stack.pop();
            reverseStack(stack);
            System.out.print(temp + " ");
            storeTheReverseStack(stack, temp);
        }
    }
    void storeTheReverseStack(Stack<Object> stack, Object item){
        if(stack.isEmpty()) stack.add(item);
        else {
            Object top = stack.pop();
            storeTheReverseStack(stack, item);
            stack.push(top);
        }
    }

    //Reverse individual words
    public void reverseWords(List<String> words){
        Stack<Character> stack;
        for (int i=0; i<words.size(); i++){
            stack = new Stack<>();
            String word = words.get(i);
            for(int j=0; j<word.length(); j++) stack.add(word.charAt(j));
            word="";
            while (!stack.isEmpty()) word += stack.pop();
            words.set(i, word);
        }
        System.out.println(words);
    }

    //Reversing a Queue using stack
    public void reverseQueue(Queue<Integer> queue){
        System.out.println(queue);
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) stack.add(queue.remove());
        while (!stack.isEmpty()) queue.add(stack.pop());
        System.out.println(queue);
    }
}
