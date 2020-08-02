package practise;

import java.util.LinkedList;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/08/01
 *     desc   : 自定义链表
 *     desc   : 自定义链表
 *     version: 1.0
 * </pre>
 */
//code format win+Alt+L
public class MyLinkedList {

    //头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表的实际长度
    private int size;


    //链表的插入
    public void insert(int data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }

        Node insertNode = new Node(data);

        //空链表
        if (size == 0) {
            head = insertNode;
            last = insertNode;
            //插入头部
        } else if (index == 0) {
            //1.把新节点的next指针指向原先的头节点
            //2.把新节点变为链表的头节点
            insertNode.next = head;
            head = insertNode;
            //插入尾部
        } else if (size == index) {
            last.next = insertNode;
            last = insertNode;

            //插入中间
        } else {
            //1.新节点的next指针，指向插入节点的位置
            //2.插入节点的前置节点指向当前的新节点
            Node preNode = get(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 链表的删除
     */
    public Node remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("error");
        }
        Node removeNode = null;
        //删除头节点
        if (index == 0) {
            removeNode = head;
            head = head.next;
            //删除尾部节点
        } else if (index == size - 1) {
            //把倒数第2个节点的next指针指向空即可
            Node preNode = get(index - 1);
            removeNode = preNode.next;
            preNode.next = null;
            //删除中间节点
        } else {
            Node preNode = get(index - 1);
            Node nextNode = preNode.next.next;
            removeNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        return removeNode;
    }

    /**
     * 查找链表元素
     *
     * @param index
     * @return
     */
    public Node get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("error");
        }
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }


    /**
     * 链表节点
     */
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insert(3, 0);
        myLinkedList.insert(7, 1);
        myLinkedList.insert(6, 2);
        myLinkedList.insert(7, 3);
        myLinkedList.insert(9, 1);
        myLinkedList.remove(0);
        myLinkedList.output();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.remove(0);
        linkedList.get(0);
    }
}
