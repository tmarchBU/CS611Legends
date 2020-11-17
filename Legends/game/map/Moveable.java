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
    public boolean enter(RPGCharacter character);
    public boolean enterable();
    public boolean exit();
}
