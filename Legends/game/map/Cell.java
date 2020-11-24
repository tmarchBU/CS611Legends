package game.map;

import java.util.ArrayList;
import characters.RPGCharacter;
import game.rules.LegendsValorRules;

/*
File: Cell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A cell of a board
*/

public class Cell implements Moveable
{
    private ArrayList<RPGCharacter> characters; 
    private Marker marker;         
    private Cell above;             // holds reference to the cell above it
    private Cell below;             // holds reference to the cell below it
    private Cell left;              // holds reference to the cell left of it
    private Cell right;             // holds reference to the cell right of it

    /*
    CONSTRUCTORS
    */
    public Cell()
    {
        setMarker(null);
        setCharacters(new ArrayList<RPGCharacter>());
        setAbove(null);
        setBelow(null);
        setRight(null);
        setLeft(null);
    }

    public Cell(Marker marker)
    {
        this();
        setMarker(marker);
    }

    // GETTER METHODS

    public ArrayList<RPGCharacter> getCharacters()
    {
        return characters;
    }

    public Marker getMarker()
    {
        return this.marker;
    }

    public Cell getAbove()
    {
        return above;
    }

    public Cell getBelow()
    {
        return below;
    }

    public Cell getLeft()
    {
        return left;
    }

    public Cell getRight()
    {
        return right;
    }

    // SETTER METHODS

    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

    public void setCharacters(ArrayList<RPGCharacter> characters)
    {
        this.characters = characters;
    }

    public void setAbove(Cell cell)
    {
        this.above = cell;
    }

    public void setBelow(Cell cell)
    {
        this.below = cell;
    }

    public void setRight(Cell cell)
    {
        this.right = cell;
    }

    public void setLeft(Cell cell)
    {
        this.left = cell;
    }

    /*
    Moveable Methods
    */
    public boolean enter(RPGCharacter character)
    {
        if (getCharacters().size() < LegendsValorRules.MAX_CHARACTERS_PER_CELL)
        {
            return getCharacters().add(character);
        }

        return false;
    }

    public boolean enterable()
    {
        return (getCharacters().size() < LegendsValorRules.MAX_CHARACTERS_PER_CELL);
    }

    public boolean exit(RPGCharacter character)
    {
        return getCharacters().remove(character);
    }
}// end class
