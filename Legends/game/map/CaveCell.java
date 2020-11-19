package game.map;

import GUI_helper.*;
import characters.*;
import game.rules.LegendsValorRules;

public class CaveCell extends Cell 
{
    public static final Marker marker = new Marker(TextColors.PURPLE + Icons.CAVE_ICON + " " + TextColors.RESET);

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
