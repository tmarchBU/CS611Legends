package items.consumables;

/*
File: Consumable.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: An interface for a consumable item
*/

/*
Imported Libararies
*/
import characters.*;
import items.Storable;

public interface Consumable extends Storable
{
    public void consume(Hero consumer);
}
