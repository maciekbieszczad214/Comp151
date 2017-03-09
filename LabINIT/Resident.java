package LabINIT;

/**
 * @author Maciek Bieszczad
 * @version 01/02/2016
 */
public class Resident
{
    private final int MIN_PASSWORD_LENGTH = 3;
    private String name;
    private String room;
    private String password;

    /**
     * the constructor  - calls the mutator methods
     *
     * @param name
     * @param room
     * @param password
     */
    public Resident(String name, String room, String password)
    {
        //TODO done
        setName(name);
        setRoom(room);
        setPassword(password);
    }

    /**
     * accessor method
     *
     * @return the value of name
     */
    public String getName()
    {
        //TODO done
        return name;
    }

    /**
     * mutator method  - sets the name to the new value
     *
     * @param name
     */
    public void setName(String name)
    {
        //TODO done
        this.name = name;
    }

    /**
     * accesor method
     *
     * @return the value of room
     */
    public String getRoom()
    {
        //TODO done
        return room;
    }

    /**
     * mutator method  - sets the room to the new value
     *
     * @param room
     */
    public void setRoom(String room)
    {
        //TODO done
        this.room = room;
    }

    /**
     * accesor method
     *
     * @return the value of room
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * mutator method - sets the password to the new value if it has at least three characters
     *                  throws IllegalArgumentException otherwise
     *
     * @param password
     * @throws IllegalArgumentException
     */
    public void setPassword(String password) throws IllegalArgumentException
    {
        //TODO done
        if (password.length() >= 3) {
            this.password = password;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * toString() method
     *
     * @return the String object containing the resident information
     */
    public String toString()
    {
        //TODO done
        return "Resident: " + name + " (room: " + room + ", password: " + password + ")";
    }
}
