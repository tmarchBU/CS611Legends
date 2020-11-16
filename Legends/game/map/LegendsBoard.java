package game.map;

/*
File: LegendsBoard.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Board, representing a Legends Board
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.*;
import game.rules.LegendsRules;
import utilities.RandomHelper;

public class LegendsBoard extends Board
{
    /*
    CONSTRUCTORS
    */
    public LegendsBoard()
    {
        setBoard(new Cell[LegendsRules.BOARD_HEIGHT][LegendsRules.BOARD_WIDTH]);

        int numCells = LegendsRules.BOARD_WIDTH * LegendsRules.BOARD_HEIGHT;
        ArrayList<Moveable> cells = new ArrayList<Moveable>();
        
        for (int i = 0; i < numCells*LegendsRules.BOARD_INACCESSIBLE_LEVEL; i++)
        {
            cells.add(new InaccessibleCell());
        }
        for (int i = 0; i < numCells*LegendsRules.BOARD_MARKET_LEVEL; i++)
        {
            cells.add(new MarketCell());
        }
        while (cells.size() < numCells)
        {
            cells.add(new CommonCell());
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                Moveable cell = RandomHelper.removeRandom(cells);
                board[i][j] = (Cell) cell;
            }
        }
        setCellAdjacents();
    }

    /*
    printLegend - prints the icons of the Legends board
    */
    public void printLegend()
    {
        System.out.print(TextColors.BLUE + Icons.PLAYER_ICON + TextColors.RESET + " = Your Location | ");
        System.out.print(TextColors.RED + Icons.INACCESSIBLE_ICON + " " + TextColors.RESET + " = Inaccessible Area | ");
        System.out.print(TextColors.GREEN + Icons.LIGHT_SHADE + Icons.LIGHT_SHADE + TextColors.RESET + " = Normal Area | ");
        System.out.println(TextColors.YELLOW + Icons.MARKET_ICON + " " + TextColors.RESET + " = Marketplace");
    }
}
