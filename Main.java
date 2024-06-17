package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        // Insert nodes
        doublyLinkedList.insertDLL(1, 0);
        doublyLinkedList.insertDLL(2, 1);
        doublyLinkedList.insertDLL(3, 2);

        // Traverse DLL
        System.out.println("Traversing DLL:");
        doublyLinkedList.traverseDLL();

        // Reverse traverse DLL
        System.out.println("Reverse Traversing DLL:");
        doublyLinkedList.reverseTraverseDLL();

        // Search node
        doublyLinkedList.searchNode(2); // Should find node at index 1
        doublyLinkedList.searchNode(4); // Should not find node

        // Delete node
        doublyLinkedList.deleteNode(1); // Delete node at index 1
        System.out.println("DLL after deleting node at index 1:");
        doublyLinkedList.traverseDLL();

        // Delete entire DLL
        doublyLinkedList.deleteDLL();
        System.out.println("DLL after deleting entire DLL:");
        doublyLinkedList.traverseDLL();
    }
}
