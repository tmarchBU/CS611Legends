package game.map;

import characters.RPGCharacter;

/*
File: Moveable.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Interface to move in and out of cells on a board
*/

public interface Moveable 
{
    /*
    enter - pass the character you want to enter this cell, returns true if successful move
    */
    public boolean enter(RPGCharacter character);

    /*
    enterable - returns true if enterable, false if not
    */
    public boolean enterable();
    
    /*
    exit - pass the character you want to exit this cell, returns true if successful move
    */
    public boolean exit(RPGCharacter character);
}
