package characters;

/*
File: Dragon.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of Monster, representing a Dragon monster
*/

public class Dragon extends Monster
{
    /*
    CONSTRUCTORS
    */
    public Dragon(String name, boolean isAI, int level, int health, int damageValue, int defenseValue, int dodgeChance)
    {
        super(name, isAI, level, health, damageValue, defenseValue, dodgeChance);
    }
}
