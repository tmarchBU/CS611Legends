package game;

/*
File: RPGGame.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Superclass RPGGame that represents any rpggame with a map and a location of a player
*/

/*
Imported Libraries
*/
import game.map.*;
import game.player.Player;

public abstract class RPGGame extends SinglePlayerGame 
{
    private Board board;
    private Cell playerLocation;

    /*
    CONSTRUCTORS
    */
    public RPGGame(Player player, String name, Board board)
    {
        super(player, name);
        setBoard(board);
        setPlayerLocation(null);
    }

    /*
    SETTERS
    */
    public void setBoard(Board board)
    {
        this.board = board;
    }

    public void setPlayerLocation(Cell playerLocation)
    {
        this.playerLocation = playerLocation;
    }

    /*
    ACCESSORS
    */
    public Cell getPlayerLocation()
    {
        return playerLocation;
    }

    public Board getBoard()
    {
        return board;
    }

    /*
    move - moves a player to a cell and returns true, or returns false if not able to move there
    */
    public boolean move(Moveable cell)
    {
        if (getPlayerLocation() == null || cell == null || !cell.enterable())
        {
            return false;
        }
        else
        {
            getPlayerLocation().exit();
            cell.enter(getPlayer().getMarker());
            setPlayerLocation((Cell) cell);
            return true;
        }
    }
}
