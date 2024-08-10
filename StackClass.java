// Code Written by Pratik Bharambe ............................

// Importing necessay packages ..........
import java.util.*;

// Public class ....................
public class StackClass {

    // Nested class to implement Node of linked list .....................
    static class Node {

        // Field of node for linkd list ..................
        int data;
        Node next;

        // Constructer to initialize the node for Linked List .................
        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    // Nested class to implement basic operations of stack using linked list ...............
    static class stack_implementation_using_Linked_List {

        // Head of the Linked list ...............
        static Node head;

        // Checking whether the linkd list is empty or not ...............
        public static boolean isEmpty() {
            return head == null;
        }

        // method for pushing data to the stack .............
        public void push(int data) {
            Node newNode = new Node(data);  // Creating new Node .................
            if (isEmpty()) {
                head = newNode;
                return;
            }
            // Inseting newNode at the top of the stack ( Linked List ) ...................
            newNode.next = head;
            head = newNode;     // Making the newNode as the head ..................
        }

        // method for poping data from the stack .............
        public int pop() {

            if (isEmpty()) {
                System.out.println("The stack is empty.");
                return -1;
            }

            // Getting the data to pop from stack ..............
            int topData = head.data;
            head = head.next;   // Poping the first element of the stack ...........
            return topData;     // returning the poped element ........................

        }

        // Method to get the peek ( top ) of the stack ....................
        public int peek() {
            if (isEmpty()) {
                System.out.println("The stack is empty.");
                return -1;
            }

            // Returning peek data ..............
            Node top = head;
            return top.data;

        }

        // Method to print the stack ..............
        public void printStack() {
            Node travNode = head; // Traversal Node ................
            while (travNode != null) {
                // Printong the data and incrementing the traveNode till end of the Linked List ....................
                System.out.print(travNode.data + " ");
                travNode = travNode.next;
            }
            System.out.println();
        }
    }

    // Nested class to implement basic operations of stack using ArrayList ...............
    static class stack_implementation_using_ArrayList {
        // Created arrayList using colletion framework ...........
        ArrayList<Integer> list = new ArrayList<>();

        // Push method to insert data in stack ..........
        public void push(int data) {
            list.add(data);
        }

        // Method to check whether the stack is empty or not ..............
        public boolean isEmpty() {
            return list.size() == 0;
        }

        // pop method to poping element from stack .................
        public int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.remove(list.size()-1);  // Getting the element to pop and poped it ..........
            return top;   // returning the poped element ..........
        }

        // Peek method to get the very first element of the stack ..............
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);  //  Getting the peek element and returning it ...........
        }

        // Method to print the stack .................
        public void printStack(){
            System.out.println(list);
        }
    }

    // Object of Scanner class to accept user input ............
    static Scanner sc = new Scanner(System.in);

    // Method to print menu for types of linked list implementations of stack ....................
    public static int print_Types_Of_Implementations() {
        System.out.println("\n0. Exit from Execution.");
        System.out.println("1. Implenation using Linked List ( From scratch ).");
        System.out.println("2. Implementation using ArrayList ( Colletion Framwork ).");
        System.out.println("3. Implementation using stack Collection Framwork.");
        System.out.print("Enter your choice : ");
        return sc.nextInt();    // returning choice accepted by user .............
    }

    // Method to print menu for linked list implementation of stack ....................
    public static int Print_Menu_for_stack_operations() {
        System.out.println("\n0. Terminate the execution thread.");
        System.out.println("1. Push data into stack.");
        System.out.println("2. Pop data into stack.");
        System.out.println("3. Peek data of stack.");
        System.out.println("4. Print stack.");
        System.out.print("\nEnter your choice : ");
        return sc.nextInt();    // returning choice accepted by user .............
    }

    // Main thred of execution ............
    public static void main(String[] args) {

        System.out.println("\n\n.................... Welcome to Stack Implementation ....................");

        switch (print_Types_Of_Implementations()) {

            // Terminate the execution thread. ............................
            case 0:
                System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                return;

            // Implenation using Linked List ( From scratch ). .....................
            case 1:

                // object of stack_implementation_using_Linked_List class to access it ...............
                stack_implementation_using_Linked_List sll = new stack_implementation_using_Linked_List();

                do {  // Starting of do-while loop for continous execution ................
                
                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_stack_operations()) { 
                    
                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into stack. .......................
                        case 1:
                            System.out.print("Enter data to push into stack : ");
                            sll.push(sc.nextInt());
                            System.out.println("The ented data is pushed into Stack.");
                            break;
                    
                        // Pop data into stack. .........................
                        case 2:
                            System.out.println("The " + sll.pop() + " is popped out from the Stack.");
                            break;
                    
                        // Peek data of stack. ........................
                        case 3:
                            System.out.println("The peek element of stack is : " + sll.peek());
                            break;
                    
                        // Print stack. .....................
                        case 4:
                            System.out.print("The elements of stack are : ");
                            sll.printStack();
                            break;
                    
                        // Default case which get executed when user make a invalid choice ...................
                        default:
                            System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                            break;
                    }
                
                } while (true);  // Infinte loop for continous accesment ....................

            // Implementation using ArrayList ( Colletion Framwork ). .....................
            case 2:

                // object of stack_implementation_using_ArrayList class to access it ...............
                stack_implementation_using_ArrayList sal = new stack_implementation_using_ArrayList();

                do {    // Starting of do-while loop for continous execution ................

                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_stack_operations()) {

                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into stack. .......................
                        case 1:
                            System.out.print("Enter data to push into stack : ");
                            sal.push(sc.nextInt());
                            System.out.println("The ented data is pushed into Stack.");
                            break;
                    
                        // Pop data into stack. .........................
                        case 2:
                            System.out.println("The " + sal.pop() + " is popped out from the Stack.");
                            break;
                    
                        // Peek data of stack. ........................
                        case 3:
                            System.out.println("The peek element of stack is : " + sal.peek());
                            break;
                    
                        // Print stack. .....................
                        case 4:
                            System.out.print("The elements of stack are : ");
                            sal.printStack();
                            break;
                    
                        // Default case which get executed when user make a invalid choice ...................
                        default:
                            System.out.println("Invaild choice !!!!!\nRe-Enter your choice.");
                            break;
                    }
                } while (true);    // Infinte loop for continous accesment ....................

            // Implementation using stack Collection Framwork. ......................
            case 3:

                // Stack Creation using Collection Framework ..................
                Stack<Integer> list = new Stack<>();

                do {    // Starting of do-while loop for continous execution ................

                    // Printing the menu and getting the choice ..............
                    // Accessing using switch cases .................
                    switch (Print_Menu_for_stack_operations()) {

                        // Terminate the execution thread. ............................
                        case 0:
                            System.out.println("The Execution Is Terminated Successfully.\nTata Bye Bye.");
                            return;
                    
                        // Push data into stack. .......................
                        case 1:
                            System.out.print("Enter data to push into stack : ");
                            list.push(sc.nextInt());
                            System.out.println("The ented data is pushed into Stack.");
                            break;
                    
                        // Pop data into stack. .........................
                        case 2:
                            System.out.println("The " + list.pop() + " is popped out from the Stack.");
                            break;
                    
                        // Peek data of stack. ........................
                        case 3:
                            System.out.println("The peek element of stack is : " + list.peek());
                            break;
                    
                        // Print stack. .....................
                        case 4:
                            System.out.print("The elements of stack are : ");
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
