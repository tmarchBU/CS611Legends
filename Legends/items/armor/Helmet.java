package items.armor;

/*
File: Helmet.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Armor subclass Helmet
*/

public class Helmet extends Armor
{
    /*
    CONSTRUCTORS
    */
    public Helmet(String name, int levelRequired, int armorValue, int moneyValue)
    {
        super(name, moneyValue, levelRequired, armorValue);
    }
}
