package items.handheld_items;

/*
File: NoWeapon.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A handtype with no weapon equiped
*/

public class NoWeapon implements HandType
{
    /*
    CONSTRUCTORS
    */
    public NoWeapon(){}

    /*
    HandType Methods
    */
    public int getArmorValue() 
    {
        return 0;
    }

    public int getDamageValue() 
    {
        return 0;
    }

    public String toString()
    {
        return "No Weapons or Shields";
    }

    public void printEquiped()
    {
        System.out.println("None");
    }

    public void addHandheld(Handheld handheld){}
}
