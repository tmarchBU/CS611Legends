package items.spells;

import characters.Battleable;
import characters.SpellCasting;

public interface Castable 
{
     public void cast(SpellCasting attacker, Battleable defender);
     public int getManaCost();
}
