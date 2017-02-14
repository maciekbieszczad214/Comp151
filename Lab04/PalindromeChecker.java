package Lab04;

/**
 * PalindromeChecker
 *
 * @author Maciek Bieszczad
 * @version 01/02/2017
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker
{
    /**
     * Tests whether a string is a palindrome, ignoring punctuation, spaces, and case.
     *
     * @param input a string to check
     */
    public boolean isPalindrome(String input)
    {
        // TODO PROJECT #4
        // push half of the characters on the stack

        // in another loop pop characters from the stack and compare with the remaining characters in the input string
        // stop the loop as soon as the first unequal pair is found

        return false; // THIS IS A STUB
    } // end isPalindrome

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        PalindromeChecker pc = new PalindromeChecker();

        //Describe the program and how it works
        System.out.println("*** This program determines whether a string is a palindrome. ");
        System.out.println("A palindrome is spelled the same from left to right as it is from right to left,");
        System.out.println("if we ignore punctuation, spaces, and case. ***");

        System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");
        String input = keyboard.nextLine();

        while (!input.equalsIgnoreCase("stop"))
        {
            if (pc.isPalindrome(input))
                System.out.println("\"" + input + "\" is a palindrome!");
            else
                System.out.println("\"" + input + "\" is not a palindrome!");

            System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");
            input = keyboard.nextLine();
        } // end while

        System.out.println("Done!");
    } // end main
} // end PalindromeChecker