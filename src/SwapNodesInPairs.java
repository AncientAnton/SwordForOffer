import util.ListNode;
import static util.ListNode.*;
/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     给定 1->2->3->4, 你应该返回 2->1->4->3.
     说明:

     你的算法只能使用常数的额外空间。
     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur, beforePre = null, afterCur, result;
        result = pre.next;
        while(pre != null && pre.next != null) {
            cur = pre.next;
            afterCur = cur.next;
            cur.next = pre;
            pre.next = afterCur;
            if (beforePre != null) {
                beforePre.next = cur;
            }
            beforePre = pre;
            pre = pre.next;
        }
        return result;
    }

    public void test(){
        int n = 10000;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = i + 1;
        printNode(swapPairs(creatNode(nums)));

    }
    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        solution.test();
    }
}
