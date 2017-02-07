package Lab03;

/**
 * LinkedSetWithChainOfNodesClient.
 *
 * @author Frank M. Carrano
 * @version 12/29/2016
 * @modifiedBy Anna Bieszczad
 */
public class LinkedSetWithChainOfNodesClient
{
    public static void main(String[] args)
    {
        String[] contentsOfBag = {"A", "B", "C", "D", "A", "C", "B", "B"};
        System.out.println("Creating aBag and aSet objects and adding elements from contentsOfBag to them");
        BagInterface<String> aBag = new LinkedBag<>();
        SetInterface<String> aSet = new LinkedSetWithChainOfNodes<>();
        for (int i = 0; i < contentsOfBag.length; i++)
        {
            aBag.add(contentsOfBag[i]);
            aSet.add(contentsOfBag[i]);
        }
        aBag.display();
        aSet.displaySet();

        System.out.println("\nClearing aSet");
        aSet.clear();
        aSet.displaySet();
        System.out.println("aSet isEmpty returns " + aSet.isEmpty());
        System.out.println("The size of aSet is " + aSet.getCurrentSize());

        System.out.println("\nCreating set1 and set2");
        SetInterface<String> set1 = new LinkedSetWithChainOfNodes<>();
        System.out.println("The size of set1 is " + set1.getCurrentSize());
        SetInterface<String> set2 = new LinkedSetWithChainOfNodes<>();
        System.out.println("The size of set2 is " + set2.getCurrentSize());

        System.out.println("\nAdding elements to set1");
        set1.add("A");
        set1.add("A");
        set1.add("B");
        set1.add("A");
        set1.add("C");
        set1.add("A");
        System.out.println("The size of set1 is " + set1.getCurrentSize());
        System.out.println("set1 is ");
        set1.displaySet();

        System.out.println("\nAdding elements to set2");
        set2.add("A");
        set2.add("B");
        set2.add("B");
        set2.add("A");
        set2.add("C");
        set2.add("C");
        set2.add("D");
        System.out.println("The size of set2 is " + set2.getCurrentSize());
        System.out.println("set2 is ");
        set2.displaySet();

        System.out.println("\nset1 contains A: " + set1.contains("A"));
        System.out.println("set1 contains E: " + set1.contains("E"));

        set1.removeElement("B");
        System.out.println("After removing B from set1, ");
        set1.displaySet();

        System.out.println("After removing " + set1.remove() + " from set1, ");
        set1.displaySet();
    } // end main
} // end LinkedSetWithChainOfNodesClient