package factories;

/*
File: ArmorFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Armor
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.armor.*;
import utilities.*;

public class ArmorFactory 
{
    /*
    getArmor - takes in the type of armor as an input and returns a random piece from it's file
    */
    public Armor getArmor(String armorType)
    {
        Armor armor = null;
        if (armorType.equalsIgnoreCase("FULLBODY"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> pieces = parser.parse("/info_files/FullBodyArmor.txt");
            String[] temp = RandomHelper.getRandom(pieces);
            armor = new FullBody(temp[0].replace("_", " "), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[1]));
        }
        else if (armorType.equalsIgnoreCase("GLOVES"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> pieces = parser.parse("/info_files/GlovesArmor.txt");
            String[] temp = RandomHelper.getRandom(pieces);
            armor = new Gloves(temp[0].replace("_", " "), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[1]));
        }
        else if (armorType.equalsIgnoreCase("HELMET"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> pieces = parser.parse("/info_files/HelmetArmor.txt");
            String[] temp = RandomHelper.getRandom(pieces);
            armor = new Helmet(temp[0].replace("_", " "), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[1]));
        }
        if (armorType.equalsIgnoreCase("BOOTS"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> pieces = parser.parse("/info_files/BootsArmor.txt");
            String[] temp = RandomHelper.getRandom(pieces);
            armor = new Boots(temp[0].replace("_", " "), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[1]));
        }
        if (armorType.equalsIgnoreCase("SPLITBODY"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> pieces = parser.parse("/info_files/BodyArmor.txt");
            String[] temp = RandomHelper.getRandom(pieces);
            armor = new SplitBody(temp[0].replace("_", " "), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[1]));
        }
        
        return armor;
    }
}
