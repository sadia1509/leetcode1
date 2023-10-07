package dataStructure.linear;

import java.util.*;

class Node {
    public int data;
    public Node next, prev;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class LinkedList {
    public Node makeLinkedList(int[] arr) {
        Node head = new Node(arr[0], null), temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i], null);
            temp.next = n;
            temp = n;
        }
        return head;
    }

    public Node makeDoublyLinkedList(int[] arr) {
        Node head = new Node(arr[0], null, null), temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i], null, null);
            temp.next = n;
            n.prev = temp;
            temp = n;
        }
        return head;
    }

    public Node makeCircularLinkedList(int[] arr) {
        Node head = new Node(arr[0], null), temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node n = new Node(arr[i], null);
            temp.next = n;
            temp = n;
        }
        temp.next = head;
        return head;
    }

    public void printLinkedList(Node head) {
        for (Node n = head; n != null; n = n.next) System.out.print(n.data + " ");
        System.out.println();
    }

    public void printLinkedListReversed(Node head) {
        Node m = head;
        while (m.next != null) m = m.next;
        for (Node n = m; n != head.prev; n = n.prev) System.out.print(n.data + " ");
    }

    public void printCircularLinkedList(Node head) {
        Node n = head;
        do {
            System.out.print(n.data + " ");
            n = n.next;
        } while (n != head);
    }

    public int getLength(Node head) {
        int length = 0;
        for (Node n = head; n != null; n = n.next) length++;
        return length;
    }

    public int getCircularLength(Node head) {
        int length = 0;
        Node n = head;
        do {
            n = n.next;
            length++;
        } while (n != head);
        return length;
    }

    public Node getIndexedValue(Node head, int k) {
        int i = 0;
        for (Node n = head; n != null && n.next != head; n = n.next, i++) {
            if (i == k) return n;
        }
        return null;
    }

    /* **************EASY************** */
    //Print the middle of a given linked list
    public void middlePrint(Node head) {
        int middleLength = getLength(head) / 2;
        Node temp = head;
        for (int i = 0; i < middleLength; i++) temp = temp.next;
        System.out.println(temp.data);
    }

    //Write a function that counts the number of times a given int occurs in a Linked List
    public void elemCount(Node head, int k) {
        int count = 0;
        for (Node n = head; n != null; n = n.next) if (n.data == k) count++;
        System.out.println(count);
    }

    //Check if a linked list is Circular Linked List
    public void circularLinkedListCheck(Node head) {
        Node m = head.next;
        while (m != head && m != null) m = m.next;
        if (m == head) System.out.println("Circular LinkedList");
        else System.out.println("Linear LinkedList");
    }

    //Count nodes in Circular linked list
    public void countCircularNodes(Node head) {
        System.out.println(getCircularLength(head));
    }

    //Convert singly linked list into circular linked list
    public void convertToCircular(Node head) {
        Node n = head;
        while (n.next != null) n = n.next;
        n.next = head;
        printCircularLinkedList(head);
    }

    //Exchange first and last nodes in Circular Linked List
    public void exchangeFirstLast(Node head) {
        Node n = head;
        while (n.next.next != head) n = n.next;
        n.next.next = head.next;
        head.next = n.next;
        n.next = head;
        head = head.next;
        printCircularLinkedList(head);
    }

    //Reverse a Doubly Linked List  5 4 3 2 1
    public void reverseDoublyLinkedList(Node head) {
//        printLinkedListReversed(head);
        Node n = head, temp = null;
        while (n != null) {
            temp = n.prev;
            n.prev = n.next;
            n.next = temp;
            n = n.prev;
        }
        if (temp != null) head = temp.prev;
        printLinkedList(head);
    }

    //Program to find size of Doubly Linked List
    public void sizeOfDoubly(Node head) {
        System.out.println(getLength(head));
    }

    //An interesting method to print reverse of a linked list TODO

    //Can we reverse a linked list in less than O(n)?
    /*
    ans - It is not possible to reverse a simple singly linked list in less than O(n).
    A simple singly linked list can only be reversed in O(n) time using recursive and iterative methods.
    */

    //Circular Linked List Traversal
    public void circularLinkedListTraversal(Node head) {
        printCircularLinkedList(head);
    }

    //Delete a node in a Doubly Linked List
    public void deleteNodeDoubly(Node head, Node del) {
        if (head.data == del.data) {
            head.prev = head.next;
            head = head.next;
        } else {
            Node n = head;
            while (n != null) {
                if (n.data == del.data) {
                    if (n.next != null) {
                        n.next.prev = n.prev;
                        n.prev.next = n.next;
                    } else n.prev.next = null;
                }
                n = n.next;
            }
        }
        printLinkedList(head);
        System.out.println();
        printLinkedListReversed(head);
    }


    //Prepare a cycle in a linked list
    public Node circleLinkedList() {
        Node n2 = new Node(2, null);
        Node n5 = new Node(5, n2);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        n2.next = n3;
        Node n1 = new Node(1, n2);
        return n1;
    }

    /* **************MEDIUM************** */
    //Detect loop in a linked list
    public void detectLoop(Node head) {
        Map<Node, Integer> trackermap = new HashMap<>();
        for (Node n = head; n.next != head && n.next != null; n = n.next) {
            if (trackermap.containsKey(n)) {
                System.out.println("There is a circle");
                break;
            }
            trackermap.put(n, n.data);
        }
    }

    //Find length of loop/cycle in given Linked List
    public void detectLoopLength(Node head) {
        Map<Node, Integer> trackermap = new LinkedHashMap<>();
        int counter = 0;
        Node prev = null;
        for (Node n = head; n.next != head && n.next != null; n = n.next) {
            if (trackermap.containsKey(n)) {
                System.out.println(trackermap.get(prev) - trackermap.get(n) + 1);
                break;
            }
            trackermap.put(n, ++counter);
            prev = n;
        }
//        trackermap.entrySet().stream().forEach(entry -> System.out.print(entry.getKey().data + ":" + entry.getValue() + " | "));
    }

    //Remove duplicates from a sorted linked list
    public void removeDuplicates(Node head) {
        printLinkedList(head);
        Node current = head, n = head;
        while (n.next != null) {
            if (current.data != n.next.data) {
                current = n.next;
                n = n.next;
                continue;
            }
            if (current.data == n.next.data) n.next = n.next.next;
            else n = n.next;
        }
        printLinkedList(head);
    }

    //Intersection of two Sorted Linked Lists
    public void intersectionTwoLinkedList(Node head1, Node head2) {
        Node n, m, head = null, tail = null;
        if (getLength(head1) < getLength(head1)) {
            n = head1;
            m = head2;
        } else {
            n = head2;
            m = head1;
        }
        while (n != null && m != null) {
            if (n.data == m.data) {
                if (head == null) {
                    head = new Node(n.data, null);
                    tail = head;
                } else {
                    Node k = new Node(n.data, null);
                    tail.next = k;
                    tail = tail.next;
                }
                n = n.next;
                m = m.next;
            } else if (n.data < m.data) n = n.next;
            else m = m.next;
        }
        if (head != null) printLinkedList(head);
        else System.out.println("No intersection found");
    }

    //QuickSort on Singly Linked List TODO
    //Split a Circular Linked List into two halves
    public void splitInHalves(Node head) {
        int length = getCircularLength(head);
        Node n = head, head1 = null, head2 = null, tail1 = null, tail2 = null;
        for (int i = 0; i < length; i++, n = n.next) {
            if (i >= length / 2) {
                if (head2 == null) {
                    head2 = new Node(n.data, null);
                    tail2 = head2;
                } else {
                    Node m = new Node(n.data, null);
                    tail2.next = m;
                    tail2 = tail2.next;
                }
                if (i == length - 1) tail2.next = head2;
            } else {
                if (head1 == null) {
                    head1 = new Node(n.data, null);
                    tail1 = head1;
                } else {
                    Node m = new Node(n.data, null);
                    tail1.next = m;
                    tail1 = tail1.next;
                }
                if (i == (length / 2) - 1) tail1.next = head1;
            }
        }
        printCircularLinkedList(head1);
        System.out.println();
        printCircularLinkedList(head2);
    }

    //Deletion from a Circular Linked List
    public void deletionCircular(Node head, int keyData) {
        Node n = head;
        if (head.data == keyData) {
            while (n.next != head) n = n.next;
            n.next = n.next.next;
            head = n.next;
        } else {
            while (n.next != head) {
                if (n.next.data == keyData) {
                    n.next = n.next.next;
                }
                n = n.next;
            }
        }
        printCircularLinkedList(head);
    }

    //Merge Sort for Doubly Linked List TODO
    //Find pairs with given sum in doubly linked list
    public void pairSum(Node head, int k) {
        for (Node n = head; n != null; n = n.next) {
            if (n.data > k || (n.next != null && n.data + n.next.data > k)) break;

            for (Node m = n.next; m != null; m = m.next)
                if (n.data + m.data == k) System.out.println("(" + m.data + ", " + n.data + ")");
        }
    }

    //Insert value in sorted way in a sorted doubly linked list
    public void insertInSortedDoubly(Node head, int k) {
        Node m = new Node(k, null);
        if (k < head.data) {
            m.next = head;
            head = m;
        } else {
            for (Node n = head; n != null; n = n.next) {
                if (n.data <= k && (n.next == null || n.next.data >= k)) {
                    m.next = n.next;
                    n.next = m;
                    break;
                }
            }
        }
        printLinkedList(head);
    }

    //Remove duplicates from an unsorted doubly linked list
    public void removeDuplicate(Node head) {
            List<Integer> list = new java.util.LinkedList<>();
            for (Node n = head; n != null; n = n.next) {
                if (list.contains(n.data)) deleteNode(head, n);
                else list.add(n.data);
            }
        printLinkedList(head);
    }
    Node deleteNode(Node head_ref, Node del)
    {
        if (head_ref == null || del == null) return head_ref;
        if (head_ref == del) head_ref = del.next;
        if (del.next != null) del.next.prev = del.prev;
        if (del.prev != null) del.prev.next = del.next;
        return head_ref;
    }

    //Rotate Doubly linked list by N nodes
    public void rotateLinkedList(Node head, int k){
        Node start = getIndexedValue(head, k);
        Node n = start;
        while(n.next!=null) n=n.next;
        n.next=head;
        head=start;
        n=head;
        while( n!=start.prev) n=n.next;
        n.next=null;
        printLinkedList(head);
    }

    //Modify contents of Linked List
    public void modifySingly(Node head){
        int len = getLength(head);
        Node n=head;
        for(int i=1; i<=len/2; i++, n=n.next)
            n.data = n.data - getIndexedValue(head, len-i).data;
        printLinkedList(head);
    }
}
