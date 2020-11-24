package game.map;

/*
File: KoulouCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a Koulou cell. Used for Legends Valor
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import game.rules.LegendsValorRules;
import utilities.RandomHelper;

public class LegendsValorBoard extends Board
{
    /*
    CONSTRUCTORS
    */
    public LegendsValorBoard()
    {
        int boardWidth = (LegendsValorRules.NUM_LANES*2) + (LegendsValorRules.NUM_LANES-1);
        setBoard(new Cell[LegendsValorRules.BOARD_HEIGHT][boardWidth]);

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length; j++)
            {
                if ((j+1) % 3 == 0)
                {
                    board[i][j] = new InaccessibleCell();
                }
                else if (i == 0 || i == board[0].length - 1)
                {
                    board[i][j] = new NexusCell();
                }
            }
        }

        int numCells = (LegendsValorRules.BOARD_HEIGHT - 2)*(boardWidth - (LegendsValorRules.NUM_LANES - 1));
        ArrayList<Moveable> cells = new ArrayList<Moveable>();

        for (int i = 0; i < numCells*LegendsValorRules.BOARD_PLAINCELL_LEVEL; i++)
        {
            cells.add(new CommonCell());
        }
        for (int i = 0; i < numCells*LegendsValorRules.BOARD_BUSHCELL_LEVEL; i++)
        {
            cells.add(new BushCell());
        }
        for (int i = 0; i < numCells*LegendsValorRules.BOARD_CAVECELL_LEVEL; i++)
        {
            cells.add(new CaveCell());
        }
        for (int i = 0; i < numCells*LegendsValorRules.BOARD_KOULOUCELL_LEVEL; i++)
        {
            cells.add(new KoulouCell());
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == null)
                {
                    Moveable cell = RandomHelper.removeRandom(cells);
                    board[i][j] = (Cell) cell;
                }
            }
        }

        setCellAdjacents();
    }

    public void printLegend()
    {
        System.out.print(InaccessibleCell.marker + " = Inaccessible Area | ");
        System.out.print(CommonCell.marker + " = Plain Area | ");
        System.out.print(NexusCell.marker + " = Nexus | ");
        System.out.print(BushCell.marker + " = Bush | ");
        System.out.print(CaveCell.marker + " = Cave | ");
        System.out.println(KoulouCell.marker + " = Koulou");
    }
}
