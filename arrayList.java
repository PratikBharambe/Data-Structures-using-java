// Code Written By Pratik Bharambe...................

// Importing necessay packages ............
import java.util.*;

// Main public class .................
public class arrayList {

    public static void main(String[] args) {
        
        // Creating ArrayList ..............
        ArrayList<Integer> list = new ArrayList<>();

        // Inserting elements in the Arraylist............
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("The array list is : " + list);

        // Inserting element at a particular position.............
        list.add(2, 2);
        System.out.println("The ArrayList after adding 2 at index 2 is : " + list);

        // Getting the element of Arraylist..............
        System.out.println("The element at the 0th index is : " + list.get(0));
        System.out.println("The element at the 2th index is : " + list.get(2));
        System.out.println("The element at the 4th index is : " + list.get(4));

        // Getting the size of ArrayList................
        System.out.println("The size of the ArrayList is : " + list.size());

        // applying Loops on ArrayList............
        System.out.print("Printed ArrayList using Loop : ");
        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }

        // Setting an element at an already existing element.............
        list.set(2, 6);
        System.out.println("\nThe updated ArrayList after setting 6 at index 2 is : " + list);

        // Removing an element from the ArrayList................
        list.remove(5);
        System.out.println("The ArrayList after removing the element at the 5th index is : " + list);

        // Sorting the Arraylist Using Collections Class in util Package...............
        Collections.sort(list);
        System.out.println("The sorted list is : " + list);

    }
    
}
