package LabINIT;

/**
 * @author Maciek Bieszczad
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
        //TODO done
        door = new Door();
        residents = new ArrayList<Resident>();
        System.out.println("Processing residents list...");
        while (fromFile.hasNextLine()) {
            try {
                String line = fromFile.nextLine();
                Scanner lineScan = new Scanner(line).useDelimiter(":");
                String name = lineScan.next();
                int room = lineScan.nextInt();
                String password = lineScan.next();
                Resident resident = new Resident(name, Integer.toString(room), password);
                System.out.println("  " + resident);
                residents.add(resident);
            } catch (IllegalArgumentException e) {
                System.out.println("*** Error: Illegal argument, skipping to next line ***");
            } catch (NoSuchElementException e) {
                System.out.println("*** Error: No such element, skipping to next line ***");
            }
        }
        System.out.println();
    }

    /**
     * Checks if there is a resident of the given name in the list of residents.
     *
     * @param name
     * @return the Resident object or null if not found
     */
    public Resident checkResident(String name)
    {
        //TODO done
        Resident result = null;
        for (Resident resident : residents) {
            if (resident.getName().equalsIgnoreCase(name)) {
                result = resident;
                break;
            }
        }
        return result;
    }

    /**
     * prints the number of residents in the dorm followed by all the names of the residents,
     * uses for-each loop
     */
    public void displayResidentNames()
    {
        //TODO done
        System.out.println("There are " + residents.size() + " residents in the dorm:");
        for (Resident resident : residents) {
            System.out.println("  " + resident);
        }
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
        //TODO done
        Resident resident = checkResident(name);
        boolean match = false;
        if (resident != null && resident.getRoom().equalsIgnoreCase(room) &&
                resident.getPassword().equals(password)) {
            match = true;
            door.unlock();
        }
        System.out.println(door);
        return match;
    }

    /**
     * asks the door object to lock itself
     */
    public void lockTheDoor()
    {
        //TODO done
        door.lock();
    }
}
