Gem Collector 
Created by Rahmaan Lodhia

GAME DETAILS:This program is a game called gem collector.  The object of this game is to collect as many gems as you can while avoiding monsters.  Each gem is worth one point.  The game ends in these following ways:
 1.  The game ends when all gems have been collected. 
 2.  The game ends when a player loses all of their lives. 
 3.  The game ends if the time limit of 150 seconds runs out. 
The status bar on top keeps track of time, items remaining and player lives.  The score bar on the bottom contains the players score and the total score so far.

PLAYERS:
There are two players in this game.  One spawns in the top left corner as a blue square (PlayerOne), and the other spawns in the bottom right corner as a cyan square (PlayerTwo).

TILES:
The game contains different Tiles.  Here is a list of them and their effects:
- Floor Tile: Basic tile that can hold a Gem
- Trap Tile:  Looks like a Floor Tile until either a player or creature passes over it.  It will kill whoever moves over it and reveal itself for the rest of the game.
- Teleport Tile:  Looks like a Floor Tile with a orange circle.  Passing over this tile teleports whoever moved over it to a random location on the map.
- Wall Tile:  A black rectangle representing a panel that cannot be passed through.

MONSTERS:
The game contains different Monsters:  Here is a list of the possible Monsters that may spawn:
- SimpleMonster:  A basic monster.  Moves and patrols an area.  Kills a player on contact.  Represented by a red square.
- KamikazeMonster:  An upgraded SimpleMonster.  Moves faster and may pass through some walls.  Kills a player on contact, but also dies in the process.  Represented by a yellow square.
- GemTheif: A Monster that instead of killing a player, it will steal that player's gems.  This Monster also has the ability to collect the gems on the field keeping them from other players.  Moves randomly through the field.  Represented by a magenta circle.

CONTROLS:
The controls for the game is as follows:
PlayerOne:  Uses the arrow keys to move in the respective direction.  
PlayerTwo:  Uses the WSAD to move.  W is up.  S is down.  A is left.  D is right.
Pause:  P Button.

FILE INPUT:
This game has the option to take in a .txt file that represents a tile mapping.  If such a file is not provided, the game will generate a random map.  The format for the .txt file that this game can receive is demonstrated below through this example:

oogooxoogooooxxxooogoxoxxogooxogxxoxooogxxogooxoxxggxxoogotoxoooxxoogooooxoogoogoxgoogoxxoxxooxogoooxoogogoxoxooxgogotoogxxxxogooxoxoooxooogoxxoooogoxggotogogoogooogooxxtxxoooxotoooxgooxogotoxogoxoxxoxogoopxoooooooooooooxooooooxooogoggoopooxoooooxooxpoggooooogxoxoogooogoooxogooooooxggooogoxggooxoopooooxooooogoooxooogooooooopoogggoooogoooooooogogoxxoggxogooooxxxooxoooxoooxogogpoxooooxoxxxoooxoxoooo

The above example represents a 20x20 tile map.  The .txt file must have the above representation of a 20x20 tile map with no extra spaces.  Each tile is represented through a different letter.  These symbols are as follows:
-'o' represents an empty Floor Tile
-'g' represents a Floor Tile with a Gem
-'t' represents a Trap Tile
-'p' represents a Teleport Tile
-'x' represents a Wall Tile

NOTE:
One thing to note of in making your own tile mapping is that the top left corner and the bottom right corner MUST BE LEFT AS EMPTY FLOOR TILES.  These are the locations that the players will spawn.  Also, the mapping must be ATLEAST a 20x20 map as the program will only look at the first 20x20 map of characters.  The file must also be a .txt file, as the program will only accept those files.

EXTRA FEATURES:
- Time Limit for the Game that when it runs out, the game ends.
- Multiple Players and each has a different control setup and lives
- Ability to pause the game and resume by pressing 'P'
- Lives for players so that they have more than one chance to collect gems.

