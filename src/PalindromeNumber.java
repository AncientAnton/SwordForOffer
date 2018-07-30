/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
     判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

     示例 1:

     输入: 121
     输出: true
     示例 2:

     输入: -121
     输出: false
     解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     示例 3:

     输入: 10
     输出: false
     解释: 从右向左读, 为 01 。因此它不是一个回文数。
     进阶:

     你能不将整数转为字符串来解决这个问题吗？
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
        int cutResult = 0;
        while (x != 0 && x > cutResult) {
            if (cutResult != 0 && cutResult == x / 10) {
                return true;
            }
            cutResult *= 10;
            cutResult += x % 10;
            x /= 10;
        }
        return cutResult !=0 && x == cutResult;
    }

    public boolean _isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i != j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(10));
        System.out.println(solution.isPalindrome(100001));
    }
}
