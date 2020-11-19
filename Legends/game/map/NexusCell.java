package game.map;

import GUI_helper.Icons;
import GUI_helper.TextColors;

public class NexusCell extends Cell
{
    public static final Marker marker = new Marker(TextColors.YELLOW + Icons.MARKET_ICON + " " + TextColors.RESET);

    /*
    CONSTRUCTORS 
    */
    public NexusCell()
    {
        super(marker);
    }
}
