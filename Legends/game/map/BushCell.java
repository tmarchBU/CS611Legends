package game.map;

/*
File: BushCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a Bush cell. Used for Legends Valor
*/

/*
Imported Libraries
*/
import GUI_helper.*;
import characters.*;
import game.rules.LegendsValorRules;

public class BushCell extends Cell
{
    public static final Marker marker = new Marker(TextColors.GREEN + Icons.LIGHT_SHADE + Icons.LIGHT_SHADE + TextColors.RESET);

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
