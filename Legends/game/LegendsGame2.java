package game;
/**
 * The game class for Legends and Heros 2
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
import game.rules.LegendsRules;
import utilities.*;

public class LegendsGame2 extends RPGGame implements Playable 
{
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
        placePlayerOnBoard();
        
        
        while(active)
        {
            playRound();
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
    private ArrayList<String> getValidChoices()
    {
        ArrayList<String> choices = new ArrayList<String>();
        choices.add("Q");
        choices.add("H");
        choices.add("I");
        if (getPlayerLocation().getAbove() != null && getPlayerLocation().getAbove().enterable())
        {
            choices.add("W");
        }
        if (getPlayerLocation().getBelow() != null && getPlayerLocation().getBelow().enterable())
        {
            choices.add("S");
        }
        if (getPlayerLocation().getLeft() != null && getPlayerLocation().getLeft().enterable())
        {
            choices.add("A");
        }
        if (getPlayerLocation().getRight() != null && getPlayerLocation().getRight().enterable())
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
        String strInput = "";
        int numInput = 0;
        ArrayList<String> choicesList = getValidChoices();
        String[] choices = new String[choicesList.size()];
        choicesList.toArray(choices);

        System.out.println(getBoard());
        getBoard().printLegend();
        TableHelper.printHeroes(getPlayer().getHeroes());
        System.out.println("What would you like to do?");
        strInput = input.inputString(choices).toUpperCase();
        switch (strInput)
        {
            case "Q": quit();
            case "W": move(getPlayerLocation().getAbove()); break;
            case "A": move(getPlayerLocation().getLeft()); break;
            case "S": move(getPlayerLocation().getBelow()); break;
            case "D": move(getPlayerLocation().getRight()); break;
            case "I": openInventory(); break;
            case "H": help(); break;
            // TODO: IMPLEMENT TELEPORT
        }
        
        if (getPlayerLocation() instanceof CommonCell)
        {
            if (RandomHelper.randomMonsterAttack())
            {
                System.out.println("Monsters have appeared!");
                ArrayList<Battleable> monsters = new ArrayList<Battleable>();
                ArrayList<Battleable> heroes = new ArrayList<Battleable>();

                for (int i = 0; i < getPlayer().getHeroes().size(); i++)
                {
                    Monster monster = monsterFactory.getRandomMonster();
                    monsters.add(monster);
                    heroes.add(getPlayer().getHeroes().get(i));
                }

                Battle battle = new Battle(heroes, monsters);
                if (!battle.start())
                {
                    resetHeroes();
                }
            }
        }

        if (getPlayerLocation() instanceof MarketCell)
        {
            System.out.println("Would you like to enter the market? (yes/no)");
            strInput = input.yesNo();
            if (strInput.equalsIgnoreCase("YES"))
            {
                Market market = new Market(armorFactory, handheldFactory, potionFactory, spellFactory);
                System.out.println("Which hero would you like to enter the market?");
                numInput = input.inputInt(1, getPlayer().getHeroes().size()) - 1;
                market.open(getPlayer().getHeroes().get(numInput));
            }
        }

        // TODO: IMPLEMENT OTHER CELL TYPES
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

    /*
    placePlayerOnBoard - randomly places a player on the board at the beginning of the game
    */
    private void placePlayerOnBoard()
    {
        // TODO: PLAYERS AND MONSTERS WILL SPAWN FROM NEXUS CELLS
        boolean active = true;
        while (active)
        {
            int cellNum = RandomHelper.randomNum(LegendsRules.BOARD_HEIGHT * LegendsRules.BOARD_WIDTH);
            int row = cellNum / LegendsRules.BOARD_HEIGHT;
            int col = cellNum % LegendsRules.BOARD_WIDTH;
            Moveable cell = (Moveable) getBoard().getCell(row, col);
            if (cell instanceof CommonCell)
            {
                cell.enter(getPlayer().getMarker());
                setPlayerLocation((Cell) cell);
                active = false;
                break;
            }
        }
    }
    
}
