package items.spells;

import characters.*;

public class IceSpell extends Spell 
{
    public IceSpell(String name, int moneyValue, int levelRequired, int damageValue, int manaCost)
    {
        super(name, moneyValue, levelRequired, damageValue, manaCost);
    }

    public void cast(SpellCasting attacker, Battleable defender)
    {
        super.castHelper(attacker, defender);
        System.out.println(defender.getName() + "'s attack value decreased");
        defender.decreaseAttackValue((int)(defender.getAttackValue() * 0.1));
    }
}
