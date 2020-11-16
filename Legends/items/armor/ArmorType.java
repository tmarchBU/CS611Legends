package items.armor;

/*
File: ArmorType.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Interface used for different armor types
*/

public interface ArmorType 
{
    public int getTotalValue();
    public void printPieces();
    public void addPiece(Armor armor);
}
