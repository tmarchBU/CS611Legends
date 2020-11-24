package game.map;

/*
File: CaveCell.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Subclass of cell, representing a Cave cell. Used for Legends Valor
*/

/*
Imported Libraries
*/
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
