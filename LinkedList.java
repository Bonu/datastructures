public class LinkedList {

    Node head; // head of list
    static class Node {

        int data;
        Node next;

        // Constructor
        Node(int d)
        {
            data = d;
            next = null;
        }

    }

    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);


        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        // Traverse through the LinkedList
        while (currNode != null) {
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }

    public static void printPendulum(Node head) {
        Node currentNode = head; // current node data = 1
        System.out.print("Pendulum of list :");
        while(currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = moveNext(currentNode);
            if(currentNode != null ) {
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }

        }
    }

    public static Node moveNext(Node head) {
        Node lastNode = null;
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            lastNode = currentNode;
        }
        Node afterDeleteHead = deleteLastNode(head);
        if(afterDeleteHead != null) {
            lastNode.next = afterDeleteHead.next;
            afterDeleteHead.next = lastNode;
            return afterDeleteHead.next;
        }else {
            return null;
        }


    }

    public static Node deleteLastNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // Driver code
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        printList(list);
        System.out.println();
        printPendulum(list.head);
    }
}



