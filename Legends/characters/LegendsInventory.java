package characters;

/*
File: LegendsInventory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Inventory, adding extra methods for Legends items
*/

/*
Imported Libraries
*/
import java.util.*;
import items.Storable;
import items.armor.*;
import items.consumables.Consumable;
import items.handheld_items.Handheld;

public class LegendsInventory extends Inventory
{
    /*
    CONSTRUCTORS
    */
    public LegendsInventory()
    {
        super();
    }

    /*
    Accessors for specific items in the inventory
    */
    public ArrayList<Armor> getArmorItems()
    {
        ArrayList<Armor> items = new ArrayList<Armor>();
        Iterator<Storable> iter = getItems().iterator();
        while(iter.hasNext())
        {
            Storable temp = iter.next();
            if (temp instanceof Armor)
            {
                items.add((Armor) temp);
            }
        }

        return items;
    }

    public ArrayList<Armor> getFullArmorItems()
    {
        ArrayList<Armor> items = getArmorItems();
        ArrayList<Armor> fullBodyItems = new ArrayList<Armor>();
        Iterator<Armor> iter = items.iterator();
        while(iter.hasNext())
        {
            Armor temp = iter.next();
            if (temp instanceof FullBody)
            {
                fullBodyItems.add((FullBody) temp);
            }
        }

        return fullBodyItems;
    }

    public ArrayList<Armor> getSplitArmorItems()
    {
        ArrayList<Armor> items = getArmorItems();
        ArrayList<Armor> splitArmorItems = new ArrayList<Armor>();
        Iterator<Armor> iter = items.iterator();
        while(iter.hasNext())
        {
            Armor temp = iter.next();
            if (temp instanceof Helmet)
            {
                splitArmorItems.add((Helmet) temp);
            }
            if (temp instanceof Gloves)
            {
                splitArmorItems.add((Gloves) temp);
            }
            if (temp instanceof Boots)
            {
                splitArmorItems.add((Boots) temp);
            }
            if (temp instanceof SplitBody)
            {
                splitArmorItems.add((SplitBody) temp);
            }
        }

        return splitArmorItems;
    }

    /*
    input specifies which type of weapons (1 or 2 handed)
    */
    public ArrayList<Handheld> getHandheldItems(int hands)
    {
        ArrayList<Handheld> items = new ArrayList<Handheld>();
        Iterator<Storable> iter = getItems().iterator();
        while(iter.hasNext())
        {
            Storable temp = iter.next();
            if (temp instanceof Handheld && ((Handheld) temp).getHandsRequired() == hands)
            {
                items.add((Handheld) temp);
            }
        }

        return items;
    }

    public ArrayList<Consumable> getConsumableItems()
    {
        ArrayList<Consumable> items = new ArrayList<Consumable>();
        Iterator<Storable> iter = getItems().iterator();
        while(iter.hasNext())
        {
            Storable temp = iter.next();
            if (temp instanceof Consumable)
            {
                items.add((Consumable) temp);
            }
        }

        return items;
    }
}
