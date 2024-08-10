// Code Written by Pratik Bharambe ..........................

// Importing necessary packages ...................
import java.util.*;

// Main public class ...............
public class binaryTree {

    // static Node class for node cration of Binary Tree ................
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

    // Binary Tree Implemenations ..............
    static class BinaryTree {

        // Static variable for array acessing to built building tree ..................
        static int index = -1;

        // Method to build binary Tree ..............
        public Node buildTree(int[] nodes) {

            // Incrementing the index variable .................
            index++;

            // If data in array is -1 the return ...........
            if (nodes[index] == -1) {
                return null;
            }

            // Creating newNode and building tree using recursion ................
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            // Returing the new Node ...................
            return newNode;
        }

        // Method to print Pre_order traversal of the binary tree .............
        public void preOrder(Node root) {

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
        public void inOrder(Node root) {

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
        public void postOrder(Node root) {

            // Checking whether the tree is empty or not ................
            if (root == null) {
                return;
            }

            // Printing data in postOrder formant ..................
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + "  ");

        }

        // Method to print data in level_order travversal of binary tree ............
        public void levelOrder(Node root) {

            // Checking whether the tree is empty or not ................
            if (root == null) {
                return;
            }

            // Creaing a queue using Linked List colletion framework ..................
            Queue<Node> q = new LinkedList<>();
            // Adding root and null to the queue ................
            q.add(root);
            q.add(null);

            // Accessing tree till it become completely traversal ...................
            while (!q.isEmpty()) {
                // getting the removing element from queue to the node ........
                Node currNode = q.remove();

                // if current Node is empty then .............
                if (currNode == null) {
                    System.out.println(); // Print the new line ........
                    if (q.isEmpty()) {
                        // is queue is empty the terminate the while loop .............
                        break;
                    } else {
                        // else add null to the queue ..............
                        q.add(null);
                    }
                } else {
                    // If the current Noe is Not Empty then print data of current node ............
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        // if left sub tree is not empty the add it to the queue ...........
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        // if right sub tree is not empty the add it to the queue ...........
                        q.add(currNode.right);
                    }
                }
            }

        }

        // Method to the number of nodes in a binary tree .............
        public int countOfNodes(Node root) {

            // Checking whether the tree is empty or not ................
            if (root == null) {
                return 0;
            }

            // Getting the lrft and right count .............
            int leftCount = countOfNodes(root.left);
            int rightCount = countOfNodes(root.right);

            // Returning it sum ...................
            return leftCount + rightCount + 1;

        }

        // Method to the number of sum in a binary tree .............
        public int sumOfNodes(Node root) {

            // Checking whether the tree is empty or not ................
            if (root == null) {
                return 0;
            }

            // Getting the lrft and right count .............
            int leftsum = sumOfNodes(root.left);
            int rightsum = sumOfNodes(root.right);

            // Returning it sum ...................
            return leftsum + rightsum + root.data;

        }

        // Method to print the height of the binary tree ...............
        public int height(Node root) {

            // Checking whether the tree is empty or not ................
            if (root == null) {
                return 0;
            }

            // Getting the left and right height of the tree .............
            int lefthight = height(root.left);
            int righthight = height(root.right);

            // Calculating its maximum and returning it by increment of 1 ...........
            int myHeight = Math.max(lefthight, righthight) + 1;
            return myHeight;

        }

    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println("\nThe data at the root is : " + root.data);

        System.out.println("\nPre Order : ");
        tree.preOrder(root);

        System.out.println("\n\nIN Order : ");
        tree.inOrder(root);

        System.out.println("\n\nPost Order : ");
        tree.postOrder(root);

        System.out.println("\n\nLevel Order : ");
        tree.levelOrder(root);

        System.out.println("\nThe count of nodes is : " + tree.countOfNodes(root));

        System.out.println("\nThe sum of nodes is : " + tree.sumOfNodes(root));

        System.out.println("\nThe height of Binary tree is : " + tree.height(root));
    }

}
