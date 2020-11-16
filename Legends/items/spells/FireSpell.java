package items.spells;

import characters.*;

public class FireSpell extends Spell 
{
    public FireSpell(String name, int moneyValue, int levelRequired, int damageValue, int manaCost)
    {
        super(name, moneyValue, levelRequired, damageValue, manaCost);
    }

    public void cast(SpellCasting attacker, Battleable defender)
    {
        super.castHelper(attacker, defender);
        System.out.println(defender.getName() + "'s defense value decreased");
        defender.decreaseDefenseValue((int)(defender.getDefenseValue() * 0.1));
    }

}
