package Lab03;

/**
 * A class that implements the ADT set by using a linked bag.
 * The set is never full.
 *
 * @author YOUR NAME
 * @version 12/29/2016
 */
public class LinkedSetWithLinkedBag<T extends Comparable<? super T>> implements SetInterface<T>
{
    private LinkedBag<T> bagOfSetEntries;

    /**
     * Creates a set from a new, empty linked bag.
     */
    public LinkedSetWithLinkedBag()
    {
        //TODO Project1 done
        bagOfSetEntries = new LinkedBag<T>();
    } // end default constructor

    public boolean add(T newEntry)
    {
        //TODO Project1 done
        boolean result = false;
        if (!bagOfSetEntries.contains(newEntry))
            result = bagOfSetEntries.add(newEntry);
        return result;
    } // end add

    public T[] toArray()
    {
        //TODO Project1 done
        return bagOfSetEntries.toArray();
    } // end toArray

    public boolean isEmpty()
    {
        //TODO Project1 done
        return bagOfSetEntries.isEmpty();
    } // end isEmpty

    public int getCurrentSize()
    {
        //TODO Project1 done
        return bagOfSetEntries.getCurrentSize();
    } // end getCurrentSize

    public boolean contains(T anEntry)
    {
        //TODO Project1 done
        return bagOfSetEntries.contains(anEntry);
    } // end contains

    public void clear()
    {
        //TODO Project1 done
        bagOfSetEntries.clear();
    } // end clear

    public T remove()
    {
        //TODO Project1 done
        return bagOfSetEntries.remove();
    } // end remove

    public boolean removeElement(T anEntry)
    {
        //TODO Project1 done
        return bagOfSetEntries.removeElement(anEntry);
    } // end remove

    // Displays a set.
    public void displaySet()
    {
        //TODO Project1 done
        bagOfSetEntries.display();
    } // end displaySet
} // end LinkedSetWithLinkedBag
