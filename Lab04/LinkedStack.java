package Lab04;

/**
 * A class of stacks whose entries are stored in a chain of nodes.
 *
 * @author Maciek Bieszczad
 * @version 01/02/2017
 */
public final class LinkedStack<T> implements TextbookStackInterface<T>
{
    private Node<T> topNode; // References the first node in the chain

    public LinkedStack()
    {
        // TODO PROJECT #3 done
        this.topNode = null;
    } // end default constructor

    public void push(T newEntry)
    {
        // TODO PROJECT #3 done
        // add to beginning of chain:
        Node<T> newNode = new Node<>(newEntry);
        newNode.next = this.topNode;
        this.topNode = newNode;
    } // end push

    public T peek() throws InsufficientNumberOfElementsOnStackException
    {
        // TODO PROJECT #3 done
        if (this.topNode == null) {
            throw new InsufficientNumberOfElementsOnStackException("couldn't peek");
        } else {
            return this.topNode.data;
        }
    } // end peek

    public T peek2() throws InsufficientNumberOfElementsOnStackException
    {
        // TODO PROJECT #3 done
        if (this.topNode == null || this.topNode.next == null) {
            throw new InsufficientNumberOfElementsOnStackException("couldn't peek2");
        } else {
            return this.topNode.next.data;
        }
    } // end peek2

    public T pop() throws InsufficientNumberOfElementsOnStackException
    {
        // TODO PROJECT #3 done
        if (this.topNode == null) {
            throw new InsufficientNumberOfElementsOnStackException("couldn't pop");
        } else {
            T result = this.topNode.data;
            this.topNode = this.topNode.next;
            return result;
        }
    } // end pop

    public boolean isEmpty()
    {
        // TODO PROJECT #3 done
        return this.topNode == null;
    } // end isEmpty

    public void clear()
    {
        // TODO PROJECT #3 done
        while (isEmpty()) {
            pop();
        }
    } // end clear

    // These methods are only for testing of array implementation
    public int getTopIndex()
    {
        return 0;
    }
    public int getCapacity() { return 0; }

    private class Node<S>
    {
        private S data; // Entry in stack
        private Node<S> next; // Link to next node

        private Node(S dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(S dataPortion, Node<S> linkPortion)
        {
            this.data = dataPortion;
            this.next = linkPortion;
        } // end constructor
    } // end Node

    public static void main(String[] args)
    {
        System.out.println("*** Create a stack ***");
        LinkedStack<String> myStack = new LinkedStack<>();

        System.out.println("--> Add to stack to get: " +
                "Joe Jane Jill Jess Jim\n");
        myStack.push("Jim");
        myStack.push("Jess");
        myStack.push("Jill");
        myStack.push("Jane");
        myStack.push("Joe");
        System.out.println("Done adding 5 elements.\n");

        System.out.println("--> Testing peek, peek2, and pop:");
        while (!myStack.isEmpty())
        {
            String top = myStack.peek();
            System.out.println(top + " is at the top of the stack.");
            try
            {
                String beneathTop = myStack.peek2();
                System.out.println(beneathTop + " is just beneath the top of the stack.");
            } catch (InsufficientNumberOfElementsOnStackException inoeose)
            {
                System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
            }
            top = myStack.pop();
            System.out.println(top + " is removed from the stack.\n");

        } // end while

        System.out.println("--> The stack should be empty: ");
        System.out.println("isEmpty() returns " + myStack.isEmpty());
        try
        {
            String top = myStack.peek();
            System.out.println(top + " is at the top of the stack.");
        } catch (InsufficientNumberOfElementsOnStackException inoeose)
        {
            System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
        }
        try
        {
            String top = myStack.pop();
            System.out.println(top + " is at the top of the stack.");
        } catch (InsufficientNumberOfElementsOnStackException inoeose)
        {
            System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
        }
        try
        {
            String beneathTop = myStack.peek2();
            System.out.println(beneathTop + " is just beneath the top of the stack.");
        } catch (InsufficientNumberOfElementsOnStackException inoeose)
        {
            System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
        }
        System.out.println("*** Done ***");
    }  // end main
} // end LinkedStack