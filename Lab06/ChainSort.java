package Lab06;

import java.util.*;

/**
 * This class represents chains of linked nodes that
 * can be sorted by a Shell sort.
 *
 * @author Charles Hoot
 * @author Frank M. Carrano
 *         Modified by Anna Bieszczad
 * @author YOUR NAME
 * @version 2/24/2017
 */
public class ChainSort<T extends Comparable<? super T>>
{
    private Node<T> firstNode; // reference to first node
    private int length; // number of entries in list

    public ChainSort()
    {
        clear();
    } // end default constructor

    public final void clear()
    {
        this.firstNode = null;
        this.length = 0;
    } // end clear

    public final int getLength()
    {
        return this.length;
    }

    public void display()
    {
        Node currentNode = this.firstNode;
        while (currentNode != null)
        {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    } // end display

    public boolean isEmpty()
    {
        boolean result;

        if (this.length == 0)
        {
            assert this.firstNode == null;
            result = true;
        } else
        {
            assert this.firstNode != null;
            result = false;
        }

        return result;
    } // end isEmpty

    public void addToBeginning(T newEntry)
    {
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = this.firstNode;
        this.firstNode = newNode;
    } // end addToBeginning

    public void shellSort(int first, int last)
    {
        //TODO Project3

        // for each space
        //     create sub-chains
        //     call incrementalInsertionSort
    } // end shellSort

    /**
     * Task: Sorts equally spaced elements of a linked chain into
     * ascending order. Sub-chains created with a use of previous.
     *
     * @param first the integer index of the first element to consider;
     * @param last  the integer index of the last element to consider;
     * @param space the difference between the indices of the
     *              elements to sort
     */
    private void incrementalInsertionSort(int first, int last, int space)
    {
        //TODO Project3
    } // end incrementalInsertionSort


    private class Node<S>
    {
        private S data;
        private Node<S> next;
        private Node<S> previous; // ADDED for linking backwards for shell sort

        private Node(S dataPortion)
        {
            this.data = dataPortion;
            this.next = null;
            this.previous = null;
        }
    } // end Node

    // ************ TEST DRIVER *****************

    public static void main(String args[])
    {
        System.out.println("What size chain should be used?");
        int chainSize = getInt("   It should be an integer value greater than or equal to 1.");

        System.out.println("What seed value should be used?");
        int seed = getInt("   It should be an integer value greater than or equal to 1.");
        Random generator = new Random(seed);
        ChainSort<Integer> myChain = new ChainSort<>();

        for (int i = 0; i < chainSize; i++)
            myChain.addToBeginning(generator.nextInt(100));

        System.out.print("\nOriginal Chain Content: ");
        myChain.display();
        myChain.shellSort(1, chainSize);
        System.out.print("\nSorted Chain Content: ");
        myChain.display();
    }


    /**
     * Get an integer value
     *
     * @param rangePrompt String representing a message used to ask the user for input
     * @return an integer
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
    }
} // end ChainSort