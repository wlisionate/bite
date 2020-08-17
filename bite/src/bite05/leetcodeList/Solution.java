package bite05.leetcodeList;

import bite05.list.Node;

import java.util.List;

/**
 * ⊙﹏⊙&&&&&&⊙▽⊙
 *
 * @Auther: pangchenbo
 * @Date: 2020/1/8 17:44
 * @Description:
 */
public class Solution {
    //移除链表中的元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                //判断头结点直接删除的情况
                if (head.val == val) {
                    head = head.next;
                } else {
                    //相等的时候，prev结点不动
                    prev.next = cur.next;
                }
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode removeElements1(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                //相等的时候，prev结点不动
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        //除了头结点之外的结点都删除了，现在进行头结点符合情况进行删除
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode last = null;
        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != val) {
                if (newHead == null) {
                    newHead = cur;
                } else {
                    last.next = cur;
                }
                last = cur;
            }
            cur = cur.next;
        }
        if (last != null) {
            last.next = null;
        }
        return newHead;
    }

    //206 反转单链表,重点中的重点。。
    //看到两小时那里
    public ListNode reverseList(ListNode head) {
        ListNode nHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = nHead;
            nHead = cur;
            cur = next;
        }
        return head;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = null;
        ListNode p2 = head;
        ListNode p3 = head.next;
        while (p2 != null) {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            if (p3 != null) {
                p3 = p3.next;
            }
        }
        return p1;
    }

    //leetcode21 合并有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        ListNode nHead = null;
        ListNode nLast = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                if (nHead == null) {
                    nHead = cur1;
                } else {
                    nLast.next = cur1;
                }
                nLast = cur1;
                cur1 = cur1.next;
            } else {
                if (nHead == null) {
                    nHead = cur2;
                } else {
                    nLast.next = cur2;
                }
                nLast = cur2;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            nLast.next = cur1;
            nLast = cur1;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            nLast.next = cur2;
            nLast = cur2;
            cur2 = cur2.next;
        }
        return nHead;
    }

    //    编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
//    给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode sHead = null;
        ListNode sLast = null;
        ListNode bHead = null;
        ListNode bLast = null;
        while (cur != null) {
            if (cur.val < x) {
                if (sHead == null) {
                    sHead = cur;
                } else {
                    sLast.next = cur;
                }
                sLast = cur;
                cur = cur.next;
            } else {
                if (bHead == null) {
                    bHead = cur;
                } else {
                    bLast.next = cur;
                }
                bLast = cur;
                cur = cur.next;
            }
        }
        //如果小链表为空，返回大连表的头结点
        if (sLast == null) {
            return bHead;
        }
        //如果大链表为空，返回小链表的头结点
        if (bHead == null) {
            return sHead;
        }
        sLast.next = bHead;
        bLast.next = null;
        return sHead;
    }

    //求链表的中间结点，如果有两个结点则返回第二个结点
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int mid = length / 2;
        cur = head;
        length = 0;
        while (cur != null) {
            if (length == mid) {
                break;
            } else {
                length++;
                cur = cur.next;
            }
        }
        head = cur;
        return head;
    }

    //本方法求中间结点，利用快慢指针的概念，当一个指针每次移动两步，另一个指针每次移动一步，
    //在第一个指针遍历到空的时候，第二个指针就在最中间的地方
    public ListNode middleNode1(ListNode head) {
        //ListNode cur = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //求链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        cur = head;
        int len = length - k;
        length = 0;
        if (len < 0) {
            return null;
        }
        while (cur != null) {
            if (length == len) {
                break;
            }
            length++;
            cur = cur.next;
        }
        return cur;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode forword = head;
        ListNode backword = head;
        for (int i = 0; i < k; i++) {
            //中途出现空的情况
            if (forword == null) {
                return null;
            }
            forword = forword.next;
        }
        while (forword != null) {
            forword = forword.next;
            backword = backword.next;
        }
        return backword;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode prev = new ListNode(1);
        prev.next = pHead;
        ListNode fake = prev;
        ListNode cur = pHead;
        ListNode next = pHead.next;
        while (next != null) {
            if (cur.val != next.val) {
                prev = prev.next;
                cur = cur.next;
                next = next.next;
            } else {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                prev.next = next;
                cur = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }
        return fake.next;
    }

    //判断链表回文
    //反转链表+求中间结点
    public int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public ListNode getMiddle(ListNode head) {
        int length = getLength(head);
        int mid = length / 2;
        ListNode cur = head;
        while (cur != null) {
            for (int i = 0; i < mid; i++) {
                cur = cur.next;
            }
            break;
        }
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode nHead = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = nHead;
            nHead = cur;

            cur = next;
        }
        return nHead;
    }

    public boolean chkPalindrome(ListNode A) {
        ListNode middle = getMiddle(A);
        ListNode rHead = reverseList2(A);

        ListNode c1 = A;
        ListNode c2 = rHead;

        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) {
                return false;
            }
            c1.next = c1;
            c2.next = c2;
        }
        return true;
    }

    //力扣第160题
    //求相交链表
    public int getLength160(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALength = getLength160(headA);
        int BLength = getLength160(headB);
        ListNode longger = headA;
        ListNode shorter = headB;
        if (ALength < BLength) {
            longger = headB;
            shorter = headA;
        }
        int diff = getLength160(longger) - getLength160(shorter);
        for (int i = 0; i < diff; i++) {
            longger = longger.next;
        }
        //这道题需要注意的点在于，交叉点是引用指向同一个结点
        if (longger != shorter) {
            longger = longger.next;
            shorter = shorter.next;
        }
        return shorter;
    }

    //判断链表有环
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        ListNode step1 = head.next;
        ListNode step2 = head.next;
        while (step1 != null && step2 != null){
            step2 = step2.next;
            if(step2 == null){
                return false;
            }
            if(step1 == step2){
                return true;
            }
            step1 = step1.next;
            step2 = step2.next;
        }
        return false;
    }
    //判断链表有环，并且返回链表进入环的第一个结点
    //L= M+NR（推导公式）
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            fast = fast.next;
            if (fast  == null){
                return null;
            }
            fast = fast.next;
            if(fast == null){
                return null;
            }
            slow = slow.next;
        }while (slow != fast);
        ListNode c1 = head;
        ListNode c2 = fast;
        while (c1 != c2){
            c1 = c1.next;
            c2 = c2.next;
        }
        return c1;
    }
    //普通链表进行复制
    public static ListNode copy(ListNode head){
        ListNode cur = head;
        ListNode head1 = null;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            if(head1 == null){
                head1 = node;
            }else {
                ListNode cur1 = head1;
                while (cur1.next != null) {
                    cur1 = cur1.next;
                }
                cur1.next = node;
            }
            cur = cur.next;
        }
        return head1;
    }
    //进行链表复制方法二：
    public static ListNode copy1(ListNode head){
        ListNode nHead = null;
        ListNode nLast = null;
        ListNode cur = head;
        while (cur != null){
            ListNode node = new ListNode(cur.val);
            if(nHead == null){
                nHead = node;
            }else {
                nLast.next = node;
            }
            nLast = node;
            cur = cur.next;
        }
        return nHead;
    }
    //力扣138 复制带随机指针的链表
//    public static ListNode copyRandomList(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        ListNode cur = head;
//        while (cur != null){
//            ListNode node = new ListNode(cur.val);
//            node.next = cur.next;
//            cur.next = node;
//            cur = cur.next.next;
//        }
//        cur = head;
//        while (cur != null){
//            if(cur.random == null) {
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//        cur = head;
//        ListNode nHead = head.next;
//        while (cur != null){
//            ListNode node = cur.next;
//            cur.next = node.next;
//            if(node.next != null) {
//                node.next = cur.next.next;
//            }
//            cur = cur.next;
//        }
//        return nHead;
//    }
    public static void printF(ListNode head){
        ListNode listNode = head;
        while (listNode != null){
            System.out.println(String.format("{node%s}",listNode.val));
            listNode = listNode.next;
        }
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode nHead = copy(n1);
        printF(nHead);
        ListNode nHead1 = copy1(n1);
        printF(nHead1);
    }
}