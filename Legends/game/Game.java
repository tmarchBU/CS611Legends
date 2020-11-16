package game;

/*
File: Game.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Abstract superclass Game to represent a game
*/

public abstract class Game 
{
    private String name;

    /*
    CONSTRUCTORS
    */
    public Game(String name)
    {
        setName(name);
    }

    /*
    SETTERS
    */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
    ACCESSORS
    */
    public String getName()
    {
        return name;
    }

    /*
    toString
    */
    public String toString()
    {
        return name;
    }
}
