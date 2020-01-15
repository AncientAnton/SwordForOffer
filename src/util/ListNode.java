package util;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 链表节点类以及方法
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static void printNode(ListNode head) {
        if (head == null) return;
        System.out.print(head.val);
        ListNode tmp = head.next;
        while (tmp != null) {
            System.out.print("->");
            System.out.print(tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode creatNode(int[] vals) {
        if (vals == null || vals.length == 0) return null;
        ListNode head = new ListNode(vals[0]), cur = head;
        for (int i = 1; i < vals.length; ++i) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }
}
