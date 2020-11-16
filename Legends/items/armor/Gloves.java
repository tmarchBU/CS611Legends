package items.armor;

/*
File: Gloves.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Armor subclass Gloves
*/

public class Gloves extends Armor
{
    /*
    CONSTRUCTORS
    */
    public Gloves(String name, int levelRequired, int armorValue, int moneyValue)
    {
        super(name, moneyValue, levelRequired, armorValue);
    }
}
