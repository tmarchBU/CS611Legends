package game;

/*
File: SinglePlayerGame.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Superclass SinglePlayerGame that represents a singleplayer game
*/

/*
Imported Libraries
*/
import game.player.Player;

public abstract class SinglePlayerGame extends Game
{
    private Player player;

    /*
    CONSTRUCTORS
    */
    public SinglePlayerGame(Player player, String name)
    {
        super(name);
        setPlayer(player);
    }

    /*
    SETTERS
    */
    public void setPlayer(Player player)
    {
        this.player = player;
    }

    /*
    GETTERS
    */
    public Player getPlayer()
    {
        return player;
    }
}
