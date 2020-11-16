package characters;

/*
File: Paladin.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Hero, representing a Paladin hero 
*/

/*
Imported Libraries
*/
import game.rules.LegendsRules;
import items.armor.ArmorType;
import items.handheld_items.HandType;

public class Paladin extends Hero 
{
    /*
    CONSTRUCTORS
    */
    public Paladin(String name, boolean isAI, int level, int health, int experience, int strength, int agility, int dexterity, int money, int mana, ArmorType armor, HandType weaponsAndShields)
    {
        super(name, isAI, level, health, experience, strength, agility, dexterity, money, mana, armor, weaponsAndShields);
    }

    /*
    levelUp - calls Hero.levelUp to do the normal levelup functions, then does the Paladin-specific functions
    */
    public void levelUp()
    {
        super.levelUp();
        increaseStrength((int) (getStrength() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseDexterity((int) (getDexterity() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
    }
}
