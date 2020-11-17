package game.map;

import characters.*;
import game.rules.LegendsValorRules;

public class BushCell extends Cell
{
    private static final Marker marker = new Marker("");

    /*
    CONSTRUCTORS 
    */
    public BushCell()
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
                hero.setDexterity((int)(hero.getDexterity() * (1 + LegendsValorRules.BUSHCELL_DEXTERITY_INCREASE)));
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
                hero.setDexterity((int)(hero.getDexterity() / (1 + LegendsValorRules.BUSHCELL_DEXTERITY_INCREASE)));
            }

            return true;
        }

        return false;
    }
}
