package factories;

/*
File: HandheldFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Handheld Items
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.handheld_items.*;
import utilities.*;

public class HandheldFactory 
{
    /*
    getHandheld - takes in the type of armor as an input and returns a random piece from it's file
    */
    public Handheld getHandheld(String handheldType)
    {
        Handheld handheld = null;
        if (handheldType.equalsIgnoreCase("WEAPON"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> weapons = parser.parse("/info_files/Weaponry.txt");
            String[] temp = RandomHelper.getRandom(weapons);
            handheld = new Weapon(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[5]), Integer.parseInt(temp[4]), Integer.parseInt(temp[3]), Integer.parseInt(temp[2]));
        }
        else if (handheldType.equalsIgnoreCase("SHIELD"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> shields = parser.parse("/info_files/Shields.txt");
            String[] temp = RandomHelper.getRandom(shields);
            handheld = new Shield(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[5]), Integer.parseInt(temp[4]), Integer.parseInt(temp[3]), Integer.parseInt(temp[2]));
        }
        
        return handheld;
    }
}
