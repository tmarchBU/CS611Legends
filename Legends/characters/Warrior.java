package characters;

/*
File: Warrior.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Hero, representing a Warrior hero
*/

/*
Imported Libraries
*/
import game.rules.LegendsRules;
import items.armor.ArmorType;
import items.handheld_items.HandType;

public class Warrior extends Hero 
{
    /*
    CONSTRUCTORS
    */
    public Warrior(String name, boolean isAI, int level, int health, int experience, int strength, int agility, int dexterity, int money, int mana, ArmorType armor, HandType weaponsAndShields)
    {
        super(name, isAI, level, health, experience, strength, agility, dexterity, money, mana, armor, weaponsAndShields);
    }

    /*
    levelUp - calls Hero.levelUp to do the normal levelup functions, then does the Warrior-specific functions
    */
    public void levelUp()
    {
        super.levelUp();
        increaseStrength((int) (getStrength() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseAgility((int) (getAgility() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
    }
}
