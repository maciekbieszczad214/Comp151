package Lab04;

import java.text.DecimalFormat;
import java.util.*;

/**
 * A class that implements math operations utilizing a stack.
 *
 * @author Maciek Bieszczad
 * @version 01/02/2017
 */
public class FunWithStack
{
    public void decimalToBinary()
    {
        System.out.println("DECIMAL TO BINARY CONVERTER");
        // TODO PROJECT #1
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        try
        {
            do
            {
                System.out.println("\nPlease enter a positive integer, or type \"stop\"");
                int decimalNumber = keyboard.nextInt();

                System.out.print(decimalNumber + " in binary is --> ");

                // YOUR CODE GOES HERE

                for (int number = decimalNumber; number >= 1; number /= 2)
                {
                    stack.push(number % 2);
                }

                System.out.println();
            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done with conversion.\n");
        }
    }

    public void ancientMultiplier()
    {
        // TODO PROJECT #1
        // http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
        Stack<Integer> op1 = new Stack<>();
        Stack<Integer> op2 = new Stack<>();



    }

    public ArrayList<Integer> noAdjacentDuplicates(int... input)
    {
        // TODO PROJECT #1
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        System.out.println("input = " + Arrays.toString(input));



        return result;
    }


    public static void main(String[] args)
    {
        FunWithStack funWithStack = new FunWithStack();
        System.out.println("*** DECIMAL TO BINARY CONVERTER ***");
        funWithStack.decimalToBinary();
        System.out.println("*** ANCIENT MULTIPLIER ***");
        funWithStack.ancientMultiplier();

        System.out.println("*** ELIMINATING ADJACENT DUPLICATES ***");

        System.out.println("--> testcase #1");
        ArrayList<Integer> result = funWithStack.noAdjacentDuplicates(1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        if (result.equals(expected))
            System.out.println("result = " + result + " CORRECT");
        else
        {
            System.out.println("INCORRECT, expected: " + expected);
            System.out.println("got: " + result);
        }

        System.out.println("\n---> testcase #2");
        result = funWithStack.noAdjacentDuplicates(1, 9, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5);
        expected.clear();
        expected.add(1);
        expected.add(9);
        expected.add(5);
        if (result.equals(expected))
            System.out.println("result = " + result + " CORRECT");
        else
        {
            System.out.println("INCORRECT, expected: " + expected);
            System.out.println("got: " + result);
        }

        System.out.println("\n---> testcase #3");
        result = funWithStack.noAdjacentDuplicates(1, 1, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5);
        expected.clear();
        expected.add(5);
        if (result.equals(expected))
            System.out.println("result = " + result + " CORRECT");
        else
        {
            System.out.println("INCORRECT, expected: " + expected);
            System.out.println("got: " + result);
        }

        System.out.println("\n---> testcase #4");
        result = funWithStack.noAdjacentDuplicates(1, 1, 1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5);
        expected.clear();
        if (result.equals(expected))
            System.out.println("result = " + result + " CORRECT");
        else
        {
            System.out.println("INCORRECT, expected: " + expected);
            System.out.println("got: " + result);
        }

        System.out.println("Done!");
    }
}