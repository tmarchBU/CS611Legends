package characters;

/*
File: SpellCasting.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Interface for any character that can cast spells
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import items.spells.Castable;
import items.spells.Spell;

public interface SpellCasting 
{
    public ArrayList<Spell> getSpells();
    public void decreaseMana(int mana);
    public int getMana();
    public String getName();
    public boolean canCast(Castable spell);
	public int getDexterity();
}
