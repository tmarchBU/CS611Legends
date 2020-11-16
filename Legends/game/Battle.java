package game;

/*
File: Battle.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: A Battle object that runs a battle between two groups of Battleable objects
*/

/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;
import characters.*;
import game.rules.LegendsRules;
import items.spells.Castable;
import utilities.InputUtility;

public class Battle 
{
    private ArrayList<Battleable> aliveHeroes;
    private ArrayList<Battleable> deadHeroes;
    private ArrayList<Battleable> aliveMonsters;
    private ArrayList<Battleable> deadMonsters;

    /*
    CONSTRUCTORS
    */
    public Battle(ArrayList<Battleable> heroes, ArrayList<Battleable> monsters)
    {
        setAliveHeroes(heroes);
        setAliveMonsters(monsters);
        setDeadHeroes(new ArrayList<Battleable>());
        setDeadMonsters(new ArrayList<Battleable>());
    }

    /*
    SETTERS
    */
    public void setAliveHeroes(ArrayList<Battleable> heroes)
    {
        this.aliveHeroes = heroes;
    }

    public void setAliveMonsters(ArrayList<Battleable> monsters)
    {
        this.aliveMonsters = monsters;
    }

    public void setDeadHeroes(ArrayList<Battleable> heroes)
    {
        this.deadHeroes = heroes;
    }

    public void setDeadMonsters(ArrayList<Battleable> monsters)
    {
        this.deadMonsters = monsters;
    }

    /*
    ACCESSORS
    */
    public ArrayList<Battleable> getAliveHeroes()
    {
        return aliveHeroes;
    }

    public ArrayList<Battleable> getAliveMonsters()
    {
        return aliveMonsters;
    }

    public ArrayList<Battleable> getDeadHeroes()
    {
        return deadHeroes;
    }

    public ArrayList<Battleable> getDeadMonsters()
    {
        return deadMonsters;
    }

    /*
    start - called on the Battle object to start the battle
    */
    public boolean start()
    {
        InputUtility input = InputUtility.getSingleInstance();
        int numInput = 0;

        System.out.println("Heroes: ");
        TableHelper.printBattleables(getAliveHeroes());
        System.out.println("Monsters: ");
        TableHelper.printBattleables(getAliveMonsters());

        System.out.println("Press Enter to Begin");
        input.pressEnter();

        while(!getAliveHeroes().isEmpty() && !getAliveMonsters().isEmpty())
        {
            System.out.println("Heroes: ");
            TableHelper.printBattleables(getAliveHeroes());
            System.out.println("Monsters: ");
            TableHelper.printBattleables(getAliveMonsters());

            for (int i = 0; i < getAliveHeroes().size(); i++)
            {
                Hero hero = (Hero) getAliveHeroes().get(i);
                System.out.println("What would you like " + hero.getName() + " to do?");
                System.out.println("1) Attack | 2) Cast a Spell | 3) Open Inventory (change or consume something)");
                numInput = input.inputInt(1, 3);
                switch(numInput)
                {
                    case 1: 
                    System.out.println("Which monster would you like to attack?");
                    numInput = input.inputInt(1, getAliveMonsters().size());
                    Battleable monsterAttacked = getAliveMonsters().get(numInput - 1);
                    attack(hero, monsterAttacked);
                    if (monsterAttacked.isDead())
                    {
                        getAliveMonsters().remove(numInput-1);
                        getDeadMonsters().add(monsterAttacked);
                    }
                    break;

                    case 2:
                    System.out.println("Which spell would you like to use?");
                    TableHelper.printSpells(hero.getSpells());
                    if (hero.getSpells().size() == 0)
                    {
                        System.out.println("You have no spells to cast.");
                        break;
                    }
                    numInput = input.inputInt(1, hero.getSpells().size()) - 1;
                    Castable spell = hero.getSpells().get(numInput);

                    System.out.println("Which monster would you like to cast a spell on?");
                    numInput = input.inputInt(1, getAliveMonsters().size());
                    Battleable monsterCasted = (Monster) getAliveMonsters().get(numInput - 1);
                    SpellCasting caster = hero;
                    
                    if (!caster.canCast(spell))
                    {
                        System.out.println("You do not have the mana required to cast this spell.");
                        break;
                    }

                    spell.cast(caster, monsterCasted);
                    if (monsterCasted.isDead())
                    {
                        getAliveMonsters().remove(numInput-1);
                        getDeadMonsters().add(monsterCasted);
                    }
                    break;
                    case 3:
                    hero.openInventory();
                    break;
                }
                
                if (getAliveMonsters().isEmpty())
                {
                    break;
                }
            }
            for (int i = 0; i < getAliveMonsters().size(); i++)
            {
                Monster monster = (Monster) getAliveMonsters().get(i);
                if (monster.isDead())
                {
                    getAliveMonsters().remove(i);
                    getDeadMonsters().add(monster);
                }
                Battleable hero = getAliveHeroes().get(0);
                attack(monster, hero);
                if (hero.isDead())
                    {
                        getAliveHeroes().remove(0);
                        getDeadHeroes().add(hero);
                    }
                if (getAliveHeroes().isEmpty())
                {
                    break;
                }
            }

            for (int i = 0; i < getAliveHeroes().size(); i++)
            {
                Hero hero = (Hero) getAliveHeroes().get(i);

                if (hero.isDead())
                {
                    getDeadHeroes().add(getAliveHeroes().remove(i));
                }
                else
                {
                    hero.increaseHealth((int) ((hero.getMaxHealth() * LegendsRules.HERO_HEALTH_REGEN_LEVEL)));
                    hero.increaseMana((int) ((hero.getMaxMana() * LegendsRules.HERO_MANA_REGEN_LEVEL)));
                }
            }


        }
        if (getAliveHeroes().isEmpty())
        {
            System.out.println("YOU LOST!");
            return false;
        }
        else
        {
            System.out.println("You won the battle.");
            heroWin();
            return true;
        }
    }
    
    /*
    attack - private helper method to do an attack action from an attacker on a defender
    */
    private void attack(Battleable attacker, Battleable defender)
    {
        if (defender.getDodge())
        {
            System.out.println(defender.getName() + " dodged an attack from " + attacker.getName());
            return;
        }

        int attack = attacker.getAttackValue();
        int defense = defender.getDefenseValue();

        int damage = (int) (((attack / 0.05) - defense) * 0.05);
        if (damage > 0)
        {
            defender.decreaseHealth(damage);
            System.out.println(attacker.getName() + " dealt " + damage + " damage to " + defender.getName());
        }
        else
        {
            System.out.println(attacker.getName() + " dealt " + 0 + " damage to " + defender.getName());
        }
    }

    /*
    heroWin - private helper method to give experience and money to the surviving heroes of the battle
    */
    private void heroWin()
    {
        for(int i = 0; i < getAliveHeroes().size(); i++)
        {
            Hero hero = (Hero) getAliveHeroes().get(i);
            for(int j = 0; j < getDeadMonsters().size(); j++)
            {
                Monster monster = (Monster) getDeadMonsters().get(j);
                hero.increaseExperience((int) LegendsRules.HERO_EXPERIENCE_GAIN_LEVEL);
                System.out.println(hero.getName() + " gained " + ((int) LegendsRules.HERO_EXPERIENCE_GAIN_LEVEL) + " experience.");
                hero.increaseMoney((int) (LegendsRules.MONSTER_MONEY_LEVEL * monster.getLevel()));
                System.out.println(hero.getName() + " gained " + ((int) (LegendsRules.MONSTER_MONEY_LEVEL * monster.getLevel())) + " money.");
            }
            hero.setHealth(hero.getMaxHealth());
            hero.setMana(hero.getMaxMana());
        }
    }
}
