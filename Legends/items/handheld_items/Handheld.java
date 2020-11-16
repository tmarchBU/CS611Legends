package items.handheld_items;

/*
File: Handheld.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: An abstract handheld item
*/

/*
Imported Libararies
*/
import items.*;

public abstract class Handheld extends Item implements LevelRequired, Storable
{
    public static String[] printHelper = {"Name", "Level Required", "Cost", "Damage", "Armor", "Required Hands"};
    private int handsRequired;
    private int armorValue;
    private int damageValue;
    private int levelRequired;

    /*
    CONSTRUCTORS
    */
    public Handheld(String name, int moneyValue, int handsRequired, int armorValue, int damageValue, int levelRequired)
    {
        super(name, moneyValue);
        setHandsRequired(handsRequired);
        setArmorValue(armorValue);
        setDamageValue(damageValue);
        setLevelRequired(levelRequired);
    }

    /*
    SETTERS
    */
    public void setHandsRequired(int handsRequired)
    {
        this.handsRequired = handsRequired;
    }

    public void setArmorValue(int armorValue)
    {
        this.armorValue = armorValue;
    }

    public void setDamageValue(int damageValue)
    {
        this.damageValue = damageValue;
    }

    public void setLevelRequired(int levelRequired)
    {
        this.levelRequired = levelRequired;
    }

    /*
    ACCESSORS
    */
    public int getArmorValue()
    {
        return armorValue;
    }

    public int getDamageValue()
    {
        return damageValue;
    }

    public int getLevelRequired()
    {
        return levelRequired;
    }

    public int getHandsRequired()
    {
        return handsRequired;
    }
}
