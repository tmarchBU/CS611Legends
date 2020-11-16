package game;

/*
File: PlayLegends.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Entry point into Legends that sets up the player and the rules before creating the game and playing it
*/

/*
Imported Libraries
*/
import GUI_helper.*;
import game.map.Marker;
import game.player.LegendsPlayer;
import game.rules.LegendsRules;
import utilities.InputUtility;

public class PlayLegends 
{
    /*
    run - entry point into LegendsGame allowing for configuration before the game begins
    */
    public static void run()
    {
        InputUtility input = InputUtility.getSingleInstance();
        String stringInput;

        System.out.println("Enter your name: ");
        String name = input.inputString();
        Marker marker = new Marker(TextColors.BLUE + Icons.PLAYER_ICON + " " + TextColors.RESET);

        LegendsPlayer player = new LegendsPlayer(name, marker);

        System.out.println("Would you like to configure your game? (yes/no)");
        stringInput = input.yesNo();
        if (stringInput.equalsIgnoreCase("YES"))
        {
            LegendsRules.configure();
        }
        
        LegendsGame game = new LegendsGame(player);

        System.out.println("Press Enter to begin the game");

        input.pressEnter();
        
        game.play();
    }
}
