import java.util.Map;

/**
 * Author: AncientAnton
 * Date: 2018/8/3.
 * Description:
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char c, LEFT = '(', RIGHT = ')';
        int begin = 0, current = 0, result = 0, len = s.length();
        while(begin + 2*result < len) {
            c = s.charAt(current);
            if (c == LEFT) {
            } else if (c == RIGHT) {
            }
        }
        return result;
    }
    public void test(){
        System.out.println(longestValidParentheses(""));
    }
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        solution.test();
    }
}
