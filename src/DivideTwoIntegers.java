/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。
 * 将两数相除，要求不使用乘法、除法和 mod 运算符。

     返回被除数 dividend 除以除数 divisor 得到的商。

     示例 1:

     输入: dividend = 10, divisor = 3
     输出: 3
     示例 2:

     输入: dividend = 7, divisor = -3
     输出: -2

     被除数和除数均为 32 位有符号整数。
     除数不为 0。
     假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
     本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long dend = Math.abs((long)dividend), div = Math.abs((long)divisor), res = 0;
        while (dend >= div) {
            long z = div, count = 1;
            while( z << 1 < dend) {
                z <<= 1;
                count <<= 1;
            }
            res += count;
            dend -= z;
        }
        int ne = (dividend >>> 31) ^ (divisor >>> 31);
        if (ne != 0) return (int)-res;
        return (int)Math.min(Math.max(res, Integer.MIN_VALUE), Integer.MAX_VALUE);
    }

    public void test(){
        System.out.println(divide(-1, -1));
        System.out.println(divide(10, -3));
        System.out.println(divide(7, 3));
    }
    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        solution.test();
    }
}
