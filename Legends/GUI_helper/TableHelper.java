package GUI_helper;

/*
File: TableHelper.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A helper class that prints out tables depending on the inputed arraylist type
*/

/*
Imported Libraries
*/
import java.util.*;
import characters.*;
import items.armor.Armor;
import items.consumables.*;
import items.handheld_items.Handheld;
import items.spells.Spell;

public class TableHelper 
{
    private static int nameWidth = 22;
    private static int width = 16;

    /*
    printHeroes - prints out a table of heroes
    */
    public static void printHeroes(ArrayList<Hero> heroes)
    {
        String[] heroTraits = Hero.printHelper;

        printRowString(heroTraits.length);
        
        System.out.print("||");
        System.out.print(TableHelper.padString(heroTraits[0], nameWidth));


        for (int i = 1; i < heroTraits.length; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(heroTraits[i], width));
        }
        System.out.println("||");
        printRowString(heroTraits.length);

        for (int i = 0; i < heroes.size(); i++)
        {
            for (int j = 0; j < heroTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = heroes.get(i).getName(); break;
                    case 1: temp = Integer.toString(heroes.get(i).getLevel()); break;
                    case 2: temp = Integer.toString(heroes.get(i).getExperience()); break;
                    case 3: temp = Integer.toString(heroes.get(i).getHealth()); break;
                    case 4: temp = Integer.toString(heroes.get(i).getMana()); break;
                    case 5: temp = Integer.toString(heroes.get(i).getStrength()); break;
                    case 6: temp = Integer.toString(heroes.get(i).getAgility()); break;
                    case 7: temp = Integer.toString(heroes.get(i).getDexterity()); break;
                    case 8: temp = Integer.toString(heroes.get(i).getMoney()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printRowString(heroTraits.length);
        }
    }

    /*
    printArmor - prints out a table of armor
    */
    public static void printArmor(ArrayList<Armor> armor)
    {
        String[] armorTraits = Armor.printHelper;
        printRowString(armorTraits.length);

        System.out.print("||");
        System.out.print(TableHelper.padString(armorTraits[0], nameWidth));


        for (int i = 1; i < armorTraits.length; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(armorTraits[i], width));
        }
        System.out.println("||");
        printRowString(armorTraits.length);

        for (int i = 0; i < armor.size(); i++)
        {
            for (int j = 0; j < armorTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = armor.get(i).getName(); break;
                    case 1: temp = Integer.toString(armor.get(i).getLevelRequired()); break;
                    case 2: temp = Integer.toString(armor.get(i).getMoneyValue()); break; 
                    case 3: temp = Integer.toString(armor.get(i).getArmorValue()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printRowString(armorTraits.length);
        }
    }

    /*
    printHandhelds - prints out a table of handhelds
    */
    public static <T extends Handheld> void printHandhelds(ArrayList<T> handhelds)
    {
        String[] handheldTraits = Handheld.printHelper;
        printRowString(handheldTraits.length);

        System.out.print("||");
        System.out.print(TableHelper.padString(handheldTraits[0], nameWidth));

        for (int i = 1; i < handheldTraits.length; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(handheldTraits[i], width));
        }
        System.out.println("||");
        printRowString(handheldTraits.length);

        for (int i = 0; i < handhelds.size(); i++)
        {
            for (int j = 0; j < handheldTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = handhelds.get(i).getName(); break;
                    case 1: temp = Integer.toString(handhelds.get(i).getLevelRequired()); break;
                    case 2: temp = Integer.toString(handhelds.get(i).getMoneyValue()); break;
                    case 3: temp = Integer.toString(handhelds.get(i).getDamageValue()); break;
                    case 4: temp = Integer.toString(handhelds.get(i).getArmorValue()); break;
                    case 5: temp = Integer.toString(handhelds.get(i).getHandsRequired()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printRowString(handheldTraits.length);
        }
    }

    /*
    printConsumables - prints out a table of consumables
    */
    public static <T extends Consumable> void printConsumables(ArrayList<T> potions)
    {
        String[] potionTraits = Potion.printHelper;
        printSpecialRowString(potionTraits.length);

        System.out.print("||");
        System.out.print(TableHelper.padString(potionTraits[0], nameWidth));


        for (int i = 1; i < potionTraits.length - 1; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(potionTraits[i], width));
        }
        System.out.print("||");
        System.out.print(TableHelper.padString(potionTraits[potionTraits.length-1], 45));
        System.out.println("||");
        printSpecialRowString(potionTraits.length);

        for (int i = 0; i < potions.size(); i++)
        {
            for (int j = 0; j < potionTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = ((Potion) potions.get(i)).getName(); break;
                    case 1: temp = Integer.toString(((Potion) potions.get(i)).getMoneyValue()); break;
                    case 2: temp = Integer.toString(((Potion) potions.get(i)).getLevelRequired()); break;
                    case 3: temp = Integer.toString(((Potion) potions.get(i)).getValue()); break;
                    case 4: temp = Arrays.toString(((Potion) potions.get(i)).getAttributes()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else if (j == 4)
                {
                    System.out.print(TableHelper.padString(temp, 45));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printSpecialRowString(potionTraits.length);
        }
    }

    /*
    printBattleables - prints out a table of battleables
    */
    public static void printBattleables(ArrayList<Battleable> battleables)
    {
        String[] battleableTraits = Battleable.printHelper;
        printRowString(battleableTraits.length);

        System.out.print("||");
        System.out.print(TableHelper.padString(battleableTraits[0], nameWidth));


        for (int i = 1; i < battleableTraits.length; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(battleableTraits[i], width));
        }
        System.out.println("||");
        printRowString(battleableTraits.length);

        for (int i = 0; i < battleables.size(); i++)
        {
            for (int j = 0; j < battleableTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = battleables.get(i).getName(); break;
                    case 1: temp = Integer.toString(battleables.get(i).getHealth()); break;
                    case 2: temp = Integer.toString(battleables.get(i).getMana()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printRowString(battleableTraits.length);
        }
    }

    /*
    printSpells - prints out a table of spells
    */
    public static void printSpells(ArrayList<Spell> spells)
    {
        String[] spellTraits = Spell.printHelper;
        printRowString(spellTraits.length);

        System.out.print("||");
        System.out.print(TableHelper.padString(spellTraits[0], nameWidth));


        for (int i = 1; i < spellTraits.length; i++)
        {
            System.out.print("||");
            System.out.print(TableHelper.padString(spellTraits[i], width));
        }
        System.out.println("||");
        printRowString(spellTraits.length);

        for (int i = 0; i < spells.size(); i++)
        {
            for (int j = 0; j < spellTraits.length; j++)
            {
                System.out.print("||");
                String temp = "";
                switch (j)
                {
                    case 0: temp = spells.get(i).getName(); break;
                    case 1: temp = Integer.toString(spells.get(i).getMoneyValue()); break;
                    case 2: temp = Integer.toString(spells.get(i).getLevelRequired()); break;
                    case 3: temp = Integer.toString(spells.get(i).getDamageValue()); break;
                    case 4: temp = Integer.toString(spells.get(i).getManaCost()); break;
                }
                if (j == 0)
                {
                    System.out.print(TableHelper.padString(((i+1) + ") " + temp), nameWidth));
                }
                else
                {
                    System.out.print(TableHelper.padString(temp, width));
                }
            }
            System.out.println("||");
            printRowString(spellTraits.length);
        }
    }

    /*
    printRowString - helper method to print the row separator
    */
    private static void printRowString(int colNum)
    {
        System.out.print("++");
        for (int i = 0; i < nameWidth; i++)
        {
            System.out.print("=");
        }

        for (int i = 1; i < colNum; i++)
        {
            System.out.print("++");
            for (int j = 0; j < width; j++)
            {
                System.out.print("=");
            }
        }
        System.out.println("++");
    }

    /*
    printSpecialRowString - used only for printing the spell table
    */
    private static void printSpecialRowString(int colNum)
    {
        System.out.print("++");
        for (int i = 0; i < nameWidth; i++)
        {
            System.out.print("=");
        }

        for (int i = 1; i < colNum - 1; i++)
        {
            System.out.print("++");
            for (int j = 0; j < width; j++)
            {
                System.out.print("=");
            }
        }
        System.out.print("++");
        for (int j = 0; j < 45; j++)
            {
                System.out.print("=");
            }
        System.out.println("++");
    }
    
    /*
    padString - pads and centers a string
    */
    public static String padString(String string, int length)
    {
        while(string.length() < length)
        {
            if (string.length() % 2 == 1)
            {
                string = " " + string;
            }
            else
            {
                string = string + " ";
            }
        }

        return string;
    }
}
