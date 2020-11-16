package game.rules;

/*
File: LegendsRules.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A class of static rules for a specific game of legends
*/

/*
Imported Libraries
*/
import utilities.InputUtility;

public class LegendsRules 
{
    public static double HERO_SPELL_LEVEL = 10000;
    public static double HERO_HEALTH_LEVEL = 100;
    public static double MONSTER_HEALTH_LEVEL = 100;
    public static double HERO_MANA_INCREASE_LEVEL = 1.1;
    public static double HERO_DAMAGE_LEVEL = 0.05;
    public static double HERO_DODGE_LEVEL = 0.002;
    public static double MONSTER_DODGE_LEVEL = 0.01;
    public static double HERO_EXPERIENCE_REQUIRED_LEVEL = 10;
    public static double HERO_SKILL_INCREASE_LEVEL = 0.05;
    public static double HERO_HEALTH_REGEN_LEVEL = 0.1;
    public static double HERO_MANA_REGEN_LEVEL = 0.1;
    public static double MONSTER_MONEY_LEVEL = 100;
    public static double HERO_EXPERIENCE_GAIN_LEVEL = 2;
    public static double MONSTER_SPELL_SKILL_DETER_LEVEL = 0.1;
    public static int BOARD_WIDTH = 8;
    public static int BOARD_HEIGHT = 8;
    public static double BOARD_INACCESSIBLE_LEVEL = 0.2;
    public static double BOARD_MARKET_LEVEL = 0.3;
    public static double MONSTER_ATTACK_CHANCE = 0.75;

    /*
    configure - allows for a player to configure the rules of their game
    */
    public static void configure()
    {
        boolean active = true;
        InputUtility input = InputUtility.getSingleInstance();
        double numInput;

        System.out.println("DISCLAIMER PLEASE READ!!!!");
        System.out.println("Please enter valid numbers only. Only change if you know what you're doing, setting up input validation for this would take too long.");
        System.out.println("Enter 0 to finish configuration");
        while (active)
        {
            printRulesSettings();
            System.out.println("Input the number of the setting you would like to change:");
            numInput = input.inputInt(0, 18);
            if (numInput == 0)
            {
                active = false;
                break;
            }
            int setting = (int) numInput;
            System.out.println("What would you like to change this setting to?");
            numInput = input.inputDouble(0, 100000);
            setSetting(setting, numInput);
        }
    }

    /*
    printRulesSettings - prints all the rules/settings of the game
    */
    public static void printRulesSettings()
    {
        System.out.println("1) Hero Spell Level: " + HERO_SPELL_LEVEL);
        System.out.println("2) Hero Health Level: " + HERO_HEALTH_LEVEL);
        System.out.println("3) Monster Health Level: " + MONSTER_HEALTH_LEVEL);
        System.out.println("4) Hero Mana Increase per Level: " + HERO_MANA_INCREASE_LEVEL);
        System.out.println("5) Hero Damage Level: " + HERO_DAMAGE_LEVEL);
        System.out.println("6) Hero Dodge Level: " + HERO_DODGE_LEVEL);
        System.out.println("7) Monster Dodge Level: " + MONSTER_DODGE_LEVEL);
        System.out.println("8) Hero Experience Required for Level Up: " + HERO_EXPERIENCE_REQUIRED_LEVEL);
        System.out.println("9) Hero Skill Increase per Level: " + HERO_SKILL_INCREASE_LEVEL);
        System.out.println("10) Hero Health Regen per Battle Round: " + HERO_HEALTH_REGEN_LEVEL);
        System.out.println("11) Hero Mana Regen per Battle Round: " + HERO_MANA_REGEN_LEVEL);
        System.out.println("12) Money from Monster Level: " + MONSTER_MONEY_LEVEL);
        System.out.println("13) Hero Experience Gain per Battle: " + HERO_EXPERIENCE_GAIN_LEVEL);
        System.out.println("14) Monster Skill Deterioration per Spell: " + MONSTER_SPELL_SKILL_DETER_LEVEL);
        System.out.println("15) Map Width: " + BOARD_WIDTH);
        System.out.println("16) Map Height: " + BOARD_HEIGHT);
        System.out.println("17) Map Inaccessible Cell Percentage: " + BOARD_INACCESSIBLE_LEVEL);
        System.out.println("18) Map MarkertCell Percentage: " + BOARD_MARKET_LEVEL);
    }

    /*
    setSetting - private setter method for all settings, accessed only through configure
    */
    private static void setSetting(int setting, double level)
    {
        switch(setting)
        {
            case 1: HERO_SPELL_LEVEL = level; break;
            case 2: HERO_HEALTH_LEVEL = level; break;
            case 3: MONSTER_HEALTH_LEVEL = level; break;
            case 4: HERO_MANA_INCREASE_LEVEL = level; break;
            case 5: HERO_DAMAGE_LEVEL = level; break;
            case 6: HERO_DODGE_LEVEL = level; break;
            case 7: MONSTER_DODGE_LEVEL = level; break;
            case 8: HERO_EXPERIENCE_REQUIRED_LEVEL = level; break;
            case 9: HERO_SKILL_INCREASE_LEVEL = level; break;
            case 10: HERO_HEALTH_REGEN_LEVEL = level; break;
            case 11: HERO_MANA_REGEN_LEVEL = level; break;
            case 12: MONSTER_MONEY_LEVEL = level; break;
            case 13: HERO_EXPERIENCE_GAIN_LEVEL = level; break;
            case 14: MONSTER_SPELL_SKILL_DETER_LEVEL = level; break;
            case 15: BOARD_WIDTH = (int) level; break;
            case 16: BOARD_HEIGHT = (int) level; break;
            case 17: BOARD_INACCESSIBLE_LEVEL = level; break;
            case 18: BOARD_MARKET_LEVEL = level; break;
        }
    }
}
