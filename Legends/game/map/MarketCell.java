package game.map;

/*
File: MarketCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a market cell. Used for Legends
*/

/*
Imported Libraries
*/
import GUI_helper.*;

public class MarketCell extends Cell
{
    private static final Marker marker = new Marker(TextColors.YELLOW + Icons.MARKET_ICON + " " + TextColors.RESET);

    /*
    CONSTRUCTORS
    */
    public MarketCell()
    {
        super(marker);
    }

    /*
    Moveable Methods
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
