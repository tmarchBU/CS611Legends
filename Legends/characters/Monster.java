package characters;

/*
File: Monster.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of RPGCharacter, representing a Monster 
*/

/*
Imported Libraries
*/
import game.rules.LegendsRules;
import utilities.RandomHelper;

public abstract class Monster extends RPGCharacter
{
    private int damageValue;
    private int defenseValue;
    private int dodgeChance;

    /*
    CONSTRUCTORS
    */
    public Monster(String name, boolean isAI, int level, int health, int damageValue, int defenseValue, int dodgeChance)
    {
        super(name, isAI, level, health, 0, new LegendsInventory());
        setDamageValue(damageValue);
        setDefenseValue(defenseValue);
        setDodgeChance(dodgeChance);
    }

    /*
    SETTERS
    */
    public void setDamageValue(int damageValue)
    {
        this.damageValue = damageValue;
    }

    public void setDefenseValue(int defenseValue)
    {
        this.defenseValue = defenseValue;
    }

    public void setDodgeChance(int dodgeChance)
    {
        this.dodgeChance = dodgeChance;
    }

    /*
    ACCESSORS
    */
    public int getDamageValue()
    {
        return damageValue;
    }

    public int getDefenseValue()
    {
        return defenseValue;
    }

    public float getDodgeChance()
    {
        return dodgeChance;
    }

    /*
    MUTATORS
    */
    public void decreaseDefenseValue(int value)
    {
        this.defenseValue -= value;
    }

    public void decreaseAttackValue(int value)
    {
        this.damageValue -= value;
    }

    public void decreaseDodgeChance(int value)
    {
        this.dodgeChance -= value;
    }
    
    /*
    Battleable Methods
    */
    public int getAttackValue()
    {
        return (int) (getDamageValue() * 0.05);
    }

    public boolean getDodge()
    {
        return RandomHelper.randomDodge((float) (getDodgeChance() * LegendsRules.MONSTER_DODGE_LEVEL));
    }
}
