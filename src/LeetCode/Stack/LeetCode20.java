package LeetCode.Stack;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/
public class LeetCode20 {
    public boolean isVaild(String s) {
        Stack<Character> stack = new Stack<Character>();
        //对s进行遍历
        for (int i = 0; i < s.length(); i++) {
            //取出每一个字符，判断是否左括号
            //如果是右括号，判断栈中的元素是否一一对应
            //如果对应，则弹栈
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        //遍历结束后，判断是栈否为空，如果不为空，则不匹配
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
