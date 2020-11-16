package game.map;

/*
File: CommonCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a common cell. Used for Legends
*/

/*
Imported Libraries
*/
import GUI_helper.*;

public class CommonCell extends Cell
{
    private static final Marker marker = new Marker(TextColors.GREEN + Icons.LIGHT_SHADE + Icons.LIGHT_SHADE + TextColors.RESET);

    /*
    CONSTRUCTORS
    */
    public CommonCell()
    {
        super(marker);
    }

    /*
    MOVEABLE METHODS
    */
    public boolean enterable()
    {
        return true;
    }

    public boolean enter(Marker marker)
    {
        setMarker(marker);

        return true;
    }

    public boolean exit()
    {
        setMarker(marker);

        return true;
    }
}
