package items.armor;

/*
File: Boots.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Armor subclass Boots
*/

public class Boots extends Armor
{
    /*
    CONSTRUCTORS
    */
    public Boots(String name, int levelRequired, int armorValue, int moneyValue)
    {
        super(name, moneyValue, levelRequired, armorValue);
    }
}
