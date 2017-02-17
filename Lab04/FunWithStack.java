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
        // TODO PROJECT #1 done
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        try
        {
            do
            {
                System.out.println("\nPlease enter a positive integer, or type \"stop\"");
                int decimalNumber = keyboard.nextInt();

                if (decimalNumber < 0) {
                    System.out.println("Integer must be positive. Try again.");
                    continue;
                } else if (decimalNumber == 0) {
                    stack.push(0);
                } else {
                    for (int number = decimalNumber; number >= 1; number /= 2) {
                        stack.push(number % 2);
                    }
                }

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                System.out.print(decimalNumber + " in binary is --> " + sb);
            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done with conversion.\n");
        }
    }

    public void ancientMultiplier()
    {
        System.out.println("ANCIENT MULTIPLIER");
        Scanner keyboard = new Scanner(System.in);

        // TODO PROJECT #1 done
        // http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
        Stack<Integer> op1 = new Stack<>();
        Stack<Integer> op2 = new Stack<>();

        try
        {
            do
            {
                System.out.println("\nPlease enter the first operand, or type \"stop\":");
                int operand1 = keyboard.nextInt();

                System.out.println("\nPlease enter the second operand:");
                int operand2 = keyboard.nextInt();

                int greaterOp = (operand1 > operand2 ? operand1 : operand2 );
                int lesserOp = (operand1 > operand2 ? operand2 : operand1 );
                while (lesserOp >= 1) {
                    op1.push(lesserOp % 2);
                    lesserOp /= 2;
                    op2.push(greaterOp);
                    greaterOp *= 2;
                }

                int product = 0;
                while (!op1.isEmpty()) {
                    if (op1.pop() == 1) {
                        product += op2.pop();
                    } else {
                        op2.pop();
                    }
                }
                System.out.println(operand1 + " * " + operand2 + " = " + product);
            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done with conversion.\n");
        }
    }

    public ArrayList<Integer> noAdjacentDuplicates(int... input)
    {
        // TODO PROJECT #1 done
        Stack<Integer> stack = new Stack<>();

        System.out.println("input = " + Arrays.toString(input));

        for (int i = 0; i < input.length; i++) {
            if (stack.isEmpty()) {
                stack.push(input[i]);
            } else {
                if (stack.peek() != input[i]) {
                    stack.push(input[i]);
                } else if (i + 1 >= input.length || input[i] != input[i + 1]) {
                    stack.pop();
                }
            }
        }

        Integer array[] = new Integer[stack.size()];
        for (int i = stack.size() - 1; !stack.isEmpty() && i >= 0; i--) {
            array[i] = stack.pop();
        }

        return new ArrayList<>(Arrays.asList(array));
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