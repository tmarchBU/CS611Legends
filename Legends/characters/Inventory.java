package characters;

/*
File: Inventory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Superclass Inventory for a hero
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.Storable;

public class Inventory 
{
    private ArrayList<Storable> items;

    /*
    CONSTRUCTORS
    */
    public Inventory()
    {
        setItems(new ArrayList<Storable>());
    }

    /*
    SETTERS
    */
    public void setItems(ArrayList<Storable> items)
    {
        this.items = items;
    }

    /*
    ACCESSORS
    */
    public ArrayList<Storable> getItems()
    {
        return items;
    }

}
