package com.blank.linkedlist;

public class ListNode {
    /**
     * 数据源
     */
    private int val;
    /**
     * 指针域
     */
    private ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public int getData() {
        return val;
    }

    public void setData(int data) {
        this.val = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 翻转链表
     * @param head ListNode
     * @return ListNode
     */
    public ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode current = head;
        ListNode preparevNode = null;
        while (current != null) {
            ListNode nextNode = current.next;
            if (nextNode == null){
                newHead = current;
                break;
            }
            current.next = preparevNode;
            preparevNode = current;
            current = nextNode;
        }
        return newHead;
    }

    /**
     * 输出该链表中倒数第k个结点
     * @param head ListNode
     * @param k int
     * @return ListNode
     */
    public ListNode findTailNode(ListNode head, int k) {
        //获取总链表长度
        int size = length(head);
        for (int i = 0; i <= size - k ; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 获取链表长度
     * @param head ListNode
     * @return int
     */
    public int length(ListNode head) {
        int size = 0;
        ListNode current = head;
        //获取总链表长度
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * 两数相加
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1 ListNode
     * @param l2 ListNode
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0){
            if (l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            head.next = new ListNode(carry % 10);
            carry = carry / 10;
            head = head.next;
        }
        return  result.next;
    }

    /**
     * 添加节点
     * @param head ListNode
     * @param node ListNode
     * @return ListNode
     */
    public ListNode addNode(ListNode head, ListNode node) {
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
        return current;
    }

    /**
     * 添加节点
     * @param head ListNode
     * @param node ListNode
     */
    public void addNodeByIndex(ListNode head, ListNode node, int index) {
        int size = length(head);
        if (index < 1 || index > size+1){
            System.out.println("插入位置不合法："+index);
            return;
        }
        ListNode current = head;
        int i = 0;
        while (current.next != null){
            if (index == i++){
                node.next = current.next;
                current.next = node;
                break;
            }
            current = current.next;
        }
    }

    /**
     * 删除指定位置上的结点
     * @param head ListNode
     * @param index int
     */
    public void deleteNodeByIndex(ListNode head, int index) {
        int size = length(head);
        if (index < 1 || index > size+1){
            System.out.println("插入位置不合法："+index);
            return;
        }
        ListNode current = head;
        int i = 0;
        while (current.next != null){
            if (index == i++){
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    /**
     * 选择排序
     * @param head ListNode
     */
    public ListNode selectSortNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        while (head.next != null) {
            ListNode secondNode = head.next;
            while (secondNode.next != null) {
                if (head.val > secondNode.val){
                    int temp = secondNode.val;
                    secondNode.val = head.val;
                    head.val = temp;
                }
                secondNode = secondNode.next;
            }
            head = head.next;
        }
        return head;
    }

    /**
     * 4 2 3 1
     * 插入排序
     * @param head ListNode
     * @return ListNode
     */
    public ListNode insertSortNode(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode helper = new ListNode(0);
        ListNode pre = helper;//pre=0|null
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            while(pre.next!=null && pre.next.val<cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {

    }
    

}
