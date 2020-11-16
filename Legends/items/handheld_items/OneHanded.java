package items.handheld_items;

/*
File: OneHanded.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A handtype with one-handed handhelds equiped
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;

public class OneHanded implements HandType 
{
    private Handheld leftHand;
    private Handheld rightHand;

    /*
    CONSTRUCTORS
    */
    public OneHanded()
    {
        setLeftHand(null);
        setRightHand(null);
    }

    public OneHanded(Handheld left)
    {
        setLeftHand(left);
        setRightHand(null);
    }

    public OneHanded(Handheld left, Handheld right)
    {
        setLeftHand(left);
        setRightHand(right);
    }

    /*
    SETTERS
    */
    public void setLeftHand(Handheld left)
    {
        leftHand = left;
    }

    public void setRightHand(Handheld right)
    {
        rightHand = right;
    }

    /*
    ACCESSORS
    */
    public Handheld getLeftHand()
    {
        return leftHand;
    }

    public Handheld getRightHand()
    {
        return rightHand;
    }

    /*
    HandType Methods
    */
    public int getDamageValue()
    {
        int value = 0;
        Handheld[] array = {getLeftHand(), getRightHand()};

        for (Handheld hand : array)
        {
            if (hand != null)
            {
                value += hand.getDamageValue();
            }
        }

        return value;
    }

    public int getArmorValue()
    {
        int value = 0;
        Handheld[] array = {getLeftHand(), getRightHand()};

        for (Handheld hand : array)
        {
            if (hand != null)
            {
                value += hand.getArmorValue();
            }
        }

        return value;
    }

    public String toString()
    {
        return "One Handed Weapons";
    }

    public void printEquiped()
    {
        ArrayList<Handheld> temp = new ArrayList<Handheld>();

        System.out.println("Left Hand: ");
        if (getLeftHand() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getLeftHand());
            TableHelper.printHandhelds(temp);
            temp.remove(0);
        }

        System.out.println("Right Hand: ");
        if (getRightHand() == null)
        {
            System.out.println("None");
        }
        else
        {
            temp.add(getRightHand());
            TableHelper.printHandhelds(temp);
            temp.remove(0);
        }
    }

    public void addHandheld(Handheld handheld)
    {
        if (getLeftHand() == null)
        {
            setLeftHand(handheld);
        }
        else
        {
            setRightHand(handheld);
        }
    }
}
