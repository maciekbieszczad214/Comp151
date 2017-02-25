package Lab04;
/**
 * A class that provides methods for sorting a stack of
 * Comparable objects, placing the smallest at the top of the stack.
 *
 * @author Maciek Bieszczad
 * @version 01/02/2017
 */

import java.util.*;

public class SortStack<T extends Comparable<? super T>>
{
    private Stack<T> stack;

    public SortStack()
    {
        this.stack = new Stack<>();
    }

    /**
     * Sorts a stack.
     *
     * @return a sorted stack
     */
    public Stack<T> sort()
    {
        // TODO PROJECT #6 Part1 done
        // this.stack represents the original stack
        Stack<T> destination = new Stack<>();
        Stack<T> temp = new Stack<>();

        if (!stack.isEmpty()) {
            T current = stack.pop();
            destination.push(current);
            while (!stack.isEmpty()) {
                T topO = stack.pop();
                while (!destination.isEmpty() && destination.peek().compareTo(topO) < 0) {
                    temp.push(destination.pop());
                }
                destination.push(topO);
                while (!temp.isEmpty()) {
                    destination.push(temp.pop());
                }
            }
        }

        return destination;
    }

    /**
     * Sorts a stack. (revised version)
     *
     * @return a sorted stack
     */
    public Stack<T> sortRevised()
    {
        // TODO PROJECT #6 Part2 done
        // this.stack represents the original stack
        Stack<T> destination = new Stack<>();
        Stack<T> temp = new Stack<>();

        if (!stack.isEmpty()) {
            T topO = stack.pop();
            destination.push(topO);

            while (!stack.isEmpty()) {
                topO = stack.pop();
                if (destination.peek().compareTo(topO) < 0) {
                    while (!destination.isEmpty() && destination.peek().compareTo(topO) < 0) {
                        temp.push(destination.pop());
                    }
                } else {
                    while (!temp.isEmpty() && temp.peek().compareTo(topO) > 0) {
                        destination.push(temp.pop());
                    }
                }
                destination.push(topO);
            }

            while (!temp.isEmpty()) {
                destination.push(temp.pop());
            }
        }


        return destination;
    }


    public void setStack(T... elements)
    {
        this.stack.clear();
        System.out.println("Setting the original stack to:");
        for (int i = 0; i < elements.length; i++)
        {
            this.stack.push(elements[i]);
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        SortStack sc = new SortStack();

        sc.setStack("03", "09", "01", "04", "06", "05", "07", "08", "00", "02");
        System.out.println("\n***Calling sort method***");
        Stack<String> sortedStack = sc.sort();
        System.out.println("\nStack should be sorted (with sort()) ....");
        while (!sortedStack.isEmpty())
            System.out.print(sortedStack.pop() + " ");
        System.out.println();

        System.out.println("\n===================================");
        System.out.println("\nTesting the revised method");
        sc.setStack("03", "09", "01", "04", "06", "05", "07", "08", "00", "02");
        System.out.println("\n***Calling sortRevised method***");
        sortedStack = sc.sortRevised();
        System.out.println("\nStack should be sorted (with sortRevised()) ....");
        while (!sortedStack.isEmpty())
            System.out.print(sortedStack.pop() + " ");
        System.out.println();
    } // end main
} // end SortStack