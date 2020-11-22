package characters;

import java.util.ArrayList;

import game.map.Cell;
import game.map.Marker;

/*
File: RPGCharacter.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Abstract Subclass of Character, representing a character of an RPG Game 
*/

public abstract class RPGCharacter extends Character implements Battleable
{
    private int level;
    private int health; 
    private int maxHealth;
    private Inventory inventory;
    private int mana;
    private int maxMana;
    private Cell location;
    private Marker marker;

    /*
    CONSTRUCTORS
    */
    public RPGCharacter(String name, boolean isAI, int level, int health, int mana, Inventory inventory)
    {
        super(name, isAI);
        setLevel(level);
        setHealth(health);
        setMaxHealth(health);
        setInventory(inventory);
        setMana(mana);
        setMaxMana(mana);
        setLocation(null);
        setMarker(null);
    }

    /*
    SETTERS
    */
    public void setMana(int mana)
    {
        this.mana = mana;
    }

    public void setMaxMana(int mana)
    {
        this.maxMana = mana;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setMaxHealth(int health)
    {
        this.maxHealth = health;
    }

    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    public void setLocation(Cell cell)
    {
        this.location = cell;
    }

    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

    /*
    ACCESSORS
    */
    public int getMana()
    {
        return mana;
    }

    public int getMaxMana()
    {
        return maxMana;
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public int getLevel()
    {
        return level;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public Cell getLocation()
    {
        return location;
    }

    public Marker getMarker()
    {
        return marker;
    }

    /*
    MUTATORS
    */
    public void incrementLevel()
    {
        level++;
    }

    public void increaseMaxHealth(int health)
    {
        this.maxHealth += health;
    }

    public void increaseMaxMana(int mana)
    {
        this.maxMana += mana;
    }

    public void increaseMana(int mana)
    {
        this.mana += mana;
    }

    public void increaseHealth(int health)
    {
        this.health += health;
    }

    public void decreaseHealth(int health)
    {
        this.health -= health;
        if (getHealth() < 0)
        {
            setHealth(0);
        }
    }

    public void decreaseMana(int value)
    {
        this.mana -= value;
        if (getMana() < 0)
        {
            setMana(0);
        }
    }

    /*
    Battleable Methods
    */
    public boolean isDead()
    {
        return (getHealth() == 0);
    }

    public ArrayList<RPGCharacter> characterWithinRange() 
    {
        Cell heroCell = getLocation();
        Cell above = heroCell.getAbove();
        Cell below = heroCell.getBelow();
        Cell left = heroCell.getLeft();
        Cell right = heroCell.getRight();
        ArrayList<RPGCharacter> characters = new ArrayList<RPGCharacter>();
        if (above != null && above.enterable())
        {
            for (RPGCharacter nextCharacter : above.getCharacters())
            {                
                characters.add(nextCharacter);
            }
        }
        if (below != null && below.enterable())
        {
            for (RPGCharacter nextCharacter : below.getCharacters())
            {
                characters.add(nextCharacter);
            }
        }
        if (left != null && left.enterable())
        {
            for (RPGCharacter nextCharacter : left.getCharacters())
            {
                characters.add(nextCharacter);
            }
        }
        if (right != null && right.enterable())
        {
            for (RPGCharacter nextCharacter : right.getCharacters())
            {
                characters.add(nextCharacter);
            }
        }
        return characters;
    }
}
