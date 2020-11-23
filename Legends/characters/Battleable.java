package characters;

/*
File: Battleable.java
Developer: Tristan Marchand
Email: tmarch@bu.edu
BU ID: U13495035
Last Edited: Tuesday, November 10, 2020

Description: Interface with methods required to be involved in a Battle
*/

public interface Battleable 
{
	public static String[] printHelper = {"Name", "Health", "Mana"};
    public int getAttackValue();
    public int getDefenseValue();
	public boolean getDodge();
	public void decreaseHealth(int health);
	public float getDodgeChance();
	public void decreaseDefenseValue(int defenseValue);
	public void decreaseAttackValue(int attackValue);
	public void decreaseDodgeChance(int dodgeChance);
	public String getName();
	public boolean isFighting();
	public boolean isDead();
	public int getHealth();
	public int getMana();
}
