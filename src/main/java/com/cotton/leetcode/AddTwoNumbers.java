package com.cotton.leetcode;

/**
 * @author wuke
 * @date 2019-06-08 22:16
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * [3,9,9,9,9,9,9,9,9,9]
 * [7]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode currentNode = one;
        for (int i = 0; i < 9; i++) {
            ListNode two = new ListNode(9);
            currentNode.next = two;
            currentNode = two;
        }


        printListNode(one);

        ListNode four = new ListNode(7);

        printListNode(four);

        ListNode listNode = addTwoNumbers(one, four);
        System.out.println("===");
        printListNode(listNode);


    }

    /**
     * 打印ListNode，方便观察链路上的值
     *
     * @param listNode 打印参数
     */
    private static void printListNode(ListNode listNode) {
        ListNode nextListNode = listNode;
        while (null != nextListNode) {
            System.out.println(nextListNode.val);
            nextListNode = nextListNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l1NextListNode = l1;
        ListNode l2NextListNode = l2;
        ListNode result = null;
        ListNode currentListNode = null;
        boolean addOne = false;
        ListNode newListNode;
        while (null != l1NextListNode || null != l2NextListNode) {

            int addNum = (null == l1NextListNode ? 0 : l1NextListNode.val) +
                    (null == l2NextListNode ? 0 : l2NextListNode.val) +
                    (addOne ? 1 : 0);


            newListNode = new ListNode(addNum % 10);

            if (null == currentListNode) {
                result = currentListNode = newListNode;
            } else {
                currentListNode.next = newListNode;
                currentListNode = newListNode;
            }

            addOne = addNum >= 10;
            if (null != l1NextListNode) {
                l1NextListNode = l1NextListNode.next;
            }
            if (null != l2NextListNode) {
                l2NextListNode = l2NextListNode.next;
            }
        }
        if (addOne) {
            newListNode = new ListNode(1);
            currentListNode.next = newListNode;
        }


        return result;

    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
