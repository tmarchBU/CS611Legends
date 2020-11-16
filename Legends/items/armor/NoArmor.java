package items.armor;

/*
File: NoArmor.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: An armortype with no armor
*/

public class NoArmor implements ArmorType
{
    private int totalValue;

    /*
    CONSTRUCTORS
    */
    public NoArmor()
    {
        setTotalValue(0);
    }

    /*
    SETTERS
    */
    public void setTotalValue(int total)
    {
        totalValue = total;
    }

    /*
    ACCESSORS
    */
    public int getTotalValue()
    {
        return totalValue;
    }

    /*
    Armortype Methods
    */
    public void printPieces()
    {
        System.out.println("None");
    }

    public void addPiece(Armor armor){}

    public String toString()
    {
        return "No Armor";
    }
}
