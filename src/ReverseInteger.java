/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:

     给定一个 32 位有符号整数，将整数中的数字进行反转。

     示例 1:

     输入: 123
     输出: 321
     示例 2:

     输入: -123
     输出: -321
     示例 3:

     输入: 120
     输出: 21
     注意:

     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
     根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 */
public class ReverseInteger {
    public int reverse(int x) {
        StringBuilder builder = new StringBuilder(String.valueOf(Math.abs(x)));
        builder.reverse();
        if (x < 0) builder.insert(0, "-");
        int result = 0;
        try {
            result = Integer.valueOf(builder.toString());
        } catch (Exception e) {
        }
        return result;
    }
    public int _reverse(int x) {
        int result = 0;
        while (x != 0) {
            int carry = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && carry > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && carry < -8)) return 0;
            result = result * 10 + carry;
        }
        return result;
    }
    public static void main(String[] args) {
        ReverseInteger soulution = new ReverseInteger();
        System.out.println(soulution._reverse(30));
        System.out.println(soulution._reverse(-490));
    }
}
