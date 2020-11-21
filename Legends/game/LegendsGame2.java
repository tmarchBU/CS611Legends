package game;
/*
File: LegendsGame2.java
Developer: Tristan Marchand, Shuaike Zhou
Email: tmarch@bu.edu, szhou97@bu.edu
Last Edited: Thursday, November 19, 2020

Description: A subclass of RPGGame that plays the game of Legends of Valor
*/


/*
Imported Libraries
*/
import java.util.ArrayList;
import GUI_helper.TableHelper;
import characters.*;
import factories.*;
import game.map.*;
import game.player.LegendsPlayer;
import game.rules.LegendsValorRules;
import utilities.*;

public class LegendsGame2 extends RPGGame2 implements Playable 
{
    private int round;
    private HeroFactory heroFactory;
    private MonsterFactory monsterFactory;
    private ArmorFactory armorFactory;
    private HandheldFactory handheldFactory;
    private PotionFactory potionFactory;
    private SpellFactory spellFactory;
    private InputUtility input;

    /*
    CONSTRUCTOR
    */
    public LegendsGame2(LegendsPlayer player)
    {
        super(player, "Legends", new LegendsBoard());
        heroFactory = new HeroFactory();
        monsterFactory = new MonsterFactory();
        armorFactory = new ArmorFactory();
        handheldFactory = new HandheldFactory();
        potionFactory = new PotionFactory();
        spellFactory = new SpellFactory();
        input = InputUtility.getSingleInstance();
        round = 0;
    }

    /*
    ACCESSOR METHODS
    */
    public LegendsPlayer getPlayer()
    {
        return (LegendsPlayer) super.getPlayer();
    }

    public LegendsBoard getBoard()
    {
        return (LegendsBoard) super.getBoard();
    }

    /*
    play - called by user to play Legends
    */
    public void play()
    {
        boolean active = true;
        intro();
        chooseHeroes();
        System.out.println("Press Enter to Begin.");
        input.pressEnter();
        placeHerosOnBoard();
        
        while(active)
        {
            playRound();
            round++;
        }
    }

    /*
    quit - quits the game
    */
    public void quit()
    {
        System.out.println("Thank you for playing!!");
        System.exit(0);
    }

    /*
    help - prints out controls
    */
    private void help()
    {
        System.out.println("| w, a, s, d = move | i = inventory | q = quit | h = help |");
    }

    /*
    getValidChoices - returns the valid moves/actions a player can make at any spot on the board
    */
    private ArrayList<String> getValidChoices(RPGCharacter hero)
    {
        Cell location = hero.getLocation();
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("Q");
        choices.add("H");
        choices.add("I");
        if (location.getAbove() != null && location.getAbove().enterable())
        {
            choices.add("W");
        }
        if (location.getBelow() != null && location.getBelow().enterable())
        {
            choices.add("S");
        }
        if (location.getLeft() != null && location.getLeft().enterable())
        {
            choices.add("A");
        }
        if (location.getRight() != null && location.getRight().enterable())
        {
            choices.add("D");
        }
        
        return choices;
    }

    /*
    playRound - plays one "round" on the board, AKA does one move by the player
    */
    private void playRound()
    {
        if (round % 8 == 0) {
            placeMonstersOnBoard(); // Place monsters on board every 8 rounds
        }
        String strInput = "";
        int numInput = 0;
        ArrayList<Hero> heros = getPlayer().getHeroes();
        for (Hero hero : heros) {
            System.out.println(getBoard());
            getBoard().printLegend();
            TableHelper.printHeroes(getPlayer().getHeroes());
            Cell currLocation = getLocation(hero);
            
            currLocation = getLocation(hero);
        
            if (currLocation instanceof BushCell)
            {
                int increase = (int) (hero.getDexterity() * 0.1);
                hero.increaseDexterity(increase);
            }
            else if (currLocation instanceof CaveCell)
            {
                int increase = (int) (hero.getAgility() * 0.1);
                hero.increaseAgility(increase);
            }
            else if (currLocation instanceof KoulouCell)
            {
                int increase = (int) (hero.getStrength() * 0.1);
                hero.increaseStrength(increase);
            }
            else if (currLocation instanceof NexusCell)
            {
                System.out.println("Would you like to enter the market? (yes/no)");
                strInput = input.yesNo();
                if (strInput.equalsIgnoreCase("YES"))
                {
                    Market market = new Market(armorFactory, handheldFactory, potionFactory, spellFactory);
                    market.open(hero);
                }
            }
            
            // TODO: If monster within range, start battle


            ArrayList<String> choicesList = getValidChoices(hero);
            String[] choices = new String[choicesList.size()];
            choicesList.toArray(choices);
            System.out.println("What would you like to do for " + hero.getName() + "?");
            strInput = input.inputString(choices).toUpperCase();
            Cell currLocation = getLocation(hero);
            switch (strInput)
            {
                case "Q": quit();
                case "W": move(currLocation.getAbove(), hero); break;
                case "A": move(currLocation.getLeft(), hero); break;
                case "S": move(currLocation.getBelow(), hero); break;
                case "D": move(currLocation.getRight(), hero); break;
                case "I": openInventory(); break;
                case "H": help(); break;
                // TODO: IMPLEMENT TELEPORT
            }
        }
    }

    /*
    resetHeroes - resets heroes to full health and mana, and half health if they died in battle
    */
    private void resetHeroes()
    {
        for (int i = 0; i < getPlayer().getHeroes().size(); i++)
        {
            Hero hero = getPlayer().getHeroes().get(i);
            if (hero.isDead())
            {
                hero.setHealth((int) (hero.getMaxHealth()*0.5));
            }
            hero.setMana(hero.getMaxMana());
        }
    }

    /*
    openInventory - asks a player which hero's inventory, and calls openInventory on the Hero
    */
    private void openInventory()
    {
        int numInput = 0;
        System.out.println("Input the number of hero whose inventory you would like to open.");
        numInput = input.inputInt(1, getPlayer().getHeroes().size());

        getPlayer().getHeroes().get(numInput - 1).openInventory();;
    }

    /*
    intro - plays the intro
    */
    private void intro()
    {   
        // TODO: CREATE NEW STORY
        System.out.println("Not enough time for a cool story, I'm sorry :(");
        System.out.println("Here are the controls:");
        help();
    }

    /*
    chooseHeroes - called at the beginning of the game to choose a player's starting heroes
    UPDATE: Three heros are required now
    */
    private void chooseHeroes()
    {
        ArrayList<Hero> options = new ArrayList<Hero>();
        options.add(heroFactory.getHero("SORCERER"));
        options.add(heroFactory.getHero("WARRIOR"));
        options.add(heroFactory.getHero("PALADIN"));

        System.out.println("Please choose the three heros that will be on your team");
        
        for (int i = 0; i < 3; i++)
        {
            TableHelper.printHeroes(options);
            System.out.println("Choose wisely. Enter the number of the hero you would like to add to your team.");
            int choice = input.inputInt(1, options.size());
            getPlayer().getHeroes().add(options.remove(choice - 1));
        }
        System.out.println("This is your group.");
        TableHelper.printHeroes(getPlayer().getHeroes());
    }

    private void placeCharactersOnBoard(ArrayList<RPGCharacter> characters, int row) {
        int numLanes = LegendsValorRules.NUM_LANES;
        int laneWidth = row / numLanes;
        int lane = 0;
        for (RPGCharacter c : characters) {
            int cellNum = RandomHelper.randomNum(laneWidth - 1);
            int col = cellNum + lane;
            Moveable cell = (Moveable) getBoard().getCell(row, col);
            if (cell instanceof NexusCell) {
                cell.enter(c);
                lane++;
            }
        }
    }

    /** 
    * placeHeroOnBoard - randomly places a hero on the bottom board when called.
    * One hero is placed in exactly one lane
    */
    private void placeHerosOnBoard()
    {
        int row = LegendsValorRules.BOARD_HEIGHT - 1;
        ArrayList<Hero> heros = getPlayer().getHeroes();
        ArrayList<RPGCharacter> chars = new ArrayList<RPGCharacter>();
        
        for (Hero hero : heros) {
            chars.add((RPGCharacter) hero);
        }
        placeCharactersOnBoard(chars, row);
    }

    /** 
    * placeMonsterOnBoard - Place three randomly picked monsters on the top of 
    * the board when called. One monster is placed in exactly one lane
    */
    private void placeMonstersOnBoard()
    {
        int row = 0;
        ArrayList<RPGCharacter> monsters = new ArrayList<RPGCharacter>();
        int size = LegendsValorRules.NUM_LANES;

        for (int i = 0; i < size; i++)
        {
            Monster monster = monsterFactory.getRandomMonster();
            monsters.add(monster);
        }
        ArrayList<RPGCharacter> chars = new ArrayList<RPGCharacter>();
        
        for (RPGCharacter monster : monsters) {
            chars.add((RPGCharacter) monster);
        }
        placeCharactersOnBoard(chars, row);
    }
}