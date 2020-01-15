import util.ListNode;
import static util.ListNode.*;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

 示例 :

 给定这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

 */
public class ReverseNodesInKGroup {

    public void reverseRange(ListNode[] nodes) {
        nodes[0].next = null;
        for (int i = 1; i < nodes.length; ++i) {
            nodes[i].next = nodes[i-1];
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) return head;
        ListNode[] knodes = new ListNode[k];
        ListNode pre = head, cur = null, result = head;
        while (true) {
            ListNode kpre, kcur;
            ListNode beforeKPre = cur, afterKCur;

            if (cur == null) {
                kpre = pre;
            } else {
                kpre = cur.next;
            }

            kcur = kpre;
            knodes[0] = kcur;
            for(int i = 0; i < k - 1 && kcur != null; ++i) {
                kcur = kcur.next;
                knodes[i + 1] = kcur;
            }

            if (kcur == null) {
                break;
            }

            afterKCur = kcur.next;
            reverseRange(knodes);
            if (beforeKPre == null) {
                result = knodes[k - 1];
            } else {
                beforeKPre.next = knodes[k - 1];
            }
            knodes[0].next = afterKCur;

            pre = knodes[k - 1];
            cur = knodes[0];
        }
        return result;
    }


    public void test(){
        printNode(reverseKGroup(creatNode(new int[]{1,2,3,4,5}), 1));
        printNode(reverseKGroup(creatNode(new int[]{1,2,3,4,5}), 2));
        printNode(reverseKGroup(creatNode(new int[]{1,2,3,4,5}), 3));
        printNode(reverseKGroup(creatNode(new int[]{1,2,3,4,5}), 4));
        printNode(reverseKGroup(creatNode(new int[]{1,2,3,4,5}), 5));
    }
    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        solution.test();
    }
}
