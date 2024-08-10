// Code Written by Pratik Bharambe .................

// Importing the nesseary files .......................
import java.util.ArrayList;
import java.util.Scanner;

// Main public class ..................
public class BinarySearchTree {

    // Node structure of the Binary search tree ................
    static class Node {

        // Data variables of Node ..............
        int data;
        Node left;
        Node right;

        // Constructor to initialize the Node with provided data .................
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // function to insert data to the binary search tree ..................
    public static Node insert(Node root, int data) {

        // if the BST is empty .............
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.data > data) {
            // insert in left sub tree ...........
            root.left = insert(root.left, data);
        } else {
            // insert in right sub tree .............
            root.right = insert(root.right, data);
        }

        // returning the root of the BST ............
        return root;
    }

    // Method to print Pre_order traversal of the binary tree .............
    public static void preOrder(Node root) {

        // Checking whether the tree is empty or not ................
        if (root == null) {
            return;
        }

        // Printing data in preOrder formant ..................
        System.out.print(root.data + "  ");
        preOrder(root.left);
        preOrder(root.right);

    }

    // Method to print in_order traversal of the binary tree .............
    public static void inOrder(Node root) {

        // Checking whether the tree is empty or not ................
        if (root == null) {
            return;
        }

        // Printing data in inOrder formant ..................
        inOrder(root.left);
        System.out.print(root.data + "  ");
        inOrder(root.right);

    }

    // Method to print post_order traversal of the binary tree .............
    public static void postOrder(Node root) {

        // Checking whether the tree is empty or not ................
        if (root == null) {
            return;
        }

        // Printing data in postOrder formant ..................
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + "  ");

    }

    // Method to search an key in the Binary Seatch Tree ...............
    public static boolean search(Node root, int key) {

        if (root == null) {
            // key is not found in the BST ...............
            return false;
        }

        if (root.data > key) {
            // Search in left sub tree ...........
            return search(root.left, key);
        } else if (root.data == key) {
            // key found in the tree ............
            return true;
        } else {
            // Search in left sub tree ...........
            return search(root.right, key);
        }
    }

    // Method to delete a node from BST .......
    /*
     *z case 1 : No child ( leaf Node ) .............
     * case 2 : One child .............
     * case 3 : Two children .............
     */
    public static Node delete(Node root, int key) {

        if (root.data > key) {
            // Enter in the left sub tree of the BST ..............
            root.left = delete(root.left, key);
        } else if (root.data < key) {
            // Enter in the right sub tree of the BST ..............
            root.right = delete(root.right, key);
        } else {
            // At the node to be deleted ............

            // case 1 : No clild ( Lead node ) ...............
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: One child .............
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3 : Two children .................
            Node Is = inOrderSuccesser(root.right);
            root.data = Is.data;
            root.right = delete(root.right, Is.data);

        }

        // Returning the node ...........
        return root;

    }

    // Method to get the in order successer for case 3 ............
    public static Node inOrderSuccesser(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Method to print number is a givern range ..................
    public static void printInRange(Node root, int min, int max) {

        if (root == null) {
            // base case ............
            return;
        }

        if (root.data >= min && root.data <= max) {
            // root data is greater than min and less than max ............
            printInRange(root.left, min, max);
            System.out.print(root.data + "  ");
            printInRange(root.right, min, max);
        } else if (root.data >= max) {
            // left sub tree ............
            printInRange(root.left, min, max);
        } else {
            // right sub tree .........
            printInRange(root.right, min, max);
        }

    }

    // Method to print paths of the BST ( Root to leaf ) .............
    public static void printRootToLeaf(Node root, ArrayList<Integer> path) {

        // Condition for null root ............
        if (root == null) {
            return;
        }

        // adding data to the arraylist ..............
        path.add(root.data);

        if (root.left == null && root.right == null) {
            // leaf Node condtion ...........
            printPath(path);
        } else {
            // Non-leaf root condition ................
            printRootToLeaf(root.left, path);
            printRootToLeaf(root.right, path);
        }

        // removing the last element from the arraylist .........
        path.remove(path.size() - 1);

    }

    // method to print paths using arraylist ...............
    public static void printPath(ArrayList<Integer> path) {
        // Traversing the arraylist and printing the data .............
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("Null.");
    }

    // Object of Scanner class for accepting the user input ...................
    static Scanner sc = new Scanner(System.in);

    // Method to print the option for choice menu ...........
    public static int optionMenu() {
        System.out.println("\n0. Terminate the program.");
        System.out.println("1. Pre-order Traversal.");
        System.out.println("2. In-order Traversal.");
        System.out.println("3. Post-order Traversal.");
        System.out.println("4. Insert a node.");
        System.out.println("5. Delete a node.");
        System.out.println("6. Print in range.");
        System.out.println("7. Print all the paths from root to leaf.");
        System.out.print("\nEnter your choice : ");
        return sc.nextInt();
    }

    // Main thread of execution ..............
    public static void main(String[] args) {

        System.out.println("\n***************** Welcome to Binary Screach Tree *****************\n");

        // values to build the BST .................
        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };

        // empty bst creation ........
        Node root = null;

        // Building the tree ..............
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        System.out.println("The Binary Search Tree is Builded Successfully.\nThe In-order Traversal is :");
        inOrder(root);
        System.out.println();

        while (true) {

            switch (optionMenu()) {

                // Terminate the Program .......
                case 0:
                    System.out.println("The program is terminated Successfully !!!\nBye Bye.");
                    return;

                // Pre-order Traversal. .................
                case 1:
                    System.out.println("The pre-order traversal is : ");
                    preOrder(root);
                    break;

                // In-order Traversal. .............
                case 2:
                    System.out.println("The in-order traversal is : ");
                    inOrder(root);
                    break;

                // Post-order Traversal. .................
                case 3:
                    System.out.println("The post-order traversal is : ");
                    postOrder(root);
                    break;

                // Insert a Node. ................
                case 4:
                    System.out.print("Enter data to add : ");
                    insert(root, sc.nextInt());
                    break;

                // Delete a node. ....................
                case 5:
                    System.out.print("Enter data to delete : ");
                    delete(root, sc.nextInt());
                    break;

                // Print in range. .............
                case 6:
                    System.out.print("Enter tne minimum value : ");
                    int min = sc.nextInt();
                    System.out.print("Enter tne maximum value : ");
                    int max = sc.nextInt();
                    printInRange(root, min, max);
                    break;

                // Print all the paths from root to leaf. ...........
                case 7:
                System.out.println("The a root to leaf paths are : ");
                    printRootToLeaf(root, new ArrayList<>());
                    break;

                // Default case if case is not found .................
                default:
                    System.out.println("Invalid choice !!!!!!!\nPlease Re-Enter your choice !!!!!!");
                    break;
            }

        }
    }

}
