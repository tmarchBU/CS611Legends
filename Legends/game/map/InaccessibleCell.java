package game.map;

/*
File: InaccessibleCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a inaccessible cell. Used for Legends
*/

/*
Imported Libraries
*/
import GUI_helper.*;

public class InaccessibleCell extends Cell
{
    private static final Marker marker = new Marker(TextColors.RED + Icons.INACCESSIBLE_ICON + " " + TextColors.RESET);

    /*
    CONSTRUCTORS
    */
    public InaccessibleCell()
    {
        super(marker);
    }

    /*
    Moveable Methods
    */
    public boolean enterable()
    {
        return false;
    }

    public boolean enter(Marker marker)
    {
        return false;
    }

    public boolean exit()
    {
        return false;
    }
}
