package items.armor;

/*
File: FullArmor.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: An armortype with only one piece of full body armor
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;

public class FullArmor implements ArmorType
{
    private FullBody armor;

    /*
    CONSTRUCTORS
    */
    public FullArmor()
    {
        setArmor(null);
    }

    /*
    SETTERS
    */
    public void setArmor(FullBody armor)
    {
        this.armor = armor;
    }

    /*
    GETTERS
    */

    public FullBody getArmor()
    {
        return armor;
    }

    /*
    Armortype Methods
    */
    public int getTotalValue()
    {
        return armor.getArmorValue();
    }

    public void printPieces()
    {
        System.out.println("Full Body Armor:");
        ArrayList<Armor> temp = new ArrayList<Armor>();
        temp.add(getArmor());
        TableHelper.printArmor(temp);
    }

    public String toString()
    {
        return "Full Body Armor";
    }

    public void addPiece(Armor armor)
    {
        setArmor((FullBody) armor);
    }
}
