package items.handheld_items;

/*
File: Handtype.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Interface used for different weapon-hand types
*/

public interface HandType 
{
    public int getDamageValue();
    public int getArmorValue();
    public void printEquiped();
    public void addHandheld(Handheld handheld);
}
