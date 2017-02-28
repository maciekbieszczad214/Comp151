package Lab05;

import java.util.Scanner;

/**
 * The class recursively generates strings of n numbers
 *
 * @author YOUR NAME
 * @version 1/02/2017
 */

public class StringsOfNumbers
{
    /**
     * bitString - a recursive function that generates strings of n bits
     *
     * @param n    the number of digits
     * @param str  one permutation of the string to be constructed and printed
     */
    private static void bitString(String str, int n)
    {
        // TODO Project #2 done
        if (str.length() == 0) {
            str = Integer.toString((int) Math.pow(2, n), 2);
            kString(str, n, 2);
        } else {
            int i = Integer.parseInt(str, 2) - 1;
            str = String.format("%" + n + "s", Integer.toString(i, 2)).replace(" ", "0");
            System.out.println(str);
            if (i > 0) {
                bitString(str, n);
            }
        }
    }

    /**
     * bitString - a recursive function that generates strings of n digits [0..k)
     *
     * @param n    the number of digits
     * @param k    k-1 should be the largest digit in the string str
     * @param str  one permutation of the string to be constructed and printed
     */
    private static void kString(String str, int n, int k)
    {
        // TODO Project #2 done
        if (str.length() == 0) {
            str = Integer.toString((int) Math.pow(k, n), k);
            kString(str, n, k);
        } else {
            int i = Integer.parseInt(str, k) - 1;
            str = String.format("%" + n + "s", Integer.toString(i, k)).replace(" ", "0");
            System.out.println(str);
            if (i > 0) {
                kString(str, n, k);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter an integer value of n representing the number of digits in a string");
        int n = input.nextInt();
        System.out.println();
        System.out.println("Generating binary-Strings:");
        bitString("", n);
        System.out.println();
        System.out.println("Please enter an integer value k; strings of length n will be drown from 0..k-1");

        int k = input.nextInt();
        System.out.println("Generating k-Strings:");
        kString("", n, k);
    }
}
