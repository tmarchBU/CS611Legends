package game.map;

import GUI_helper.*;
import characters.*;
import game.rules.LegendsValorRules;

public class KoulouCell extends Cell
{
    public static final Marker marker = new Marker(TextColors.BLUE + Icons.KOULOU_ICON + " " + TextColors.RESET);

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
