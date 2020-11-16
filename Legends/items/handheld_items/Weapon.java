package items.handheld_items;

/*
File: Weapon.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Handheld for a weapon
*/

public class Weapon extends Handheld
{
    /*
    CONSTRUCTORS
    */
    public Weapon(String name, int moneyValue, int handsRequired, int armorValue, int damageValue, int levelRequired)
    {
        super(name, moneyValue, handsRequired, armorValue, damageValue, levelRequired);
    }
}
 