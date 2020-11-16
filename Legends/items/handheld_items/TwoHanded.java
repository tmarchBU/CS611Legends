package items.handheld_items;

/*
File: TwoHanded.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A handtype with a two-handed handheld equiped
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;

public class TwoHanded implements HandType 
{
    private Handheld handheld;

    /*
    CONSTRUCTORS
    */
    public TwoHanded()
    {
        setHandheld(null);
    }

    public TwoHanded(Handheld handheld)
    {
        setHandheld(handheld);
    }

    /*
    SETTERS
    */
    public void setHandheld(Handheld handheld)
    {
        this.handheld = handheld;
    }

    /*
    ACCESSORS
    */
    public Handheld getHandheld()
    {
        return handheld;
    }

    /*
    HandType Methods
    */
    public int getDamageValue()
    {
        int value = 0;

        value = getHandheld().getDamageValue();

        return value;
    }

    public int getArmorValue()
    {
        int value = 0;

        value = getHandheld().getArmorValue();

        return value;
    }

    public String toString()
    {
        return "Two Handed Weapon";
    }

    public void printEquiped()
    {
        System.out.println("One Handed Weapon:");
        ArrayList<Handheld> temp = new ArrayList<Handheld>();
        temp.add(getHandheld());
        TableHelper.printHandhelds(temp);
    }

    public void addHandheld(Handheld handheld)
    {
        setHandheld(handheld);
    }
}
