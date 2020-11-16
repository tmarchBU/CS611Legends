package game;

/*
File: Market.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A Market where any Hero can buy or sell items
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;
import characters.*;
import factories.*;
import items.armor.Armor;
import items.consumables.Potion;
import items.handheld_items.*;
import items.spells.Spell;
import utilities.InputUtility;

public class Market 
{
    private ArrayList<Armor> armorItems;
    private ArrayList<Weapon> weaponItems;
    private ArrayList<Shield> shieldItems;
    private ArrayList<Potion> potionItems;
    private ArrayList<Spell> spellItems;

    /*
    CONSTRUCTORS
    */
    public Market(ArmorFactory armorFactory, HandheldFactory handheldFactory, PotionFactory potionFactory, SpellFactory spellFactory)
    {
        ArrayList<Armor> newArmorItems = new ArrayList<Armor>();
        newArmorItems.add(armorFactory.getArmor("FULLBODY"));
        newArmorItems.add(armorFactory.getArmor("HELMET"));
        newArmorItems.add(armorFactory.getArmor("GLOVES"));
        newArmorItems.add(armorFactory.getArmor("BOOTS"));
        newArmorItems.add(armorFactory.getArmor("SPLITBODY"));
        setArmorItems(newArmorItems);

        ArrayList<Weapon> newWeaponItems = new ArrayList<Weapon>();
        newWeaponItems.add((Weapon) handheldFactory.getHandheld("WEAPON"));
        newWeaponItems.add((Weapon) handheldFactory.getHandheld("WEAPON"));
        setWeaponItems(newWeaponItems);

        ArrayList<Shield> newShieldItems = new ArrayList<Shield>();
        newShieldItems.add((Shield) handheldFactory.getHandheld("SHIELD"));
        newShieldItems.add((Shield) handheldFactory.getHandheld("SHIELD"));
        setShieldItems(newShieldItems);

        ArrayList<Potion> newPotionItems = new ArrayList<Potion>();
        newPotionItems.add(potionFactory.getPotion());
        newPotionItems.add(potionFactory.getPotion());
        newPotionItems.add(potionFactory.getPotion());
        setPotionItems(newPotionItems);

        ArrayList<Spell> newSpellItems = new ArrayList<Spell>();
        newSpellItems.add(spellFactory.getSpell("ICE"));
        newSpellItems.add(spellFactory.getSpell("FIRE"));
        newSpellItems.add(spellFactory.getSpell("LIGHTNING"));
        setSpellItems(newSpellItems);
    }

    /*
    SETTERS
    */
    public void setArmorItems(ArrayList<Armor> items)
    {
        armorItems = items;
    }

    public void setWeaponItems(ArrayList<Weapon> items)
    {
        weaponItems = items;
    }

    public void setShieldItems(ArrayList<Shield> items)
    {
        shieldItems = items;
    }

    public void setPotionItems(ArrayList<Potion> items)
    {
        potionItems = items;
    }

    public void setSpellItems(ArrayList<Spell> items)
    {
        spellItems = items;
    }

    /*
    ACCESSORS
    */
    public ArrayList<Armor> getArmorItems()
    {
        return armorItems;
    }

    public ArrayList<Weapon> getWeaponItems()
    {
        return weaponItems;
    }

    public ArrayList<Shield> getShieldItems()
    {
        return shieldItems;
    }

    public ArrayList<Potion> getPotionItems()
    {
        return potionItems;
    }

    public ArrayList<Spell> getSpellItems()
    {
        return spellItems;
    }

    /*
    open - UI entry point into the market
    */
    public void open(Hero hero)
    {
        boolean active = true;
        int numInput = 0;
        InputUtility input = InputUtility.getSingleInstance();

        while(active)
        {
            ArrayList<Hero> temp = new ArrayList<Hero>();
            temp.add(hero);
            TableHelper.printHeroes(temp);
            System.out.println("Would you like to buy or sell an item? (1 = buy | 2 = sell | 3 = leave)");
            numInput = input.inputInt(1, 3);
            if (numInput == 1)
            {
                buy(hero);
            }
            else if (numInput == 2)
            {
                sell(hero);
            }
            else if (numInput == 3)
            {
                active = false;
                break;
            }
        }
    }

    /*
    buy - accessed through open to allow a hero to buy something from the market
    */
    private void buy(Hero hero)
    {
        int numInput = 0;
        InputUtility input = InputUtility.getSingleInstance();

        System.out.println("What type of item would you like to buy?");
        System.out.println("1) Armor | 2) Weapon | 3) Shield | 4) Potion | 5) Spell");
        numInput = input.inputInt(1, 5);
        switch(numInput)
        {
            case 1:
            TableHelper.printArmor(getArmorItems());
            System.out.println("Enter the number of the item you would like to purchase. (0 = none)");
            numInput = input.inputInt(0, getArmorItems().size()) - 1;
            if (numInput == -1)
            {
                break;
            }

            if (getArmorItems().get(numInput).getMoneyValue() > hero.getMoney() || getArmorItems().get(numInput).getLevelRequired() > hero.getLevel())
            {
                System.out.println("You cannot purchase " + getArmorItems().get(numInput).getName());
            }
            else
            {
                Armor item = getArmorItems().remove(numInput);
                hero.decreaseMoney(item.getMoneyValue());
                hero.getInventory().getItems().add(item);
                System.out.println("You purchased " + item.getName());
            }
            break;

            case 2:
            TableHelper.printHandhelds(getWeaponItems());
            System.out.println("Enter the number of the item you would like to purchase. (0 = none)");
            numInput = input.inputInt(0, getWeaponItems().size()) - 1;
            if (numInput == -1)
            {
                break;
            }
            
            if (getWeaponItems().get(numInput).getMoneyValue() > hero.getMoney() || getWeaponItems().get(numInput).getLevelRequired() > hero.getLevel())
            {
                System.out.println("You cannot purchase " + getWeaponItems().get(numInput).getName());
            }
            else
            {
                Weapon item = getWeaponItems().remove(numInput);
                hero.decreaseMoney(item.getMoneyValue());
                hero.getInventory().getItems().add(item);
                System.out.println("You purchased " + item.getName());
            }
            break;

            case 3:
            TableHelper.printHandhelds(getShieldItems());
            System.out.println("Enter the number of the item you would like to purchase. (0 = none)");
            numInput = input.inputInt(0, getShieldItems().size()) - 1;
            if (numInput == -1)
            {
                break;
            }
            if (getShieldItems().get(numInput).getMoneyValue() > hero.getMoney() || getShieldItems().get(numInput).getLevelRequired() > hero.getLevel())
            {
                System.out.println("You cannot purchase " + getShieldItems().get(numInput).getName());
            }
            else
            {
                Shield item = getShieldItems().remove(numInput);
                hero.decreaseMoney(item.getMoneyValue());
                hero.getInventory().getItems().add(item);
                System.out.println("You purchased " + item.getName());
            }
            break;

            case 4:
            TableHelper.printConsumables(getPotionItems());
            System.out.println("Enter the number of the item you would like to purchase. (0 = none)");
            numInput = input.inputInt(0, getPotionItems().size()) - 1;
            if (numInput == -1)
            {
                break;
            }
            if (getPotionItems().get(numInput).getMoneyValue() > hero.getMoney() || getPotionItems().get(numInput).getLevelRequired() > hero.getLevel())
            {
                System.out.println("You cannot purchase " + getPotionItems().get(numInput).getName());
            }
            else
            {
                Potion item = getPotionItems().remove(numInput);
                hero.decreaseMoney(item.getMoneyValue());
                hero.getInventory().getItems().add(item);
                System.out.println("You purchased " + item.getName());
            }
            break;

            case 5:
            TableHelper.printSpells(getSpellItems());
            System.out.println("Enter the number of the item you would like to purchase. (0 = none)");
            numInput = input.inputInt(0, getSpellItems().size()) - 1;
            if (numInput == -1)
            {
                break;
            }
            if (getSpellItems().get(numInput).getMoneyValue() > hero.getMoney() || getSpellItems().get(numInput).getLevelRequired() > hero.getLevel())
            {
                System.out.println("You cannot purchase " + getSpellItems().get(numInput).getName());
            }
            else
            {
                Spell item = getSpellItems().remove(numInput);
                hero.decreaseMoney(item.getMoneyValue());
                hero.getSpells().add(item);
                System.out.println("You purchased " + item.getName());
            }
            break;
        }
    }

    /*
    sell - accessed through open for a hero to sell something to the market
    */
    private void sell(Hero hero)
    {
        int numInput = 0;
        InputUtility input = InputUtility.getSingleInstance();
        LegendsInventory inventory = (LegendsInventory) hero.getInventory();

        System.out.println("What type of item would you like to sell?");
        System.out.println("1) Armor | 2) Weapon/Shield | 3) Potion");
        numInput = input.inputInt(1, 3);
        switch(numInput)
        {
            case 1:
            TableHelper.printArmor(inventory.getArmorItems());
            System.out.println("Enter the number of the item you would like to sell. (0 = none)");
            numInput = input.inputInt(0, inventory.getArmorItems().size()) - 1;

            if (numInput == -1)
            {
                break;
            }

            Armor armorItem = inventory.getArmorItems().remove(numInput);
            hero.increaseMoney(armorItem.getMoneyValue());
            getArmorItems().add(armorItem);
            System.out.println("You sold " + armorItem.getName());
            
            break;
            case 2:
            TableHelper.printHandhelds(inventory.getHandheldItems());
            System.out.println("Enter the number of the item you would like to sell. (0 = none)");
            numInput = input.inputInt(0, inventory.getHandheldItems().size()) - 1;

            if (numInput == -1)
            {
                break;
            }
            
            Handheld handheldItem = inventory.getHandheldItems().remove(numInput);
            hero.increaseMoney(handheldItem.getMoneyValue());
            System.out.println("You sold " + handheldItem.getName());


            break;
            case 3:
            TableHelper.printConsumables(inventory.getConsumableItems());
            System.out.println("Enter the number of the item you would like to sell. (0 = none)");
            numInput = input.inputInt(0, inventory.getConsumableItems().size()) - 1;

            if (numInput == -1)
            {
                break;
            }
            
            Potion potionItem = (Potion) inventory.getConsumableItems().remove(numInput);
            hero.increaseMoney(potionItem.getMoneyValue());
            getPotionItems().add(potionItem);
            System.out.println("You sold " + potionItem.getName());

            break;
        }
    }
}
