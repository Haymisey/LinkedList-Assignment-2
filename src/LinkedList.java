public class LinkedList {
    private Node head;

    // Inner Node class
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public void insertAtPos(int value, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position must be positive.");
            return;
        }

        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position exceeds list size.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or empty list.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position exceeds list size.");
            return;
        }

        current.next = current.next.next;
    }
    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null || prevNode.next == null) {
            System.out.println("Invalid previous node.");
            return;
        }

        prevNode.next = prevNode.next.next;
    }
    public boolean searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void displayList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null"); // Mark the end of the list
    }

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();

        // Insert nodes
        myList.insertAtPos(10, 1);
        myList.insertAtPos(20, 2);
        myList.insertAtPos(30, 3);

        // Display the list
        System.out.println("Linked List after insertions:");
        myList.displayList();

        // Delete node at position 2
        myList.deleteAtPosition(2);

        // Display the updated list
        System.out.println("\nLinked List after deletion at position 2:");
        myList.displayList();

        // Search for a value
        int searchValue = 20;
        boolean found = myList.searchNode(searchValue);
        System.out.println("\nValue " + searchValue + " found: " + found);
    }

}


public class Stack {
    class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }


    private Node top;

    public Stack() {
        top = null;
    }

    // Push operation: Insert a new element into the stack
    public void push(int data) {
        Node temp = new Node(data);
        temp.link = top;
        top = temp;
    }

    // Pop operation: Remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedValue = top.data;
        top = top.link;
        return poppedValue;
    }

    // Peek operation: Return the top element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display all elements in the stack
    public void display() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
        System.out.println();
    }

}




