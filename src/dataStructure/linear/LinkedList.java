package dataStructure.linear;

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


    /* **************MEDIUM************** */
    //Detect loop in a linked list

}
