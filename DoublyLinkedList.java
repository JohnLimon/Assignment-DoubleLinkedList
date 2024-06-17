package DoubleLinkedList;

public class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    // Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    // Insert into a DLL
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
    }

    // Traverse a DLL
    public void traverseDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            while (tempNode != null) {
                System.out.print(tempNode.value);
                if (tempNode.next != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println();
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            while (tempNode != null) {
                System.out.print(tempNode.value);
                if (tempNode.prev != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
        }
        System.out.println();
    }

    // Search Node
    public boolean searchNode(int nodeValue) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return false;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (tempNode != null) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Node found at location: " + index);
                    return true;
                }
                tempNode = tempNode.next;
                index++;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Deletion Method
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        } else if (location == 0) { // delete head
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (location >= size - 1) { // delete tail
            if (size == 1) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        } else { // delete in the middle
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            tempNode.next = tempNode.next.next;
            tempNode.next.prev = tempNode;
        }
        size--;
    }

    // Delete entire DLL
    public void deleteDLL() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("DLL has been deleted");
    }
}
