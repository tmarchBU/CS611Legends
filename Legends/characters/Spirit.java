package characters;

/*
File: Sorcerer.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Hero, representing a Sorcerer hero
*/

public class Spirit extends Monster 
{
    /*
    CONSTRUCTORS
    */
    public Spirit(String name, boolean isAI, int level, int health, int damageValue, int defenseValue, int dodgeChance)
    {
        super(name, isAI, level, health, damageValue, defenseValue, dodgeChance);
    }
}
