/**
 * @author YOUR NAME GOES HERE
 * @version 12/26/2016
 */

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Dorm
{
    private ArrayList<Resident> residents;
    private Door door;

    /**
     * the constructor creates the door object and the residents object.
     * Reads from the file with the Scanner passed to the constructor and fills
     * the residents list with resident object based on the data retrieved from the file.
     * Must handle invalid data by catching IllegalArgumentException and  NoSuchElementException
     *
     * @param fromFile - the Scanner object that is associated with the text file
     *                   containing the residents data. The Scanner object is created
     *                   by the client
     */
    public Dorm(Scanner fromFile)
    {
        //TODO


    }

    /**
     * Checks if there is a resident of the given name in the list of residents.
     *
     * @param name
     * @return the Resident object or null if not found
     */
    public Resident checkResident(String name)
    {
        //TODO
        return null; // THIS IS A STUB
    }

    /**
     * prints the number of residents in the dorm followed by all the names of the residents,
     * uses for-each loop
     */
    public void displayResidentNames()
    {
        //TODO

    }

    /**
     * validates if the resident can enter the dorm
     * unlocks the door only if the valid credentials were entered
     * prints the current status of the door
     *
     * @param name
     * @param room
     * @param password
     * @return true  - the door was unlocked if the user entered the correct room number and
     *                 the password for the given name
     *         false - the door was not unlocked because either the name was not valid or invalid
     *                 credentials were entered
     */
    public boolean validateAndUnlock(String name, String room, String password)
    {
        //TODO
        return false; // THIS IS A STUB
    }

    /**
     * asks the door object to lock itself
     */
    public void lockTheDoor()
    {
        //TODO

    }
}
