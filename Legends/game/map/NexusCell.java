package game.map;

/*
File: NexusCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a Nexus cell. Used for Legends Valor
*/

/*
Imported Libraries
*/
import GUI_helper.*;
import game.Nexus;

public class NexusCell extends Cell
{
    public static final Marker marker = new Marker(TextColors.YELLOW + Icons.MARKET_ICON + " " + TextColors.RESET);
    private Nexus nexus;

    /*
    CONSTRUCTORS 
    */
    public NexusCell()
    {
        super(marker);
    }

    public void setNexus(Nexus nexus)
    {
        this.nexus = nexus;
    }

    public Nexus getNexus()
    {
        return nexus;
    }
}
