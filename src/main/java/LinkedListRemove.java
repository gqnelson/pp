/**
 * Given a linkedlist of integers and an integer value,
 * delete every node of the linkedlist containing that value.
 *
 * http://www.ardendertat.com/2011/09/29/programming-interview-questions-5-linkedlist-remove-nodes/
 */
public class LinkedListRemove {
    public static void main(String[] args) {
        Node head1 = new Node(1, null);
        printLinkedList(head1);
        printLinkedList(removeNode(5, head1));

        Node head2 = new Node(5, new Node(1, null));
        printLinkedList(head2);
        printLinkedList(removeNode(5, head2));

        Node head3 = new Node(1, new Node(5, new Node(1, null)));
        printLinkedList(head3);
        printLinkedList(removeNode(5, head3));

        Node head4 = new Node(5, new Node(1, new Node(2, new Node(5, new Node(7, null)))));
        printLinkedList(head4);
        printLinkedList(removeNode(5, head4));

    }

    private static Node removeNode(int value, Node head) {
        Node newHead = null;
        Node prevNode = null;
        while (head != null) {
            if (head.value == value){
                if (prevNode != null) {
                    prevNode.next = head.next;
                }
            } else {
                newHead = newHead != null ? newHead : head;
                prevNode = head;
            }
            head = head.next;
        }
        return newHead;
    }

    private static void printLinkedList(Node head) {
        while(head != null) {
            System.out.print(String.format("%d ", head.value));
            head = head.next;
        }
        System.out.println("");
    }

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
