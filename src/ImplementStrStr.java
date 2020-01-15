/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 实现 strStr() 函数。
 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 如果不存在，则返回  -1。
 kmp 算法
 */
public class ImplementStrStr {

    public int[] getKmpNext(String pattern) {
        int j = 0, k = -1;
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for (;j < pattern.length() - 1;) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return 0;
        if (haystack == null || haystack.isEmpty()) return -1;
        int[] next = getKmpNext(needle);
        int hptr = 0, nptr = 0;
        while(hptr < haystack.length() && nptr < needle.length()) {
            if (nptr == -1 || haystack.charAt(hptr) == needle.charAt(nptr)) {
                ++hptr;
                ++nptr;
            } else {
                nptr = next[nptr];
            }
        }
        if (nptr == needle.length()) {
            return hptr - nptr;
        }
        return -1;
    }

    public void test(){
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "ba"));

    }
    public static void main(String[] args) {
        ImplementStrStr solution = new ImplementStrStr();
        solution.test();
    }
}
