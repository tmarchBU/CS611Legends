package items.spells;

import characters.*;
import game.rules.LegendsRules;
import items.Item;
import items.LevelRequired;

public abstract class Spell extends Item implements LevelRequired, Castable
{
    public static String[] printHelper = {"Name", "Cost", "Level Required", "Damage", "Mana Cost"};
    private int levelRequired;
    private int damageValue;
    private int manaCost;

    public Spell(String name, int moneyValue, int levelRequired, int damageValue, int manaCost)
    {
        super(name, moneyValue);
        setLevelRequired(levelRequired);
        setDamageValue(damageValue);
        setManaCost(manaCost);
    }

    public void setLevelRequired(int levelRequired)
    {
        this.levelRequired = levelRequired;
    }

    public void setDamageValue(int damageValue)
    {
        this.damageValue = damageValue;
    }

    public void setManaCost(int manaCost)
    {
        this.manaCost = manaCost;
    }

    public int getLevelRequired()
    {
        return levelRequired;
    }

    public int getDamageValue()
    {
        return damageValue;
    }

    public int getManaCost()
    {
        return manaCost;
    }

    protected void castHelper(SpellCasting attacker, Battleable defender)
    {
        int damage = (int) ((attacker.getDexterity()/LegendsRules.HERO_SPELL_LEVEL) * getDamageValue());
        System.out.println(attacker.getName() + " dealt " + damage + " damage to " + defender.getName());
        attacker.decreaseMana(getManaCost());
        defender.decreaseHealth(damage);
    }
}
