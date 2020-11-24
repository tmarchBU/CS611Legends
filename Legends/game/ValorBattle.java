package game;

/*
File: ValorBattle.java
Developer: Shuaike Zhou
Email: szhou97@bu.edu
Last Edited: Tuesday, November 10, 2020

Description: Handles all attack mechanics of the game
*/

/*
Imported Libraries
*/
import GUI_helper.TableHelper;
import characters.Battleable;
import characters.Hero;
import characters.SpellCasting;
import items.spells.Castable;
import utilities.InputUtility;

public class ValorBattle {
    private InputUtility input;
    public ValorBattle() {
        input = InputUtility.getSingleInstance();
    }
    /*
    attack - Method to do an attack action from an attacker on a defender
    */
    public void attack(Battleable attacker, Battleable defender)
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
    castSpell - method to cast a spell from a hero to a monster
    */
    public void castSpell(Hero hero, Battleable monster)
    {
        int numInput = 0;
        System.out.println("Which spell would you like to use?");
        TableHelper.printSpells(hero.getSpells());
        if (hero.getSpells().size() == 0)
        {
            System.out.println("You have no spells to cast.");
            return;
        }
        numInput = input.inputInt(1, hero.getSpells().size()) - 1;
        Castable spell = hero.getSpells().get(numInput);
        SpellCasting caster = hero;
                    
        if (!caster.canCast(spell))
        {
            System.out.println("You do not have the mana required to cast this spell.");
            return;
        }
        spell.cast(caster, monster);
    }

}
