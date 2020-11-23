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

import GUI_helper.Icons;
import GUI_helper.TableHelper;
import characters.*;
import factories.*;
import game.map.*;
import game.player.LegendsPlayer;
import game.rules.LegendsRules;
import game.rules.LegendsValorRules;
import utilities.*;

public class LegendsValorGame extends RPGGame implements Playable 
{
    private int round;
    private HeroFactory heroFactory;
    private MonsterFactory monsterFactory;
    private InputUtility input;
    private ValorBattle battle;
    private ArrayList<Monster> monsters;
    private ArrayList<Hero> teleportedHeroes;
    private ArmorFactory armorFactory;
    private HandheldFactory handheldFactory;
    private PotionFactory potionFactory;
    private SpellFactory spellFactory;
    
    /*
    CONSTRUCTOR
    */
    public LegendsValorGame(LegendsPlayer player)
    {
        super(player, "Legends", new LegendsValorBoard());
        heroFactory = new HeroFactory();
        monsterFactory = new MonsterFactory();
        armorFactory = new ArmorFactory();
        handheldFactory = new HandheldFactory();
        potionFactory = new PotionFactory();
        spellFactory = new SpellFactory();
        input = InputUtility.getSingleInstance();
        round = 0;
        battle = new ValorBattle();
        monsters = new ArrayList<Monster>();
        teleportedHeroes = new ArrayList<Hero>();
    }

    /*
    ACCESSOR METHODS
    */
    public LegendsPlayer getPlayer()
    {
        return (LegendsPlayer) super.getPlayer();
    }

    public LegendsValorBoard getBoard()
    {
        return (LegendsValorBoard) super.getBoard();
    }

    public ArrayList<Monster> getMonsters()
    {
        return monsters;
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
        System.out.println("Game loaded, have fun!!");
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
        System.out.println("| w, a, s, d = move | b = back to spawn point nexus | t = teleport | i = inventory | q = quit | h = help |");
    }

    /*
    validLocation - Check if a destination is reachable
    */
    private boolean validLocation(Cell nextCell, Cell monsterCell) {
        if (monsterCell == null)
        {
            return nextCell != null 
                && nextCell.enterable();
        }
        else
        {
            return nextCell != null 
                && nextCell.enterable() 
                && nextCell != monsterCell.getAbove() 
                && nextCell != monsterCell.getLeft() 
                && nextCell != monsterCell.getRight();
        }
    }

    /*
    getValidChoices - returns the valid moves/actions a player can make at any spot on the board
    */
    private ArrayList<String> getValidChoices(RPGCharacter hero, RPGCharacter monster)
    {
        Cell location = hero.getLocation();
        Cell monsterLocation = null;
        if (monster != null)
        {
            monsterLocation = monster.getLocation();
        }
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("Q");
        choices.add("H");
        choices.add("I");
        choices.add("T");
        if (location != ((Hero) hero).getSpawnPoint())
        {
            choices.add("B");
        }
        if (validLocation(location.getAbove(), monsterLocation))
        {
            choices.add("W");
        }
        if (validLocation(location.getBelow(), monsterLocation))
        {
            choices.add("S");
        }
        if (validLocation(location.getLeft(), monsterLocation))
        {
            choices.add("A");
        }
        if (validLocation(location.getRight(), monsterLocation))
        {
            choices.add("D");
        }
        return choices;
    }

    /*
    highestHeroLevel - returns the highest hero level for the current team. Primarily
    used for spawning valid monsters
    */
    private int highestHeroLevel() {
        ArrayList<Hero> heros = getPlayer().getHeroes();
        int level = 0;
        for (Hero hero : heros) {
            int tmpLevel = hero.getLevel();
            if (tmpLevel > level) level = tmpLevel;
        }
        return level;
    }

    /*
    playRound - plays one "round" on the board, AKA does one move by the player
    */
    private void playRound()
    {
        if (round % 8 == 0) {
            int level = highestHeroLevel();
            placeMonstersOnBoard(level); // Place monsters on board every 8 rounds
            System.out.println("New monsters have been spotted!!");
        }
        String strInput = "";
        int numInput = 0;
        ArrayList<Hero> heros = getPlayer().getHeroes();
        for (Hero hero : heros) {
            RPGCharacter targetMonster = null;
            help();
            System.out.println(getBoard());
            getBoard().printLegend();
            TableHelper.printHeroes(getPlayer().getHeroes());
            TableHelper.printBattleables(getMonsters());
            Cell currLocation = getLocation(hero);
            boolean engage = false;
            if (currLocation instanceof NexusCell)
            {
                if (currLocation.getAbove() == null)
                {
                    // TODO: Hero wins
                }

                System.out.println("Would you like to enter the market as " + hero.getName() + "? yes/NO");
                strInput = input.yesNo();
                if (strInput.equals("yes")) {
                    Nexus nexus = new Nexus(armorFactory, handheldFactory, potionFactory, spellFactory);
                    nexus.open(hero);
                }
            }    
            // Check for monsters within range
            ArrayList<RPGCharacter> nearbyMonsters = hero.characterWithinRange();
            
            for (RPGCharacter c : nearbyMonsters)
            {
                if (c instanceof Monster)
                {
                    targetMonster = c;
                    break;
                }
            }
            if (targetMonster != null)
            {
                System.out.println("You have encountered a monster: " + targetMonster.getName() + ". Would you like to engage? yes/NO");
                System.out.println("Warning: you need to defeat the monster to move forward");
                strInput = input.yesNo();
                if (strInput.equals("yes"))
                {
                    engage = true;
                    System.out.println(hero.getName() 
                    + " is fighting a " 
                    + targetMonster.getName() 
                    + "! What would you like to do?");
                
                    System.out.println("1) Attack | 2) Cast a Spell | 3) Open Inventory (change or consume something)");
                    numInput = input.inputInt(1, 3);
                    switch(numInput) 
                    {
                        // attack
                        case 1:
                            battle.attack(hero, targetMonster);
                            break;
                        // cast spell
                        case 2:
                            battle.castSpell(hero, targetMonster);
                            break;
                        // open inventory
                        case 3:
                            hero.openInventory();
                            break;
                    }

                    if (targetMonster.isDead())
                    {
                        resetHero(hero);
                        System.out.println(hero.getName() + " has defeated a " + targetMonster.getName());
                        hero.increaseExperience((int) LegendsRules.HERO_EXPERIENCE_GAIN_LEVEL);
                        System.out.println(hero.getName() + " gained " + ((int) LegendsRules.HERO_EXPERIENCE_GAIN_LEVEL) + " experience.");
                        hero.increaseMoney((int) (LegendsRules.MONSTER_MONEY_LEVEL * targetMonster.getLevel()));
                        System.out.println(hero.getName() + " gained " + ((int) (LegendsRules.MONSTER_MONEY_LEVEL * targetMonster.getLevel())) + " money.");
                        targetMonster.getLocation().exit(targetMonster);
                        getMonsters().remove(targetMonster);
                    }
                }
            } 
            if (engage == false)
            {
                ArrayList<String> choicesList = getValidChoices(hero, targetMonster);
                String[] choices = new String[choicesList.size()];
                choicesList.toArray(choices);
                System.out.println("What would you like to do for " + hero.getName() + "?");
                
                strInput = input.inputString(choices).toUpperCase();
                currLocation = getLocation(hero);
                switch (strInput)
                {
                    case "Q": quit();
                    case "W": move(currLocation.getAbove(), hero); break;
                    case "A": move(currLocation.getLeft(), hero); break;
                    case "S": move(currLocation.getBelow(), hero); break;
                    case "D": move(currLocation.getRight(), hero); break;
                    case "I": hero.openInventory(); break;
                    case "H": help(); break;
                    case "B": moveBack(hero); break;
                    case "T": teleport(hero); 
                }
            }
        }
        
        // Monster movements
        for (Monster monster : monsters)
        {
            Cell currLocation = monster.getLocation();
            if (currLocation instanceof NexusCell && currLocation.getBelow() == null) 
            {
                // TODO: Monster wins
            }
            else
            {
                ArrayList<RPGCharacter> nearbyHeros = monster.characterWithinRange();
                
                Hero hero = null;
                for (RPGCharacter c : nearbyHeros)
                {
                    if (c instanceof Hero)
                    {
                        hero = (Hero) c;
                        break;
                    }
                }
                if (hero != null)
                {
                    battle.attack(monster, hero);
                    // Check health
                    if (hero.isDead()) 
                    {
                        resetHero(hero);
                    }
                }
                else
                {
                    // Move one cell below if no hero nearby
                    move(currLocation.getBelow(), monster);
                }
            }
        }
    }

    /*

    */
    private void moveBack(Hero hero) {
        System.out.println("Returning " + hero.getName() + " to spawn point");
        move(hero.getSpawnPoint(), hero);
        teleportedHeroes.remove(hero);
    }

    /*
     * resetHero - resets heroes to full health and mana, and half health if they
     * died in battle
     */
    private void resetHero(Hero hero)
    {
        int health = hero.getMaxHealth();
        int mana = hero.getMaxMana();
        if (hero.isDead()) 
        {
            System.out.println("Hero " + hero.getName() + " has fainted. Respawning...");
            health = (int) (health * 0.5);
            move(hero.getSpawnPoint(), hero);
        }
    
        hero.setHealth(health);
        hero.setMana(mana);
    }

    /*

    */
    private void teleport(Hero hero)
    {
        if (teleportedHeroes.contains(hero))
        {
            System.out.println("Teleporting back to original nexus");
            move(hero.getSpawnPoint(), hero);
            teleportedHeroes.remove(hero);
        } 
        else
        {
            int row = LegendsValorRules.BOARD_HEIGHT - 1;
            int lane = 0;
            System.out.println("Choose the lane you would like to teleport to. (1 for Lane 1, etc)");
            lane = input.inputInt(1, LegendsValorRules.NUM_LANES) - 1;
            System.out.println("Teleporting to lane :" + (lane + 1));
            int laneWidth = LegendsValorRules.BOARD_HEIGHT / LegendsValorRules.NUM_LANES;
            int cellNum = RandomHelper.randomNum(laneWidth);
            int col = cellNum + lane * (laneWidth + 1);
            Cell cell = getBoard().getCell(row, col);
            boolean moved = move(cell, hero);
            if (!moved)
            {
                moved = move(cell.getLeft(), hero);
                if (!moved)
                {
                    moved = move(cell.getRight(), hero);
                }
            }
            if (!moved)
            {
                System.out.println("The chosen lane is full, unable to teleport.");
            }
            else
            {
                teleportedHeroes.add(hero);
            }
        }
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
        ArrayList<Marker> markers = new ArrayList<Marker>();
        markers.add(new Marker(Icons.HERO1_ICON + " "));
        markers.add(new Marker(Icons.HERO2_ICON + " "));
        markers.add(new Marker(Icons.HERO3_ICON + " "));

        System.out.println("Please choose the three heros that will be on your team");
        
        for (int i = 0; i < 3; i++)
        {
            TableHelper.printHeroes(options);
            System.out.println("Choose wisely. Enter the number of the hero you would like to add to your team.");
            int choice = input.inputInt(1, options.size());
            Hero hero = options.remove(choice - 1);
            hero.setMarker(markers.remove(0));
            getPlayer().getHeroes().add(hero);
        }
        System.out.println("This is your group.");
        TableHelper.printHeroes(getPlayer().getHeroes());
    }

    private void placeCharactersOnBoard(ArrayList<RPGCharacter> characters, int row) {
        int numLanes = LegendsValorRules.NUM_LANES;
        int laneWidth = LegendsValorRules.BOARD_HEIGHT / numLanes;
        
        int lane = 0;
        for (RPGCharacter c : characters) {
            int cellNum = RandomHelper.randomNum(laneWidth);
            int col = cellNum + lane * (laneWidth + 1);
            Moveable cell = (Moveable) getBoard().getCell(row, col);
            if (cell instanceof NexusCell) {
                cell.enter(c);
                c.setLocation((Cell) cell);
                if (c instanceof Hero)
                {
                    ((Hero) c).setSpawnPoint((Cell) cell);
                }
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
            chars.add(hero);
        }
        placeCharactersOnBoard(chars, row);
    }

    /** 
    * placeMonsterOnBoard - Place three randomly picked monsters on the top of 
    * the board when called. One monster is placed in exactly one lane
    */
    private void placeMonstersOnBoard(int level)
    {
        int row = 0;
        ArrayList<RPGCharacter> newMonsters = new ArrayList<RPGCharacter>();
        int size = LegendsValorRules.NUM_LANES;
        for (int i = 0; i < size; i++)
        {
            Monster monster = monsterFactory.getMonsterWithLevel(level);
            newMonsters.add(monster);
            monsters.add(monster);
        }
        ArrayList<RPGCharacter> chars = new ArrayList<RPGCharacter>();
        
        for (RPGCharacter monster : newMonsters) {
            chars.add(monster);
        }
        placeCharactersOnBoard(chars, row);
    }
}
