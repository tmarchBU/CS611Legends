package game.map;

import characters.*;
import game.rules.LegendsValorRules;

public class KoulouCell extends Cell
{
    private static final Marker marker = new Marker("");

    /*
    CONSTRUCTORS 
    */
    public KoulouCell()
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
                hero.setStrength((int)(hero.getDexterity() * (1 + LegendsValorRules.KOULOUCELL_STRENGTH_INCREASE)));
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
                hero.setStrength((int)(hero.getDexterity() / (1 + LegendsValorRules.KOULOUCELL_STRENGTH_INCREASE)));
            }

            return true;
        }

        return false;
    }
}
