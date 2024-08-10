
// Importing the necesseary files ..............
import java.util.HashSet;
import java.util.Iterator;;

// Main public class ............
public class Hash_Set {

    // mian function ............
    public static void main(String[] args) {

        // Creating hashset using java collections .....
        HashSet<Integer> set = new HashSet<>();

        // Adding data to the set ..........
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1); // ? will not get inserted again as it against the rule of the set
                    // ..............

        // Printing the data from the hashset .............
        System.out.println(set);

        // cheking whether a number is presnt in the set using .........
        // ? " contains() " method .............
        if (set.contains(3)) {
            System.out.println("\nThe number is present in set.");
        } else {
            System.out.println("\nThe number is not present in set.");
        }

        // Grtting the length of the set ...........
        System.out.println("\nThe length of the set is : " + set.size());

        // Iterating over the set ............
        Iterator it = set.iterator();
        System.out.println();

        // Printing the data in the list ..............
        while (it.hasNext()) {
            System.out.print(it.next() + "  ");
        }

        // Deleting an number from set ................
        set.remove(2);
        System.out.println("\n\nThe number is removed.");
        System.out.println(set);

    }

}
