package items.armor;

/*
File: FullBody.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Armor subclass FullBody, the physical full body armor for armortype FullArmor
*/

public class FullBody extends Armor
{
    /*
    CONSTRUCTORS
    */
    public FullBody(String name, int levelRequired, int armorValue, int moneyValue)
    {
        super(name, moneyValue, levelRequired, armorValue);
    }
}
