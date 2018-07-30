/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 */
public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) return 0;
        int result = 0, signBit = -1;
        boolean hasNumBit = false;
        for (int i = 0; i < str.length(); ++i) {
            char cur = str.charAt(i);
            if (cur == ' ') {
                if (hasNumBit || signBit != -1) {
                    break;
                }
                continue;
            } else if (cur == '-'){
                if (signBit == -1 && !hasNumBit) {
                    signBit = 1;
                } else {
                    break;
                }
            } else if (cur == '+') {
                if (signBit == -1 && !hasNumBit) {
                    signBit = 0;
                } else {
                    break;
                }
            }  else if (cur >= '0' && cur <= '9') {
                hasNumBit = true;
                if (signBit == -1) {
                    signBit = 0;
                }
                int carry = cur - '0';
                if (result == 0 && carry == 0) continue;

                if (signBit == 0) {
                    if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && carry > 7)) return Integer.MAX_VALUE;
                } else if (signBit == 1) {
                    carry = 0 - carry;
                    if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && carry < -8)) return Integer.MIN_VALUE;
                }
                result = result * 10 + carry;
            } else {
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        StringToIntegerAtoi solution = new StringToIntegerAtoi();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi(" -42"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
    }
}
