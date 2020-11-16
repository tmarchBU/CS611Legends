package utilities;

/*
File: RandomHelper.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A utility for random generation
*/

/*
Imported Libraries
*/
import java.util.*;
import game.rules.LegendsRules;

public class RandomHelper 
{
    private static Random random = new Random();

    public static <T> T getRandom(List<T> list)
    {
        int num = random.nextInt(list.size());
        return list.get(num);
    }

    public static <T> T removeRandom(List<T> list)
    {
        int num = random.nextInt(list.size());
        return list.remove(num);
    }

    public static int randomNum(int max)
    {
        return random.nextInt(max);
    }

    public static boolean randomMonsterAttack()
    {
        float temp = random.nextFloat();
        return temp < LegendsRules.MONSTER_ATTACK_CHANCE;
    }

    public static boolean randomDodge(float dodgeChance)
    {
        float temp = random.nextFloat();
        return temp < (dodgeChance * LegendsRules.MONSTER_DODGE_LEVEL);
    }
}
