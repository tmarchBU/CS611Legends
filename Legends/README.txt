Tristan Marchand
tmarch@bu.edu
U13495035
Legends

----------- List of Java Files for Legends ---------------
              73 Classes | 17 Text Files

Main:
Play.java

characters:
Battleable.java
Character.java
Dragon.java
Exoskeleton.java
Hero.java
Inventory.java
LegendsInventory.java
Monster.java
Paladin.java
RPGCharacter.java
Sorcerer.java
SpellCasting.java
Spirit.java
Warrior.java

factories:
ArmorFactory.java
HandheldFactory.java
HeroFactory.java
MonsterFactory.java
PotionFactory.java
SpellFactory.java

game:
Battle.java
Game.java
LegendsGame.java
Market.java
Playable.java
PlayLegends.java
RPGGame.java
SinglePlayerGame.java

game/map:
Board.java
Cell.java
CommonCell.java
InaccessibleCell.java
LegendsBoard.java
Marker.java
MarketCell.java
Moveable.java

game/player:
LegendsPlayer.java
Player.java

game/rules:
LegendsRules.java

GUI_helper:
Icons.java
TableHelper.java
TextColors.java

info_files:
BodyArmor.txt
BootsArmor.txt
Dragons.txt
Exoskeletons.txt
FireSpells.txt
FullBodyArmor.txt
GlovesArmor.txt
HelmetArmor.txt
IceSpells.txt
LightningSpells.txt
Paladins.txt
Potions.txt
Shields.txt
Sorcerers.txt
Spirits.txt
Warriors.txt
Weaponry.txt

items:
Item.java
LevelRequired.java
Storable.java

items/armor:
Armor.java
ArmorType.java
Boots.java
FullArmor.java
FullBody.java
Gloves.java
Helmet.java
NoArmor.java
SplitArmor.java
SplitBody.java

items/consumables:
Consumable.java
Potion.java

items/handheld_items:
Handheld.java
HandType.java
NoWeapon.java
OneHanded.java
Shield.java
TwoHanded.java
Weapon.java

items/spells:
Castable.java
FireSpell.java
IceSpell.java
LightningSpell.java
Spell.java

utilities:
FileParser.java
InputUtility.java
RandomHelper.java

--------------- Compilation Instructions -----------------

Download the .zip file
unzip the file
cd into the file
you should be location in *zipfile name*/Legends (necessary to be located here)
run command javac *.java

------------------- Run Instructions ---------------------

make sure you are located in *zipfile name*/Legends
run command java Play

NOTABLE CONTROL CHANGE: i opens inventory, not prints information. Information is always printed. 

----------------------------------------------------------


---- Descriptions of Java Class Files and Text Files -----
I will be describing the files in groups to avoid 91 descriptions and make reading the information easier for you

---
Play.java:
This is where execution begins by calling PlayLegends.run()
---
GUI_helper files:
Icons.java
TableHelper.java
TextColors.java

Icons and TextColors hold static variables for a graphic experience. TableHelper holds static methods to create and print
tables for different datatypes.
---
utilities files:
FileParser.java
InputUtility.java
RandomHelper.java

FileParser is a Singleton pattern that uses .parse to take in a string filename and return an arraylist of the strings
in a file. Used by the Factories when creating objects. 
InputUtility is a Singleton pattern that has a few different methods that allows for different expected inputs. Handles
all input validation, including situation-specific input validation (can be passed valid inputs).
RandomHelper is a utility with static methods that uses java.util.Random in different methods that handle different 
random situations.
---
info files:
BodyArmor.txt
BootsArmor.txt
Dragons.txt
Exoskeletons.txt
FireSpells.txt
FullBodyArmor.txt
GlovesArmor.txt
HelmetArmor.txt
IceSpells.txt
LightningSpells.txt
Paladins.txt
Potions.txt
Shields.txt
Sorcerers.txt
Spirits.txt
Warriors.txt
Weaponry.txt

Files that store all the information for legends. Files editted for easier read-in to the game, and new files created for
some new objects (Deleted Armory, Added BodyArmor, BootsArmor, FullBodyArmor, GlovesArmor, HelmetArmor, Shields)
---
rules files:
LegendRules.java

Stores static variables for all the rules of Legends (the constant values). Implements a .configure method that allows
the player to personalize their game experience. Input validation is NOT implemented for simplicity, this would take too long. 
But all settings can be changed, from hero/monster settings to board size.
---
game files:
Game.java
SinglePlayerGame.java
RPGGame.java
LegendsGame.java
Playable.java
PlayLegends.java

The heirarchy of the game files from top to bottom: Game -> SinglePlayerGame -> RPGGame -> LegendsGame

Game is an abstract superclass that just holds the name of the game. Abstract SinglePlayerGame adds one player. 
Abstract RPGGame adds a map (board) and the location of the player on the map. LegendsGame is the actual game of 
Legends and is where the game is played. Playable is an interface for .play and .quit, which LegendsGame implements. 
PlayLegends is the access point into LegendsGame, asking if the player would like to configure the rules then 
creating and starting the game. 
	
Notable Things:
1. LegendsGame holds factories of every type of physical object in the game: Hero, Monster, Armor, Handheld, Potion, and Spell.
2. LegendsGame getValidChoices uses the player's location to determine all valid choices a player can make per "round" on the board.
3. LegendsGame placePlayerOnBoard randomly decides a cell on the board for a player to start at. Must be a common cell. 
---
player files:
LegendsPlayer.java
Player.java

The heirarchy of the player files from top to bottom: Player.java -> LegendsPlayer.java

Player holds the name of the player, some ID of the player (if necessary), and a marker for player representation.
LegendsPlayer adds the arraylist of heroes necessary to play Legends.
---
game situation files:
Battle.java
Market.java

The main 2 "events" of the game occur on common cells (a battle) and market cells (shop at the market). These two
events are executed in Battle and Market. 
Battle has 2 sets of arraylists: alive and dead. The constructor is passed 2 arraylists of Battleable objects. 
The battle is started by calling .start, which gives each hero an option of attacking, casting a spell, or opening 
inventory. The action is executed, and the hero's turn is over. When someone dies, they are removed from the alive 
arraylist and added to the dead arraylist. .attack executes an attack from a Battleable attacker and a 
Battleable defender.
When a player enters a market cell, a market is created by being passed the factories. It creates arraylists of 
each item type randomly using the factories, so the items offered are different every time. Entry point to the
market it calling .open on the market object. This asks a hero if they want to buy or sell, and calls either .buy
or .sell depending on the choice. 
---
board files:
Board.java
Cell.java
CommonCell.java
InaccessibleCell.java
LegendsBoard.java
Marker.java
MarketCell.java
Moveable.java

The heirarchy of board files from top to bottom: Board -> LegendsBoard
The heirarchy of cell files from top to bottom: Cell -> {MarketCell, CommonCell, Inaccessible Cell}

The board contains an 2D array of Cells. Each cell on the board implements Moveable, allowing a marker to enter
and exit a cell. Each cell has reference to it's immediate adjacent cell, allowing for easy moveability around the 
board. The adjacents are set by Board in the constructor. LegendsBoard creates a board and randomly assigns 
Inaccessible, Market, and Common cells cased on the levels specified in the rules and sets the adjacents. 
Also provides a .printLegend method that prints the board's legend. 
Marker is used by Player as a graphic representation of the player, as well as used by the subclasses of cell to 
represent the type of cell. 
---
factories files:
ArmorFactory.java
HandheldFactory.java
HeroFactory.java
MonsterFactory.java
PotionFactory.java
SpellFactory.java

Following information goes for all factories: They follow the Factory Design Pattern and use the FileParser utility
to scan information from the correct info file and create and return the object. 
Armor, Handheld, Hero, Monster, Spell: their .get*object*() methods all take in a String type that is used to return
the type asked for. 
Monster: includes a .getRandomMonster method to randomly choose a monster type, then pass that type to the normal 
.getMonster method.  
---
abstract/interface character files:
Battleable.java
Character.java
RPGCharacter.java
SpellCasting.java

The heirarchy of abstract character files from top to bottom: Character -> RPGCharacter
Battleable and SpellCasting are interfaces. 

Character is an abstract superclass for any character, and gives it a name and isAI (if applicable). 
RPGCharacter is an abstract subclass of Character, giving an RPG character a level, health, mana, and an inventory.
Battleable is an interface used by Battle. Any object implementing Battleable can be involved in a battle.
SpellCasting is an interface that allows an object to cast spells. 
---
inventory files:
Inventory.java
LegendsInventory.java

The heirarchy of inventory files from top to bottom: Inventory -> LegendsInventory

Inventory is just an arraylist of storeable items. LegendsInventory adds some methods for pulling out items 
of certain types involved in Legends. 
---
hero character files:
Hero.java
Paladin.java
Sorcerer.java
Warrior.java

The heirarchy of hero character files from top to bottom: -> RPGCharacter -> Hero -> {Paladin, Sorcerer, Warrior}

Hero is a abstract subclass of RPGCharacter that adds experience, strength, agility, dexterity, money, armor, weaponsAndShields
and spells. This class includes all functionality for changing armor, weapons and shields, and consuming items through
openInventory. Paladin, Sorcerer, and Warrior are all subclasses of Hero, and implement their own levelUp method to help 
with the specific levelup for each type. 
Hero has an ArmorType and HandType which allows a hero to have different types. ArmorTypes: NoArmor, SplitArmor, and 
FullArmor. HandTypes: NoWeapon, OneHanded, TwoHanded.  
---
monster character files:
Monster.java
Dragon.java
Exoskeleton.java
Spirit.java

The heirarchy of monster character files from top to bottom: -> RPGCharacter -> Monster -> {Dragon, Exoskeleton, Spirit}

Monster is an abstract subclass of RPGCharacter that adds damage value, defense value, and dodge chance.
Dragon, Exoskeleton, and Spirit are all subclasses of Monster. 
---
item files:
Item.java
LevelRequired.java
Storable.java

Item is an abstract superclass of all items in a game, which has a name and a money value. 
LevelRequired is an interface for anything that requires a level. This is only used for items, but can be 
implemented by anything that requires a certain level (an action, going to a certain cell, etc.).
Storable is an interface used by Inventory for any storable item. Item does NOT implement Storable, its storable
subclasses do. 
---
consumables files:
Consumable.java
Potion.java

The heirarchy of monster character files from top to bottom: Item -> Potion

Consumable is an interface for any consumable item, and includes a .consume method and takes a consumer as an input. 
Potion is a subclass of Item that implements consumable. 
---
spell files:
Castable.java
FireSpell.java
IceSpell.java
LightningSpell.java
Spell.java

The heirarchy of spell files from top to bottom: Item -> Spell -> {FireSpell, IceSpell, LightningSpell}

Spell is an abstract subclass of Item (spells are essentially treated as items that can be bought and sold) and
implements Castable. Castable is an interface for any castable item. FireSpell, IceSpell, and LightningSpell are 
all subclasses of Spell, and have their own cast() that takes in a SpellCasting attacker and a Battleable defender.
---
handheld files:
Handheld.java
HandType.java
NoWeapon.java
OneHanded.java
Shield.java
TwoHanded.java
Weapon.java

The heirarchy of handtypes files from top to bottom: HandType is implemented by {NoWeapon, OneHanded, TwoHanded}
The heirarchy of handheld files from top to bottom: Item -> Handheld -> {Shield, Weapon}

HandType is a used by Hero to equip handheld items. A hero can have no weapon equiped, a twohanded weapon equiped,
or 2 onehanded weapons equiped. WARNING: This is definitely buggy, and there a bunch of validation that was necessary 
to make sure correct weapons were equiped. This works if when asked what weapon to equip, only equip the weapons 
specifically for that type. I spent too much time on this and had to move on. 
Handheld is an abstract subclass of item, and has two subclasses Shield and Weapon. Both have attack and defense value
(you can hit someone with a shield or block an attack with a sword), but in-game weapons have 0 defense and 
shields have 0 attack (can be created though, just didn't add those items). 
---
armor items:
Armor.java
ArmorType.java
Boots.java
FullArmor.java
FullBody.java
Gloves.java
Helmet.java
NoArmor.java
SplitArmor.java
SplitBody.java

The heirarchy of armortypes files from top to bottom: ArmorType is implemented by {NoArmor, SplitArmor, FullArmor}
The heirarchy of handheld files from top to bottom: Item -> Armor -> {Boots, FullBody, Gloves, Helmet, SplitBody}

ArmorType is used by Hero to equip armor items. A hero can have noArmor, split armor (different pieces of armor), 
or full body armor (one full body piece). WARNING: Same warning as above. This is definitely buggy, and there a 
bunch of validation that was necessary to make sure correct armor pieces were equiped. This works if when asked 
what armor item to equip, only equip the armor pieces specifically for that type. I spent too much time on 
this and had to move on. 
Armor is an abstract subclass of item, and has 5 subclasses Boots, FullBody, Gloves, Helmet, SplitBody. SplitArmor
uses Boots, Gloves, SplitBody, and Helmet to calculate the defense value. FullArmor uses only one FullBody piece to
calculate the defense value.

---------------------- Final Notes---------------------------

There are definitely a lot of places in here that need improvement, and the ArmorTypes and HandTypes are a bit buggy,
but I thought they were important scalable features. At some point, I had to ditch good implementation and just write
something that worked, so there's a lot of places that could be better. I focused mostly on the design structure,
so I hope that counts for something. I also definitely lacked on the graphics a bit, and lack some storytelling,
but I didn't have the time unfortunately. So I hope this is alright!






