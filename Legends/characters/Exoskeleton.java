package characters;

/*
File: Exoskeleton.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Monster, representing a Exoskeleton monster
*/

public class Exoskeleton extends Monster
{
    /*
    CONSTRUCTORS
    */
    public Exoskeleton(String name, boolean isAI, int level, int health, int damageValue, int defenseValue, int dodgeChance)
    {
        super(name, isAI, level, health, damageValue, defenseValue, dodgeChance);
    }
}
