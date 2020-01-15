import util.ListNode;
import static util.ListNode.*;
/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，
 * 并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。
 *
 */

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1 || head == null) return head;
        ListNode left = head, right = head, before = null;

        for (int i = 0; i < n - 1; ++i) {
            right = right.next;
        }

        while (right.next != null) {
            before = left;
            left = left.next;
            right = right.next;
        }

        if (before != null) {
            before.next = left.next;
        } else {
            before = head;
            head = head.next;
            before.next = null;
        }

        return head;
    }

    public void test() {
        ListNode head = creatNode(new int[]{1,2});
        printNode(head);
        printNode(removeNthFromEnd(head, 2));
    }
    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList();
        solution.test();
    }
}
