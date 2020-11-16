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
import items.armor.Armor;
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

    public ArrayList<Handheld> getHandheldItems()
    {
        ArrayList<Handheld> items = new ArrayList<Handheld>();
        Iterator<Storable> iter = getItems().iterator();
        while(iter.hasNext())
        {
            Storable temp = iter.next();
            if (temp instanceof Handheld)
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
