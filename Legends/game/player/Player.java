package game.player;

/*
File: Player.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Superclass Player of any game
*/

/*
Imported Libraries
*/
import game.map.Marker;

public class Player 
{
    private String name;
    private String ID;
    private Marker marker;
    
    /*
    CONSTRUCTORS
    */
    public Player(String name, String ID, Marker marker)
    {
        setName(name);
        setID(ID);
        setMarker(marker);
    }

    /*
    SETTERS
    */
    public void setName(String name)
    {
        this.name = name;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

    /*
    ACCESSORS
    */
    public String getName()
    {
        return name;
    }

    public String getID()
    {
        return ID;
    }

    public Marker getMarker()
    {
        return marker;
    }

    /*
    toString
    */
    public String toString()
    {
        return name;
    }
}
