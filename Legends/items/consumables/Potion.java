package items.consumables;

/*
File: Potion.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A consumable potion item
*/

/*
Imported Libararies
*/
import items.*;
import characters.*;

public class Potion extends Item implements Consumable, LevelRequired
{
    public static String[] printHelper = {"Name", "Cost", "Level Required", "Increase Value", "Attributes Affected"};
    private int levelRequired;
    private int value;
    private String[] attributes;

    /*
    CONSTRUCTORS
    */
    public Potion(String name, int moneyValue, int levelRequired, int value, String[] attributes)
    {
        super(name, moneyValue);
        setLevelRequired(levelRequired);
        setValue(value);
        setAttributes(attributes);
    }

    /*
    SETTERS
    */
    public void setLevelRequired(int levelRequired)
    {
        this.levelRequired = levelRequired;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void setAttributes(String[] attributes)
    {
        this.attributes = attributes;
    }

    /*
    ACCESSORS
    */
    public int getLevelRequired()
    {
        return levelRequired;
    }

    public int getValue()
    {
        return value;
    }

    public String[] getAttributes()
    {
        return attributes;
    }

    /*
    Consumable Methods
    */
    public void consume(Hero consumer)
    {
        String[] attributes = getAttributes();
        for (int i = 0; i < attributes.length; i++)
        {
            String temp = attributes[i];
            switch(temp)
            {
                case "Health":
                    consumer.increaseHealth(getValue());
                    break;
                case "Strength":
                    consumer.increaseStrength(getValue());
                    break;
                case "Mana":
                    consumer.increaseMana(getValue());
                    break;
                case "Agility":
                    consumer.increaseAgility(getValue());
                    break;
                case "Dexterity":
                    consumer.increaseDexterity(getValue());
                    break;
            }
        }
    }

}
