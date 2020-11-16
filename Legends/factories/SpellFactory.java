package factories;

/*
File: SpellFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Spells
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.spells.*;
import utilities.*;

public class SpellFactory 
{
    /*
    getSpell - takes in the type of spell as an input and returns a random spell from it's file
    */
    public Spell getSpell(String spellType)
    {
        Spell spell = null;
        if (spellType.equalsIgnoreCase("FIRE"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> spells = parser.parse("/info_files/FireSpells.txt");
            String[] temp = RandomHelper.getRandom(spells);
            spell = new FireSpell(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (spellType.equalsIgnoreCase("ICE"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> spells = parser.parse("/info_files/IceSpells.txt");
            String[] temp = RandomHelper.getRandom(spells);
            spell = new IceSpell(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (spellType.equalsIgnoreCase("LIGHTNING"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> spells = parser.parse("/info_files/LightningSpells.txt");
            String[] temp = RandomHelper.getRandom(spells);
            spell = new LightningSpell(temp[0].replace("_", " "), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        
        return spell;
    }    
}
