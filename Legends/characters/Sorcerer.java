package characters;

/*
File: Sorcerer.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Hero, representing a Sorcerer hero
*/

/*
Imported Libraries
*/
import game.rules.LegendsRules;
import items.armor.ArmorType;
import items.handheld_items.HandType;

public class Sorcerer extends Hero 
{
    /*
    CONSTRUCTORS
    */
    public Sorcerer(String name, boolean isAI, int level, int health, int experience, int strength, int agility, int dexterity, int money, int mana, ArmorType armor, HandType weaponsAndShields)
    {
        super(name, isAI, level, health, experience, strength, agility, dexterity, money, mana, armor, weaponsAndShields);
    }

    /*
    levelUp - calls Hero.levelUp to do the normal levelup functions, then does the Sorcerer-specific functions
    */
    public void levelUp()
    {
        super.levelUp();
        increaseAgility((int) (getAgility() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseDexterity((int) (getDexterity() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
    }
}
