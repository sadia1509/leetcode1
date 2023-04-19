package easy;

import java.util.Stack;

public class ValidParenthesis {
    Stack<Character> parenthesis = new Stack<>();
    boolean check(char ending, char starting) {
        if (starting == '(' && ending == ')') return true;
        else if (starting == '{' && ending == '}') return true;
        else if (starting == '[' && ending == ']') return true;
        else return false;
    }

    boolean traverseTheString(String s, int index){
        if (index < s.length()){
            char temp = s.charAt(index);
            switch (temp) {
                case '[', '{', '(':
                    parenthesis.push(temp);
                    return traverseTheString(s, ++index);
                case ']', '}', ')':
                    if (!parenthesis.isEmpty()) {
                        if (!check(temp, parenthesis.pop())) return false;
                    } else return false;
                    return traverseTheString(s, ++index);
                default:
                    return false;
            }
        } return true;

    }

    public boolean isValid(String s) {
        if (s.length() < 1) return true;
        if ( traverseTheString(s,0) && parenthesis.empty() ) return true;
        else return false;
    }
}
