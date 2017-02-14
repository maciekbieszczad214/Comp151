package Lab04;

import java.util.EmptyStackException;

/**
 A class of stacks whose entries are stored in an array.
 @author Maciek Bieszczad
 @version 01/02/2017
 */
public final class ArrayStack<T> implements TextbookStackInterface<T>
{
	private T[] myStack;    // Array of myStack entries
	private int topIndex; // Index of top entry
	private boolean initialized = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;

	public ArrayStack()
	{
		// TODO PROJECT #2
	} // end default constructor

	public ArrayStack(int initialCapacity)
	{
		// TODO PROJECT #2
	} // end constructor

	public void push(T newEntry)
	{
		// TODO PROJECT #2
	} // end push

	public T peek() throws InsufficientNumberOfElementsOnStackException
	{
		// TODO PROJECT #2
		return null; // THIS IS A STUB
	} // end peek

	public T pop() throws InsufficientNumberOfElementsOnStackException
	{
		// TODO PROJECT #2
		return null; // THIS IS A STUB
	} // end pop

	public boolean isEmpty()
	{
		// TODO PROJECT #2
		return false;  //THIS IS A STUB
	} // end isEmpty

	public void clear()
	{
		// TODO PROJECT #2
	} // end clear

	// Throws an exception if this object is not initialized.
	private void checkInitialization() throws SecurityException
	{
		// TODO PROJECT #2
	} // end checkInitialization

	// Throws an exception if the client requests a capacity that is too large.
	private void checkCapacity(int capacity) throws IllegalStateException
	{
		// TODO PROJECT #2
	} // end checkCapacity

	// Doubles the size of the array myStack if it is full
	// Precondition: checkInitialization has been called.
	private void ensureCapacity()
	{
		// TODO PROJECT #2
	} // end ensureCapacity

	// These methods are only for testing of the array implementation
	public int getTopIndex()
	{
		return this.topIndex;
	}
	public int getCapacity() { return this.myStack.length; }

	public static void main(String[] args)
	{
		System.out.println("*** Creating a stack with default constructor ***");
		TextbookStackInterface<String> defaultStack = new ArrayStack<>();
		System.out.println("---> The stack capacity is set by the constructor to: " + defaultStack.getCapacity());
		System.out.println("---> The topIndex is: " + defaultStack.getTopIndex());
		System.out.println("\n---> isEmpty() returns " + defaultStack.isEmpty());

		int topLocation = defaultStack.getTopIndex();
		int capacity = defaultStack.getCapacity();
		if (topLocation == capacity)
			System.out.println("CORRECT - the top index is set to " + capacity);
		else
			System.out.println("INCORRECT - the top index is set to " + topLocation);

		System.out.println("\n---> Adding to stack to get: " +
				"Joe Jane Jill Jess Jim");
		defaultStack.push("Jim");
		defaultStack.push("Jess");
		defaultStack.push("Jill");
		defaultStack.push("Jane");
		defaultStack.push("Joe");
		System.out.println("---> Done adding 5 elements; the topIndex is: " + defaultStack.getTopIndex());
		System.out.println("---> isEmpty() returns " + defaultStack.isEmpty());

		System.out.println("\n--> Testing peek and pop:");
		while (!defaultStack.isEmpty())
		{
			String top = defaultStack.peek();
			System.out.println(top + " is at the top of the stack.");

			top = defaultStack.pop();
			System.out.println(top + " is removed from the stack.");
		} // end while

		System.out.println("--> The stack should be empty: ");
		System.out.println("isEmpty() returns " + defaultStack.isEmpty());

		System.out.println("\n--> Adding to stack to get: " +
				"Jim Jess Joe");
		defaultStack.push("Joe");
		defaultStack.push("Jess");
		defaultStack.push("Jim");
		System.out.println("---> Done adding 3 elements; the topIndex is: " + defaultStack.getTopIndex());
		System.out.println("\n--> Testing clear:");
		defaultStack.clear();

		System.out.println("--> The stack should be empty: ");
		System.out.println("isEmpty() returns " + defaultStack.isEmpty());
		try
		{
			System.out.println("defaultStack.peek() returns: ");
			System.out.println(defaultStack.peek());
		}
		catch (InsufficientNumberOfElementsOnStackException inoeose)
		{
			System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
		}
		try
		{
			System.out.println("defaultStack.pop() returns: ");
			System.out.println(defaultStack.pop());
		}
		catch (InsufficientNumberOfElementsOnStackException inoeose)
		{
			System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
		}

		System.out.println("\n\n*** Creating a stack with the secondary constructor ***");
		TextbookStackInterface<String> smallStack = new ArrayStack<>(3);
		System.out.println("---> The stack capacity is set by the constructor to: " + smallStack.getCapacity());
		System.out.println("---> The topIndex is: " + smallStack.getTopIndex());

		System.out.println("\n--> isEmpty() returns " + smallStack.isEmpty());

		System.out.println("\n--> Adding to stack to get: " +
				"Joe Jane Jill Jess Jim");
		smallStack.push("Jim");
		smallStack.push("Jess");
		smallStack.push("Jill");
		smallStack.push("Jane");
		smallStack.push("Joe");

		System.out.println("---> Done adding 5 elements; the topIndex is: " + smallStack.getTopIndex());
		System.out.println("--> isEmpty() returns " + smallStack.isEmpty());

		System.out.println("\n-->Testing peek and pop:");
		while (!smallStack.isEmpty())
		{
			String top = smallStack.peek();
			System.out.println(top + " is at the top of the stack.");

			top = smallStack.pop();
			System.out.println(top + " is removed from the stack.");
		} // end while

		System.out.println("--> The stack should be empty: ");
		System.out.println("isEmpty() returns " + smallStack.isEmpty());
		topLocation = smallStack.getTopIndex();
		capacity = smallStack.getCapacity();
		if (topLocation == capacity)
			System.out.println("CORRECT - the top index is set to " + capacity);
		else
			System.out.println("INCORRECT - the top index is set to " + topLocation);

		System.out.println("\n--> Adding to stack to get: " +
				"Jim Jess Joe");
		smallStack.push("Joe");
		smallStack.push("Jess");
		smallStack.push("Jim");
		System.out.println("---> Done adding 3 elements; the topIndex is: " + smallStack.getTopIndex());

		System.out.println("\n--> Testing clear:");
		smallStack.clear();
		System.out.println("--> The stack should be empty: ");
		System.out.println("isEmpty() returns " + smallStack.isEmpty());
		try
		{
			System.out.println("smallStack.peek() returns: ");
			System.out.println(smallStack.peek());
		}
		catch (InsufficientNumberOfElementsOnStackException inoeose)
		{
			System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
		}
		try
		{
			System.out.println("smallStack.pop() returns: ");
			System.out.println(smallStack.pop());
		}
		catch (InsufficientNumberOfElementsOnStackException inoeose)
		{
			System.out.println(" CORRECT - exception has been thrown: " + inoeose.getMessage());
		}

		System.out.println("*** Done ***");
	} // end main
} // end ArrayStack