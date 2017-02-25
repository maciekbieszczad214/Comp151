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
        // TODO PROJECT #4 done
        boolean result = true;
        String stripped = input.replaceAll("[\\W]", "").toLowerCase();
        System.out.println("--> Checking: \"" + stripped + "\"");
        int length = stripped.length();
        if (length > 1) {
            Stack<Character> stack = new Stack<>();
            int index = 0;
            while (index < length / 2) {
                stack.push(stripped.charAt(index++));
            }
            index += length % 2;
            while (result && !stack.isEmpty()) {
                if (!stack.pop().equals(stripped.charAt(index++))) {
                    result = false;
                }
            }
        }
        return result;
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