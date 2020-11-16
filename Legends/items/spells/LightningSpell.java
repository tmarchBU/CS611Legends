package items.spells;

import characters.*;

public class LightningSpell extends Spell 
{
    public LightningSpell(String name, int moneyValue, int levelRequired, int damageValue, int manaCost)
    {
        super(name, moneyValue, levelRequired, damageValue, manaCost);
    }

    public void cast(SpellCasting attacker, Battleable defender)
    {
        super.castHelper(attacker, defender);
        System.out.println(defender.getName() + "'s dodge chance decreased");
        defender.decreaseDodgeChance((int)(defender.getDodgeChance() * 0.1));
    }
}
