package game;

import characters.RPGCharacter;

/*
File: RPGGame2.java (based on RPGGame.java)
Developer: Tristan Marchand, Shuaike Zhou
Email: tmarch@bu.edu, szhou97@bu.edu
Last Edited: Thursday, November 19, 2020

Description: Superclass RPGGame that represents any rpggame with a map and a location of a player
UPDATE: Now RPGGame no longer keeps track of player location, instead each rpg character shall
keep track of its own location
*/

/*
Imported Libraries
*/
import game.map.*;
import game.player.Player;

public abstract class RPGGame extends SinglePlayerGame 
{
    private Board board;

    /*
    CONSTRUCTORS
    */
    public RPGGame(Player player, String name, Board board)
    {
        super(player, name);
        setBoard(board);
    }

    /*
    SETTERS
    */
    public void setBoard(Board board)
    {
        this.board = board;
    }

    /*
    ACCESSORS
    */
    public Board getBoard()
    {
        return board;
    }

    public Cell getLocation(RPGCharacter character)
    {
        return character.getLocation();
    }

    /*
    move - moves a player to a cell and returns true, or returns false if not able to move there
    */
    public boolean move(Moveable nextCell, RPGCharacter character)
    {
        Cell currentCell = character.getLocation();
        if (currentCell == null || nextCell == null || !nextCell.enterable())
        {
            return false;
        } else {
            currentCell.exit(character);
            nextCell.enter(character);
            character.setLocation((Cell) nextCell);
            return true;
        }
    }
}
