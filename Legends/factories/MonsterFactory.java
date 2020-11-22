package factories;

/*
File: MonsterFactory.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Factory Design Pattern for Monsters
*/

/*
Imported Libraries
*/
import characters.*;
import game.rules.LegendsRules;
import utilities.*;
import java.util.*;

public class MonsterFactory
{
    private static int numTypes = 3;

    /*
    getMonster - takes in the type of monster as an input and returns a random monster from it's file
    */
    public Monster getMonster(String monsterType)
    {
        Monster monster = null;
        if (monsterType.equalsIgnoreCase("DRAGON"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> dragons = parser.parse("/info_files/Dragons.txt");
            String[] temp = RandomHelper.getRandom(dragons);
            monster = new Dragon(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (monsterType.equalsIgnoreCase("EXOSKELETON"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> exoskeletons = parser.parse("/info_files/Exoskeletons.txt");
            String[] temp = RandomHelper.getRandom(exoskeletons);
            monster = new Exoskeleton(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (monsterType.equalsIgnoreCase("SPIRIT"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> spirits = parser.parse("/info_files/Spirits.txt");
            String[] temp = RandomHelper.getRandom(spirits);
            monster = new Spirit(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        
        return monster;
    }

    /*
    getRandomMonster - chooses a random monster type and passes it to getMonster
    */
    public Monster getRandomMonster()
    {
        return getMonster(getRandomMonsterType());
    }

    /*
    getMonsterWithLevel - chooses a random monster with inputed level
    */
    public Monster getMonsterWithLevel(int level)
    {
        String monsterType = getRandomMonsterType();

        Monster monster = null;
        if (monsterType.equalsIgnoreCase("DRAGON"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> dragons = parser.parse("/info_files/Dragons.txt");
            boolean rightLevel = false;
            String[] temp = null;
            while (!rightLevel)
            {
                temp = RandomHelper.getRandom(dragons);
                if (Integer.parseInt(temp[1]) == level)
                {
                    rightLevel = true;
                }
            }
            monster = new Dragon(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (monsterType.equalsIgnoreCase("EXOSKELETON"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> exoskeletons = parser.parse("/info_files/Exoskeletons.txt");
            boolean rightLevel = false;
            String[] temp = null;
            while (!rightLevel)
            {
                temp = RandomHelper.getRandom(exoskeletons);
                if (Integer.parseInt(temp[3]) == level)
                {
                    rightLevel = true;
                }
            }
            monster = new Exoskeleton(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        else if (monsterType.equalsIgnoreCase("SPIRIT"))
        {
            FileParser parser = FileParser.getSingleInstance();
            ArrayList<String[]> spirits = parser.parse("/info_files/Spirits.txt");
            boolean rightLevel = false;
            String[] temp = null;
            while (!rightLevel)
            {
                temp = RandomHelper.getRandom(spirits);
                if (Integer.parseInt(temp[3]) == level)
                {
                    rightLevel = true;
                }
            }
            monster = new Spirit(temp[0].replace("_", " "), true, Integer.parseInt(temp[1]), (int) (Integer.parseInt(temp[1]) * LegendsRules.MONSTER_HEALTH_LEVEL), Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        }
        
        return monster;
    }

    private String getRandomMonsterType()
    {
        Random random = new Random();
        int num = random.nextInt(numTypes);
        String monsterType = null;
        switch(num)
        {
            case 0: monsterType = "DRAGON";
            case 1: monsterType = "EXOSKELETON";
            case 2: monsterType = "SPIRIT";
        }
        return monsterType;
    }
}