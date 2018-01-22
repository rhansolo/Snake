# :snake::snake: Snake :snake::snake:
### Authors :smile:
  Robin Han and Steven Liu

### Info :octocat:
_Run our game!_  
1. Download the Snake directory
2. Compile in terminal/bash shell by typing in 
```
javac *.java
```
3. Run the program by typing in 
```
java Game
```
_How to play:_ 
1. Control the snake using the WASD keys.  
  *Note: You cannot move in the opposite direction of the where the snake is moving!*
2. Your objective is to eat as many "fruits" as possible, represented as the red circles that generate randomly on the map.
3. Just like the classic Snake game, you lose a life under certain conditions:  
	* If you (the snake) collide with yourself.
	* If you (the snake) contacts the border (the edges of the window).
4. For each fruit eaten, 100 points are added to your score.
5. The snake grows (by 10 pixels) each time a fruit is consumed.
6. Once you have used up all 3 lives, you have have an option to restard or quit. Your score will be displayed
7. Your goal is the achieve the highest score possible
8. You can pause the game by pressing the Space Bar. Press it again to unpause it. 

:metal:**Good Luck!** :metal:




### Development Log :thought_balloon: :thought_balloon:
1/5/18 : Created a KeyBoard input reading class. Class reads key user is pressing.  
1/6/18 : Created basic class and implemented threading as well as previously written Display class. Incoportaed KeyBoardEvents with the Game class.    
1/7/18 : Modified method in KeyBoardEvents class. Pressing the spacebar closes the window. Pressing a WASD key updates the direction.    
1/8/18 : Created basic Entity abstract class. Created Snake class, inherits Entity. Started working on basic Snake class.  
1/9/18 : Added Snake class to GameState class, modified Snake class, used Coordinates to represent segments of snakes. Added a simple collision check method.  
1/10/18 : Modified snake head changing direction method. Implemented tick in Snake class.  
1/11/18 : Fixed many bugs that exist in the Snake, Game, and KeyBoard Events class. Changed movement of Snake to int coordinates.  
1/12/18 : Snake displays and moves on screen but moves too fast. Made snake slower.  
1/13/18 : Created an apple class and generated randomly on the map.  
1/14/18 : Modified so snake can eat the apple and grow longer in length.  
1/15/18 : Changed so that snake can't move in direct opposite directions. Gave snake 3 lives. Added ScoreBoard and Lives to the top of the window but not yet functional. Made the score culmulative after snake dies.  
1/16/18 : Modified GUI to make it look better.  
1/19/18 : Added method that allows user to pause the game by pressing spacebar.  
1/20/18 : Tried to add menuState, got nullpointer error.  
1/21/18 : Created pop-up window after snake runs out of lives. User can restart or quit. Restart reset score and lives but stores highScore. Displays high-score after losing all lives. Made final changes! DONE :tada: :tada: (sorta)!  
