package characters;

/*
File: Hero.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of RPGCharacter, representing a Hero 
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;
import game.map.Cell;
import game.rules.LegendsRules;
import items.armor.*;
import items.consumables.Consumable;
import items.handheld_items.*;
import items.spells.*;
import utilities.*;

public abstract class Hero extends RPGCharacter implements SpellCasting
{
    public static String[] printHelper = {"Name", "Level", "Experience", "Health", "Mana", "Strength", "Agility", "Dexterity", "Money"};
    private int experience;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private ArmorType armor;
    private HandType weaponsAndShields;
    private ArrayList<Spell> spells;
    private Cell spawnPoint;

    /*
    CONSTUCTORS
    */
    public Hero(String name, boolean isAI, int level, int health, int experience, int strength, int agility, int dexterity, int money, int mana, ArmorType armor, HandType weaponsAndShields)
    {
        super(name, isAI, level, health, mana, new LegendsInventory());
        setExperience(experience);
        setStrength(strength);
        setAgility(agility);
        setDexterity(dexterity);
        setMoney(money);
        setArmor(armor);
        setWeaponsAndShields(weaponsAndShields);
        setSpells(new ArrayList<Spell>());
    }

    /*
    SETTERS
    */
    public void setExperience(int experience)
    {
        this.experience = experience;
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public void setAgility(int agility)
    {
        this.agility = agility;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public void setArmor(ArmorType armor)
    {
        this.armor = armor;
    }

    public void setWeaponsAndShields(HandType weaponsAndShields)
    {
        this.weaponsAndShields = weaponsAndShields;
    }

    public void setSpells(ArrayList<Spell> spells)
    {
        this.spells = spells;
    }

    public void setSpawnPoint(Cell cell)
    {
        this.spawnPoint = cell;
    }

    /*
    ACCESSORS
    */

    public ArrayList<Spell> getSpells()
    {
        return spells;
    }

    public int getExperience()
    {
        return experience;
    }

    public int getStrength()
    {
        return strength;
    }

    public int getAgility()
    {
        return agility;
    }

    public int getDexterity()
    {
        return dexterity;
    }

    public int getMoney()
    {
        return money;
    }

    public ArmorType getArmor()
    {
        return armor;
    }

    public HandType getWeaponsAndShields()
    {
        return weaponsAndShields;
    }

    public Cell getSpawnPoint()
    {
        return spawnPoint;
    }

    /*
    MUTATORS
    */
    public void increaseExperience(int experience)
    {
        this.experience += experience;
        while (getExperience() >= getLevel()*LegendsRules.HERO_EXPERIENCE_REQUIRED_LEVEL)
        {
            setExperience((int) (getExperience() - getLevel()*LegendsRules.HERO_EXPERIENCE_REQUIRED_LEVEL));
            levelUp();
        }
    }

    public void increaseStrength(int strength)
    {
        this.strength += strength;
    }

    public void increaseAgility(int agility)
    {
        this.agility += agility;
    }

    public void increaseDexterity(int dexterity)
    {
        this.dexterity += dexterity;
    }

    public void increaseMoney(int money)
    {
        this.money += money;
    }

    public void decreaseMoney(int money)
    {
        this.money -= money;
    }

    /*
    Battleable Methods
    */

    public int getAttackValue()
    {
        return (int) ((getStrength() + getWeaponsAndShields().getDamageValue()) * 0.05);
    }

    public boolean getDodge()
    {
        return RandomHelper.randomDodge(getDodgeChance());
    }

    public float getDodgeChance()
    {
        return (float) (getAgility() * LegendsRules.HERO_DODGE_LEVEL);
    }

    public void decreaseDefenseValue(int value){}

    public void decreaseAttackValue(int value){}

    public void decreaseDodgeChance(int value){}

    public int getDefenseValue()
    {
        return getArmor().getTotalValue() + getWeaponsAndShields().getArmorValue();
    }

    /*
    SpellCasting Methods
    */

    public boolean canCast(Castable spell)
    {
        if (spell.getManaCost() > getMana())
        {
            return false;
        }
        return true;
    }

    /*
    levelUp - helper for the subtypes to level up a hero
    */
    protected void levelUp()
    {
        incrementLevel();
        System.out.println(getName() + " leveled up to level " + getLevel());
        increaseStrength((int) (getStrength() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseMaxMana((int) (getMaxMana() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseDexterity((int) (getDexterity() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseMaxHealth((int) (getMaxHealth() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
        increaseAgility((int) (getAgility() * LegendsRules.HERO_SKILL_INCREASE_LEVEL));
    }

    /*
    changeArmor - UI to edit the armor of a hero
    */
    private void changeArmor()
    {
        InputUtility input = InputUtility.getSingleInstance();
        int numInput = 0;
        String strInput = "";

        ArmorType armor = getArmor();
        System.out.println("Your Present Armor Type: " + armor);
        System.out.println("Armor Equiped:");
        armor.printPieces();

        System.out.println("Would you like to change your armor type? (yes/no)");
        strInput = input.yesNo();
        ArrayList<Armor> items = null;
        if (strInput.equalsIgnoreCase("YES"))
        {
            System.out.println("What type of armor would you like to equip?");
            System.out.println("1) Full Body Armor | 2) Split Armor Pieces | 3) No Armor");
            numInput = input.inputInt(1, 3);
            switch(numInput)
            {
                case 1: setArmor(new FullArmor()); items = ((LegendsInventory) getInventory()).getFullArmorItems(); break;
                case 2: setArmor(new SplitArmor()); items = ((LegendsInventory) getInventory()).getSplitArmorItems(); break;
                case 3: setArmor(new NoArmor()); return; 
            }
        }
        if (items == null || items.size() == 0)
        {
            System.out.println("You have no armor to equip.");
            setArmor(new NoArmor());
            System.out.println("Press Enter to return to map");
            input.pressEnter();
            return;
        }

        TableHelper.printArmor(items);
        System.out.println("What armor would you like to equip (number of armor piece)?");
        System.out.println("Input 0 to skip.");
        
        numInput = input.inputInt(0, items.size());
        if (numInput == 0)
        {
            return;
        }
        Armor piece = items.remove(numInput - 1);

        System.out.println("You equiped " + piece.getName());

        getArmor().addPiece(piece);
    }

    /*
    changeWeaponsAndShields - UI to edit the weapons and shields of a hero
    */
    private void changeWeaponsAndShields()
    {
        InputUtility input = InputUtility.getSingleInstance();
        int numInput = 0;
        String strInput = "";

        HandType weaponsAndShields = getWeaponsAndShields();
        System.out.println("Your Present Weapon Type: " + weaponsAndShields);
        System.out.println("Weapons Equiped:");
        weaponsAndShields.printEquiped();

        System.out.println("Would you like to change your weapon type? (yes/no)");
        strInput = input.yesNo();
        if (strInput.equalsIgnoreCase("YES"))
        {
            System.out.println("What type of weapon would you like to equip?");
            System.out.println("1) One Handed Weapons | 2) Two Handed Weapon | 3) No Weapons");
            numInput = input.inputInt(1, 3);
            switch(numInput)
            {
                case 1: setWeaponsAndShields(new OneHanded()); break;
                case 2: setWeaponsAndShields(new TwoHanded()); break;
                case 3: setWeaponsAndShields(new NoWeapon()); return; 
            }
        }
        ArrayList<Handheld> items = ((LegendsInventory) getInventory()).getHandheldItems(numInput);
        if (items.size() == 0)
        {
            System.out.println("You have no weapons to equip.");
            setWeaponsAndShields(new NoWeapon());
            System.out.println("Press Enter to return to map");
            input.pressEnter();
            return;
        }

        TableHelper.printHandhelds(items);
        System.out.println("What weapons would you like to equip (number of weapon/shield)?");
        System.out.println("Input 0 to skip.");

        numInput = input.inputInt(0, items.size());
        if (numInput == 0)
        {
            return;
        }
        Handheld handheld = items.remove(numInput - 1);

        System.out.println("You equiped " + handheld.getName());
        getWeaponsAndShields().addHandheld(handheld);
    }

    /*
    consumeItem - UI to choose a consumable item from inventory and consume it
    */
    private void consumeItem()
    {
        InputUtility input = InputUtility.getSingleInstance();
        int numInput = 0;

        ArrayList<Consumable> items = ((LegendsInventory) getInventory()).getConsumableItems();
        if (items.size() == 0)
        {
            System.out.println("You have no consumable items.");
            System.out.println("Press Enter to return to map");
            input.pressEnter();
            return;
        }

        TableHelper.printConsumables(items);
        System.out.println("Enter the number of item you would like to consume.");
        
        numInput = input.inputInt(1, items.size());
        Consumable item = items.get(numInput - 1);

        getInventory().getItems().remove(item);

        item.consume(this);
    }

    /*
    openInventory - UI to access changeArmor, changeWeaponsAndShields, and consumeItem
    */
    public void openInventory()
    {
        InputUtility input = InputUtility.getSingleInstance();
        int numInput = 0;

        System.out.println("What would you like to do?");
        System.out.println("1) Change Armor | 2) Change Weapons/Shields | 3) Use a Consumable");
        numInput = input.inputInt(1, 3);

        switch(numInput)
        {
            case 1: changeArmor(); break;
            case 2: changeWeaponsAndShields(); break;
            case 3: consumeItem(); break;
        }
    }
}