package game.map;

import GUI_helper.*;

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
