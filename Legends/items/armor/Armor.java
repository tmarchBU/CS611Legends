package items.armor;

/*
File: Armor.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Abstract superclass Armor, representing a piece of armor
*/

/*
Imported Libraries
*/
import items.*;

public abstract class Armor extends Item implements LevelRequired, Storable
{
    public static String[] printHelper = {"Name", "Level Required", "Cost", "Damage Reduction"};
    private int levelRequired;
    private int armorValue;

    /*
    CONSTRUCTORS
    */
    public Armor(String name, int moneyValue, int levelRequired, int armorValue)
    {
        super(name, moneyValue);
        setLevelRequired(levelRequired);
        setArmorValue(armorValue);
    }

    /*
    SETTERS
    */
    public void setLevelRequired(int levelRequired)
    {
        this.levelRequired = levelRequired;
    }

    public void setArmorValue(int armorValue)
    {
        this.armorValue = armorValue;
    }

    /*
    ACCESSORS
    */
    public int getLevelRequired()
    {
        return levelRequired;
    }

    public int getArmorValue()
    {
        return armorValue;
    }
}
