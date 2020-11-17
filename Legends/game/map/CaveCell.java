package game.map;

import characters.*;
import game.rules.LegendsValorRules;

public class CaveCell extends Cell 
{
    private static final Marker marker = new Marker("");

    /*
    CONSTRUCTORS 
    */
    public CaveCell()
    {
        super(marker);
    }

    /*
    Moveable Methods
    */
    public boolean enter(RPGCharacter character)
    {
        if (super.enter(character))
        {
            if (character instanceof Hero)
            {
                Hero hero = (Hero) character;
                hero.setAgility((int)(hero.getDexterity() * (1 + LegendsValorRules.CAVECELL_AGILITY_INCREASE)));
            }

            return true;
        }

        return false;
    }

    public boolean exit(RPGCharacter character)
    {
        if (super.exit(character))
        {
            if (character instanceof Hero)
            {
                Hero hero = (Hero) character;
                hero.setAgility((int)(hero.getDexterity() / (1 + LegendsValorRules.CAVECELL_AGILITY_INCREASE)));
            }

            return true;
        }

        return false;
    }
}
