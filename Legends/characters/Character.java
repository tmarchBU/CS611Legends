package characters;

/*
File: Character.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Abstract superclass for any video game character
*/

public abstract class Character 
{
    private String name;
    private boolean isAI;

    /*
    CONSTRUCTORS
    */
    public Character(String name, boolean isAI)
    {
        setName(name);
        setIsAI(isAI); 
    }

    /*
    SETTERS
    */

    public void setName(String name)
    {
        this.name = name;
    }

    public void setIsAI(boolean isAI)
    {
        this.isAI = isAI;
    }

    /*
    ACCESSORS
    */

    public String getName()
    {
        return name;
    }

    public boolean getIsAI()
    {
        return isAI;
    }

    /*
    toString
    */
    public String toString()
    {
        return name;
    }
}
