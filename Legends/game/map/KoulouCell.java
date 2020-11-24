package game.map;

/*
File: KoulouCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a Koulou cell. Used for Legends Valor
*/

/*
Imported Libraries
*/
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
