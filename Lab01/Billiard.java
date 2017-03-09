import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

/**
 * This class determines how long it would take to remove billiard balls from a table,
 * where ball n is replaced by n balls with randomly generated numbers between 1 and n-1.
 *
 * @version 12/27/2016
 * @updatedBy YOUR NAME GOES HERE
 */
public class Billiard
{
    private BagInterface<Integer> table;

    /**
     * constructor creates this.table object as ResizableArrayBag
     */
    public Billiard()
    {
        this.table = new ResizableArrayBag<>();
    }

    /**
     * prompts the user for the first numbered ball and adds it to this.table
     */
    public void addFirstElement()
    {
        Scanner keyboard = new Scanner(System.in);
        int start;
        do
        {
            System.out.println("What is the first numbered ball to start with? (must be greater than 0)");
            start = keyboard.nextInt();
        } while (start < 1);

        System.out.println("The first ball is: \"" + start + "\"");
        this.table.add(start);
    }// end addFirstElement

    /**
     * Removes balls from this.table until all are gone.
     */
    public void removeBallsFromTable()
    {
        System.out.println("\n*** Removing balls from the table ***\n");
        //TODO
        System.out.println("\nThe table is empty!!!");
    } // end removeBallsFromTable

    /**
     * Displays the content of this.table
     */
    private void displayBag()
    {
        Object[] bagArray = this.table.toArray();
        System.out.println(Arrays.toString(bagArray));
        System.out.println();
    } // end displayBag

    public static void main(String args[])
    {
        Billiard billiard = new Billiard();
        billiard.addFirstElement();

        long startTime = Calendar.getInstance().getTime().getTime(); // get current time in miliseconds

        billiard.removeBallsFromTable();

        long stopTime = Calendar.getInstance().getTime().getTime();

        System.out.println("\nThe time required was " + (stopTime - startTime) + " milliseconds");
    } // end main
} // end Billiard