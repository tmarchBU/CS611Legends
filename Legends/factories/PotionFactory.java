package factories;

/*
File: PotionFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Potions
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.consumables.Potion;
import utilities.*;

public class PotionFactory 
{
    /*
    getPotion - returns a random potion from it's file
    */
    public Potion getPotion()
    {
        Potion potion = null;
        
        FileParser parser = FileParser.getSingleInstance();
        ArrayList<String[]> potions = parser.parse("/info_files/Potions.txt");
        String[] temp = RandomHelper.getRandom(potions);

        String[] attributes = temp[4].split("/");

        potion = new Potion(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), attributes);
    
        return potion;
    } 
}
