import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

     '.' 匹配任意单个字符。
     '*' 匹配零个或多个前面的元素。
     匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

     说明:

     s 可能为空，且只包含从 a-z 的小写字母。
     p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
     示例 1:

     输入:
     s = "aa"
     p = "a"
     输出: false
     解释: "a" 无法匹配 "aa" 整个字符串。
     示例 2:

     输入:
     s = "aa"
     p = "a*"
     输出: true
     解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
     示例 3:

     输入:
     s = "ab"
     p = ".*"
     输出: true
     解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
     示例 4:

     输入:
     s = "aab"
     p = "c*a*b"
     输出: true
     解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
     示例 5:

     输入:
     s = "mississippi"
     p = "mis*is*p*."
     输出: false
 */
public class RegularExpressionMatching {

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isDot(char c) {
        return c == '.';
    }

    private boolean isAsterisk(char c) {
        return c == '*';
    }

    public boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty()) return p == null || p.isEmpty();
        if (p == null || p.isEmpty()) return s == null || s.isEmpty();
        return false;
    }
    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println(solution.isMatch("", ""));
    }
}
