package Lab02;

/**
 * ArraySetWithArrayClient.
 *
 * @author Frank Carrano
 * @author Karen Gardner
 * @version 12/28/2016
 */
public class ArraySetWithArrayClient
{
    public static void main(String[] args)
    {
        String[] contentsOfBag = {"A", "B", "C", "D", "A", "C", "B", "B"};
        BagInterface<String> aBag = new ResizableArrayBag<>(contentsOfBag, contentsOfBag.length);
        aBag.display();

        System.out.println("Creating aSet with the secondary constructor - capacity of " + contentsOfBag.length);
        SetInterface<String> aSet = new ArraySetWithArray<>(contentsOfBag.length);
        System.out.println("Adding elements from aBag to aSet");
        while (!aBag.isEmpty())
            aSet.add(aBag.remove());
        aSet.displaySet();
        System.out.println("\nClearing aSet");
        aSet.clear();
        aSet.displaySet();
        System.out.println("aSet isEmpty returns " + aSet.isEmpty());
        System.out.println("The size of aSet is " + aSet.getCurrentSize());

        System.out.println("\nCreating set1 with default constructor");
        SetInterface<String> set1 = new ArraySetWithArray<>();

        // Initial capacity is 3
        System.out.println("\nset1 initially empty, capacity of 3: ");
        set1.displaySet();

        set1.add("A");
        set1.add("A");
        set1.add("B");
        set1.add("A");
        set1.add("C");
        set1.add("A");

        System.out.println("\nset1 after adding elements: ");
        set1.displaySet();
        System.out.println("\nAdding elements to set1");
        set1.add("V");
        set1.add("V");
        set1.add("T");
        set1.add("U");
        set1.add("V");
        set1.add("W");
        set1.add("X");
        set1.add("Y");
        set1.add("Z");

        System.out.println("\nset1 after adding and resizing: ");
        set1.displaySet();

        System.out.println("\nCreating set2 with the content of contentsOfBag array");
        SetInterface<String> set2 = new ArraySetWithArray<>(contentsOfBag);
        System.out.println("Adding more elements to set2");
        set2.add("A");
        set2.add("B");
        set2.add("B");
        set2.add("A");
        set2.add("C");
        set2.add("C");
        set2.add("D");
        set2.add("E");
        set2.add("F");
        set2.add("G");
        set2.add("H");

        System.out.println("\nset2 after adding and resizing: ");
        set2.displaySet();

        System.out.println("\nset1 contains A: " + set1.contains("A"));
        System.out.println("set1 contains E: " + set1.contains("E"));

        set1.removeElement("B");
        System.out.println("After removing B from set1:");
        set1.displaySet();

        System.out.println("After removing " + set1.remove()
                + " from set1:");
        set1.displaySet();
    }
} // end ArraySetWithArrayClient