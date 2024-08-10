// Code written by Pratik Bharambe ................

// Importing neccessay Packages ............
import java.util.*;

// Main Public class ....................
public class QueueClass {

    // Node class for node creation of linked list .............
    static class Node{

        // Data pointer of the node ............
        int data;
        Node next;

        // Constructor to initialize the new node ..........
        Node(int data){
            this.data = data;
            this.next = null;  // Making next pointer of node null ............
        }
    }

    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅
    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅

    // Implementation of Queue data structure using Linked List ...................
    static class Queue_implementation_using_Linked_list{

        // Stating point of Queue ( Linked List ) ..................
        Node head;

        // Method the check the queue is empty or not and return it ..............
        public boolean isEmpty() {
            return head == null;
        }

        // Method to insert an element in the top of the queue .......................
        public void push(int data) {
            
            // New Node created with initialization of data in it ..............
            Node newNode = new Node(data);

            // checking the queue is empty or not ...........
            if (isEmpty()) {
                // if the queue is empty then make newNode as head ............
                head = newNode;
                return;
            }

            // Inseting new node at the top of the linked list ..........
            newNode.next = head;

            // Making the newNode as the head of the linked list ...........
            head = newNode;     

        }

        // Method to remove the last element of the Queue ...........
        public int pop() {

            // checking the queue is empty or not ...........
            if (isEmpty()) {
                System.out.println("The queue is empty.");
                return -1;
            }

            // Creating last node and seconf last node to remove last element of queue ......
            Node second_Last_Node = head;
            Node last_Node = head.next;

            // traverse till last node ...................
            while(last_Node.next != null){
                second_Last_Node = second_Last_Node.next;
                last_Node = last_Node.next;
            }

            // getting the data to be removed and then removed ot ...............
            int node_removed = last_Node.data;
            second_Last_Node.next = null;

            // Returnd the removed element .............
            return node_removed;
            
        }

        // Method to get peek element of the linked list .........
        public int peek() {
            
            // checking the queue is empty or not ...........
            if (isEmpty()) {
                System.out.println("The queue is empty.");
                return -1;
            }

             // Creating a traversal node to traverse accross the queue ..............
            Node traversalNode = head;

            // Traversing till the last of the queue ................
            while(traversalNode.next != null){
                traversalNode = traversalNode.next;
            }

            // Returing the peek of the Queue .............
            return traversalNode.data;

        }

        // Method for printing the elements of queue ...........
        public void printQueue() {

            // checking the queue is empty or not ...........
            if (isEmpty()) {
                System.out.println("The queue is empty.");
                return;
            }

            // Creating a traversal node to traverse accross the queue ..............
            Node traversalNode = head;

            System.out.print("\nIn -> ");
            while(traversalNode != null){
                // Printing data at node and incrementing traversal node ..............
                System.out.print(traversalNode.data + " -> ");
                traversalNode = traversalNode.next;
            }
            System.out.println("Out.");

            // Getting new line after display of queue ..................
            System.out.println();

        }

    }

    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅
    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅

    // Implementation of Queue data structure using ArrayList ...................
    static class Queue_implementation_using_ArrayList{

        ArrayList<Integer> list = new ArrayList<>();

        // Method the check the queue is empty or not and return it ..............
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // Method to insert an element in the top of the queue .......................
        public void push(int data) {
            list.add(data);
        }

        // Method to remove the last element of the Queue ...........
        public int pop() {
            return list.remove(0);
        }

        // Method to get peek element of the linked list .........
        public int peek() {
            return list.get(0);
        }

        // Method for printing the elements of queue ...........
        public void printQueue() {

            System.out.print("\nIn -> ");
            // for loop to trav over the list .............
            for(int i = list.size()-1 ; i >= 0 ; i--){
                // Getting the data and printing it .................
                System.out.print(list.get(i) + " -> ");
            }
            System.out.print("Out.");
            System.out.println();
        }

    }

    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅
    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅

    // Object of Scanner class to accept user input ............
    static Scanner sc = new Scanner(System.in);

    // Method to print menu for types of linked list implementations of Queue ....................
    public static int print_Types_Of_Implementations() {
        System.out.println("\n0. Exit from Execution.");
        System.out.println("1. Implenation using Linked List ( From scratch ).");
        System.out.println("2. Implementation using ArrayList ( Colletion Framwork ).");
        System.out.println("3. Implementation using Queue Collection Framwork.");
        System.out.print("Enter your choice : ");
        return sc.nextInt();    // returning choice accepted by user .............
    }

    // Method to print menu for linked list implementation of Queue ....................
    public static int Print_Menu_for_queue_operations() {
        System.out.println("\n0. Terminate the execution thread.");
        System.out.println("1. Push data into Queue.");
        System.out.println("2. Pop data into Queue.");
        System.out.println("3. Peek data of Queue.");
        System.out.println("4. Print Queue.");
        System.out.print("\nEnter your choice : ");
        return sc.nextInt();    // returning choice accepted by user .............
    }

    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅
    // ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅ ⇅

    // Main thred of execution ............
    public static void main(String[] args) {

        System.out.println("\n\n.................... Welcome to Queue Implementation ....................");

        switch (print_Types_Of_Implementations()) {

            // Terminate the execution thread. ............................
            case 0:
                System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                return;

            // Implenation using Linked List ( From scratch ). .....................
            case 1:

                // object of Queue_implementation_using_Linked_list class to access it ...............
                Queue_implementation_using_Linked_list qll = new Queue_implementation_using_Linked_list();

                do {  // Starting of do-while loop for continous execution ................
                
                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_queue_operations()) { 
                    
                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into Queue. .......................
                        case 1:
                            System.out.print("Enter data to push into Queue : ");
                            qll.push(sc.nextInt());
                            System.out.println("The ented data is pushed into Queue.");
                            break;
                    
                        // Pop data into Queue. .........................
                        case 2:
                            System.out.println("The " + qll.pop() + " is popped out from the Queue.");
                            break;
                    
                        // Peek data of Queue. ........................
                        case 3:
                            System.out.println("The peek element of Queue is : " + qll.peek());
                            break;
                    
                        // Print Queue. .....................
                        case 4:
                            System.out.print("The elements of Queue are : ");
                            qll.printQueue();
                            break;
                    
                        // Default case which get executed when user make a invalid choice ...................
                        default:
                            System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                            break;
                    }
                
                } while (true);  // Infinte loop for continous accesment ....................

            // Implementation using ArrayList ( Colletion Framwork ). .....................
            case 2:

                // object of Queue_implementation_using_ArrayList class to access it ...............
                Queue_implementation_using_ArrayList qal = new Queue_implementation_using_ArrayList();

                do {    // Starting of do-while loop for continous execution ................

                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_queue_operations()) {

                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into Queue. .......................
                        case 1:
                            System.out.print("Enter data to push into Queue : ");
                            qal.push(sc.nextInt());
                            System.out.println("The ented data is pushed into Queue.");
                            break;
                    
                        // Pop data into Queue. .........................
                        case 2:
                            System.out.println("The " + qal.pop() + " is popped out from the Queue.");
                            break;
                    
                        // Peek data of Queue. ........................
                        case 3:
                            System.out.println("The peek element of Queue is : " + qal.peek());
                            break;
                    
                        // Print Queue. .....................
                        case 4:
                            System.out.print("The elements of Queue are : ");
                            qal.printQueue();
                            break;
                    
                        // Default case which get executed when user make a invalid choice ...................
                        default:
                            System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                            break;
                    }
                } while (true);    // Infinte loop for continous accesment ....................

            // Implementation using Queue Collection Framwork. ......................
            case 3:

                // Queue Creation using Collection Framework ..................
                Queue<Integer> list = new LinkedList<>();

                do {    // Starting of do-while loop for continous execution ................

                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_queue_operations()) {

                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into Queue. .......................
                        case 1:
                            System.out.print("Enter data to push into Queue : ");
                            list.add(sc.nextInt());
                            System.out.println("The ented data is pushed into Queue.");
                            break;
                    
                        // Pop data into Queue. .........................
                        case 2:
                            System.out.println("The " + list.remove() + " is popped out from the Queue.");
                            break;
                    
                        // Peek data of Queue. ........................
                        case 3:
                            System.out.println("The peek element of Queue is : " + list.peek());
                            break;
                    
                        // Print Queue. .....................
                        case 4:
                            System.out.print("The elements of Queue are : ");
                            System.out.println(list);
                            break;
                    
                        // Default case which get executed when user make a invalid choice ...................
                        default:
                            System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                            break;
                    }

                } while (true);     // Infinte loop for continous accesment ....................

            // Default case which get executed when user make a invalid choice ...................
            default:
                System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                return;
        }

    }
    
}