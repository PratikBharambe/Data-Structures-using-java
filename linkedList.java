// Code Written by Pratik Bharambe ...............................

// Importing the necessary files ................
import java.util.*;

// Public class ................
public class linkedList {

    // Head of the linked ( Object of the inner Node class ) ..............
    Node head;

    // Private variable for storing size of the linked list ................
    private int size;

    // Constructor to initialize the private size variable .......................
    linkedList() {
        size = 0;
    }

    // Node class the basic building block of the Linked List ...................
    public class Node {

        // Creating the data and address field for the linked list .............
        int data;
        Node next;

        // Constructor for creating new node and inserting data in data field .............
        Node(int data) {
            this.data = data;
            this.next = null;

            // Increment the size of the linked list ....................
            size++;
        }

    }

    // Method to insert data in Linked List at the First Position .............
    public void add_At_First_Position(int data) {

        // Creating new Node ..............
        Node newNode = new Node(data);

        // Checking whether the Linked List is empty or not .............
        if (head == null) {
            head = newNode;
            return;
        }

        // Storing the value of head in the next field of new node ...............
        newNode.next = head;

        // Storing the value of new Node in the head ..................
        head = newNode;

    }

    // Method to insert data in Linked List at the Last Position .............
    public void add_At_Last_Position(int data) {

        // Creating new Node ..............
        Node newNode = new Node(data);

        // Checking whether the Linked List is empty or not .............
        if (head == null) {
            head = newNode;
            return;
        }

        // Creating a traversal node for traversing the linked List ..............
        Node trav_Node = head;

        // Traversing the linked list till the second last Node ................
        while (trav_Node.next != null) {
            // Incrementing the value of traversasl Nodde to the next node ..............
            trav_Node = trav_Node.next;
        }

        // adding the newly created Node at the last of the Linked List .................
        trav_Node.next = newNode;

    }

    // Removing data from the first position of the list ................
    public void delete_From_First_Position() {

        // Checking whether the Linked List is empty or not .............
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        // Decrement the size of the linked list ....................
        size--;

        // Removing the first node by assigning the head to the next node ................
        head = head.next;

    }

    // Method to insert node at nth position from head ...............
    public void add_at_nth_position_from_the_start(int position, int data){

        // Checking the linked is empty or not .....................
        if(head == null){
            System.out.println("Linked List is Empty.");
        }

        // Creating a new Node ......................
        Node newNode = new Node(data);

        // Traversing the list till previous location where the node to be added ..............
        int i = 1;
        Node prevNode = head;
        while(i < position-1){
            prevNode = prevNode.next;
            i++;
        }

        // Making next part of newnode as the next part of current Node ........... 
        newNode.next = prevNode.next;
        // Making current node next part as the new Node .......................
        prevNode.next = newNode;

    }

    // Removing data from the last position of the list ................
    public void delete_From_Last_Position() {
        // Checking whether the Linked List is empty or not .............
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        // Checking is the linked list contains only one node .............
        if (head.next == null) {
            head = null;
        }

        // Decrement the size of the linked list ....................
        size--;

        // Traversal Objectes of node class .........
        Node trav_Till_Second_Last_Node = head;
        Node trav_Till_Last_Node = head.next;
        // Traversing the linked list till second last node of the list ............
        while (trav_Till_Last_Node.next != null) {
            trav_Till_Last_Node = trav_Till_Last_Node.next;
            trav_Till_Second_Last_Node = trav_Till_Second_Last_Node.next;
        }
        // Removing the last node from the linked list ..............
        trav_Till_Second_Last_Node.next = null;

    }

    // Method to delete node from nth position from last ...............
    public void delete_From_nth_Position_From_Last(int position){

        // Checking the bounday conditions as mentioned below ..............
        if(head.next == null || position == size){
            if(head.next == null){
                // checking whether the Linked list contain only one element ....................
                System.out.println("The only existing node is deleted. Now ....");
                delete_From_First_Position();
            }else{
                // checking whether the Linked list is empty ...............
                //                                 OR ............
                // checking whether the position given is the first element of the linked list .................
                delete_From_First_Position();
            }
            return;
        }

        // Getting the positon of node from first to delete ....................
        int indexToSearch = size - position;
        Node previousNode = head;   // Node to traverse till the searching point ............
        int i = 1;

        // While loop to traver over the Linked List .............
        while(i < indexToSearch){
            previousNode = previousNode.next;
            i++;
        }

        // Linked the previous node to the next node of node to be deleted ..................
        previousNode.next = previousNode.next.next;
        
    }

    // for printing the linkd list ................
    public void Print_Linked_List() {

        // Checking whether the Linked List is empty or not .............
        if (head == null) {
            System.out.println("The Linked list is empty ...........");
            return;
        }

        // Creating a traversal node for traversing the linked List ..............
        Node trav_Node = head;

        // Traversing the linked list till the second last Node ................
        while (trav_Node != null) {
            // Incrementing the value of traversasl Nodde to the next node ..............
            // And print the data ..............
            System.out.print(trav_Node.data + " -> ");
            trav_Node = trav_Node.next;
        }
        System.out.print("Null.\n");
    }

    // method for getting te size of linked list ............
    public int size() {
        return size;
    }

    // Method to reverse a linked list ...................
    public void reverse_Linked_List_Using_Iterators_And_Print() {

        // Corner condtion to check whether the linked list is empty or contains only one node ...........
        if(head == null || head.next == null){return;}

        // Creating previous and current node ..............
        Node prevNode = head;
        Node currNode = head.next;
        // looping till last node ...................
        while (currNode != null) {
            Node nextNode = currNode.next;
            // Opertations to make the linked list reverse ............
            currNode.next = prevNode;   
            prevNode = currNode;
            currNode = nextNode; 
        }
        // Disconnecting the conncetion b/w prevNode and currNode ...........
        head.next = null;
        // Incrementing Head .................
        head = prevNode;

        // Printing the reversed Linked List using Iterators Method ....................
        System.out.println("Reversed operation on linked is successfully completed.");
        System.out.print("The Reversed Linked list is : ");
        Print_Linked_List();
    }

    // creating object of scanner for accepting input from user ..............
    static Scanner sc = new Scanner(System.in);

    // Mrthod to print the choices of operations to be performed on the linked list .............
    public static int menu() {
        System.out.println("\n0. Exit.");
        System.out.println("1. Add data at the first position.");
        System.out.println("2. Add the node at nth position from the start.");
        System.out.println("3. Add data at the last position.");
        System.out.println("4. Delete data from first position.");
        System.out.println("5. Delete the node from nth position from the last.");
        System.out.println("6. Delete data from last position.");
        System.out.println("7. Print Linked List.");
        System.out.println("8. Display the size of the linked list.");
        System.out.println("9. Print the reversed Linked List using Iterators Method.");
        System.out.print("\nEnter your choice : ");
        return sc.nextInt();
    }

    // Starting the main thread of execution ...........
    public static void main(String[] args) {

        int choice;
        linkedList list = new linkedList();

        do {
            // taking choice from user to perform operations on linked list ............
            choice = menu();

            // Switch case implementation for optimization ...............
            switch (choice) {
                // Exit from the Program .....................
                case 0:
                    System.out.println("The program is terminated Succesfully !!!!\nBye Bye.");
                    return;

                // Add data at the first position .............
                case 1:
                    System.out.print("Enter data to add : ");
                    list.add_At_First_Position(sc.nextInt());
                    System.out.println("The data was inserted at the first position.");
                    break;

                // Add the node at nth position from the start. ................
                case 2:
                    System.out.print("Enter the position : ");
                    int Position = sc.nextInt();
                    System.out.print("Enter the data to add : ");
                    list.add_at_nth_position_from_the_start(Position, sc.nextInt());
                    System.out.println("The Data was inserted at the enterd position.");
                    break;

                // Add data at the last position. ....................
                case 3:
                    System.out.print("Enter data to add : ");
                    list.add_At_Last_Position(sc.nextInt());
                    System.out.println("The data was inserted at the last position.");
                    break;

                // Delete data from first position. .................
                case 4:
                    list.delete_From_First_Position();
                    System.out.println("The data was deleted from the first position.");
                    break;
                    
                // Delete the node from nth position from the last. ....................
                case 5:
                    System.out.print("Enter the position from the last : ");
                    list.delete_From_nth_Position_From_Last(sc.nextInt());
                    System.out.println("The Data was deleted from the enterd position.");
                    break;

                // Delete data from last position. ...................
                case 6:
                    list.delete_From_Last_Position();
                    System.out.println("The data was deleted from the last position.");
                    break;

                // Print the Linked List ...........................
                case 7:
                    System.out.print("The Linked List is : ");
                    list.Print_Linked_List();
                    break;

                // Display the size of the Linked List ................
                case 8:
                    System.out.println("The size of the linked list is : " + list.size());
                    break;

                // Printing the reversed Linked List using Iterators Method. .................
                case 9:
                    list.reverse_Linked_List_Using_Iterators_And_Print();
                    break;

                // Deafault case get calls automatically if the user wrong choice .............
                default:
                    System.out.println("Invalid choice !!!!!!!\nPlease Re-Enter your choice !!!!!!");
                    break;

            }

        } while (true); // making infinte while loop .......
        // It terminate when the user will enter 0 as a chioce ..............

    }

}