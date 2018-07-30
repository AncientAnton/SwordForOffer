import java.util.HashMap;

/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。
 * 请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();

        int i, head = 0, tail = 1, maxLength = 1;
        int[] indexMap = new int[Character.MAX_VALUE + 1];
        for (i = 0; i < indexMap.length; ++i) {
            indexMap[i] = -1;
        }
        indexMap[s.charAt(head)] = head;
        while(tail < s.length() && s.length() - head >= maxLength) {
            if (indexMap[s.charAt(tail)] != -1) {
                head = Math.max(indexMap[s.charAt(tail)] + 1, head);
            }
            indexMap[s.charAt(tail)] = tail;
            ++tail;
            maxLength = Math.max(tail - head, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("loddktdji"));
        System.out.println(lengthOfLongestSubstring("bbbbbe"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
