import java.util.BitSet;

/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 动态规划，存储前面的状态变量，使用BitSet存储
 * 空间优化：从中心位置展开，考虑偶数的情况，只需要存储最大长度，O(1)的空间复杂度
 * 时间优化：Manacher算法 O(n)时间
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int adder, first, last, lBit, rBit, len = s.length(), start = 0, end = 0;
        BitSet checkMap = new BitSet(len * len * 2);
        for (adder = 0; adder < len; ++adder) {
            for (first = 0; first < len - adder; ++first) {
                last = first + adder;

                lBit = (first * len + last) * 2;
                rBit = (last * len + first) * 2;

                boolean lBitOne = checkMap.get(lBit);
                boolean lBitTwo = checkMap.get(lBit + 1);

                if (!lBitOne && !lBitTwo) {
                    if (s.charAt(first) != s.charAt(last)) {
                        checkMap.set(lBit + 1);
                        checkMap.set(rBit + 1);
                    } else {
                        if (last < first + 2) {
                            checkMap.set(lBit, lBit + 2);
                            checkMap.set(rBit, rBit + 2);
                            if (end - start < last - first) {
                                start = first;
                                end = last;
                            }
                        } else {
                            int lInnerBit = ((first + 1) * len + last - 1) * 2;
                            if (!checkMap.get(lInnerBit)) {
                                checkMap.set(lBit + 1);
                                checkMap.set(rBit + 1);
                            } else {
                                checkMap.set(lBit, lBit + 2);
                                checkMap.set(rBit, rBit + 2);
                                if (end - start < last - first) {
                                    start = first;
                                    end = last;
                                }
                            }
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ab"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindrome("bba"));
        System.out.println(longestPalindrome("bab"));
        System.out.println(longestPalindrome("abc"));
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("babab"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
