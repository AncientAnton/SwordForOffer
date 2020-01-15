import java.util.LinkedList;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        LinkedList<Integer> stack = new LinkedList<>();
        Integer head;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    stack.push(1);
                    break;
                case '{':
                    stack.push(2);
                    break;
                case '[':
                    stack.push(3);
                    break;
                case ')':
                    head = stack.poll();
                    if (head == null || head != 1) {
                        return false;
                    }
                    break;
                case '}':
                    head = stack.poll();
                    if (head == null || head != 2) {
                        return false;
                    }
                    break;
                case ']':
                    head = stack.poll();
                    if (head == null || head != 3) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }
    public void test(){
        System.out.println(isValid(null));
        System.out.println(isValid(""));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        solution.test();
    }
}
