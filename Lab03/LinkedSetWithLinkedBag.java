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
        //TODO Project1
    } // end default constructor

    public boolean add(T newEntry)
    {
        //TODO Project1

        return false; //THIS IS A STUB
    } // end add

    public T[] toArray()
    {
        //TODO Project1
        return null; //THIS IS A STUB
    } // end toArray

    public boolean isEmpty()
    {
        //TODO Project1
        return false; //THIS IS A STUB
    } // end isEmpty

    public int getCurrentSize()
    {
        //TODO Project1
        return 0; //THIS IS A STUB
    } // end getCurrentSize

    public boolean contains(T anEntry)
    {
        //TODO Project1
        return false; //THIS IS A STUB
    } // end contains

    public void clear()
    {
        //TODO Project1
    } // end clear

    public T remove()
    {
        //TODO Project1
        return null; //THIS IS A STUB
    } // end remove

    public boolean removeElement(T anEntry)
    {
        //TODO Project1
        return false; //THIS IS A STUB
    } // end remove

    // Displays a set.
    public void displaySet()
    {
        //TODO Project1
    } // end displaySet
} // end LinkedSetWithLinkedBag
