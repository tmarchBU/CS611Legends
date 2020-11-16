package factories;

/*
File: HeroFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Heroes
*/

/*
Imported Libraries
*/
import characters.*;
import game.rules.LegendsRules;
import items.armor.NoArmor;
import items.handheld_items.NoWeapon;
import utilities.*;
import java.util.*;

public class HeroFactory 
{
    /*
    getHero - takes in the type of hero as an input and returns a random hero from it's file
    */
    public Hero getHero(String heroType)
    {
        Hero hero = null;
        if (heroType.equalsIgnoreCase("WARRIOR"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> warriors = parser.parse("/info_files/Warriors.txt");
            String[] temp = RandomHelper.getRandom(warriors);
            hero = new Warrior(temp[0].replace("_", " "), true, 1, (int) LegendsRules.HERO_HEALTH_LEVEL, Integer.parseInt(temp[6]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[1]), new NoArmor(), new NoWeapon());
        }
        else if (heroType.equalsIgnoreCase("PALADIN"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> paladins = parser.parse("/info_files/Paladins.txt");
            String[] temp = RandomHelper.getRandom(paladins);
            hero = new Paladin(temp[0].replace("_", " "), true, 1, (int) LegendsRules.HERO_HEALTH_LEVEL, Integer.parseInt(temp[6]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[1]), new NoArmor(), new NoWeapon());
        }
        else if (heroType.equalsIgnoreCase("SORCERER"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> sorcerers = parser.parse("/info_files/Sorcerers.txt");
            String[] temp = RandomHelper.getRandom(sorcerers);
            hero = new Sorcerer(temp[0].replace("_", " "), true, 1, (int) LegendsRules.HERO_HEALTH_LEVEL, Integer.parseInt(temp[6]), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]), Integer.parseInt(temp[1]), new NoArmor(), new NoWeapon());
        }
        
        return hero;
    }
}
